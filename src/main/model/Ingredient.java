package model;

import org.json.JSONObject;
import persistence.Writable;

public class Ingredient implements Writable {

    // Represents each ingredient that is going to be put into the Sandwich
    private String name;   // name of the ingredient
    private Integer protein;   // amount of protein for the ingredient
    private Integer calories;    // amount of calories for the ingredient
    private Integer sugar;       // amount of sugar for the ingredient

    private Category category; // the category of ingredient

    // Effects: sets the name, protein, calories, and sugar of the ingredient to the given name and amount of nutrition.
    public Ingredient(String n,  int c, int p, int s, Category category) {
        name = n;
        protein = p;
        calories = c;
        sugar = s;
        this.category = category;
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

    public Category getCategory() {
        return category;
    }

    public void print() {
        EventLog.getInstance().logEvent(new Event("Ingredient " + getName() + " added to Sandwich."));
    }

    public void printRemoved(Object s) {
        EventLog.getInstance().logEvent(new Event("Ingredient " + s + " removed from Sandwich."));
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("category", category);
        json.put("calories", calories);
        json.put("protein", protein);
        json.put("sugar", sugar);
        return json;
    }


}
