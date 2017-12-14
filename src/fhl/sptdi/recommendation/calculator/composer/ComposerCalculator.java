package fhl.sptdi.recommendation.calculator.composer;

import fhl.sptdi.recommendation.calculator.Calculator;
import fhl.sptdi.recommendation.calculator.genre.GenreMetrics;
import fhl.sptdi.recommendation.model.PlayedSong;
import fhl.sptdi.recommendation.model.Song;

import java.util.List;
import java.util.Set;


public class ComposerCalculator extends Calculator {

    @Override
    public double calculate(Song song, List<PlayedSong> playedSongs) {
        Set<String> composers = song.getComposers();
        ComposerMetrics composerMetrics = new ComposerMetrics(playedSongs);
        double result = 0;
        double size = composers.size();
        for (String composer : composers) {
            result += composerMetrics.songsOfComposer(composer) / size;
        }
        return result;
    }

}
