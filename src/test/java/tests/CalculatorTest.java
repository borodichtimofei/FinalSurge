package tests;

import dto.Calculator;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class CalculatorTest extends BaseTest {

    @Test
    public void test() {
        loginSteps.login(user, password);
        Calculator calculator = Calculator.builder().
                distance("10").
                typeDistance("Kilometers").
                raceDistance("Marathon").
                hours("10").
                minutes("10").
                seconds("10").
                build();
        calculatorSteps.calculator("Pace Calculator", calculator);
    }
}
