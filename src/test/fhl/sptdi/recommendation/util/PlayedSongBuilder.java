package test.fhl.sptdi.recommendation.util;

import main.fhl.sptdi.recommendation.io.in.train.PlayedSongImpl;
import main.fhl.sptdi.recommendation.model.PlayedSong;
import main.fhl.sptdi.recommendation.model.Song;

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
