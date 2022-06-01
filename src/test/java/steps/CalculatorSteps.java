package steps;

import dto.Calculator;
import pages.CalculatorModal;
import pages.NavigationPage;

public class CalculatorSteps {

    NavigationPage navigationPage;
    CalculatorModal calculatorModal;

    public CalculatorSteps() {
        navigationPage = new NavigationPage();
        calculatorModal = new CalculatorModal();
    }

    public void calculation(String typeCalculator, Calculator calculator) {
        navigationPage.selectCalculator().
                isPageOpened().
                selectCalculatorType(typeCalculator).
                enterValues(calculator).
                calculatePaces();
    }

    public void validateResult(String expectedPacePer, String expectedTime, String expectedSpeed) {
        calculatorModal.validateResultCalculation(expectedPacePer, expectedTime, expectedSpeed);
    }

    public void validateError(String expectedErrorMessage) {
        calculatorModal.validateErrorCalculation(expectedErrorMessage);
    }
}
