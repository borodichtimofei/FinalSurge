package steps;

import dto.Calculator;
import pages.CalculatorModal;
import pages.NavigationPage;

public class CalculatorSteps {

    NavigationPage navigationPage;
    CalculatorModal calculatorModal;

    public CalculatorSteps(){
        navigationPage = new NavigationPage();
        calculatorModal = new CalculatorModal();
    }

    public void calculator(String typeCalculator, Calculator calculator){
        navigationPage.selectCalculator();
        calculatorModal.selectCalculatorType(typeCalculator);
        calculatorModal.calculation(calculator);
        calculatorModal.calculatePaces();
    }
}
