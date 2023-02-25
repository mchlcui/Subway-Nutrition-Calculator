package model;


import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    // Represent the sandwich the user is making

    String name;  // the given name to the sandwich

    List<Ingredient> sandwich = new ArrayList<>();   // creates a list for ingredients that are in the sandwich

    private static int totalC = 0;    // setting the initial total calories to 0 as the sandwich is empty
    private static int totalP = 0;    // setting the initial total protein to 0 as the sandwich is empty
    private static int totalS = 0;    // setting the initial total sugar to 0 as the sandwich is empty

    //Requires: n to have a length > 0
    //Effects: Setting n as the name that is given to the sandwich. Creates a new ArrayList named sandwich that
    //contains all the ingredients that is going into the sandwich.
    public Sandwich(String n) {
        name = n;
    }


    //Modifies: This
    //Effects: add the given ingredient to end of sandwich.
    public void addIngredient(Ingredient i) {
        this.sandwich.add(i);
    }

    //Requires: 0 < ind < sandwich.size() - 1
    //Effects: returns the ingredient from the sandwich at given index
    public Ingredient getIngredient(int ind) {
        return sandwich.get(ind);
    }

    //Requires: 0 < ind < sandwich.size() - 1
    //Modifies:this
    //Effects: removes the ingredient from the sandwich at given index
    public void removeIngredient(int ind) {
        this.sandwich.remove(ind);
    }

    //Effects: Display the name of all current ingredients in the list
    public List<String> allIngredients() {
        List<String> names = new ArrayList<>();
        for (Ingredient ingredient : sandwich) {
            names.add(ingredient.getName());

        }
        return names;
    }


    //Effects: Add up all the calories from the ingredients in the current sandwich
    public int calculateTotalCalories() {
        for (Ingredient ingredient : sandwich) {
            this.totalC += ingredient.getCalories();
        }
        return this.totalC;
    }

    //Effects: Add up all the proteins from the ingredients in the current sandwich
    public int calculateTotalProtein() {
        for (Ingredient ingredient : sandwich) {
            this.totalP += ingredient.getProtein();
        }
        return this.totalP;
    }

    //Effects: Add up all the sugars  from the ingredients in the current sandwich
    public int calculateTotalSugar() {
        for (Ingredient ingredient : sandwich) {
            this.totalS += ingredient.getSugar();
        }
        return this.totalS;
    }

    //Effects: Return the sandwich's name
    public String getName() {
        return name;
    }

}

