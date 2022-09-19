import java.util.ArrayList;

public class LowCarbDiet extends Diet{
    Float minWeightKg;
    public LowCarbDiet(int daysDuration, String purpose, ArrayList<Food> allowedFood, float minWeightKg) {
        super(daysDuration, purpose, allowedFood);
        setMinWeightKg(minWeightKg);
        int amountOfCarbtype = 0;

        for (int i = 0; i < allowedFood.size(); i++) {
            if (allowedFood.get(i).type.equals(FoodType.Carb))
            amountOfCarbtype ++;
        }
        if (amountOfCarbtype > 2){
            throw new IllegalArgumentException("A low carb diet can't contain more than 2 types of carb foods.");
        }
    }
    public float getMinWeightKg() {
        return minWeightKg;
    }

    @Override
    public float getMaxWeightKg() {
        return 500;
    }

    public void setMinWeightKg(float newMinWeightKg) {
        if(newMinWeightKg >= 0.0) {
            minWeightKg = newMinWeightKg;
        }
    }
}
