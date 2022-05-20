package pages;

import com.codeborne.selenide.Condition;
import dto.Account;
import org.openqa.selenium.By;
import pages.base.BasePage;
import wrappers.DropDown;
import wrappers.Input;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage extends BasePage {

    public static final By FIRST_NAME = By.id("create_first");

    @Override
    public RegistrationPage isPageOpened() {
        $(FIRST_NAME).shouldBe(Condition.visible);
        return this;
    }

    public RegistrationPage openPage(){
        open("register.cshtml");
        return this;
    }

    public RegistrationPage create(Account account){
        new Input("First Name").write(account.getFirstName());
        new Input("Last Name").write(account.getLastName());
        new Input("Email Address").write(account.getEmailAddress());
        new Input("Password").write(account.getPassword());
        new Input("Re-type password").write(account.getReTypePassword());
        new DropDown("Time Zone").select(account.getTimeZone());
        return this;
    }

    public void save(){
        $(FIRST_NAME).submit();
    }
}
