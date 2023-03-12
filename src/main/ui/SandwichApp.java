package ui;

import model.Category;
import model.Ingredient;
import model.Sandwich;
import persistence.JsonWriter;
import persistence.JsonReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;

public class SandwichApp {
    private Scanner input;
    String command = null;

    private static final String JSON_STORE = "./data/workroom.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;



    private Sandwich sandwich;


    public SandwichApp() {
        input = new Scanner(System.in);
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runSandwichApp();
    }

    public void runSandwichApp() {
        boolean keep = true;

        while (keep) {
            displayOptions();
            this.command = input.next();
            this.command = command.toLowerCase();
            if (this.command.equals("q")) {
                keep = false;
                System.out.println("Thanks for using the SandwichApp!");
            } else if (this.command.equals("c")) {
                sandwich = newSandwich();
                chooseBread();
                chooseMeat();
                chooseCheese();
                chooseVegetable();
                chooseSauce();
                chooseSize();
                viewIngredients();
                displayNutrition();
                saveSandwich();
            } else if (this.command.equals("m")) {
                loadSandwich();
            }
        }
    }



    public void displayOptions() {
        System.out.println("q to quit the application");
        System.out.println("c to create a new sandwich");
        System.out.println("m to view a saved sandwich");
    }

    public Sandwich newSandwich() {
        input = new Scanner(System.in);
        System.out.println("What would you like your sandwich to be called?");
        this.command = input.next();
        this.command = this.command.toLowerCase();
        return new Sandwich(this.command);
    }

    public void chooseBread() {
        input = new Scanner(System.in);
        System.out.println("Please select your desired bred");
        displayBreadOptions();
        this.command = input.next();
        this.command = this.command.toLowerCase();
        if (this.command.equals("w")) {
            sandwich.addIngredient(new Ingredient("Italian White Bread", 200, 7, 5, Category.BREAD));
        } else if (this.command.equals("g")) {
            sandwich.addIngredient(new Ingredient("9-Grain Wheat Bread", 210, 8, 5, Category.BREAD));
        } else if (this.command.equals("h")) {
            sandwich.addIngredient(new Ingredient("Italian Herb & Cheese Bread", 240, 9, 5, Category.BREAD));
        } else {
            System.out.println("Your selection is invalid");
        }

    }

    public void displayBreadOptions() {
        System.out.println("w to select Italian White Bread");
        System.out.println("g to select 9-Grain Wheat Bread");
        System.out.println("h to select Italian Herb & Cheese Bread");
    }


    public void chooseMeat() {
        input = new Scanner(System.in);
        boolean keep = true;
        System.out.println("Please select your desired meat");
        displayMeatOptions();
        this.command = input.next();
        this.command = this.command.toLowerCase();
        while (keep) {
            if (this.command.equals("d")) {
                keep = false;
            } else if (this.command.equals("s")) {
                sandwich.addIngredient(new Ingredient("Steak", 110, 17, 1, Category.MEAT));
                chooseMeat();
            } else if (this.command.equals("m")) {
                sandwich.addIngredient(new Ingredient("Meatball", 230, 12, 5, Category.MEAT));
                chooseMeat();
            } else if (this.command.equals("t")) {
                sandwich.addIngredient(new Ingredient("Tuna", 250, 12, 0, Category.MEAT));
                chooseMeat();
            } else {
                System.out.println("Your selection is invalid");
                chooseMeat();
            }
        }

    }

    public void displayMeatOptions() {
        System.out.println("d to signify that you are done with this section");
        System.out.println("s to select Steak");
        System.out.println("m to select Meatball");
        System.out.println("t to select Tuna");
    }

    public void chooseCheese() {
        boolean keep = true;
        System.out.println("Please select your desired cheese");
        displayCheeseOptions();
        this.command = input.next();
        this.command = this.command.toLowerCase();
        while (keep) {
            if (this.command.equals("d")) {
                keep = false;
            } else if (this.command.equals("p")) {
                sandwich.addIngredient(new Ingredient("Provolone", 50, 4, 0, Category.CHEESE));
                chooseCheese();
            } else if (this.command.equals("a")) {
                sandwich.addIngredient(new Ingredient("American Cheese", 40, 2, 0, Category.CHEESE));
                chooseCheese();
            } else if (this.command.equals("s")) {
                sandwich.addIngredient(new Ingredient("Swiss Cheese", 50, 4, 0, Category.CHEESE));
                chooseCheese();
            } else {
                System.out.println("Your selection is invalid");
                chooseCheese();
            }
        }

    }

    public void displayCheeseOptions() {
        System.out.println("d to signify that you are done with this section");
        System.out.println("p to select Provolone");
        System.out.println("a to select American Cheese");
        System.out.println("s to select Swiss Cheese");
    }

