import org.junit.Assert;
import org.junit.Test;

public class FoodTest {

    @Test
    public void creatingFoodWorks() {
        Food banana = new Food("Banana", 40f, true, FoodType.Carb);

        Assert.assertEquals("Name: Banana,Calories: 40,000000, isVegan: true,type: Carb", banana.toString());
    }


}
