package wrappers;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class DropDown {

    String label;

    public DropDown(String label) {
        this.label = label;
    }

    @Step("Select: {option} into: {select}")
    public void select(String option) {
        $(By.xpath(String.format("//label[text()='%s']/../select", label))).click();
        $(byText(option)).click();
    }
}
