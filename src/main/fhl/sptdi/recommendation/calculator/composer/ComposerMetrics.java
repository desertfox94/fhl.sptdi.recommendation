package main.fhl.sptdi.recommendation.calculator.composer;

import main.fhl.sptdi.recommendation.model.PlayedSong;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ComposerMetrics {

	private Map<String, Integer> composersPlayed = new HashMap<>();

	// with duplicated composers
	private int composersCountOverall;

	private double songCount;

	public ComposerMetrics(List<PlayedSong> songs) {
		composersPlayed = extractComposers(songs);
		composersCountOverall = countComposers();
		songCount = songs.size();
	}

	public double songsOfComposer(String composer) {
		return composersPlayed.get(composer) != null ? composersPlayed.get(composer) / songCount : 0;
	}

	private int countComposers() {
		int composersCountOverall = 0;
		for (Integer composersCount : composersPlayed.values()) {
			composersCountOverall += composersCount;
		}
		return composersCountOverall;
	}

	private Map<String, Integer> extractComposers(List<PlayedSong> songs) {
		Map<String, Integer> composersPlayed = new HashMap<>();
		Integer composersCount;
		Set<String> composers;
		for (PlayedSong playedSong : songs) {
			composers = playedSong.getSong().getComposers();
			for (String composer : composers) {
				composersCount = composersPlayed.getOrDefault(composer, 0);
				composersPlayed.put(composer, ++composersCount);
			}
		}
		return composersPlayed;
	}

}
