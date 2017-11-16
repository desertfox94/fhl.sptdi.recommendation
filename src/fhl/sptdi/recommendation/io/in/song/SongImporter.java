package fhl.sptdi.recommendation.io.in.song;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import fhl.sptdi.recommendation.io.in.CsvEntityImporter;
import fhl.sptdi.recommendation.io.in.CsvLine;
import fhl.sptdi.recommendation.model.Song;

public class SongImporter extends CsvEntityImporter<Song> {

	@Override
	public Song importEntity(CsvLine line) {
		SongImpl song = new SongImpl();
		song.id = line.getValue(0);
		song.length = Long.parseLong(line.getValue(1));
		song.genres = parseGenres(line.getValue(2));
		song.artistName = line.getValue(3);
		song.composer = line.getValue(4);
		song.lyrics = line.getValue(5);
		song.language = line.getValue(6);
		return song;
	}

	private Set<String> parseGenres(String genre) {
		if (genre.isEmpty()) {
			return Collections.emptySet();
		}
		String[] genres = genre.split("\\|");
		HashSet<String> result = new HashSet<>(genre.length());
		for (String g : genres) {
			result.add(g.trim());
		}
		return result;
	}

}
