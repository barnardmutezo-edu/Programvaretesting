import java.util.ArrayList;

public class HyperCaloricDiet extends Diet{
    float maxWeightKg;
    float minCaloriesPerDay;

    public HyperCaloricDiet(int daysDuration, String purpose, ArrayList<Food> allowedFood, float maxWeightKg, float minCaloriesPerDay) {
        super(daysDuration, purpose, allowedFood);
        setMaxWeightKg(maxWeightKg);
        setMinCaloriesPerDay(minCaloriesPerDay);
    }

    public float getMinCaloriesPerDay() {
        return minCaloriesPerDay;
    }

    public void setMinCaloriesPerDay(float minCaloriesPerDay) {

        this.minCaloriesPerDay = minCaloriesPerDay;
    }

    @Override
    public float getMinWeightKg() {
        return 0;
    }
    @Override
    public float getMaxWeightKg() {
        return maxWeightKg;
    }

    public void setMaxWeightKg(float maxWeightKg) {
        this.maxWeightKg = maxWeightKg;
    }
}
