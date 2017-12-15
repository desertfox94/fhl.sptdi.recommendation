package fhl.sptdi.recommendation;

import fhl.sptdi.recommendation.io.in.song.SongImpl;
import fhl.sptdi.recommendation.model.Song;

import java.util.Arrays;
import java.util.List;

public class SongBuilder {

    private Song song = new SongImpl();

    public Song build() {
        return song;
    }

    public SongBuilder withGenres(String... genres) {
        return withGenres(Arrays.asList(genres));
    }

    public SongBuilder withGenres(List<String> genres) {
        genres.forEach(genre -> song.addGenre(genre));
        return this;
    }

    public SongBuilder withComposers(String... composers) {
        return withComposers(Arrays.asList(composers));
    }

    public SongBuilder withComposers(List<String> composers) {
        composers.forEach(composer -> song.addComposer(composer));
        return this;
    }

}
