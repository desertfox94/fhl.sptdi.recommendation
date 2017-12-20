package test.fhl.sptdi.recommendation.calculator;

import main.fhl.sptdi.recommendation.calculator.Recommender;
import test.fhl.sptdi.recommendation.util.PlayedSongBuilder;
import test.fhl.sptdi.recommendation.util.SongBuilder;
import main.fhl.sptdi.recommendation.io.in.train.PlayedSongImpl;
import main.fhl.sptdi.recommendation.model.PlayedSong;
import main.fhl.sptdi.recommendation.model.Song;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RecommenderTest {

    private Song song;
    private List<PlayedSong> playedSongs;

    @Test
    public void testCalculate_WillListenAgain() {
        setUp(true);
        assertEquals(1, new Recommender().willListenAgain(song, playedSongs));
    }

    @Test
    public void testCalculate_WontListenAgain() {
        setUp(false);
        assertEquals(0, new Recommender().willListenAgain(song, playedSongs));
    }

    private void setUp(boolean willListenAgain) {
        song = new SongBuilder().withComposers("Test").withGenres("1", "2", "3").build();
        if (willListenAgain) {
            playedSongs = Arrays.asList(
                    createPlayedSong(Arrays.asList("Test2"), Arrays.asList("1", "4")),
                    createPlayedSong(Arrays.asList("Test"), Arrays.asList("1", "2", "3")),
                    createPlayedSong(Arrays.asList("Test"), Arrays.asList("2", "3", "5")));
        }
        else {
            playedSongs = Arrays.asList(
                    createPlayedSong(Arrays.asList("Test2"), Arrays.asList("1", "4")),
                    createPlayedSong(Arrays.asList("Test1"), Arrays.asList("4")),
                    createPlayedSong(Arrays.asList("Test"), Arrays.asList("2", "3", "5")));
        }
    }

    private PlayedSong createPlayedSong(List<String> composers, List<String> genres) {
        return new PlayedSongBuilder().withSong(new SongBuilder().withComposers(composers).withGenres(genres).build()).build();
    }

}
