package fhl.sptdi.recommendation.model;

public interface Train {

	String getSongId();

	String getMemberId();

	/**
	 * the name of the tab where the event was triggered. System tabs are used to
	 * categorize KKBOX mobile apps functions. For example, tab my library contains
	 * functions to manipulate the local storage, and tab search contains functions
	 * relating to search.
	 * 
	 * @return
	 */
	String getSourceSystemTab();

	/**
	 * name of the layout a user sees
	 * 
	 * @return
	 */
	String getSourceScreenName();

	/**
	 * an entry point a user first plays music on mobile apps. An entry point could
	 * be album, online-playlist, song .. etc.
	 * 
	 * @return
	 */
	String getSourceType();

	/**
	 * this is the target variable. target=1 means there are recurring listening
	 * event(s) triggered within a month after the user’s very first observable
	 * listening event, target=0 otherwise .
	 * 
	 * @return
	 */
	String getTarget();

	Member getMember();

	Song getSong();

	void setMember(Member member);

	void setSong(Song song);

}
