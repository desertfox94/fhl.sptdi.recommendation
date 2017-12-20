package main.fhl.sptdi.recommendation.calculator;

import java.util.ArrayList;
import java.util.List;

import main.fhl.sptdi.recommendation.calculator.composer.ComposerCalculator;
import main.fhl.sptdi.recommendation.calculator.genre.GenreCalculator;
import main.fhl.sptdi.recommendation.model.PlayedSong;
import main.fhl.sptdi.recommendation.model.Song;

public class Recommender {

	private List<Calculator> calculators;

	public Recommender() {
		init();
	}

	private void init() {
		calculators = new ArrayList<Calculator>();
		calculators.add(new GenreCalculator());
		calculators.add(new ComposerCalculator());
	}

	public int willListenAgain(Song song, List<PlayedSong> playedSongs) {
		int result = 0;
		int weightSum = 0;
		for (Calculator calculator : calculators) {
			int weight = calculator.getWeighting();
			weightSum += weight;
			result += calculator.willListenAgain(song, playedSongs) * weight;
		}
		return (double) result / weightSum >= 0.5 ? 1 : 0;
	}

}
