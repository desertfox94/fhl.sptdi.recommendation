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

	String getArtistName();

	String getLyrics();

	String getLanguage();

	String getComposer();

	void addGenre(String genre);

}
