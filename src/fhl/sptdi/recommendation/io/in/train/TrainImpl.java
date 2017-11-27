package fhl.sptdi.recommendation.io.in.train;

import fhl.sptdi.recommendation.model.Member;
import fhl.sptdi.recommendation.model.Song;
import fhl.sptdi.recommendation.model.Train;

public class TrainImpl implements Train {

	String memberId;
	Member member;
	String songId;
	Song song;
	String sourceSystemTab;
	String sourceScreenName;
	String sourceType;
	String target;

	@Override
	public String getMemberId() {
		return memberId;
	}

	@Override
	public String getSongId() {
		return songId;
	}

	@Override
	public String getSourceSystemTab() {
		return sourceSystemTab;
	}

	@Override
	public String getSourceScreenName() {
		return sourceScreenName;
	}

	@Override
	public String getSourceType() {
		return sourceType;
	}

	@Override
	public String getTarget() {
		return target;
	}

	@Override
	public Member getMember() {
		return member;
	}

	@Override
	public Song getSong() {
		return song;
	}

	@Override
	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public void setSong(Song song) {
		this.song = song;
	}

	@Override
	public String toString() {
		return "Train[Member(" + member == null ? "null" : member.toString() + "), Song(" + song == null ? "null" : song.toString() + ")]";
	}

}
