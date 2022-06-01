package tests;

import dto.Account;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import tests.base.Retry;

public class RegistrationTest extends BaseTest {

    @DataProvider(name = "Input data for negative registration tests")
    public Object[][] RegistrationDataNegative() {
        return new Object[][]{
                {"test", "test", "borokko1980@gmail.com", "123456", "123456", "(GMT+02:00) Minsk",
                        "Error: *Please enter a Password value with at least one number, lower-case letter," +
                                " and upper-case letter between 7 and 15 characters in length."},
                {"test", "test", "borokko1980@gmail.com", "Kazantip2211", "Kazantip2211", "(GMT+02:00) Minsk",
                        "Error: There is already a user account associated with this Email Address. Please retrieve" +
                                " your password or create an account with a different address."}};
    }

    @Test(dataProvider = "Input data for negative registration tests", retryAnalyzer = Retry.class,
            description = "Registration with negative data")
    public void ifTheDataIsIncorrectRegistrationShouldNotBePerformed(String firstName, String lastName,
                                                                     String eMail, String password,
                                                                     String reTypePassword,
                                                                     String timeZone, String errorMessage) {
        Account account = Account.builder()
                .firstName(firstName)
                .lastName(lastName)
                .emailAddress(eMail)
                .password(password)
                .reTypePassword(reTypePassword)
                .timeZone(timeZone)
                .build();
        registrationSteps.createAccount(account, errorMessage);
    }
}