    public void chooseVegetable() {
        boolean keep = true;
        System.out.println("Please select your desired vegetable");
        displayVegetableOptions();
        this.command = input.next();
        this.command = this.command.toLowerCase();
        while (keep) {
            if (this.command.equals("d")) {
                keep = false;
            } else if (this.command.equals("l")) {
                sandwich.addIngredient(new Ingredient("Lettuce", 0, 0, 0, Category.VEGETABLE));
                chooseVegetable();
            } else if (this.command.equals("c")) {
                sandwich.addIngredient(new Ingredient("Cucumber", 0, 0, 0, Category.VEGETABLE));
                chooseVegetable();
            } else if (this.command.equals("o")) {
                sandwich.addIngredient(new Ingredient("Onion", 0, 0, 0, Category.VEGETABLE));
                chooseVegetable();
            }  else {
                System.out.println("Your selection is invalid");
                chooseVegetable();
            }
        }

    }

    public void displayVegetableOptions() {
        System.out.println("d to signify that you are done with this section");
        System.out.println("l to select Lettuce");
        System.out.println("c to select Cucumber");
        System.out.println("o to select Onion");
    }

    public void chooseSauce() {
        boolean keep = true;
        System.out.println("Please select your desired sauce");
        displaySauceOptions();
        this.command = input.next();
        this.command = this.command.toLowerCase();
        while (keep) {
            if (this.command.equals("d")) {
                keep = false;
            } else if (this.command.equals("b")) {
                sandwich.addIngredient(new Ingredient("BBQ Sauce", 25, 0, 5, Category.SAUCE));
                chooseSauce();
            } else if (this.command.equals("m")) {
                sandwich.addIngredient(new Ingredient("Mayonnaise", 100, 0, 0, Category.SAUCE));
                chooseSauce();
            } else if (this.command.equals("y")) {
                sandwich.addIngredient(new Ingredient("Yellow Mustard", 10, 1, 0, Category.SAUCE));
                chooseSauce();
            }  else {
                System.out.println("Your selection is invalid");
                chooseSauce();
            }
        }
    }

    public void displaySauceOptions() {
        System.out.println("d to signify that you are done with this section");
        System.out.println("b to select BBQ Sauce");
        System.out.println("m to select Mayonnaise");
        System.out.println("y to select Yellow Mustard");
    }

    public void chooseSize() {
        System.out.println("Please select your sandwich size");
        displaySizeOptions();
        this.command = input.next();
        this.command = this.command.toLowerCase();
        if (this.command.equals("t")) {
            this.sandwich.setSixinch(Boolean.TRUE);
        } else if (this.command.equals("f")) {
            this.sandwich.setSixinch(Boolean.FALSE);
        } else {
            System.out.println("Your selection is invalid");
            chooseSize();
        }
    }

    public void displaySizeOptions() {
        System.out.println("t if it is a 6-inch sandwich");
        System.out.println("f if it is a foot-long sandwich");
    }

    public void displayNutrition() {
        double calorie = sandwich.calculateTotalCalories();
        double protein = sandwich.calculateTotalProtein();
        double sugar = sandwich.calculateTotalSugar();
        double ftcal = calorie * 2;
        double ftpro = protein * 2;
        double ftsug = sugar * 2;

        if (this.sandwich.getSixInch()) {
            System.out.println(sandwich.getName() + " contains " + calorie + " calories, "
                    + protein + " grams of protein, " + sugar + " grams of sugar.");
        } else {
            System.out.println((sandwich.getName() + " contains " + ftcal + " calories, "
                    + ftpro + " grams of protein, " + ftsug + " grams of sugar."));
        }
    }

    public void viewIngredients() {
        List<String> name = sandwich.allIngredients();
        int i = 0;
        int index = name.size();
        for (i = 0; i < index; i++) {
            String food = name.get(i);
            System.out.println(food);
        }
    }


    // EFFECTS: saves the sandwich to file
    private void saveSandwich() {
        input = new Scanner(System.in);
        System.out.println("Would you like to save this sandwich?");
        this.command = input.next();
        this.command = this.command.toLowerCase();
        if (this.command.equals("yes")) {
            try {
                jsonWriter.open();
                jsonWriter.write(sandwich);
                jsonWriter.close();
                System.out.println("Saved " + sandwich.getName() + " to " + JSON_STORE);
            } catch (FileNotFoundException e) {
                System.out.println("Unable to write to file: " + JSON_STORE);
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: loads sandwich from file
    private void loadSandwich() {
        try {
            sandwich = jsonReader.read();

            System.out.println("Loaded " + sandwich.getName() + " from " + JSON_STORE);
            viewIngredients();
            displayNutrition();
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

}




