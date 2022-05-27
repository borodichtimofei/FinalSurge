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

@Log4j2
public class AddWorkoutModal extends BasePage {

    public static final String MESSAGE = "Add New Workout";

    @Override
    public AddWorkoutModal isPageOpened() {
        log.info("Waiting for add workout modal page to be opened");
        $(byText(MESSAGE)).shouldBe(Condition.visible);
        return this;
    }

    @Step("Input information for add workout")
    public AddWorkoutModal create(Workout workout) {
        log.info("Input information for add workout {}", workout);
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
        $(By.xpath("//input[@type = 'submit']")).click();
    }
}

