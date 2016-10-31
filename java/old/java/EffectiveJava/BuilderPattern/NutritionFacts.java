package old.java.EffectiveJava.BuilderPattern;

/**
 * Created by pandita on 11/9/2015.
 */
public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class BuilderClass implements Builder<NutritionFacts> {
        // Required parameters
        private final int servingSize;
        private final int servings;
        // Optional parameters - initialized to default values
        private int calories = 0;
        private int fat = 0;
        private int carbohydrate = 0;
        private int sodium = 0;
        public BuilderClass(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }
        public BuilderClass calories(int val)
        { calories = val; return this; }
        public BuilderClass fat(int val)
        { fat = val; return this; }
        public BuilderClass carbohydrate(int val)
        { carbohydrate = val; return this; }
        public BuilderClass sodium(int val)
        { sodium = val; return this; }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }
    private NutritionFacts(BuilderClass builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }
}
