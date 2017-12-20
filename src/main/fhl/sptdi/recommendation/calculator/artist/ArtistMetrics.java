package main.fhl.sptdi.recommendation.calculator.artist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import main.fhl.sptdi.recommendation.model.PlayedSong;
import main.fhl.sptdi.recommendation.model.Song;

public class ArtistMetrics {

	private static final double ARTIST_SKIPPED_PRECENTAGE_BOUND = 1.0 / 3.0;

	private Map<String, Integer> notPlayedAgainCount = new HashMap<String, Integer>();

	private Map<String, Integer> playedAgainCount = new HashMap<String, Integer>();

	public ArtistMetrics(List<PlayedSong> playedSongs) {
		initMetric(playedSongs);
	}

	private void initMetric(List<PlayedSong> playedSongs) {
		for (PlayedSong playedSong : playedSongs) {
			Song song = playedSong.getSong();
			Set<String> artists = song.getArtists();
			Map<String, Integer> counter;
			for (String artist : artists) {
				if (playedSong.getPlayedAgain()) {
					counter = playedAgainCount;
				} else {
					counter = notPlayedAgainCount;
				}
				Integer count = counter.getOrDefault(artist, 0);
				counter.put(artist, count);
			}
		}
	}

	public boolean isFavorite(String artist) {
		double playedAgain = playedAgainCount.get(artist);
		double notPlayedAgain = notPlayedAgainCount.get(artist);
		if (notPlayedAgain > playedAgain) {
			return false;
		}
		double artistSkipPrecentage = notPlayedAgain / playedAgain;
		if (artistSkipPrecentage > ARTIST_SKIPPED_PRECENTAGE_BOUND) {
			return false;
		}
		return playedAgain > 5; // TODO: evtl checken ob der Artist mehre Songs hat.
	}

	public boolean dislikeArtis(String artist) {
		return !likesArtist(artist);
	}

	public boolean likesArtist(String artist) {
		return playedAgainCount.get(artist) - notPlayedAgainCount.get(artist) > 0;
	}

	public int getArtistPlayedAgainCount() {
		return playedAgainCount.size();
	}

	public int getArtistNotPlayedAgainCount() {
		return notPlayedAgainCount.size();
	}

}