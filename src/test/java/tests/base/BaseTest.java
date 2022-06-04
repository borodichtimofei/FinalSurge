package tests.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import steps.AddWorkoutSteps;
import steps.CalculatorSteps;
import steps.LoginSteps;
import steps.RegistrationSteps;
import utils.PropertyReader;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {

    public String user;
    public String password;
    protected LoginSteps loginSteps;
    protected RegistrationSteps registrationSteps;
    protected AddWorkoutSteps addWorkoutSteps;
    protected CalculatorSteps calculatorSteps;

    @Parameters({"browser"})
    @BeforeMethod(description = "Opening browser")
    public void setup(@Optional("chrome") String browser) {
        user = System.getProperty("final.surge.user", PropertyReader.getProperty("user"));

        password = System.getProperty("final.surge.password", PropertyReader.getProperty("password"));

        Configuration.baseUrl = "https://log.finalsurge.com/";
        Configuration.browser = browser;
        Configuration.headless = true;
        Configuration.clickViaJs = true;
        Configuration.timeout = 10000;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.reportsFolder = "target/allure-results";

        loginSteps = new LoginSteps();
        registrationSteps = new RegistrationSteps();
        addWorkoutSteps = new AddWorkoutSteps();
        calculatorSteps = new CalculatorSteps();
    }

    @AfterMethod(alwaysRun = true, description = "Closing browser")
    public void close() {
        if (getWebDriver() != null) {
            getWebDriver().quit();
        }
    }
}
