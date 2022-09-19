import java.util.ArrayList;

public class DietManager {
    public HyperCaloricDiet randomDiet(Person p, ArrayList<Food> f) {
        int daysDuration = (int) Math.floor(Math.random() * (100 - 0 + 1) + 0);
        f.removeAll(p.getAllergies());
        int maxWeightKG = (int) Math.floor(Math.random() * ((int) p.getWeight() + 20 - (int) p.getWeight() + 1) + (int) p.getWeight());
        int minCaloriesPerDay = (int) Math.floor(Math.random() * (4000 - 2000 + 1) + 2000);
        HyperCaloricDiet hpc = new HyperCaloricDiet(daysDuration, "Random Diet", f, maxWeightKG, (float) minCaloriesPerDay);
        return hpc;
    }

    public static boolean compatible(Person person, Diet diet) {
        try {
            person.setDiet(diet);

        } catch (Exception e) {
            var msg = e.getMessage();
            var evaluate = msg.equals("The person is allergic to more than 50% of the foods in the diet.") || msg.equals("This person loves meat and can't have a vegan diet!") || msg.equals("The person is to light to use this Diet.") || msg.equals("The person is to heavy to use this Diet.");

            return !evaluate;
        }
        return true;
    }
}
