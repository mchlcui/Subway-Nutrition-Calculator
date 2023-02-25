package model;

public class Ingredient {

    // Represents each ingredient that is going to be put into the Sandwich
    private String name;   // name of the ingredient
    private Integer protein;   // amount of protein for the ingredient
    private Integer calories;    // amount of calories for the ingredient
    private Integer sugar;       // amount of sugar for the ingredient

    // Effects: sets the name, protein, calories, and sugar of the ingredient to the given name and amount of nutrition.
    public Ingredient(String n, int c, int p, int s) {
        name = n;
        protein = p;
        calories = c;
        sugar = s;
    }


    // Effects: return the amount of protein
    public int getProtein() {
        return protein;
    }

    // Effects: return the amount of calories
    public int getCalories() {
        return calories;
    }

    // Effects: return the amount of sugar
    public int getSugar() {
        return sugar;
    }

    // Effects: return the name
    public String getName() {
        return name;
    }


}
