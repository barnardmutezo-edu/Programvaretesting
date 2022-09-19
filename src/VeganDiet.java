import java.util.ArrayList;

public class VeganDiet extends Diet {
    private Float minWeightKg;

    public VeganDiet(int daysDuration, String purpose, ArrayList<Food> allowedFood, float minWeightKg) {
        super(daysDuration, purpose, allowedFood);

        if (!this.nonVegan(allowedFood) || !isVegan)
            throw new IllegalArgumentException("Must be vegan!");
        setMinWeightKg(minWeightKg);
    }

    public float getMinWeightKg() {
        return minWeightKg;
    }

    public void setMinWeightKg(float newMinWeightKg) {
        if (newMinWeightKg >= 0.0) {
            minWeightKg = newMinWeightKg;
        }
    }
    @Override
    public float getMaxWeightKg() {
        return 500;
    }
}


