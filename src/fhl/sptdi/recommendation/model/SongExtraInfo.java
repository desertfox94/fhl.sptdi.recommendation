package fhl.sptdi.recommendation.model;

public interface SongExtraInfo {

	String getSongId();

	/**
	 * the name of the song
	 * 
	 * @return
	 */
	String getSongName();

	/**
	 * International Standard Recording Code, theoretically can be used as an
	 * identity of a song. However, what worth to note is, ISRCs generated from
	 * providers have not been officially verified; therefore the information in
	 * ISRC, such as country code and reference year, can be misleading/incorrect.
	 * Multiple songs could share one ISRC since a single recording could be
	 * re-published several times.
	 * 
	 * @return
	 */
	String getIsrc();

}
