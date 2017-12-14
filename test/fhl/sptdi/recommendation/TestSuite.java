package fhl.sptdi.recommendation;

import fhl.sptdi.recommendation.calculator.ComposerCalculatorTest;
import fhl.sptdi.recommendation.calculator.GenreCalculatorTest;
import fhl.sptdi.recommendation.calculator.RecommenderTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        ComposerCalculatorTest.class,
        GenreCalculatorTest.class,
        RecommenderTest.class
})

public class TestSuite {
}