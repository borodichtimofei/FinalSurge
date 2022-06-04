package pages;


import com.codeborne.selenide.Condition;
import dto.Calculator;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import pages.base.BasePage;
import wrappers.DropDown;
import wrappers.Input;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertEquals;

@Log4j2
public class CalculatorModal extends BasePage {

    public static final By BUTTON_CALCULATE_PACES = By.id("saveButtonSettings"),
            LOCATOR_RESULT_PACE_PER = By.xpath("//table[@class = 'table table-condensed table-hover']//tr[1]//td[1]"),
            LOCATOR_RESULT_TIME = By.xpath("//table[@class = 'table table-condensed table-hover']//tr[1]//td[2]"),
            LOCATOR_RESULT_SPEED = By.xpath("//table[@class = 'table table-condensed table-hover']//tr[1]//td[3]"),
            LOCATOR_ERROR_MESSAGE = By.xpath("//div[@class = 'alert alert-error']");

    @Override
    public CalculatorModal isPageOpened() {
        $(byText("Caloric Needs")).shouldBe(Condition.visible);
        return this;
    }

    @Step("Select calculator type '{calculatorType}'")
    public CalculatorModal selectCalculatorType(String calculatorType) {
        log.info("Select activity - {}", calculatorType);
        $(byText(calculatorType)).click();
        return this;
    }

    @Step("Filling in the calculator form")
    public CalculatorModal enterValues(Calculator calculator) {
        log.info("Filling in the calculator form");
        new Input("Distance").writeCalculatorDistance(calculator.getDistance());
        new DropDown("Distance").selectForCalculatorType(calculator.getTypeDistance());
        new DropDown("Distance").selectForCalculatorRace(calculator.getRaceDistance());
        new Input("Hours").writeCalculatorTime(calculator.getHours());
        new Input("Minutes").writeCalculatorTime(calculator.getMinutes());
        new Input("Seconds").writeCalculatorTime(calculator.getSeconds());
        return this;
    }

    @Step("Click on button 'Calculate Paces'")
    public void calculatePaces() {
        $(BUTTON_CALCULATE_PACES).click();
    }

    @Step("Get result Pace Per")
    public String getPacePer() {
        log.info("Get result Pace Per");
        return $(LOCATOR_RESULT_PACE_PER).getText();
    }

    @Step("Get result time")
    public String getTime() {
        log.info("Get result time");
        return $(LOCATOR_RESULT_TIME).getText();
    }

    @Step("Get result time")
    public String getSpeed() {
        log.info("Get result time");
        return $(LOCATOR_RESULT_SPEED).getText();
    }

    @Step("Validation result calculation")
    public void validateResultCalculation(String expectedPacePer, String expectedTime, String expectedSpeed) {
        log.info("Validation result calculation");
        assertEquals(getPacePer(),
                expectedPacePer,
                "Pace Per not valid");
        assertEquals(getTime(),
                expectedTime,
                "Result time not valid");
        assertEquals(getSpeed(),
                expectedSpeed,
                "Result speed not valid");
    }

    @Step("Getting the error message")
    public String getErrorMessage() {
        log.info("Getting the error message");
        return $(LOCATOR_ERROR_MESSAGE).getText().split(":")[1].substring(1);
    }

    @Step("Error message validation when calculation")
    public void validateErrorCalculation(String expectedErrorMessage) {
        log.info("Error message validation when calculation");
        assertEquals(getErrorMessage(),
                expectedErrorMessage,
                "Error message not correct");
    }
}
