package builder.product;

import java.util.ArrayList;
import java.util.List;

/**
 * Product of the Builder pattern.
 * A training plan has many fields and some of them are optional
 * (trainer, nutrition plan), so it is built step by step.
 */
public class TrainingPlan {

    private final String memberName;
    private final String goal;
    private final int daysPerWeek;
    private final int durationWeeks;
    private final List<String> exercises;
    private final String trainer;        // optional
    private final boolean nutritionPlan; // optional

    public TrainingPlan(String memberName, String goal, int daysPerWeek, int durationWeeks,
                        List<String> exercises, String trainer, boolean nutritionPlan) {
        this.memberName = memberName;
        this.goal = goal;
        this.daysPerWeek = daysPerWeek;
        this.durationWeeks = durationWeeks;
        this.exercises = new ArrayList<>(exercises);
        this.trainer = trainer;
        this.nutritionPlan = nutritionPlan;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getGoal() {
        return goal;
    }

    public List<String> getExercises() {
        return new ArrayList<>(exercises);
    }

    @Override
    public String toString() {
        return "Training plan for " + memberName + "\n"
                + "   Goal: " + goal + "\n"
                + "   Schedule: " + daysPerWeek + " days/week, " + durationWeeks + " weeks\n"
                + "   Exercises: " + String.join(", ", exercises) + "\n"
                + "   Trainer: " + (trainer == null ? "no" : trainer) + "\n"
                + "   Nutrition plan: " + (nutritionPlan ? "yes" : "no");
    }
}
