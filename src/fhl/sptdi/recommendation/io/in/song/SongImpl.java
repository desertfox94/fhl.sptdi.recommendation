package fhl.sptdi.recommendation.io.in.song;

import java.util.Set;

import fhl.sptdi.recommendation.model.Song;

public class SongImpl implements Song {

	String id;
	long length;
	Set<String> genres;
	String artistName;
	String lyrics;
	String language;
	String composer;

	SongImpl() {
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public long getLength() {
		return length;
	}

	@Override
	public Set<String> getGenres() {
		return genres;
	}

	@Override
	public String getArtistName() {
		return artistName;
	}

	@Override
	public String getLyrics() {
		return lyrics;
	}

	@Override
	public String getLanguage() {
		return language;
	}

	@Override
	public String getComposer() {
		return composer;
	}

	@Override
	public String toString() {
		return getId() + ", " + getArtistName();
	}

}
