package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class LoginTest extends BaseTest{

        @Test(description = "Log in")
        public void test() {
        loginSteps.login(user, password);
        }
}
