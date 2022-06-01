package tests;

import dto.Workout;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class AddWorkoutTest extends BaseTest {

    @Test(description = "Add new workout with correct data")
    public void workoutRunTypeWithCorrectDataShouldBeCreated() {
        loginSteps.login(user, password);
        Workout workout = Workout.builder()
                .name("Test")
                .date("5/30/2022")
                .timeOfDay("05:30 AM")
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
                .name("Test")
                .date("5/31/2022")
                .timeOfDay("11:30 PM")
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
                .name("Test Rest Day workout in Tempo")
                .date("5/30/2022")
                .description("Test description")
                .build();
        addWorkoutSteps.addWorkout("Rest Day", "No Sub-Type", workout);
        addWorkoutSteps.validate("Rest Day", "No Sub-Type", workout);
    }
}
