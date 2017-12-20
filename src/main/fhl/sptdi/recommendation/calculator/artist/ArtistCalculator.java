package main.fhl.sptdi.recommendation.calculator.artist;

import java.util.List;
import java.util.Set;

import main.fhl.sptdi.recommendation.calculator.Calculator;
import main.fhl.sptdi.recommendation.model.PlayedSong;
import main.fhl.sptdi.recommendation.model.Song;

public class ArtistCalculator extends Calculator {

	@Override
	public double calculate(Song song, List<PlayedSong> playedSongs) {
		ArtistMetrics metric = new ArtistMetrics(playedSongs);
		Set<String> artists = song.getArtists();
		double result = 0;
		for (String artist : artists) {
			if (metric.isFavorite(artist)) {
				result += (1.0 / (double) artists.size());
			} else if (metric.likesArtist(artist)) {
				result += (0.75 / (double) artists.size());
			} else if (metric.dislikeArtis(artist)) {
				result -= (0.15 / (double) artists.size());
			}
		}
		return result;
	}

}
