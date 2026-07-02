interface MealPlan {
    String getMeal();
}

class VegetarianMeal implements MealPlan {

    public String getMeal() {
        return "Vegetarian Meal";
    }
}

class VeganMeal implements MealPlan {

    public String getMeal() {
        return "Vegan Meal";
    }
}

class KetoMeal implements MealPlan {

    public String getMeal() {
        return "Keto Meal";
    }
}

class Meal<T extends MealPlan> {

    T plan;

    Meal(T plan) {
        this.plan = plan;
    }

    void showMeal() {
        System.out.println(plan.getMeal());
    }
}

public class MealDemo {

    public static <T extends MealPlan> void generateMeal(T meal) {

        System.out.println("Generated : " + meal.getMeal());
    }

    public static void main(String[] args) {

        VegetarianMeal veg = new VegetarianMeal();

        Meal<VegetarianMeal> meal = new Meal<>(veg);

        meal.showMeal();

        generateMeal(veg);
    }
}