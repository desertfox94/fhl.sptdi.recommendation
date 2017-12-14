package fhl.sptdi.recommendation.calculator;

import fhl.sptdi.recommendation.calculator.genre.GenreCalculator;

import java.util.HashMap;
import java.util.Optional;

public class Weightings {

    private static HashMap<Class<? extends Calculator>, Integer> hashMap;

    static {
        hashMap = new HashMap<>();
        hashMap.put(GenreCalculator.class, 2);
    }

    /**
     * Returns the weighting of a calculator.
     * @param calculator the calculator
     * @return the weighting of the calculator or 1 if no weighting is specified
     */
    public static Integer get(Class calculator) {
        return Optional.ofNullable(hashMap.get(calculator)).orElse(1);
    }

}
