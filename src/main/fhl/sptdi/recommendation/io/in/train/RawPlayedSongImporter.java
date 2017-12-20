package main.fhl.sptdi.recommendation.io.in.train;

import main.fhl.sptdi.recommendation.io.in.CsvImporter;
import main.fhl.sptdi.recommendation.io.in.CsvLine;
import main.fhl.sptdi.recommendation.model.PlayedSong;

public class RawPlayedSongImporter extends CsvImporter<PlayedSong> {

	public RawPlayedSongImporter(int i) {
		super(i);
	}

	@Override
	protected PlayedSong importEntity(CsvLine line) {
		PlayedSongImpl train = new PlayedSongImpl();
		train.memberId = line.getValue(0);
		train.songId = line.getValue(1);
		train.sourceSystemTab = line.getValue(2);
		train.sourceScreenName = line.getValue(3);
		train.sourceType = line.getValue(4);
		train.playedAgain = Boolean.parseBoolean(line.getValue(5));
		return train;
	}

}
