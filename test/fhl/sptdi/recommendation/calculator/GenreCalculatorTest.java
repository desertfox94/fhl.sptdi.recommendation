package fhl.sptdi.recommendation.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fhl.sptdi.recommendation.calculator.genre.GenreCalculator;
import fhl.sptdi.recommendation.io.in.song.SongImpl;
import fhl.sptdi.recommendation.io.in.train.PlayedSongImpl;
import fhl.sptdi.recommendation.model.PlayedSong;
import fhl.sptdi.recommendation.model.Song;

public class GenreCalculatorTest {

	private Song song;
	private List<PlayedSong> playedSongs;

	@Before
	public void setUp() {
		song = createSong("1", "2", "3");

		playedSongs = new ArrayList<>();
		playedSongs.add(createPlayedSong("1", "4"));
		playedSongs.add(createPlayedSong("1", "2", "3"));
		playedSongs.add(createPlayedSong("2", "3", "5"));
	}

	private Song createSong(String... genres) {
		Song song = new SongImpl();
		Arrays.asList(genres).forEach(genre -> song.addGenre(genre));
		return song;
	}

	private PlayedSong createPlayedSong(String... genres) {
		PlayedSong playedSong = new PlayedSongImpl();
		playedSong.setSong(createSong(genres));
		return playedSong;
	}

	@Test
	public void testCalculate() {
		Assert.assertEquals((2.0 / 3.0), new GenreCalculator().calculate(song, playedSongs), 0);
	}

}
