package wrappers;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class TextArea {

    public static final String LOCATOR_WORKOUT = "//label[text()='%s']//../following-sibling::textarea";

    String label;

    public TextArea(String label) {
        this.label = label;
    }

    @Step("Writing: {text} into: {label}")
    public void write(String text) {
        if (StringUtils.isNoneEmpty(text)) {
            log.info("Writing {} into  {}", text, label);
            $(By.xpath(String.format(LOCATOR_WORKOUT, label))).clear();
            $(By.xpath(String.format(LOCATOR_WORKOUT, label))).sendKeys(text);
        }
    }
}
