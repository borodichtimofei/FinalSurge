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
                save().
                isPageOpened();
    }

    public void validate(String activity, String typeActivity, Workout workout) {
        workoutDetailsPage.validateActivity(activity, typeActivity);
        workoutDetailsPage.validateWorkout(workout);
    }
}
