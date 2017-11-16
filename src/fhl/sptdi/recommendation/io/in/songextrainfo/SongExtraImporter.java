package fhl.sptdi.recommendation.io.in.songextrainfo;

import fhl.sptdi.recommendation.io.in.CsvImporter;
import fhl.sptdi.recommendation.io.in.CsvLine;
import fhl.sptdi.recommendation.model.SongExtraInfo;

public class SongExtraImporter extends CsvImporter<SongExtraInfo> {

	@Override
	protected SongExtraInfo importEntity(CsvLine line) {
		SongExtraInfoImpl songExtraInfo = new SongExtraInfoImpl();
		songExtraInfo.songId = line.getValue(0);
		songExtraInfo.songName = line.getValue(1);
		songExtraInfo.isrc = line.getValue(2);
		return songExtraInfo;
	}

}
