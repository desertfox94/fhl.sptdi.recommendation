package fhl.sptdi.recommendation.calculator;

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

    private PlayedSong playedSong;
    private List<PlayedSong> songs;

    @Before
    public void setUp() {
        songs = Arrays.asList(
                createSong("Test2"),
                createSong("Test"),
                createSong("Test"),
                createSong("Test3"),
                createSong("Test4"));
    }

    private PlayedSong createSong(String composer) {
        Song song = new SongImpl();
        song.setComposer(composer);
        PlayedSong playedSong = new PlayedSongImpl();
        playedSong.setSong(song);
        return playedSong;
    }

    @Test
    public void testCalculate_TwoOutOfFive() {
        playedSong = createSong("Test");
        assertEquals(0.4, new ComposerCalculator().calculate(playedSong, songs), 0);
    }

    @Test
    public void testCalculate_ZeroOutOfFive() {
        playedSong = createSong("Test5");
        assertEquals(0.0, new ComposerCalculator().calculate(playedSong, songs), 0);
    }

}
