package fhl.sptdi.recommendation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fhl.sptdi.recommendation.calculator.Recommender;
import fhl.sptdi.recommendation.calculator.genre.GenreCalculator;
import fhl.sptdi.recommendation.io.in.song.SongImpl;
import fhl.sptdi.recommendation.io.in.train.PlayedSongImpl;
import fhl.sptdi.recommendation.model.PlayedSong;
import fhl.sptdi.recommendation.model.Song;

public class GenreCalculatorTest {

	private PlayedSong playedSong;
	private List<PlayedSong> songs;

	@Before
	public void setUp() {
		playedSong = createSong("1", "2", "3");

		songs = new ArrayList<>();
		songs.add(createSong("1", "4"));
		songs.add(createSong("1", "2", "3"));
		songs.add(createSong("2", "3", "5"));
	}

	private PlayedSong createSong(String... genres) {
		PlayedSong playedSong = new PlayedSongImpl();
		Song song = new SongImpl();
		Arrays.asList(genres).forEach(genre -> song.addGenre(genre));
		playedSong.setSong(song);
		// asdasdas
		return playedSong;
	}

	@Test
	public void testCalculate() {
		Assert.assertEquals((2.0 / 3.0), new GenreCalculator().calculate(playedSong, songs), 0);
		Recommender recommender = new Recommender();
		System.out.println(recommender.willListenAgain(playedSong, songs));
	}

}
