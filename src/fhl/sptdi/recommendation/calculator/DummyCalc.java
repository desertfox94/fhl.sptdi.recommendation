package fhl.sptdi.recommendation.calculator;

import java.util.List;

import fhl.sptdi.recommendation.model.PlayedSong;

public class DummyCalc implements Calculator {

	@Override
	public double calculate(PlayedSong playedSong, List<PlayedSong> songs) {
		return 0;
	}

	@Override
	public int getGewichtung() {
		return 3;
	}

}
