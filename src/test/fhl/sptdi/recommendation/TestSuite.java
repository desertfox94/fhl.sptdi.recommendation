package test.fhl.sptdi.recommendation;

import test.fhl.sptdi.recommendation.calculator.ComposerCalculatorTest;
import test.fhl.sptdi.recommendation.calculator.GenreCalculatorTest;
import test.fhl.sptdi.recommendation.calculator.RecommenderTest;
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