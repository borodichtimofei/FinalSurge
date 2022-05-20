package steps;

import dto.Account;
import pages.RegistrationPage;

public class RegistrationSteps {

    RegistrationPage registrationPage;

    public RegistrationSteps(){
        registrationPage = new RegistrationPage();
    }

    public void create(Account account) {
        registrationPage.openPage()
                .isPageOpened()
                .create(account)
                .save();
    }
}
