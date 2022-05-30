package tests;

import dto.Account;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class RegistrationTest extends BaseTest {

    @Test
    public void test(){
        Account account = Account.builder()
                .timeZone("(GMT+02:00) Minsk")
                .firstName("Timo")
                .lastName("Bo")
                .emailAddress("borokko1980@gmail.com")
                .password("Kazantip2007")
                .reTypePassword("Kazantip2007")
                .build();
        registrationSteps.create(account);
    }

}
