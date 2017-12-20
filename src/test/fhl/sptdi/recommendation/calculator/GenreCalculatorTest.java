package test.fhl.sptdi.recommendation.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import test.fhl.sptdi.recommendation.util.PlayedSongBuilder;
import test.fhl.sptdi.recommendation.util.SongBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.fhl.sptdi.recommendation.calculator.genre.GenreCalculator;
import main.fhl.sptdi.recommendation.io.in.train.PlayedSongImpl;
import main.fhl.sptdi.recommendation.model.PlayedSong;
import main.fhl.sptdi.recommendation.model.Song;

public class GenreCalculatorTest {

	private Song song;
	private List<PlayedSong> playedSongs = new ArrayList<>();

	@Before
	public void setUp() {
		List<Song> songs = Arrays.asList(
				new SongBuilder().withGenres("1", "4").build(),
				new SongBuilder().withGenres("1", "2", "3").build(),
				new SongBuilder().withGenres("2", "3", "5").build());
		songs.forEach(song -> playedSongs.add(new PlayedSongBuilder().withSong(song).build()));
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
