package pages;

import com.codeborne.selenide.Condition;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import pages.base.BasePage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class NavigationPage extends BasePage {

    public static final By USER_INFO = By.xpath("//div[@class = 'user-info']");

    @Override
    public NavigationPage isPageOpened() {
        log.info("Waiting for navigation page to be opened");
        $(USER_INFO).shouldBe(Condition.visible);
        return this;
    }

    public AddWorkoutPage selectMenuFunction(String menuName, String functionName) {
        $(byText(menuName)).hover();
        $(byText(functionName)).click();
        return new AddWorkoutPage();
    }
}
