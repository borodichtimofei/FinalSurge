package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import pages.base.BasePage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class LoginPage extends BasePage {

    public static final By USER_EMAIL = By.id("login_name");
    public static final By PASSWORD = By.id("login_password");

    @Override
    @Step("Waiting for login page to be opened")
    public LoginPage isPageOpened() {
        log.info("Waiting for login page to be opened");
        $(USER_EMAIL).shouldBe(Condition.visible);
        return this;
    }

    @Step("Opening login page")
    public LoginPage openPage() {
        log.info("Opening login page");
        open("UserProfile.cshtml");
        return this;
    }

    @Step("Log in by '{user}' using password '{password}'")
    public NavigationPage login(String user, String password) {
        log.info("Log in by {} using password {}", user, password);
        $(USER_EMAIL).sendKeys(user);
        $(PASSWORD).sendKeys(password);
        $(USER_EMAIL).submit();
        return new NavigationPage();
    }
}
