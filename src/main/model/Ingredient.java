package model;

public class Ingredient implements Writable {

    // Represents each ingredient that is going to be put into the Sandwich
    private String name;   // name of the ingredient
    private Integer protein;   // amount of protein for the ingredient
    private Integer calories;    // amount of calories for the ingredient
    private Integer sugar;       // amount of sugar for the ingredient

    private Category category; // sets the category.

    // Effects: sets the name, protein, calories, and sugar of the ingredient to the given name and amount of nutrition.

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public Ingredient(String n) {
        name = n;
        switch (n) {
            case "BBQ Sauce":
                this.calories = 25;
                this.protein = 0;
                this.sugar = 5;
            case "Mayonnaise":
                this.calories = 100;
                this.protein = 0;
                this.sugar = 0;
            case "Yellow Mustard":
                this.calories = 10;
                this.protein = 1;
                this.sugar = 0;
            case "Italian White Bread":
                this.calories = 200;
                this.protein = 7;
                this.sugar = 5;
            case "9-Grain Wheat Bread":
                this.calories = 210;
                this.protein = 8;
                this.sugar = 5;
            case "Italian Herb & Cheese Bread":
                this.calories = 240;
                this.protein = 9;
                this.sugar = 5;
            case "Steak":
                this.calories = 110;
                this.protein = 17;
                this.sugar = 1;
            case "Meatball":
                this.calories = 230;
                this.protein = 12;
                this.sugar = 5;
            case "Tuna":
                this.calories = 250;
                this.protein = 12;
                this.sugar = 0;
            case "Provolone":
                this.calories = 50;
                this.protein = 4;
                this.sugar = 5;
            case "American Cheese":
                this.calories = 40;
                this.protein = 2;
                this.sugar = 5;
            case "Swiss Cheese":
                this.calories = 50;
                this.protein = 4;
                this.sugar = 5;
            case "Lettuce":
                this.calories = 0;
                this.protein = 0;
                this.sugar = 0;
            case "Cucumber":
                this.calories = 0;
                this.protein = 0;
                this.sugar = 0;
            case "Onion":
                this.calories = 0;
                this.protein = 0;
                this.sugar = 0;
            default:
                break;
        }
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

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("Ingredients", category);
        return json;
    }


}
