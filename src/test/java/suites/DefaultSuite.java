package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.CalculationTest;
import tests.SavingsCalculatorTest;

    @RunWith(Suite.class)
    @Suite.SuiteClasses({
            CalculationTest.class,
            SavingsCalculatorTest.class
    })
    public class DefaultSuite{
    }

