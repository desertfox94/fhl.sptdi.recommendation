package fhl.sptdi.recommendation.io.in.train;

import fhl.sptdi.recommendation.io.in.CsvImporter;
import fhl.sptdi.recommendation.io.in.CsvLine;
import fhl.sptdi.recommendation.model.PlayedSong;

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
		train.target = line.getValue(5);
		return train;
	}

}
