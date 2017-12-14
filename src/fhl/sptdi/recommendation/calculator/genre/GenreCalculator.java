package fhl.sptdi.recommendation.calculator.genre;

import java.util.List;
import java.util.Set;

import fhl.sptdi.recommendation.calculator.Calculator;
import fhl.sptdi.recommendation.model.PlayedSong;
import fhl.sptdi.recommendation.model.Song;

public class GenreCalculator extends Calculator {

	@Override
	public double calculate(Song song, List<PlayedSong> playedSongs) {
		Set<String> genres = song.getGenres();
		GenreMetrics genreMetrics = new GenreMetrics(playedSongs);
		double result = 0;
		double size = genres.size();
		for (String genre : genres) {
			result += genreMetrics.songsOfGenre(genre) / size;
		}
		return result;
	}

}
