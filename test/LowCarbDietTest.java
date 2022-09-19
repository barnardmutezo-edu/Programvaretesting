import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class LowCarbDietTest {

    @Test
    public void lowCarbCauseException1e() {
        String errors = "";
        try {
            ArrayList<Food> allowedFood = new ArrayList<>();

            allowedFood.add(new Food("pasta", 60, true, FoodType.Carb));
            allowedFood.add(new Food("pasta", 60, true, FoodType.Carb));
            allowedFood.add(new Food("pasta", 60, true, FoodType.Carb));


            Diet diet = new LowCarbDiet(8, "Gain Weight", allowedFood, 75);


        } catch (Exception e) {
            errors = e.getMessage();
        }

        Assert.assertEquals("A low carb diet can't contain more than 2 types of carb foods.", errors);
    }

    @Test
    public void lowCarbandietWeight2c() {
        String errors = "";
        try {
            ArrayList<Person> weight = new ArrayList<>();
            ArrayList<Food> allowedFood = new ArrayList<>();
            ArrayList<Food> allergies = new ArrayList<>();
            allergies.add(new Food("pasta", 60, true, FoodType.Carb));
            Food faveFood = new Food("Beef", 100, true, FoodType.Recipe);

            Diet vegan = new LowCarbDiet(8, "Gain Weight", allergies, 75);

            Person person = new Person(faveFood, allowedFood, vegan, 70);

        } catch (Exception e) {
            errors = e.getMessage();
        }

        Assert.assertEquals("The person is to light to use this Diet.", errors);
    }

}
