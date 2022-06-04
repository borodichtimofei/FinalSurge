package wrappers;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class DropDown {

    public static final String LOCATOR_REGISTRATION = "//label[text()='%s']/../select";
    public static final String LOCATOR_WORKOUT_BASIC = "//label[text()='%s']//../following-sibling::select";
    public static final String LOCATOR_WORKOUT_SECONDARY = "(//label[text()='%s']//../following-sibling::select)[2]";
    public static final String LOCATOR_CALCULATOR_TYPE = "//label[text() = '%s:']/..//select[1]";
    public static final String LOCATOR_CALCULATOR_RACE = "//label[text() = '%s:']/..//select[2]";

    String label;

    public DropDown(String label) {
        this.label = label;
    }

    @Step("Choosing: {option} into: {this.label}")
    public void selectForRegistration(String option) {
        log.info("Choosing {} into {}", option, label);
        $(By.xpath(String.format(LOCATOR_REGISTRATION, label))).click();
        $(byText(option)).click();
    }

    @Step("Choosing: {option} into: {this.label}")
    public void basicSelectForAddWorkout(String option) {
        if (StringUtils.isNoneEmpty(option)) {
            log.info("Choosing {} into {}", option, label);
            $(By.xpath(String.format(LOCATOR_WORKOUT_BASIC, label))).
                    selectOption(option);
        }
    }

    @Step("Choosing: {option} into: {this.label}")
    public void secondarySelectForAddWorkout(String option) {
        if (StringUtils.isNoneEmpty(option)) {
            log.info("Choosing {} into {}", option, label);
            $(By.xpath(String.format(LOCATOR_WORKOUT_SECONDARY, label))).
                    selectOption(option);
        }
    }

    @Step("Choosing: {option} into: {this.label}")
    public void selectForCalculatorType(String option) {
        if (StringUtils.isNoneEmpty(option)) {
            log.info("Choosing {} into {}", option, label);
            $(By.xpath(String.format(LOCATOR_CALCULATOR_TYPE, label))).
                    selectOption(option);
        }
    }

    @Step("Choosing: {option} into: {this.label}")
    public void selectForCalculatorRace(String option) {
        if (StringUtils.isNoneEmpty(option)) {
            log.info("Choosing {} into {}", option, label);
            $(By.xpath(String.format(LOCATOR_CALCULATOR_RACE, label))).
                    selectOption(option);
        }
    }


}


