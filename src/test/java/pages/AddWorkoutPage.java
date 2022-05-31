package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.base.BasePage;

import java.util.Objects;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class AddWorkoutPage extends BasePage {

    @Override
    public AddWorkoutPage isPageOpened() {
        log.info("Waiting for add workout page to be opened");
        $(byText("Select an Activity Type")).shouldBe(Condition.visible);
        return this;
    }

    @Step("Opening add workout page")
    public AddWorkoutPage openPage() {
        log.info("Opening AddWorkout page");
        open("WorkoutAdd.cshtml");
        return this;
    }

    @Step("Select activity '{activity}'")
    public AddWorkoutPage selectActivity(String activity) {
        log.info("Select activity - {}", activity);
        $(byText(activity)).click();
        return new AddWorkoutPage();
    }

    @Step("Select type activity '{typeActivity}'")
    public AddWorkoutModal selectTypeActivity(String typeActivity) {
        log.info("Select type activity - {}", typeActivity);
        if (Objects.equals(typeActivity, "No Sub-Type")) {
            return new AddWorkoutModal();
        } else
            $(byText(typeActivity)).click();
            $(byText(typeActivity)).shouldBe(Condition.visible);
        return new AddWorkoutModal();
    }
}
