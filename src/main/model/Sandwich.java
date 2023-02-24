package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    // Represent the sandwich the user is making

    int startingValue = 0;
    String name;

    ArrayList<Ingredient> sandwich;
    int totalC;
    int totalP;
    int totalS;

    public Sandwich(String n, int c, int p, int s) {
        sandwich = new ArrayList<>();
        name = n;
        totalC = p;
        totalP = c;
        totalS = s;
    }

    public void addIngredient(String n, int c, int p, int s) {
        this.sandwich.add(new Ingredient(n, c, p, s));
    }

    public void removeIngredient(int ind) {
        this.sandwich.remove(ind);
    }

    public List<String> displayIngredients() {
        List<String> names = new ArrayList<>();
        for (Ingredient ingredient : sandwich) {
            names.add(ingredient.getName());

        }
        return names;
    }


    public int calculateTotalCalories() {
        this.totalC = startingValue;
        for (Ingredient ingredient : sandwich) {
            this.totalC += ingredient.getCalories();
        }
        return this.totalC;
    }

    public int calculateTotalProtein() {
        this.totalP = startingValue;
        for (Ingredient ingredient : sandwich) {
            this.totalP += ingredient.getProtein();
        }
        return this.totalP;
    }

    public int calculateTotalSugar() {
        this.totalS = startingValue;
        for (Ingredient ingredient : sandwich) {
            this.totalS += ingredient.getSugar();
        }
        return this.totalS;
    }

    public String getName() {
        return name;
    }

}

