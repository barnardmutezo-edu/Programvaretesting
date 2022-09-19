import java.util.ArrayList;
import java.util.Objects;

public class Food {
    String name;
    float caloriesPerDay;
    Boolean isVegan;
    FoodType type;

    public Food(String name, float caloriesPerDay, Boolean isVegan, FoodType type) {
        setName(name);
        setCaloriesPerDay(caloriesPerDay);
        setVegan(isVegan);
        setType(type);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCaloriesPerDay() {
        return caloriesPerDay;
    }

    public void setCaloriesPerDay(float caloriesPerDay) {
        this.caloriesPerDay = caloriesPerDay;
    }

    public Boolean getVegan() {
        return isVegan;
    }

    public void setVegan(Boolean vegan) {
        isVegan = vegan;
    }

    public FoodType getType() {
        return type;
    }

    public void setType(FoodType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return Float.compare(food.caloriesPerDay, caloriesPerDay) == 0 && Objects.equals(name, food.name) && Objects.equals(isVegan, food.isVegan) && type == food.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, caloriesPerDay, isVegan, type);
    }

    @Override
    public String toString() {
        return String.format("Name: %s,Calories: %f, isVegan: %b,type: %s", name, caloriesPerDay, isVegan, type);
    }
}
