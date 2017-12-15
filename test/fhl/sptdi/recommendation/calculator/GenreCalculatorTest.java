package fhl.sptdi.recommendation.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fhl.sptdi.recommendation.SongBuilder;
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
		playedSongs = new ArrayList<>();
		playedSongs.add(createPlayedSong("1", "4"));
		playedSongs.add(createPlayedSong("1", "2", "3"));
		playedSongs.add(createPlayedSong("2", "3", "5"));
	}

	private PlayedSong createPlayedSong(String... genres) {
		PlayedSong playedSong = new PlayedSongImpl();
		playedSong.setSong(new SongBuilder().withGenres(genres).build());
		return playedSong;
	}

	@Test
	public void testCalculate() {
		song = new SongBuilder().withGenres("1", "2", "3").build();
		Assert.assertEquals((2.0 / 3.0), new GenreCalculator().calculate(song, playedSongs), 0);
	}

	@Test
	public void testCalculate_NoMatches() {
		song = new SongBuilder().withGenres("6").build();
		Assert.assertEquals(0, new GenreCalculator().calculate(song, playedSongs), 0);
	}

}
