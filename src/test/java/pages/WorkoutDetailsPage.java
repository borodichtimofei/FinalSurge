package pages;

import com.codeborne.selenide.Condition;
import dto.Workout;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import pages.base.BasePage;

import java.util.Objects;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertEquals;

@Log4j2
public class WorkoutDetailsPage extends BasePage {

    @Override
    @Step("Waiting for workout details page to be opened")
    public WorkoutDetailsPage isPageOpened() {
        log.info("Waiting for workout details page to be opened");
        $(byText("Workout Details")).shouldBe(Condition.visible);
        return this;
    }

    public String getActivity() {
        return $(By.xpath("//span[@class='activityTypeName']")).getText().split("-")[0].trim();
    }

    public String getActivityType() {
        try {
            return $(By.xpath("//span[@class='activityTypeName']")).getText().split("-")[1].substring(1);
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    @Step("Validation activity")
    public void validateActivity(String activity, String typeActivity) {
        log.info("Validation activity type");
        assertEquals(
                getActivity(),
                activity,
                "Activity name is not valid");
        if (Objects.equals(typeActivity, "No Sub-Type")) {
            typeActivity = null;
        }
        assertEquals(
                getActivityType(),
                typeActivity,
                "Activity name is not valid");
    }

    public String getName() {
        return $(By.xpath("//span[@class='activityTypeName']//..//following-sibling::div")).getText();
    }

    public String getDescription() {
        try {
            return $(By.xpath("//p[contains(@class, 'testme dont-break-out')]")).getText().split(":")[1].
                    replaceAll("\n", "");
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            return null;
        }
    }

    public String getDistance() {
        try {
            return $(By.xpath("//span[@class='label label-info']")).getText().split("\\.")[0];
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            return null;
        }
    }

    public String getDistanceType() {
        try {
            return $(By.xpath("//span[@class='label label-info']")).getText().split(" ")[1];
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            return null;
        }
    }

    public String getHowIFeltTypeType() {
        try {
            return $(By.xpath("//small[contains(text(), 'How I Felt:')]/..//span")).getText();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            return null;
        }
    }

    public String getCaloriesBurned() {
        try {
            return $(By.xpath("//p[@class='formSep' and contains(.,'Calories Burned:')]//span")).getText().
                    split(":")[1].substring(1).replaceAll(" kCal", "");
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            return null;
        }
    }

    public String getMinHR() {
        try {
            return $(By.xpath("//p[@class='formSep' and contains(.,'Min HR')]")).getText().
                    split(":")[1].substring(1).replaceAll(" bpm   Avg HR", "");
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            return null;
        }
    }

    public String getAvgHR() {
        try {
            return $(By.xpath("//p[@class='formSep' and contains(.,'Min HR')]")).getText().
                    split(":")[2].substring(1).replaceAll(" bpm    Max HR", "");
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            return null;
        }
    }

    private Workout getActualWorkout() {
        Workout actual = new Workout();
        actual.setName(getName());
        actual.setDescription(getDescription());
        actual.setDistance(getDistance());
        actual.setDistanceType(getDistanceType());
        actual.setHowIFeltType(getHowIFeltTypeType());
        actual.setCaloriesBurned(getCaloriesBurned());
        actual.setHrMin(getMinHR());
        actual.setHrAvg(getAvgHR());
        return actual;
    }

    private Workout getExpectedWorkout(Workout workout) {
        Workout expected = new Workout();
        expected.setName(workout.getName());
        expected.setDescription(workout.getDescription());
        expected.setDistance(workout.getDistance());
        expected.setDistanceType(workout.getDistanceType());
        expected.setHowIFeltType(workout.getHowIFeltType());
        expected.setCaloriesBurned(workout.getCaloriesBurned());
        expected.setHrMin(workout.getHrMin());
        expected.setHrAvg(workout.getHrAvg());
        return expected;
    }

    @Step("Validation workout data")
    public void validateWorkout(Workout workout) {
        log.info("Validation workout data");
        assertEquals(
                getActualWorkout(),
                getExpectedWorkout(workout),
                "Workout data is not valid");
    }
}

