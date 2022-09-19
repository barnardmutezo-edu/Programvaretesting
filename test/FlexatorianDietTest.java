import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class FlexatorianDietTest {

    @Test
    public void dietIsFlexatorianButNotProteinSoShouldCauseException1D() {
        String error = "";

        try {
            ArrayList<Food> allowedFood = new ArrayList<>();

            allowedFood.add(new Food("Pie", 400f, true, FoodType.Carb));
            allowedFood.add(new Food("Meat", 100f, true, FoodType.Fat));
            allowedFood.add(new Food("Burger", 350f, true, FoodType.Carb));

            /*PREFERRED FOODTYPE IS NOT PROTEIN SO CAUSE EXCEPTION*/
            Food preMeat = new Food("Beef", 300, false, FoodType.Carb);
            Diet diet = new FlexitorianDiet(60, "Healthy", allowedFood, 30, preMeat);
        } catch (Exception e) {
            error = e.getMessage();

        }

        Assert.assertEquals("Flexitorian Diet prefered meat must be of nonvegan of protein type.", error);

    }


    @Test(expected = IllegalArgumentException.class)
    public void dietIsFlexatorianButNotVeganSoShouldCauseException() {
        ArrayList<Food> allowedFood = new ArrayList<>();
        allowedFood.add(new Food("Pie", 400f, true, FoodType.Carb));
        allowedFood.add(new Food("Meat", 100f, true, FoodType.Fat));
        allowedFood.add(new Food("Burger", 350f, true, FoodType.Carb));

        /*PREFERRED FOOD IS VEGAN SO SHOULD CAUSE EXCEPTION*/
        Food preMeat = new Food("Salad", 300, true, FoodType.Protein);
        Diet diet = new FlexitorianDiet(60, "Healthy", allowedFood, 30, preMeat);

    }


    @Test
    public void dietIsFlexatorianShoudNotCauseException1D2() {
        boolean exception = false;

        try {
            ArrayList<Food> allowedFood = new ArrayList<>();
            allowedFood.add(new Food("Pie", 400f, true, FoodType.Carb));
            allowedFood.add(new Food("Meat", 100f, true, FoodType.Fat));
            allowedFood.add(new Food("Burger", 350f, true, FoodType.Carb));

            /*PREFERRED FOOD IS NOT VEGAN AND HAS PROTEIN SO SHOULD NOT CAUSE EXCEPTION*/
            Food preMeat = new Food("Salad", 300, false, FoodType.Protein);
            Diet diet = new FlexitorianDiet(60, "Healthy", allowedFood, 30, preMeat);
        } catch (Exception e) {
            exception = true;
        }

        Assert.assertFalse(exception);
    }


}
