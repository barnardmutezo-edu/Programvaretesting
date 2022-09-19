import java.util.ArrayList;

public class FlexitorianDiet extends Diet {
    private Float maxMeatGramsPerWeek;
    private Food preferedMeat;

    public FlexitorianDiet(int daysDuration, String purpose, ArrayList<Food> allowedFood, float maxMeatGramsPerWeek, Food preferedMeat) {
        super(daysDuration, purpose, allowedFood);
        setMaxMeatGramsPerWeek(maxMeatGramsPerWeek);
        setPreferedMeat(preferedMeat);
    }
    public float getMaxMeatGramsPerWeek() {
        return maxMeatGramsPerWeek;
    }
    public Food getPreferedMeat() {
        return preferedMeat;
    }

    public void setMaxMeatGramsPerWeek(float newMaxMeatGramsPerWeek) {
        if(newMaxMeatGramsPerWeek >= 0.0) {
            maxMeatGramsPerWeek = newMaxMeatGramsPerWeek;
        }
    }
    public void setPreferedMeat(Food newPreferedMeat) {
        if (newPreferedMeat.isVegan || !newPreferedMeat.type.equals(FoodType.Protein)){
            throw new IllegalArgumentException("Flexitorian Diet prefered meat must be of nonvegan of protein type.");
        }else{
            preferedMeat = newPreferedMeat;
        }
    }

    @Override
    public float getMinWeightKg() {
        return 0;
    }
    @Override
    public float getMaxWeightKg() {
        return 500;
    }
}
