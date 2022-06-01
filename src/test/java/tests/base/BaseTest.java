package tests.base;

import com.codeborne.selenide.Configuration;

import com.codeborne.selenide.logevents.SelenideLogger;


import io.qameta.allure.selenide.AllureSelenide;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import steps.AddWorkoutSteps;
import steps.CalculatorSteps;
import steps.LoginSteps;
import steps.RegistrationSteps;
import utils.PropertyReader;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Listeners({TestListener.class})

public class BaseTest {

    protected LoginSteps loginSteps;
    protected RegistrationSteps registrationSteps;
    protected AddWorkoutSteps addWorkoutSteps;
    protected CalculatorSteps calculatorSteps;

    public String user;
    public String password;

    @BeforeMethod(description = "Opening browser")
    public void setup() {
        user = System.getProperty("user", PropertyReader.getProperty("user"));
        password = System.getProperty("password", PropertyReader.getProperty("password"));


        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));


        Configuration.baseUrl = "https://log.finalsurge.com/";
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.clickViaJs = true;
        Configuration.timeout = 10000;

        loginSteps = new LoginSteps();
        registrationSteps = new RegistrationSteps();
        addWorkoutSteps = new AddWorkoutSteps();
        calculatorSteps = new CalculatorSteps();
    }

    @AfterMethod(alwaysRun = true, description = "Closing browser")
    public void close() {
        if (getWebDriver() != null)
            getWebDriver().quit();
    }
}
