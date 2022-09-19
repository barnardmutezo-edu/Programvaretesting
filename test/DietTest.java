import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class DietTest {
    @Test
    public void dietIsNotVegan1A() {
        ArrayList<Food> allowedFood = new ArrayList<>();

        allowedFood.add(new Food("Pie", 400f, true, FoodType.Carb));
        allowedFood.add(new Food("Meat", 100f, true, FoodType.Fat));
        allowedFood.add(new Food("Burger", 350f, false, FoodType.Carb));
        Diet diet = new HyperCaloricDiet(60, "Gain weight", allowedFood, 100, 80);

        Assert.assertFalse(diet.isVegan);
        System.out.println("Diet is not vegan");
    }


    @Test
    public void CheckVeganFood1B() {

        ArrayList<Food> foods = new ArrayList<>();
        foods.add(new Food("bread", 29, true, FoodType.Carb));
        foods.add(new Food("vegan meat", 100, true, FoodType.Protein));
        LowCarbDiet lowCarbDiet = new LowCarbDiet(367, "Save the animals", foods, 20f);
        Assert.assertTrue(lowCarbDiet.isVegan);
        System.out.println("Diet is vegan");
    }


    @Test
    public void dietReturnsDietDuration3A() {
        ArrayList<Food> allowedFood = new ArrayList<>();
        allowedFood.add(new Food("Pie", 400f, true, FoodType.Fat));
        allowedFood.add(new Food("Meat", 100f, true, FoodType.Fat));
        allowedFood.add(new Food("Burger", 350f, true, FoodType.Carb));

        Diet diet = new HyperCaloricDiet(368, "Healthy", allowedFood, 90, 500);
        var res = diet.dietDuration();

        Assert.assertEquals("This HyperCaloricDiet lasts for 1 years, 0 months and 3 days.", res);
    }

    @Test
    public void allowedFood3B() {
        ArrayList<Food> allowedFood = new ArrayList<>();
        Food f1 = new Food("Salad", 20, true, FoodType.Carb);
        Food f2 = new Food("Soup", 20, true, FoodType.Carb);
        Food f3 = new Food("Apple", 20, true, FoodType.Carb);
        Food f4 = new Food("Strawberry", 20, true, FoodType.Carb);
        Food f5 = new Food("Salmon", 20, true, FoodType.Carb);

        allowedFood.add(f1);
        allowedFood.add(f2);
        allowedFood.add(f3);
        allowedFood.add(f4);
        allowedFood.add(f5);

        Food faveFood = new Food("Meat", 300, false, FoodType.Protein);
        Diet diet = new FlexitorianDiet(60, "Healthy", allowedFood, 30, faveFood);
        var res = diet.allowedFood();
        Assert.assertEquals("The following food is allowed on this FlexitorianDiet: Salad, Soup, Apple, Strawberry, Salmon.", res);


    }
}