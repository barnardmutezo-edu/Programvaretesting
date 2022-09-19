import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class HyperCaloricTest {
    @Test
    public void personWeightsMoreThanLimitHypercaloricDietShouldCauseError2D() {
        String exception = "";
        try {
            ArrayList<Food> allowedFood = new ArrayList<>();
            ArrayList<Food> allergies = new ArrayList<>();
            allergies.add(new Food("pasta", 60, true, FoodType.Carb));


            allowedFood.add(new Food("Pie", 400f, true, FoodType.Fat));
            allowedFood.add(new Food("Meat", 100f, true, FoodType.Fat));
            allowedFood.add(new Food("Burger", 350f, true, FoodType.Carb));

            Diet diet = new HyperCaloricDiet(60, "Healthy", allowedFood, 90, 500);

            Food faveFood = new Food("Beef", 100, true, FoodType.Recipe);
            Person person = new Person(faveFood, allergies, diet, 95);

        } catch (Exception e) {
            exception = e.getMessage();
        }

        Assert.assertEquals("The person is to heavy to use this Diet.", exception);

    }
}
