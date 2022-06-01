package pages;


import dto.Calculator;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalculatorModal {

    public void selectCalculatorType(String typeCalculator) {
        $(byText(typeCalculator)).click();
    }

    public void calculation(Calculator calculator) {
        $(By.id("RunDist")).sendKeys(calculator.getDistance());
        $(By.id("DistType")).selectOption(calculator.getTypeDistance());
        $(By.id("RaceDist")).selectOption(calculator.getRaceDistance());
        $(By.id("TimeHH")).sendKeys(calculator.getHours());
        $(By.id("TimeMM")).sendKeys(calculator.getMinutes());
        $(By.id("TimeSS")).sendKeys(calculator.getSeconds());
    }

    public void calculatePaces() {
        $(By.id("saveButtonSettings")).click();
    }


}
