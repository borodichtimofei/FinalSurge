package steps;

import dto.Workout;
import pages.AddWorkoutModal;
import pages.AddWorkoutPage;
import pages.WorkoutDetailsPage;

public class AddWorkoutSteps {

    AddWorkoutPage addWorkoutPage;
    AddWorkoutModal addWorkoutModal;
    WorkoutDetailsPage workoutDetailsPage;

    public AddWorkoutSteps() {
        addWorkoutPage = new AddWorkoutPage();
        addWorkoutModal = new AddWorkoutModal();
        workoutDetailsPage = new WorkoutDetailsPage();
    }

    public void addWorkout(String activity, String typeActivity, Workout workout) {
        addWorkoutPage.openPage().
                isPageOpened().
                selectActivity(activity).
                selectTypeActivity(typeActivity).
                isPageOpened().
                create(workout).
                save();
    }

    public void validate(String expectedActivity, String expectedTypeActivity, Workout workout) {
        workoutDetailsPage.validateActivity(expectedActivity, expectedTypeActivity);
        workoutDetailsPage.validateWorkout(workout);
    }

    public void validateErrorMessage(String expectedErrorMessage) {
        addWorkoutModal.validateErrorMessageAddWorkout(expectedErrorMessage);
    }
}
