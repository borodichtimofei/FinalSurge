package wrappers;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class DropDown {

    String label;

    public DropDown(String label) {
        this.label = label;
    }

    @Step("Select: {option} into: {label}")
    public void selectForRegistration(String option) {
        log.info("Select {} into {}", option, label);
        $(By.xpath(String.format("//label[text()='%s']/../select", label))).click();
        $(byText(option)).click();
    }

    @Step("Select: {option} into: {label}")
    public void basicSelectForAddWorkout(String option) {
        if (StringUtils.isNoneEmpty(option)) {
            log.info("Select {} into {}", option, label);
            $(By.xpath(String.format("//label[text()='%s']//../following-sibling::select", label))).
                    selectOption(option);
        }
    }

    @Step("Select: {option} into: {label}")
    public void secondarySelectForAddWorkout(String option) {
        if (StringUtils.isNoneEmpty(option)) {
            log.info("Select {} into {}", option, label);
            $(By.xpath(String.format("(//label[text()='%s']//../following-sibling::select)[2]", label))).
                    selectOption(option);
        }
    }


}


