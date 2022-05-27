package steps;

import io.qameta.allure.Step;
import pages.LoginPage;
import pages.NavigationPage;

public class LoginSteps {

    LoginPage loginPage;
    NavigationPage navigationPage;

    public LoginSteps() {
        navigationPage = new NavigationPage();
        loginPage = new LoginPage();
    }

    @Step("Log in by '{user}' using password '{password}'")
    public void login(String user, String password) {
        loginPage.openPage()
                .isPageOpened()
                .login(user, password)
                .isPageOpened();
    }
}
