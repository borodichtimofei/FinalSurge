package tests.base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import steps.AddWorkoutSteps;
import steps.LoginSteps;
import steps.RegistrationSteps;
import utils.PropertyReader;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Listeners(TestListener.class)
public class BaseTest {

    protected LoginSteps loginSteps;
    protected RegistrationSteps registrationSteps;
    protected AddWorkoutSteps addWorkoutSteps;

    public String user;
    public String password;

    @BeforeMethod(description = "Opening browser")
    public void setup() {
        user = System.getProperty("user", PropertyReader.getProperty("user"));
        password = System.getProperty("password", PropertyReader.getProperty("password"));

        Configuration.baseUrl = "https://log.finalsurge.com/";
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.clickViaJs = true;
        Configuration.timeout = 10000;

        loginSteps = new LoginSteps();
        registrationSteps = new RegistrationSteps();
        addWorkoutSteps = new AddWorkoutSteps();
    }

    @AfterMethod(alwaysRun = true, description = "Closing browser")
    public void close() {
        if (getWebDriver() != null)
            getWebDriver().quit();
    }
}
