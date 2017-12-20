package main.fhl.sptdi.recommendation.io.in.song;

import java.util.HashSet;
import java.util.Set;

import main.fhl.sptdi.recommendation.model.Song;

public class SongImpl implements Song {

	String id;
	long length;
	Set<String> genres = new HashSet<>();
	Set<String> artists = new HashSet<>();
	String lyrics;
	String language;
	Set<String> composers = new HashSet<>();

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
	public Set<String> getArtists() {
		return artists;
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
	public Set<String> getComposers() {
		return composers;
	}

	@Override
	public String toString() {
		return getId() + ", " + artists.toString();
	}

	@Override
	public void addGenre(String genre) {
		genres.add(genre);
	}

	public void setComposer(Set<String> composers) {
		this.composers = composers;
	}

	@Override
	public void addComposer(String composer) {
		composers.add(composer);
	}

}
