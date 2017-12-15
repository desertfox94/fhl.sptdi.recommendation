package fhl.sptdi.recommendation.util;

import fhl.sptdi.recommendation.io.in.train.PlayedSongImpl;
import fhl.sptdi.recommendation.model.PlayedSong;
import fhl.sptdi.recommendation.model.Song;

public class PlayedSongBuilder {

    private PlayedSong playedSong = new PlayedSongImpl();

    public PlayedSong build() {
        return playedSong;
    }

    public PlayedSongBuilder withSong(Song song) {
        playedSong.setSong(song);
        return this;
    }

}
