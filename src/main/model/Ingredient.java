package model;

public class Ingredient {

    // Represents each ingredient that is going to be put into the Sandwich
    private String name;
    private Integer protein;
    private Integer calories;
    private Integer sugar;

    public Ingredient(String n, int c, int p, int s) {
        name = n;
        protein = p;
        calories = c;
        sugar = s;
    }

    public void setName(String n) {
        this.name = n;
    }

    public String getName() {
        return name;
    }

    public int getProtein() {
        return protein;
    }

    public int getCalories() {
        return calories;
    }

    public int getSugar() {
        return sugar;
    }


}
