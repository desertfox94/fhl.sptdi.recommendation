package fhl.sptdi.recommendation.io.in.songextrainfo;

import fhl.sptdi.recommendation.model.SongExtraInfo;

public class SongExtraInfoImpl implements SongExtraInfo {

	String songId;
	String songName;
	String isrc;

	@Override
	public String getSongId() {
		return songId;
	}

	@Override
	public String getSongName() {
		return songName;
	}

	@Override
	public String getIsrc() {
		return isrc;
	}

}
