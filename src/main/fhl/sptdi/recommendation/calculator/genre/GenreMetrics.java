package main.fhl.sptdi.recommendation.calculator.genre;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import main.fhl.sptdi.recommendation.model.PlayedSong;

public class GenreMetrics {

	private Map<String, Integer> genresPlayed = new HashMap<>();

	// with duplicated genres
	private int genreCountOverall;

	private double songCount;

	public GenreMetrics(List<PlayedSong> songs) {
		genresPlayed = extractGenres(songs);
		genreCountOverall = countGenres();
		songCount = songs.size();
	}

	public double songsOfGenre(String genre) {
		return genresPlayed.get(genre) != null ? genresPlayed.get(genre) / songCount : 0;
	}

	private int countGenres() {
		int genreCountOverall = 0;
		for (Integer genreCount : genresPlayed.values()) {
			genreCountOverall += genreCount;
		}
		return genreCountOverall;
	}

	private Map<String, Integer> extractGenres(List<PlayedSong> songs) {
		Map<String, Integer> genresPlayed = new HashMap<>();
		Integer genreCount;
		Set<String> genres;
		for (PlayedSong playedSong : songs) {
			genres = playedSong.getSong().getGenres();
			for (String genre : genres) {
				genreCount = genresPlayed.getOrDefault(genre, 0);
				genresPlayed.put(genre, ++genreCount);
			}
		}
		return genresPlayed;
	}

}
