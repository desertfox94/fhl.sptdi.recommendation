package fhl.sptdi.recommendation.calculator;

import fhl.sptdi.recommendation.SongBuilder;
import fhl.sptdi.recommendation.calculator.composer.ComposerCalculator;
import fhl.sptdi.recommendation.io.in.song.SongImpl;
import fhl.sptdi.recommendation.io.in.train.PlayedSongImpl;
import fhl.sptdi.recommendation.model.PlayedSong;
import fhl.sptdi.recommendation.model.Song;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ComposerCalculatorTest {

    private Song song;
    private List<PlayedSong> playedSongs;

    @Before
    public void setUp() {
        playedSongs = Arrays.asList(
                createPlayedSong("Test2", "Test"),
                createPlayedSong("Test", "Test3"),
                createPlayedSong("Test"),
                createPlayedSong("Test3", "Test", "Test4"),
                createPlayedSong("Test4"));
    }

    private PlayedSong createPlayedSong(String... composers) {
        PlayedSong playedSong = new PlayedSongImpl();
        playedSong.setSong(new SongBuilder().withComposers(composers).build());
        return playedSong;
    }

    @Test
    public void testCalculate() {
        song = new SongBuilder().withComposers("Test").build();
        assertEquals(0.8, new ComposerCalculator().calculate(song, playedSongs), 0);
    }

    @Test
    public void testCalculate_NoMatches() {
        song = new SongBuilder().withComposers("Test5").build();
        assertEquals(0.0, new ComposerCalculator().calculate(song, playedSongs), 0);
    }

}
