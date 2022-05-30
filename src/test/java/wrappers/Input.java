package wrappers;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Input {

    String label;

    public Input(String label) {
        this.label = label;
    }

    public void write(String text) {
        if (StringUtils.isNoneEmpty(text)) {
            $(By.xpath(String.format("//label[text()='%s']/../input", label))).sendKeys(text);
        }
    }
}
