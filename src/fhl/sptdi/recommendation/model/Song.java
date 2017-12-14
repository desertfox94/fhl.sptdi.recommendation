package fhl.sptdi.recommendation.model;

import java.util.Set;

import fhl.sptdi.recommendation.io.in.CsvEntity;

public interface Song extends CsvEntity {

	/**
	 * in ms
	 * 
	 * @return
	 */
	long getLength();

	/**
	 * genre category. Some songs have multiple genres.
	 * 
	 * @return
	 */
	Set<String> getGenres();

	Set<String> getArtists();

	String getLyrics();

	String getLanguage();

	Set<String> getComposer();

	void addGenre(String genre);

	void addComposer(String composer);

}
