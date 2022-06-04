package tests;

import dto.Workout;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class AddWorkoutTest extends BaseTest {

    @Test(description = "Add new workout with correct data")
    public void workoutRunTypeWithCorrectDataShouldBeCreated() {
        loginSteps.login(user, password);
        Workout workout = Workout.builder()
                .name("Test name")
                .date("6/02/2022")
                .timeOfDay("11:30 AM")
                .description("Test description")
                .distance("10")
                .distanceType("km")
                .duration("10")
                .perceivedEffort("8 (Hard)")
                .howIFeltType("Normal")
                .hrMin("60")
                .hrAvg("90")
                .hrMax("120")
                .caloriesBurned("1500")
                .build();
        addWorkoutSteps.addWorkout("Run", "Marathon Pace", workout);
        addWorkoutSteps.validate("Run", "Marathon Pace", workout);
    }

    @Test(description = "Add new workout with correct data")
    public void workoutBikeWithCorrectDataShouldBeCreated() {
        loginSteps.login(user, password);
        Workout workout = Workout.builder()
                .name("Test name")
                .date("6/01/2022")
                .timeOfDay("10:45 PM")
                .description("Test description")
                .distance("10")
                .distanceType("km")
                .duration("10")
                .elevationGain("15")
                .elevationGainType("m")
                .elevationLoss("10")
                .elevationLossType("m")
                .perceivedEffort("8 (Hard)")
                .howIFeltType("Normal")
                .avgPower("100")
                .maxPower("150")
                .avgCadence("200")
                .maxCadence("250")
                .hrMin("60")
                .hrAvg("90")
                .hrMax("120")
                .caloriesBurned("1500")
                .build();
        addWorkoutSteps.addWorkout("Bike", "Tempo", workout);
        addWorkoutSteps.validate("Bike", "Tempo", workout);
    }

    @Test(description = "Add new workout with correct data")
    public void workoutRestDayWithCorrectDataShouldBeCreated() {
        loginSteps.login(user, password);
        Workout workout = Workout.builder()
                .name("Test name")
                .date("6/01/2022")
                .description("Test description")
                .build();
        addWorkoutSteps.addWorkout("Rest Day", "No Sub-Type", workout);
        addWorkoutSteps.validate("Rest Day", "No Sub-Type", workout);
    }

    @Test(description = "Add new workout with incorrect data")
    public void workoutSwimWithoutValuesDataNotShouldBeCreated() {
        loginSteps.login(user, password);
        Workout workout = Workout.builder()
                .name("Test name")
                .date(" ")
                .timeOfDay("10:45 PM")
                .description("Test description")
                .build();
        addWorkoutSteps.addWorkout("Swim", "Open Water", workout);
        addWorkoutSteps.validateErrorMessage("*Please enter a value for Workout Date.");
    }
}
