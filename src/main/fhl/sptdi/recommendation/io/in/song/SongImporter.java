package main.fhl.sptdi.recommendation.io.in.song;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import main.fhl.sptdi.recommendation.io.in.CsvEntityImporter;
import main.fhl.sptdi.recommendation.io.in.CsvLine;
import main.fhl.sptdi.recommendation.model.Song;

public class SongImporter extends CsvEntityImporter<Song> {

	private Set<String> songsPlayedByMembers;

	public SongImporter(Set<String> members) {
		this.songsPlayedByMembers = members;
	}

	@Override
	public Song importEntity(CsvLine line) {
		SongImpl song = new SongImpl();
		song.id = line.getValue(0);
		if (!songsPlayedByMembers.contains(song.getId())) {
			return null;
		}
		song.length = Long.parseLong(line.getValue(1));
		song.genres = parseSet(line.getValue(2));
		song.artists = parseSet(line.getValue(3));
		song.composers = parseSet(line.getValue(4));
		song.lyrics = line.getValue(5);
		song.language = line.getValue(6);
		return song;
	}

	private Set<String> parseSet(String entries) {
		if (entries.isEmpty()) {
			return Collections.emptySet();
		}
		String[] set = entries.split("\\|");
		HashSet<String> result = new HashSet<>(entries.length());
		for (String s : set) {
			result.add(s.trim());
		}
		return result;
	}

}
