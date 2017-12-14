package fhl.sptdi.recommendation.calculator;

import java.util.List;

import fhl.sptdi.recommendation.model.PlayedSong;

public interface Calculator {

	double calculate(PlayedSong playedSong, List<PlayedSong> songs);

	default int willListenAgain(PlayedSong playedSong, List<PlayedSong> songs) {
		return calculate(playedSong, songs) >= 0.5 ? 1 : 0;
	}

	int getGewichtung();

}
