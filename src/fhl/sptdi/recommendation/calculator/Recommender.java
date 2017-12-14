package fhl.sptdi.recommendation.calculator;

import java.util.ArrayList;
import java.util.List;

import fhl.sptdi.recommendation.calculator.genre.GenreCalculator;
import fhl.sptdi.recommendation.model.PlayedSong;

public class Recommender {

	private List<Calculator> calculators;

	public Recommender() {
		init();
	}

	private void init() {
		calculators = new ArrayList<Calculator>();
		calculators.add(new GenreCalculator());
		calculators.add(new DummyCalc());
	}

	public int willListenAgain(PlayedSong playedSong, List<PlayedSong> songs) {
		int result = 0;
		int weightSum = 0;
		for (Calculator calculator : calculators) {
			int weight = calculator.getGewichtung();
			weightSum += weight;
			result += calculator.willListenAgain(playedSong, songs) * weight;
		}
		return (double) result / weightSum >= 0.5 ? 1 : 0;
	}

}
