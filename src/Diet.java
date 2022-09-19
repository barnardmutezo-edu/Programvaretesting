import java.util.ArrayList;

public abstract class Diet {
    int daysDuration;
    String purpose;
    ArrayList<Food> allowedFood;
    boolean isVegan;


    public Diet(int daysDuration, String purpose, ArrayList allowedFood) {
        System.out.println("Constructing a Diet");
        this.daysDuration = daysDuration;
        this.purpose = purpose;
        this.allowedFood = allowedFood;

        //set isVegan automatically based on result from allowedFood
        this.isVegan = this.nonVegan(allowedFood);

        //this.isVegan = isVegan;
    }
    public boolean nonVegan(ArrayList<Food> foods) {
        for (Food food : foods) {
            if (!food.isVegan) {
                return false;
            }
        }
        return true;
    }


    public abstract float getMinWeightKg();

    public abstract float getMaxWeightKg();



    public String dietDuration() {

        int counter = 0;

        int days = daysDuration;

        int years = 0;
        int months = 0;

        //CALCULATE YEARS ASSUMING A YEAR HAS PRECISELY 365 DAYS
        while (days >= 365) {

            if (counter == 365) {
                days -= 365;
                counter = 0;
                years++;
            }
            counter++;

        }

        //CALCULATE MONTHS ASSUMING A MONTH HAS PRECISELY 30 DAYS

        while (days >= 30) {

            if (counter == 30) {
                days -= 30;
                counter = 0;
                months++;
            }
            counter++;
        }
        return String.format("This %s lasts for %d years, %d months and %d days.", dietName(), years, months, days);
    }



    public String allowedFood() {
        String foods = "";

        for (int i = 0; i < this.allowedFood.size(); i++) {
            String punctuation = ", ";

            if (i == this.allowedFood.size() - 1) {
                punctuation = ".";
            }
            foods = foods.concat(this.allowedFood.get(i).getName() + punctuation);
        }

        return String.format("The following food is allowed on this %s: %s", dietName(), foods);
    }

    public String dietName() {
        return this.getClass().getName();
    }
}





