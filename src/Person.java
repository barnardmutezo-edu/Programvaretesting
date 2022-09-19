import java.util.ArrayList;

public class Person {
    private Food favoriteFood;
    private ArrayList<Food> allergies;
    private Diet diet;
    private float weight;

    public Person(Food favoriteFood, ArrayList<Food> allergies, Diet diet, float weight) {
        setFavoriteFood(favoriteFood);
        setAllergies(allergies);
        setWeight(weight);
        setDiet(diet);


    }

    //SETTERS:
    public void setFavoriteFood(Food favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public void setAllergies(ArrayList<Food> allergies) {
        this.allergies = allergies;
    }

    public void setDiet(Diet diet) {
        this.diet = diet;

        allergies.retainAll(this.diet.allowedFood);

        float parsedListAllergies = allergies.size();
        float parsedListFoods = this.diet.allowedFood.size();

        if (diet.isVegan == true && this.favoriteFood.isVegan == false) {
            throw new IllegalArgumentException("This person loves meat and can't have a vegan diet!");
        }
        // If over Half of the food list is smaller than the list of allergies for the person it will not be created.
        if (parsedListAllergies / parsedListFoods > 0.5) {
            throw new IllegalArgumentException("The person is allergic to more than 50% of the foods in the diet.");
        }
        if (this.weight < this.diet.getMinWeightKg()) {
            throw new IllegalArgumentException("The person is to light to use this Diet.");
        }
        if (this.weight > this.diet.getMaxWeightKg()) {
            throw new IllegalArgumentException("The person is to heavy to use this Diet.");
        } else {
            System.out.println("Person created");
        }


    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    //GETTERS:
    public Food getFavoriteFood() {
        return favoriteFood;
    }

    public ArrayList<Food> getAllergies() {
        return allergies;
    }

    public Diet getDiet() {
        return diet;
    }

    public float getWeight() {
        return weight;
    }
}
