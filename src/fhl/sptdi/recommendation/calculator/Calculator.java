package fhl.sptdi.recommendation.calculator;

import java.util.List;

import fhl.sptdi.recommendation.model.PlayedSong;

public abstract class Calculator {

	private int weighting;

	public Calculator(int weighting) {
		this.weighting = weighting;
	}

	public abstract double calculate(PlayedSong playedSong, List<PlayedSong> songs);

	public int willListenAgain(PlayedSong playedSong, List<PlayedSong> songs) {
		return calculate(playedSong, songs) >= 0.5 ? 1 : 0;
	}

	public final int getWeighting() {
		return weighting;
	}

}
