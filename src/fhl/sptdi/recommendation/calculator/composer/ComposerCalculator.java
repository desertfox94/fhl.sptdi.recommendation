package fhl.sptdi.recommendation.calculator.composer;

import fhl.sptdi.recommendation.calculator.Calculator;
import fhl.sptdi.recommendation.model.PlayedSong;

import java.util.List;


public class ComposerCalculator extends Calculator {

    @Override
    public double calculate(PlayedSong playedSong, List<PlayedSong> songs) {
        String composer = playedSong.getSong().getComposer();
        long composerCount = songs.stream().map(song -> song.getSong()).filter(song -> song.getComposer().equals(composer)).count();
        return composerCount / (double) songs.size();
    }

}
