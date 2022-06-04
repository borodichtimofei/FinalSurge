package pages;

import com.codeborne.selenide.Condition;
import dto.Workout;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import pages.base.BasePage;
import wrappers.CheckBox;
import wrappers.DropDown;
import wrappers.Input;
import wrappers.TextArea;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertEquals;

@Log4j2
public class AddWorkoutModal extends BasePage {

    public static final String MESSAGE = "Add New Workout";
    public static final By ADD_WORKOUT_BUTTON = By.xpath("//input[@type = 'submit']"),
            LOCATOR_ERROR_MESSAGE = By.xpath("//div[@class = 'alert alert-error']");

    @Override
    public AddWorkoutModal isPageOpened() {
        $(byText(MESSAGE)).shouldBe(Condition.visible);
        return this;
    }

    @Step("Filling in the Workout Add form")
    public AddWorkoutModal create(Workout workout) {
        log.info("Filling in the Workout Add form with name {}", workout.getName());
        new Input("Workout Name").basicWriteForAddWorkout(workout.getName());
        new Input("Date").basicWriteForAddWorkout(workout.getDate());
        new Input("Time of Day").timeWriteForAddWorkout(workout.getTimeOfDay());
        new TextArea("Workout Description").write(workout.getDescription());
        new Input("Distance").secondaryWriteForAddWorkout(workout.getDistance());
        new DropDown("Distance").secondarySelectForAddWorkout(workout.getDistanceType());
        new Input("Duration").secondaryWriteForAddWorkout(workout.getDistance());
        new Input("Elevation Gain").basicWriteForAddWorkout(workout.getElevationGain());
        new DropDown("Elevation Gain").basicSelectForAddWorkout(workout.getElevationGainType());
        new Input("Elevation Loss").basicWriteForAddWorkout(workout.getElevationLoss());
        new DropDown("Elevation Loss").basicSelectForAddWorkout(workout.getElevationLossType());
        new DropDown("Perceived Effort").basicSelectForAddWorkout(workout.getPerceivedEffort());
        new Input("Avg Power").basicWriteForAddWorkout(workout.getAvgPower());
        new Input("Max Power").basicWriteForAddWorkout(workout.getMaxPower());
        new Input("Avg Cadence").basicWriteForAddWorkout(workout.getAvgCadence());
        new Input("Max Cadence").basicWriteForAddWorkout(workout.getMaxCadence());
        new Input("Min HR").basicWriteForAddWorkout(workout.getHrMin());
        new Input("Avg HR").basicWriteForAddWorkout(workout.getHrAvg());
        new Input("Max HR").basicWriteForAddWorkout(workout.getHrMax());
        new Input("Calories Burned").basicWriteForAddWorkout(workout.getCaloriesBurned());
        new CheckBox("How I Felt").click(workout.getHowIFeltType());
        return this;
    }

    @Step("Click on button 'Add workout'")
    public void save() {
        log.info("Click on button 'Add workout'");
        $(ADD_WORKOUT_BUTTON).click();
    }

    @Step("Getting the error message")
    public String getErrorMessage() {
        log.info("Getting the error message");
        return $(LOCATOR_ERROR_MESSAGE).getText().split(":")[1].substring(1);
    }

    @Step("Error message validation when adding a workout")
    public void validateErrorMessageAddWorkout(String expectedErrorMessage) {
        log.info("Error message validation when adding a workout");
        assertEquals(getErrorMessage(),
                expectedErrorMessage,
                "Error message not correct");
    }
}

