package wrappers;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class CheckBox {

    String label;

    public CheckBox(String label) {
        this.label = label;
    }

    @Step("Click: {option} into: {label}")
    public void click(String option) {
        if (StringUtils.isNoneEmpty(option)) {
            log.info("Select {} into {}", option, label);
            $(By.xpath(String.format("//label[text()='%s']/..//div//label//span[text()='%s']/..//input", label, option))).
                    click();
        }
    }
}
