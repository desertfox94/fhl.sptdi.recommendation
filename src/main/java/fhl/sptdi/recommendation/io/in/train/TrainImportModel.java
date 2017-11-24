package fhl.sptdi.recommendation.io.in.train;

import java.io.File;

public class TrainImportModel {

	public final File trains;
	public final File members;
	public final File songs;

	public TrainImportModel(File trains, File members, File songs) {
		this.trains = trains;
		this.members = members;
		this.songs = songs;
	}

}
