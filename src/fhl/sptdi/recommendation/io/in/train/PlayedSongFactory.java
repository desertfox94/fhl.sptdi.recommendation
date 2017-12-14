package fhl.sptdi.recommendation.io.in.train;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import fhl.sptdi.recommendation.io.in.CSVImport;
import fhl.sptdi.recommendation.io.in.member.MemberImporter;
import fhl.sptdi.recommendation.io.in.song.SongImporter;
import fhl.sptdi.recommendation.model.Member;
import fhl.sptdi.recommendation.model.Song;
import fhl.sptdi.recommendation.model.PlayedSong;

public class PlayedSongFactory {

	public static List<PlayedSong> createFromFile(PlayedSongImportModel importModel) throws IOException {
		List<PlayedSong> trains = CSVImport.importFromFile(importModel.trains, new RawPlayedSongImporter(1000));
		Set<String> memberIds = get(trains, x -> x.getMemberId());
		Map<String, Member> members = CSVImport.importFromFile(importModel.members, new MemberImporter(memberIds));
		Map<String, Song> songs = CSVImport.importFromFile(importModel.songs, new SongImporter(get(trains, x -> x.getSongId())));
		for (PlayedSong train : trains) {
			train.setMember(members.get(train.getMemberId()));
			train.setSong(songs.get(train.getSongId()));
		}
		return trains;
	}
	
	private static Set<String> get(List<PlayedSong> trains, Function<PlayedSong, String> f) {
		Set<String> result = new HashSet<>();
		for (PlayedSong train : trains) {
			result.add(f.apply(train));
		}
		return result;
	}

}
