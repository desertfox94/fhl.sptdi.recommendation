package fhl.sptdi.recommendation.io.in.train;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import fhl.sptdi.recommendation.io.in.CSVImport;
import fhl.sptdi.recommendation.io.in.member.MemberImporter;
import fhl.sptdi.recommendation.io.in.song.SongImporter;
import fhl.sptdi.recommendation.model.Member;
import fhl.sptdi.recommendation.model.Song;
import fhl.sptdi.recommendation.model.Train;

public class TrainFactory {

	public static List<Train> createFromFile(TrainImportModel importModel) throws IOException {
		Map<String, Song> songs = CSVImport.importFromFile(importModel.songs, new SongImporter());
		Map<String, Member> members = CSVImport.importFromFile(importModel.members, new MemberImporter());
		List<Train> trains = CSVImport.importFromFile(importModel.songs, new RawTrainImporter());
		for (Train train : trains) {
			train.setMember(members.get(train.getMemberId()));
			train.setSong(songs.get(train.getSongId()));
		}
		return trains;
	}

}
