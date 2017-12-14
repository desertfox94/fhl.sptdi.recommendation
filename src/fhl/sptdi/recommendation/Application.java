package fhl.sptdi.recommendation;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import fhl.sptdi.recommendation.io.in.train.PlayedSongFactory;
import fhl.sptdi.recommendation.io.in.train.PlayedSongImportModel;
import fhl.sptdi.recommendation.model.PlayedSong;

public class Application {

	public static void main(String[] args) throws IOException {
		String root = new File("").getAbsolutePath() + File.separator + "data";
		File trainCsv = new File(root + File.separator + "train.csv");
		File memberCsv = new File(root + File.separator + "members.csv");
		File songCsv = new File(root + File.separator + "songs.csv");
		PlayedSongImportModel importModel = new PlayedSongImportModel(trainCsv, memberCsv, songCsv);
		List<PlayedSong> trains = new CopyOnWriteArrayList<>(PlayedSongFactory.createFromFile(importModel));
		for (PlayedSong train : trains) {
			if (train.getMember() == null && train.getSong() == null) {
				trains.remove(train);
			}
		}
		trains.forEach(System.out::println);
	}

}
