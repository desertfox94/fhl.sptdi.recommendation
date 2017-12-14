package fhl.sptdi.recommendation.calculator.genre;

import java.util.List;
import java.util.Set;

import fhl.sptdi.recommendation.calculator.Calculator;
import fhl.sptdi.recommendation.model.PlayedSong;

public class GenreCalculator extends Calculator {

	@Override
	public double calculate(PlayedSong playedSong, List<PlayedSong> songs) {
		Set<String> genres = playedSong.getSong().getGenres();
		GenreMetrics genreMetrics = new GenreMetrics(songs);
		double result = 0;
		double size = genres.size();
		for (String genre : genres) {
			result += genreMetrics.songsOfGenre(genre) / size;
		}
		return result;
	}

}
