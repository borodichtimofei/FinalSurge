package tests;

import dto.Calculator;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import tests.base.Retry;

public class CalculatorTest extends BaseTest {

    @Test(description = "Calculation with correct data", retryAnalyzer = Retry.class)
    public void whenEnteringTheCorrectDataShouldBeCalculation() {
        loginSteps.login(user, password);
        Calculator calculator = Calculator.builder().
                typeDistance("Kilometers").
                raceDistance("Marathon").
                hours("10").
                minutes("10").
                seconds("10").
                build();
        calculatorSteps.calculation("Pace Calculator", calculator);
        calculatorSteps.validateResult("Mile", "23:16 min/mi", "2.6 mph");
    }

    @Test(description = "Calculation with incorrect data", retryAnalyzer = Retry.class)
    public void withoutEnteringValueDistanceShouldBeError() {
        loginSteps.login(user, password);
        Calculator calculator = Calculator.builder().
                typeDistance("Kilometers").
                hours("10").
                minutes("10").
                seconds("10").
                build();
        calculatorSteps.calculation("Pace Calculator", calculator);
        calculatorSteps.validateError("*Please enter a value for Distance.");
    }

    @Test(description = "Calculation with incorrect data", retryAnalyzer = Retry.class)
    public void withoutEnteringValueMinutesShouldBeError() {
        loginSteps.login(user, password);
        Calculator calculator = Calculator.builder().
                distance("10").
                typeDistance("Kilometers").
                build();
        calculatorSteps.calculation("Pace Calculator", calculator);
        calculatorSteps.validateError("*Please enter an Integer value for Minutes.");
    }
}
