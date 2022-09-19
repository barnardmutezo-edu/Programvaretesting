import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class VeganDietTest {




    @Test
    public void dietIsNotVegan1C() {
        String error = "";

        try {
            ArrayList<Food> allowedFood = new ArrayList<>();

            allowedFood.add(new Food("Pie", 400f, true, FoodType.Carb));
            allowedFood.add(new Food("Meat", 100f, true, FoodType.Fat));
            allowedFood.add(new Food("Burger", 350f, false, FoodType.Carb));
            Diet diet = new VeganDiet(60, "Gain weight", allowedFood, 80);


        } catch (Exception e) {
            error = e.getMessage();
        }

        Assert.assertEquals("Must be vegan!", error);

    }

    @Test
    public void vegandietWeight2c() {
        String errors = "";
        try {
            ArrayList<Person> weight = new ArrayList<>();
            ArrayList<Food> allowedFood = new ArrayList<>();
            ArrayList<Food> allergies = new ArrayList<>();
            allergies.add(new Food("pasta", 60, true, FoodType.Carb));
            Food faveFood = new Food("Beef", 100, true, FoodType.Recipe);

            Diet vegan = new VeganDiet(8, "Gain Weight", allergies, 75);

            Person person = new Person(faveFood, allowedFood, vegan, 70);

        } catch (Exception e) {
            errors = e.getMessage();
        }

        Assert.assertEquals("The person is to light to use this Diet.", errors);
    }


}
