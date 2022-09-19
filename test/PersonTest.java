import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class PersonTest {
   /* @Test
    public void addingNewPerson() {
        try {
            ArrayList<Food> allowedFood1 = new ArrayList<>();
            ArrayList<Food> allowedFood2 = new ArrayList<>();
            ArrayList<Food> allowedFood3 = new ArrayList<>();
            ArrayList<Food> allowedFood4 = new ArrayList<>();

            ArrayList<Food> listOfAllergies = new ArrayList<Food>();

            //Making the foods:
            Food Pizza = new Food("Pizza", 100, false, FoodType.Recipe);
            Food Salad = new Food("Salad", 200, true, FoodType.Recipe);
            Food Beef = new Food("Beef", 800, false, FoodType.Protein);
            Food Sitrus = new Food("Sitrus", 200, true, FoodType.Carb);

            //Adding foods to list:
            allowedFood1.add(Pizza); //notvegan
            allowedFood1.add(Beef);

            allowedFood2.add(Salad); //vegan
            allowedFood2.add(Sitrus);

            allowedFood3.add(Pizza); //notvegan
            allowedFood3.add(Salad);
            allowedFood3.add(Beef);
            allowedFood3.add(Sitrus);

            allowedFood4.add(Sitrus); //notvegan
            allowedFood4.add(Sitrus); //notvegan


            //Add allergies:
            listOfAllergies.add(Sitrus);
            listOfAllergies.add(Pizza);

            Diet fd = new FlexitorianDiet(8, "Gain Weight", allowedFood1,75, Beef);
            Diet vd = new VeganDiet(10, "Gain Weight", allowedFood2,85);
            Diet hcd = new HyperCaloricDiet(4, "Gain Weight", allowedFood3, 82, 4000);
            Diet lcd = new LowCarbDiet(11, "Gain Weight", allowedFood4,75);
            //creating person
            Person Anders = new Person(Sitrus, listOfAllergies, hcd, 81);
        } catch (Exception e) {
        }
    }*/


    @Test
    public void favoriteFoodNotVeganButFollowsVeganDietShouldFail2A() {
        String error = "";
        try {

            ArrayList<Food> allowedFood = new ArrayList<>();
            ArrayList<Food> allergies = new ArrayList<>();
            allergies.add(new Food("pasta", 60, true, FoodType.Carb));
            allowedFood.add(new Food("Beef", 100, true, FoodType.Recipe));

            Food faveFood = new Food("Beef", 100, false, FoodType.Recipe);

            Diet vegan = new VeganDiet(8, "Gain Weight", allowedFood, 75);

            Person person = new Person(faveFood, allergies, vegan, 90);

        } catch (Exception e) {
            error = e.getMessage();
        }

        Assert.assertEquals("This person loves meat and can't have a vegan diet!", error);
    }

    @Test
    public void AllergiFood2B() {
        String errors = "";
        try {

            ArrayList<Food> allowedFood = new ArrayList<>();
            allowedFood.add(new Food("pasta", 350f, false, FoodType.Carb));
            allowedFood.add(new Food("rice", 350f, false, FoodType.Carb));
            allowedFood.add(new Food("spaghetti", 350f, false, FoodType.Carb));


            Diet d = new HyperCaloricDiet(60, "Gain weight", allowedFood, 100, 80);

            ArrayList<Food> allergies = new ArrayList<>();
            allergies.add(new Food("pasta", 350f, false, FoodType.Carb));
            allergies.add(new Food("rice", 350f, false, FoodType.Carb));

            Person p = new Person(new Food("Taco", 50, false, FoodType.Carb), allergies, d, 82);

        } catch (Exception e) {
            errors = e.getMessage();
        }

        Assert.assertEquals("The person is allergic to more than 50% of the foods in the diet.", errors);
    }






}
