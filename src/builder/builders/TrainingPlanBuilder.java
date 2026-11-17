package builder.builders;

import builder.product.TrainingPlan;

/**
 * Builder interface - declares the steps to build a TrainingPlan.
 * Every step returns the builder itself, so calls can be chained.
 */
public interface TrainingPlanBuilder {

    TrainingPlanBuilder forMember(String memberName);

    TrainingPlanBuilder goal(String goal);

    TrainingPlanBuilder daysPerWeek(int days);

    TrainingPlanBuilder durationWeeks(int weeks);

    TrainingPlanBuilder addExercise(String exercise);

    TrainingPlanBuilder withTrainer(String trainer);

    TrainingPlanBuilder withNutritionPlan();

    TrainingPlan build();
}
