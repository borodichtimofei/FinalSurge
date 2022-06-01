package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import dto.Workout;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import pages.base.BasePage;

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
        if (typeActivity.equals("No Sub-Type")) {
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
        Configuration.timeout = 100;
        try {
            return $(By.xpath("//p[contains(@class, 'testme dont-break-out')]")).getText().split(":")[1].
                    replaceAll("\n", "");
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            log.warn("Element description not found");
            Configuration.timeout = 10000;
            return null;
        }
    }

    public String getDistance() {
        Configuration.timeout = 100;
        try {
            return $(By.xpath("//span[@class='label label-info']")).getText().split("\\.")[0];
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            log.warn("Element distance not found");
            Configuration.timeout = 10000;
            return null;
        }
    }

    public String getDistanceType() {
        Configuration.timeout = 100;
        try {
            return $(By.xpath("//span[@class='label label-info']")).getText().split(" ")[1];
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            log.warn("Element type distance not found");
            Configuration.timeout = 10000;
            return null;
        }
    }

    public String getHowIFeelType() {
        Configuration.timeout = 100;
        try {
            return $(By.xpath("//small[contains(text(), 'How I Felt:')]/..//span")).getText();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            log.warn("Element type How I Felt not found");
            Configuration.timeout = 10000;
            return null;
        }
    }

    public String getCaloriesBurned() {
        Configuration.timeout = 100;
        try {
            return $(By.xpath("//p[@class='formSep' and contains(.,'Calories Burned:')]//span")).getText().
                    split(":")[1].substring(1).replaceAll(" kCal", "");
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            log.warn("Element calories burned not found");
            Configuration.timeout = 10000;
            return null;
        }
    }

    public String getMinHR() {
        Configuration.timeout = 100;
        try {
            return $(By.xpath("//p[@class='formSep' and contains(.,'Min HR')]")).getText().
                    split(":")[1].substring(1).replaceAll(" bpm   Avg HR", "");
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            log.warn("Element HR min not found");
            Configuration.timeout = 10000;
            return null;
        }
    }

    public String getAvgHR() {
        Configuration.timeout = 100;
        try {
            return $(By.xpath("//p[@class='formSep' and contains(.,'Min HR')]")).getText().
                    split(":")[2].substring(1).replaceAll(" bpm    Max HR", "");
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            log.warn("Element HR avg not found");
            Configuration.timeout = 10000;
            return null;
        }
    }

    /*
    Getting the parameters of the actual workout for validation
     */
    private Workout getActualWorkout() {
        Workout actual = new Workout();
        actual.setName(getName());
        actual.setDescription(getDescription());
        actual.setDistance(getDistance());
        actual.setDistanceType(getDistanceType());
        actual.setHowIFeltType(getHowIFeelType());
        actual.setCaloriesBurned(getCaloriesBurned());
        actual.setHrMin(getMinHR());
        actual.setHrAvg(getAvgHR());
        return actual;
    }

    @Step("Validation workout data")
    public void validateWorkout(Workout workout) {
        log.info("Validation workout data");
        assertEquals(
                getActualWorkout(),
                workout,
                "Workout data is not valid");
    }
}

