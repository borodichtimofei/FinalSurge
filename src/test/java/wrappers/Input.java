package wrappers;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class Input {

    public static final String LOCATOR_REGISTRATION = "//label[text()='%s']/../input";
    public static final String LOCATOR_WORKOUT_BASIC = "//label[text()='%s']//../following-sibling::input";
    public static final String LOCATOR_WORKOUT_TIME = "//label[text()='%s']//..//div//input";
    public static final String LOCATOR_WORKOUT_SECONDARY = "(//label[text()='%s']//../following-sibling::input)[2]";

    String label;

    public Input(String label) {
        this.label = label;
    }

    @Step("Writing: {text} into: {label}")
    public void WriteForRegistration(String text) {
        if (StringUtils.isNoneEmpty(text)) {
            log.info("Writing {} into  {}", text, label);
            $(By.xpath(String.format(LOCATOR_REGISTRATION, label))).sendKeys(text);
        }
    }

    @Step("Writing: {text} into: {label}")
    public void basicWriteForAddWorkout(String text) {
        if (StringUtils.isNoneEmpty(text)) {
            log.info("Writing {} into  {}", text, label);
            $(By.xpath(String.format(LOCATOR_WORKOUT_BASIC, label))).clear();
            $(By.xpath(String.format(LOCATOR_WORKOUT_BASIC, label))).sendKeys(text);
        }
    }

    @Step("Writing: {text} into: {label}")
    public void timeWriteForAddWorkout(String text) {
        if (StringUtils.isNoneEmpty(text)) {
            log.info("Writing {} into  {}", text, label);
            $(By.xpath(String.format(LOCATOR_WORKOUT_TIME, label))).clear();
            $(By.xpath(String.format(LOCATOR_WORKOUT_TIME, label))).sendKeys(text);
        }
    }

    @Step("Writing: {text} into: {label}")
    public void secondaryWriteForAddWorkout(String text) {
        if (StringUtils.isNoneEmpty(text)) {
            log.info("Writing {} into  {}", text, label);
            $(By.xpath(String.format(LOCATOR_WORKOUT_SECONDARY, label))).clear();
            $(By.xpath(String.format(LOCATOR_WORKOUT_SECONDARY, label))).sendKeys(text);
        }
    }


}

