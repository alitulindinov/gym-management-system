package builder.builders;

import builder.product.TrainingPlan;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete builder - collects the parts and creates the TrainingPlan in build().
 */
public class GymTrainingPlanBuilder implements TrainingPlanBuilder {

    private String memberName;
    private String goal = "General fitness";
    private int daysPerWeek = 3;
    private int durationWeeks = 4;
    private List<String> exercises = new ArrayList<>();
    private String trainer;
    private boolean nutritionPlan;

    @Override
    public TrainingPlanBuilder forMember(String memberName) {
        this.memberName = memberName;
        return this;
    }

    @Override
    public TrainingPlanBuilder goal(String goal) {
        this.goal = goal;
        return this;
    }

    @Override
    public TrainingPlanBuilder daysPerWeek(int days) {
        this.daysPerWeek = days;
        return this;
    }

    @Override
    public TrainingPlanBuilder durationWeeks(int weeks) {
        this.durationWeeks = weeks;
        return this;
    }

    @Override
    public TrainingPlanBuilder addExercise(String exercise) {
        exercises.add(exercise);
        return this;
    }

    @Override
    public TrainingPlanBuilder withTrainer(String trainer) {
        this.trainer = trainer;
        return this;
    }

    @Override
    public TrainingPlanBuilder withNutritionPlan() {
        this.nutritionPlan = true;
        return this;
    }

    @Override
    public TrainingPlan build() {
        if (memberName == null || memberName.isEmpty()) {
            throw new IllegalStateException("Member name is required");
        }
        if (daysPerWeek < 1 || daysPerWeek > 7) {
            throw new IllegalStateException("Days per week must be from 1 to 7");
        }
        TrainingPlan plan = new TrainingPlan(memberName, goal, daysPerWeek, durationWeeks,
                exercises, trainer, nutritionPlan);
        reset(); // the same builder can be used again for the next plan
        return plan;
    }

    private void reset() {
        memberName = null;
        goal = "General fitness";
        daysPerWeek = 3;
        durationWeeks = 4;
        exercises = new ArrayList<>();
        trainer = null;
        nutritionPlan = false;
    }
}
