package fhl.sptdi.recommendation;

import fhl.sptdi.recommendation.calculator.ComposerCalculatorTest;
import fhl.sptdi.recommendation.calculator.GenreCalculatorTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        ComposerCalculatorTest.class,
        GenreCalculatorTest.class
})

public class TestSuite {
}