package fhl.sptdi.recommendation.calculator;

import fhl.sptdi.recommendation.util.PlayedSongBuilder;
import fhl.sptdi.recommendation.util.SongBuilder;
import fhl.sptdi.recommendation.calculator.composer.ComposerCalculator;
import fhl.sptdi.recommendation.io.in.train.PlayedSongImpl;
import fhl.sptdi.recommendation.model.PlayedSong;
import fhl.sptdi.recommendation.model.Song;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ComposerCalculatorTest {

    private Song song;
    private List<PlayedSong> playedSongs = new ArrayList<>();

    @Before
    public void setUp() {
        List<Song> songs = Arrays.asList(new SongBuilder().withComposers("Test2", "Test").build(),
                new SongBuilder().withComposers("Test", "Test3").build(),
                new SongBuilder().withComposers("Test").build(),
                new SongBuilder().withComposers("Test3", "Test", "Test4").build(),
                new SongBuilder().withComposers("Test4").build());
        songs.forEach(song -> playedSongs.add(new PlayedSongBuilder().withSong(song).build()));
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
