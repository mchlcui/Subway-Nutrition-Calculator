package ui;

import model.Sandwich;

import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class SandwichApp {
    private Scanner input;
    String command = null;


    boolean sixinch = false;


    public SandwichApp() {
        input = new Scanner(System.in);
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
                Sandwich f = newSandwich();
                chooseBread(f);
                chooseMeat(f);
                chooseCheese(f);
                chooseVegetable(f);
                chooseSauce(f);
                chooseSize(f);
                viewIngredients(f);
                displayNutrition(f);
            }
        }
    }

    public void displayOptions() {
        System.out.println("q to quit the application");
        System.out.println("c to create a new sandwich");
        System.out.println("m to modify a existing sandwich");
    }

    public Sandwich newSandwich() {
        input = new Scanner(System.in);
        System.out.println("What would you like your sandwich to be called?");
        this.command = input.next();
        this.command = this.command.toLowerCase();
        return new Sandwich(this.command, 0, 0, 0);
    }

    public void chooseBread(Sandwich f) {
        input = new Scanner(System.in);
        System.out.println("Please select your desired bred");
        displayBreadOptions();
        this.command = input.next();
        this.command = this.command.toLowerCase();
        if (this.command.equals("w")) {
            f.addIngredient("Italian White Bread", 200, 7, 5);
        } else if (this.command.equals("g")) {
            f.addIngredient("9-Grain Wheat Bread", 210, 8, 5);
        } else if (this.command.equals("h")) {
            f.addIngredient("Italian Herb & Cheese Bread", 240, 9, 5);
        } else {
            System.out.println("Your selection is invalid");
        }

    }

    public void displayBreadOptions() {
        System.out.println("w to select Italian White Bread");
        System.out.println("g to select 9-Grain Wheat Bread");
        System.out.println("h to select Italian Herb & Cheese Bread");
    }


    public void chooseMeat(Sandwich f) {
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
                f.addIngredient("Steak", 110, 17, 1);
                chooseMeat(f);
            } else if (this.command.equals("m")) {
                f.addIngredient("Meatball", 230, 12, 5);
                chooseMeat(f);
            } else if (this.command.equals("t")) {
                f.addIngredient("Tuna", 250, 12, 0);
                chooseMeat(f);
            } else {
                System.out.println("Your selection is invalid");
                chooseMeat(f);
            }
        }

    }

    public void displayMeatOptions() {
        System.out.println("d to signify that you are done with this section");
        System.out.println("s to select Steak");
        System.out.println("m to select Meatball");
        System.out.println("t to select Tuna");
    }

    public void chooseCheese(Sandwich f) {
        boolean keep = true;
        System.out.println("Please select your desired cheese");
        displayCheeseOptions();
        this.command = input.next();
        this.command = this.command.toLowerCase();
        while (keep) {
            if (this.command.equals("d")) {
                keep = false;
            } else if (this.command.equals("p")) {
                f.addIngredient("Provolone", 50, 4, 0);
                chooseCheese(f);
            } else if (this.command.equals("a")) {
                f.addIngredient("American Cheese", 40, 2, 0);
                chooseCheese(f);
            } else if (this.command.equals("s")) {
                f.addIngredient("Swiss Cheese", 50, 4, 0);
                chooseCheese(f);
            } else {
                System.out.println("Your selection is invalid");
                chooseCheese(f);
            }
        }

    }

    public void displayCheeseOptions() {
        System.out.println("d to signify that you are done with this section");
        System.out.println("p to select Provolone");
        System.out.println("a to select American Cheese");
        System.out.println("s to select Swiss Cheese");
    }

    public void chooseVegetable(Sandwich f) {
        boolean keep = true;
        System.out.println("Please select your desired vegetable");
        displayVegetableOptions();
        this.command = input.next();
        this.command = this.command.toLowerCase();
        while (keep) {
            if (this.command.equals("d")) {
                keep = false;
            } else if (this.command.equals("l")) {
                f.addIngredient("Lettuce", 0, 0, 0);
                chooseVegetable(f);
            } else if (this.command.equals("c")) {
                f.addIngredient("Cucumber", 0, 0, 0);
                chooseVegetable(f);
            } else if (this.command.equals("o")) {
                f.addIngredient("Onion", 0, 0, 0);
                chooseVegetable(f);
            }  else {
                System.out.println("Your selection is invalid");
                chooseVegetable(f);
            }
        }

    }

    public void displayVegetableOptions() {
        System.out.println("d to signify that you are done with this section");
        System.out.println("l to select Lettuce");
        System.out.println("c to select Cucumber");
        System.out.println("o to select Onion");
    }

    public void chooseSauce(Sandwich f) {
        boolean keep = true;
        System.out.println("Please select your desired sauce");
        displaySauceOptions();
        this.command = input.next();
        this.command = this.command.toLowerCase();
        while (keep) {
            if (this.command.equals("d")) {
                keep = false;
            } else if (this.command.equals("b")) {
                f.addIngredient("BBQ Sauce", 25, 0, 5);
                chooseSauce(f);
            } else if (this.command.equals("m")) {
                f.addIngredient("Mayonnaise", 100, 0, 0);
                chooseSauce(f);
            } else if (this.command.equals("y")) {
                f.addIngredient("Yellow Mustard", 10, 1, 0);
                chooseSauce(f);
            }  else {
                System.out.println("Your selection is invalid");
                chooseSauce(f);
            }
        }
    }

    public void displaySauceOptions() {
        System.out.println("d to signify that you are done with this section");
        System.out.println("b to select BBQ Sauce");
        System.out.println("m to select Mayonnaise");
        System.out.println("y to select Yellow Mustard");
    }

    public void chooseSize(Sandwich f) {
        System.out.println("Please select your sandwich size");
        displaySizeOptions();
        this.command = input.next();
        this.command = this.command.toLowerCase();
        if (this.command.equals("t")) {
            sixinch = true;
        } else if (this.command.equals("f")) {
            sixinch = false;
        } else {
            System.out.println("Your selection is invalid");
            chooseSize(f);
        }
    }

    public void displaySizeOptions() {
        System.out.println("t if it is a 6-inch sandwich");
        System.out.println("f if it is a foot-long sandwich");
    }

    public void displayNutrition(Sandwich f) {
        double calorie = f.calculateTotalCalories();
        double protein = f.calculateTotalProtein();
        double sugar = f.calculateTotalSugar();
        double ftcal = calorie * 2;
        double ftpro = protein * 2;
        double ftsug = sugar * 2;

        if (sixinch) {
            System.out.println(f.getName() + " contains " + calorie + " calories, "
                    + protein + " grams of protein, " + sugar + " grams of sugar.");
        } else {
            System.out.println((f.getName() + " contains " + ftcal + " calories, "
                    + ftpro + " grams of protein, " + ftsug + " grams of sugar."));
        }
    }

    public void viewIngredients(Sandwich f) {
        List<String> name = f.displayIngredients();
        int i = 0;
        int index = name.size();
        for (i = 0; i < index; i++) {
            String food = name.get(i);
            System.out.println(food);
        }
    }

}




