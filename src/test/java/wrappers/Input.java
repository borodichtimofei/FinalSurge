package wrappers;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class Input {

    String label;

    public Input(String label) {
        this.label = label;
    }

    @Step("Writing: {text} into: {label}")
    public void WriteForRegistration(String text) {
        if (StringUtils.isNoneEmpty(text)) {
            log.info("Writing {} into  {}", text, label);
            $(By.xpath(String.format("//label[text()='%s']/../input", label))).sendKeys(text);
        }
    }

    @Step("Writing: {text} into: {label}")
    public void basicWriteForAddWorkout(String text) {
        if (StringUtils.isNoneEmpty(text)) {
            log.info("Writing {} into  {}", text, label);
            $(By.xpath(String.format("//label[text()='%s']//../following-sibling::input", label))).clear();
            $(By.xpath(String.format("//label[text()='%s']//../following-sibling::input", label))).sendKeys(text);
        }
    }

    @Step("Writing: {text} into: {label}")
    public void timeWriteForAddWorkout(String text) {
        if (StringUtils.isNoneEmpty(text)) {
            log.info("Writing {} into  {}", text, label);
            $(By.xpath(String.format("//label[text()='%s']//..//div//input", label))).clear();
            $(By.xpath(String.format("//label[text()='%s']//..//div//input", label))).sendKeys(text);
        }
    }

    @Step("Writing: {text} into: {label}")
    public void secondaryWriteForAddWorkout(String text) {
        if (StringUtils.isNoneEmpty(text)) {
            log.info("Writing {} into  {}", text, label);
            $(By.xpath(String.format("(//label[text()='%s']//../following-sibling::input)[2]", label))).clear();
            $(By.xpath(String.format("(//label[text()='%s']//../following-sibling::input)[2]", label))).sendKeys(text);
        }
    }


}

