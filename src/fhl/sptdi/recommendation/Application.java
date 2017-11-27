package fhl.sptdi.recommendation;

import java.io.File;
import java.io.IOException;
import java.util.List;

import fhl.sptdi.recommendation.io.in.train.TrainFactory;
import fhl.sptdi.recommendation.io.in.train.TrainImportModel;
import fhl.sptdi.recommendation.model.Train;

public class Application {

	public static void main(String[] args) throws IOException {

		String root = new File("").getAbsolutePath() + "\\data";

		File trainCsv = new File(root + "\\trains.csv");
		File memberCsv = new File(root + "\\members.csv");
		File songCsv = new File(root + "\\songs.csv");
		TrainImportModel importModel = new TrainImportModel(trainCsv, memberCsv, songCsv);
		List<Train> trains = TrainFactory.createFromFile(importModel);
		System.out.println(trains);
	}

}
