package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import pages.base.BasePage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

@Log4j2
public class NavigationPage extends BasePage {

    public static final By USER_INFO = By.xpath("//div[@class = 'user-info']");
    public static final By CALCULATOR_SELECT = By.xpath("//i[@class = 'icsw16-calculator']");
    public static final By CALCULATOR_FRAME = By.id("OtherCalciFrame");

    @Override
    @Step("Waiting for navigation page to be opened")
    public NavigationPage isPageOpened() {
        log.info("Waiting for navigation page to be opened");
        $(USER_INFO).shouldBe(Condition.visible);
        return this;
    }

    @Step("Click on calculator button")
    public CalculatorModal selectCalculator() {
        $(CALCULATOR_SELECT).click();
        switchTo().frame($(CALCULATOR_FRAME));
        return new CalculatorModal();
    }
}
