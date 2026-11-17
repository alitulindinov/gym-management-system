package builder.director;

import builder.builders.TrainingPlanBuilder;
import builder.product.TrainingPlan;

/**
 * Director of the Builder pattern.
 * It knows the ORDER of steps for ready-made plans,
 * the builder knows HOW to build each part.
 */
public class PlanDirector {

    private final TrainingPlanBuilder builder;

    public PlanDirector(TrainingPlanBuilder builder) {
        this.builder = builder;
    }

    public TrainingPlan makeWeightLossPlan(String memberName) {
        return builder.forMember(memberName)
                .goal("Weight loss")
                .daysPerWeek(4)
                .durationWeeks(8)
                .addExercise("Treadmill 30 min")
                .addExercise("Cycling")
                .addExercise("Plank")
                .withNutritionPlan()
                .build();
    }

    public TrainingPlan makeMuscleGainPlan(String memberName, String trainer) {
        return builder.forMember(memberName)
                .goal("Muscle gain")
                .daysPerWeek(5)
                .durationWeeks(12)
                .addExercise("Bench press")
                .addExercise("Squats")
                .addExercise("Deadlift")
                .withTrainer(trainer)
                .withNutritionPlan()
                .build();
    }
}
