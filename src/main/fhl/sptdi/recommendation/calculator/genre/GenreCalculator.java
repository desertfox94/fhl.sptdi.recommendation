package main.fhl.sptdi.recommendation.calculator.genre;

import java.util.List;
import java.util.Set;

import main.fhl.sptdi.recommendation.calculator.Calculator;
import main.fhl.sptdi.recommendation.model.PlayedSong;
import main.fhl.sptdi.recommendation.model.Song;

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
