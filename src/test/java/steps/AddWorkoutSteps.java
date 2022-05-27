package steps;

import dto.Workout;
import pages.AddWorkoutModal;
import pages.AddWorkoutPage;

public class AddWorkoutSteps {

    AddWorkoutPage addWorkoutPage;
    AddWorkoutModal addWorkoutModal;

    public AddWorkoutSteps() {
        addWorkoutPage = new AddWorkoutPage();
        addWorkoutModal = new AddWorkoutModal();
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
}
