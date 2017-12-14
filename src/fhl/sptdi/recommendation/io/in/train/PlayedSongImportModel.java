package fhl.sptdi.recommendation.io.in.train;

import java.io.File;

public class PlayedSongImportModel {

	private static final int DEBUG_LIMIT = 1000;
	public final File trains;
	public final File members;
	public final File songs;
	
	public final int limit;

	public PlayedSongImportModel(File trains, File members, File songs, int limit) {
		this.trains = trains;
		this.members = members;
		this.songs = songs;
		this.limit = limit;
	}
	
	public PlayedSongImportModel(File trains, File members, File songs) {
		this(trains, members, songs, DEBUG_LIMIT);
	}

}
