package steps;

import dto.Account;
import pages.RegistrationPage;

public class RegistrationSteps {

    RegistrationPage registrationPage;

    public RegistrationSteps() {
        registrationPage = new RegistrationPage();
    }

    public void createAccount(Account account, String expectedMessage) {
        registrationPage.openPage()
                .isPageOpened()
                .create(account)
                .save()
                .validate(expectedMessage);
    }
}
