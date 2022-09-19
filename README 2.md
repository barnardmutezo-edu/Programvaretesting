**VERSION 1.0.0**
A README for the examination ITP2200 programm Diet Manager.

## Description
The project contains all the classes and the neccecary methods and logic needed to meet the requirements.

## Setup

The program needs to be set to Java 11 and JUNIT 4, inorder for the code to compile properly.
Once the setup is done correctliy, run all the test with coverage. The tests should pass with 91% cover according to the IDE.


## Examples
-- Bellow are some snippets from the sourc ecode that demonstrates how the program behaves --

  From requirement 3a
  
    The source code
        
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


    The test

        @Test
        public void dietReturnsDietDuration3A() {
            ArrayList<Food> allowedFood = new ArrayList<>();
            allowedFood.add(new Food("Pie", 400f, true, FoodType.Fat));
            allowedFood.add(new Food("Meat", 100f, true, FoodType.Fat));
            allowedFood.add(new Food("Burger", 350f, true, FoodType.Carb));

            Diet diet = new HyperCaloricDiet(368, "Healthy", allowedFood, 90, 500);
            var res = diet.dietDuration();

            Assert.assertEquals("This HyperCaloricDiet lasts for 1 years, 0 months and 3 days.", res);
        }


    The above code uses the subclass HyperCaloricDiet (Will work with any other instances of Diet) to assert that the object returns a string containing the duration of the diet.



  From  requirement 2B

    The source code

        .....
        if (parsedListAllergies / parsedListFoods > 0.5) {
            throw new IllegalArgumentException("The person is allergic to more than 50% of the foods in the diet.");
        }



    The test
    
        @Test
        public void AllergiFood2B() {
            String errors = "";
            try {

                ArrayList<Food> allowedFood = new ArrayList<>();
                allowedFood.add(new Food("pasta", 350f, false, FoodType.Carb));
                allowedFood.add(new Food("rice", 350f, false, FoodType.Carb));
                allowedFood.add(new Food("spaghetti", 350f, false, FoodType.Carb));


                Diet d = new HyperCaloricDiet(60, "Gain weight", allowedFood, 100, 80);

                ArrayList<Food> allergies = new ArrayList<>();
                allergies.add(new Food("pasta", 350f, false, FoodType.Carb));
                allergies.add(new Food("rice", 350f, false, FoodType.Carb));

                Person p = new Person(new Food("Taco", 50, false, FoodType.Carb), allergies, d, 82);

            } catch (Exception e) {
                errors = e.getMessage();
            }

            Assert.assertEquals("The person is allergic to more than 50% of the foods in the diet.", errors);
        }


    Most of the code is tested using try-catch handling since the connstructor throws IllegalArgumentException, given unwanted parameters. The way the above code is tested by asserting the getMessage property of the Exception class, to see if the string matches with the desired error. 


## Navigation

-- Bellow is are the locations for the solutions of all the test requirements -- 


<NOTE!> 

Requirement 4B are all under one test method, consisting of multiple assertions, these assertions can be found by locating the corresponding comment example shown below.

req 4B

    i  

        Class: DietManagerTest

        Test: //4BI


This test is found below //4B1 in the DietManagerTest class.


## Req 1
  
  a)
  
    Class: DietTest

    Test: dietIsNotVegan1A

  b)
  
    Class: DietTest

    Test: CheckVeganFood1B


  c)
  
    Class: VeganDietTest

    Test: dietIsNotVegan1C


  d)
  
    Class: FlexatorianDietTest

    Test: dietIsFlexatorianButNotProteinSoShouldCauseException1D, dietIsFlexatorianButNotVeganSoShouldCauseException

  e) 
  
    Class: LowCarbDietTest

    Test: lowCarbCauseException1e


## Req 2
  
  a)
    Class: PersonTest

    Test: favoriteFoodNotVeganButFollowsVeganDietShouldFail2A

  b)

    Class: PersonTest

    Test: AllergiFood2B

  c)

    Class: VeganDietTest, LowCarbDietTest

    Test: vegandietWeight2c,lowCarbandietWeight2c


  d)

    Class: HyperCaloricTest

    Test: personWeightsMoreThanLimitHypercaloricDietShouldCauseError2D


## Req 3
  
  a)

    Class: DietTest

    Test: dietReturnsDietDuration3A

  b)

    Class: DietTest

    Test: allowedFood3B
      

## Req 4
  
  a)

    Class: DietManagerTest

    Test: compatibleOrNot4a, compatibleOrNot4a2

  b)

    0
     
        Class: DietManagerTest

        Test: //4B0 

    i  

        Class: DietManagerTest

        Test: //4BI

    ii
      
        Class: DietManagerTest

        Test: //4BII

    iii  

        Class: DietManagerTest

        Test: //4BIII
    
    iv

        Class: DietManagerTest

        Test: //4BIV
    
    v  
        Class: DietManagerTest

        Test: //4BV
    
    vi  
        Class: DietManagerTest

        Test: //4BVI       

