package fhl.sptdi.recommendation.calculator;

import java.util.List;

import fhl.sptdi.recommendation.model.PlayedSong;
import fhl.sptdi.recommendation.model.Song;

public abstract class Calculator {

	public abstract double calculate(Song song, List<PlayedSong> playedSongs);

	public int willListenAgain(Song song, List<PlayedSong> playedSongs) {
		return calculate(song, playedSongs) >= 0.5 ? 1 : 0;
	}

	public final int getWeighting() {
		return Weightings.get(this.getClass());
	}

}
