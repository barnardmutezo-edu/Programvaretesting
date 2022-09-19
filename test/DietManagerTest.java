import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class DietManagerTest {


    @Test
    public void compatibleOrNot4a() {

        ArrayList<Food> allowedFood = new ArrayList<>();
        allowedFood.add(new Food("pasta", 350f, false, FoodType.Carb));
        allowedFood.add(new Food("rice", 350f, false, FoodType.Carb));
        allowedFood.add(new Food("mayo", 350f, false, FoodType.Carb));
        allowedFood.add(new Food("chicken", 350f, false, FoodType.Carb));

        ArrayList<Food> allowedFood2 = new ArrayList<>();
        allowedFood2.add(new Food("pasta", 350f, false, FoodType.Carb));
        allowedFood2.add(new Food("rice", 350f, false, FoodType.Carb));
        allowedFood2.add(new Food("mayo", 350f, false, FoodType.Carb));


        Diet d = new HyperCaloricDiet(60, "Gain weight", allowedFood, 100, 80);
        Diet d2 = new HyperCaloricDiet(60, "Gain weight", allowedFood2, 100, 80);

        ArrayList<Food> allergies = new ArrayList<>();
        allergies.add(new Food("pasta", 350f, false, FoodType.Carb));
        allergies.add(new Food("rice", 350f, false, FoodType.Carb));

        Person p = new Person(new Food("Taco", 50, false, FoodType.Carb), allergies, d, 82);


        var res = DietManager.compatible(p, d2);
        Assert.assertFalse(res);


    }


    @Test
    public void compatibleOrNot4a2() {

        ArrayList<Food> allowedFood = new ArrayList<>();
        allowedFood.add(new Food("pasta", 350f, false, FoodType.Carb));
        allowedFood.add(new Food("rice", 350f, false, FoodType.Carb));
        allowedFood.add(new Food("mayo", 350f, false, FoodType.Carb));
        allowedFood.add(new Food("chicken", 350f, false, FoodType.Carb));


        Diet d = new HyperCaloricDiet(60, "Gain weight", allowedFood, 100, 80);


        ArrayList<Food> allergies = new ArrayList<>();
        allergies.add(new Food("pasta", 350f, false, FoodType.Carb));
        allergies.add(new Food("rice", 350f, false, FoodType.Carb));
        Person p = new Person(new Food("Taco", 50, false, FoodType.Carb), allergies, d, 82);

        var res = DietManager.compatible(p, d);
        Assert.assertTrue(res);


    }


    @Test
    public void testRandomDiet4b() {

        ArrayList<Food> allowedFood1 = new ArrayList<>();
        ArrayList<Food> listOfAllergies = new ArrayList<>();
        //Making the foods:
        Food Pizza = new Food("Pizza", 100, false, FoodType.Recipe);
        Food Salad = new Food("Salad", 200, true, FoodType.Recipe);
        Food Beef = new Food("Beef", 800, false, FoodType.Protein);
        Food Sitrus = new Food("Sitrus", 200, true, FoodType.Carb);
        //Adding foods to list:
        allowedFood1.add(Pizza); //notvegan
        allowedFood1.add(Beef);
        allowedFood1.add(Salad);
        allowedFood1.add(Sitrus);


        //Add allergies:
        listOfAllergies.add(Sitrus);
        listOfAllergies.add(Salad);

        Diet fd = new FlexitorianDiet(8, "Gain Weight", allowedFood1, 75, Beef);
        Person Anders = new Person(Pizza, listOfAllergies, fd, 81);
        Diet randomDiet = new DietManager().randomDiet(Anders, allowedFood1);


        //4B0
        Assert.assertEquals("HyperCaloricDiet", randomDiet.dietName());


        //4BI
        boolean randomDietDurationValid = randomDiet.daysDuration <= 100 && randomDiet.daysDuration >= 1;
        Assert.assertTrue(randomDietDurationValid);


        //4BII
        Assert.assertEquals("Random Diet", randomDiet.purpose);


        //4BIII
        boolean nonAllergicRandomDiet = false;
        for (Food f : randomDiet.allowedFood) {

            if (Anders.getDiet().allowedFood.contains(f))
                nonAllergicRandomDiet = true;
        }
        Assert.assertTrue(nonAllergicRandomDiet);


        //4BIV
        Assert.assertFalse(randomDiet.isVegan);

        //4V
        boolean maxWeightIsValid = randomDiet.getMaxWeightKg() >= Anders.getWeight() && randomDiet.getMaxWeightKg() <= Anders.getWeight() + 20;
        Assert.assertTrue(maxWeightIsValid);


        //4BVI
        HyperCaloricDiet h = ((HyperCaloricDiet) randomDiet);


        boolean minCalsIsValid = ((HyperCaloricDiet) randomDiet).getMinCaloriesPerDay() >= 2000 && ((HyperCaloricDiet) randomDiet).getMinCaloriesPerDay() <= 4000;
        Assert.assertTrue(minCalsIsValid);

    }


}
