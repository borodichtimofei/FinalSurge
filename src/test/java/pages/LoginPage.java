package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.base.BasePage;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BasePage {

    public static final By USER_EMAIL = By.id("login_name");
    public static final By PASSWORD = By.id("login_password");

    @Override
    public LoginPage isPageOpened() {
        $(USER_EMAIL).shouldBe(Condition.visible);
        return this;
    }

    @Step("Opening login page")
    public LoginPage openPage() {
        open("UserProfile.cshtml");
        return this;
    }

    @Step("Log in by '{user}' using password '{password}'")
    public void login(String user, String password) {
        $(USER_EMAIL).sendKeys(user);
        $(PASSWORD).sendKeys(password);
        $(USER_EMAIL).submit();
    }

}
