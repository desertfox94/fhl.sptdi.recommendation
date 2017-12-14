package fhl.sptdi.recommendation.calculator;

import fhl.sptdi.recommendation.io.in.song.SongImpl;
import fhl.sptdi.recommendation.io.in.train.PlayedSongImpl;
import fhl.sptdi.recommendation.model.PlayedSong;
import fhl.sptdi.recommendation.model.Song;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RecommenderTest {

    private PlayedSong playedSong;
    private List<PlayedSong> songs;

    @Test
    public void testCalculate_WillListenAgain() {
        setUp(true);
        assertEquals(1, new Recommender().willListenAgain(playedSong, songs));
    }

    @Test
    public void testCalculate_WontListenAgain() {
        setUp(false);
        assertEquals(0, new Recommender().willListenAgain(playedSong, songs));
    }

    private void setUp(boolean willListenAgain) {
        if (willListenAgain) {
            playedSong = createSong("Test", "1", "2", "3");
            songs = Arrays.asList(
                    createSong("Test2", "1", "4"),
                    createSong("Test", "1", "2", "3"),
                    createSong("Test", "2", "3", "5"));
        }
        else {
            playedSong = createSong("Test", "1", "2", "3");
            songs = Arrays.asList(
                    createSong("Test2", "1", "4"),
                    createSong("Test1", "4"),
                    createSong("Test", "2", "3", "5"));
        }
    }

    private PlayedSong createSong(String composer, String... genres) {
        Song song = new SongImpl();
        song.setComposer(composer);
        Arrays.asList(genres).forEach(genre -> song.addGenre(genre));
        PlayedSong playedSong = new PlayedSongImpl();
        playedSong.setSong(song);
        return playedSong;
    }

}
