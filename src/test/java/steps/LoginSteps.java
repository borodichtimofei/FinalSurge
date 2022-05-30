package steps;

import io.qameta.allure.Step;
import pages.LoginPage;

public class LoginSteps {

    LoginPage loginPage;

    public LoginSteps() {
        loginPage = new LoginPage();
    }

    @Step("Log in by '{user}' using password '{password}'")
    public void login(String user, String password) {
        loginPage.openPage()
                .isPageOpened()
                .login(user, password);
    }
}
