package pages;

import com.codeborne.selenide.Condition;
import dto.Account;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import pages.base.BasePage;
import wrappers.DropDown;
import wrappers.Input;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertEquals;

@Log4j2
public class RegistrationPage extends BasePage {

    public static final By FIRST_NAME = By.id("create_first");
    public static final By REGISTRATION_MESSAGE = By.xpath("//div[@class = 'alert alert-error']");

    @Override
    @Step("Waiting for registration page to be opened")
    public RegistrationPage isPageOpened() {
        log.info("Waiting for registration page to be opened");
        $(FIRST_NAME).shouldBe(Condition.visible);
        return this;
    }

    @Step("Opening registration page")
    public RegistrationPage openPage() {
        log.info("Opening registration page");
        open("register.cshtml");
        return this;
    }

    @Step("Input information for registration")
    public RegistrationPage create(Account account) {
        log.info("Input information for registration account {}", account);
        new Input("First Name").WriteForRegistration(account.getFirstName());
        new Input("Last Name").WriteForRegistration(account.getLastName());
        new Input("Email Address").WriteForRegistration(account.getEmailAddress());
        new Input("Password").WriteForRegistration(account.getPassword());
        new Input("Re-type password").WriteForRegistration(account.getReTypePassword());
        new DropDown("Time Zone").selectForRegistration(account.getTimeZone());
        return this;
    }

    @Step("Validate registration")
    public void validate(String expectedMessage) {
        log.info("Validate registration");
        String actualMessage = $(REGISTRATION_MESSAGE).getText();
        assertEquals(actualMessage, expectedMessage);
    }

    @Step("Click on button 'Save'")
    public RegistrationPage save() {
        log.info("Click on button 'Save'");
        $(FIRST_NAME).submit();
        return this;
    }
}
