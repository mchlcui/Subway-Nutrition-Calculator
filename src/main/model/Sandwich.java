package model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;
import org.json.JSONArray;
import persistence.Writable;

//citation: used given example as sample code
public class Sandwich implements Writable {
    // Represent the sandwich the user is making

    String name;  // the given name to the sandwich

    List<Ingredient> sandwich = new ArrayList<>();   // creates a list for ingredients that are in the sandwich

    private boolean sixinch;

    private static int totalC;    // setting the initial total calories to 0 as the sandwich is empty
    private static int totalP;    // setting the initial total protein to 0 as the sandwich is empty
    private static int totalS;    // setting the initial total sugar to 0 as the sandwich is empty

    //Requires: n to have a length > 0
    //Effects: Setting n as the name that is given to the sandwich. Creates a new ArrayList named sandwich that
    //contains all the ingredients that is going into the sandwich.
    public Sandwich(String n) {
        sixinch = false;
        name = n;
        totalC = 0;    // setting the initial total calories to 0 as the sandwich is empty
        totalP = 0;    // setting the initial total protein to 0 as the sandwich is empty
        totalS = 0;
    }



    public int numOfIngredients() {
        return sandwich.size();
    }

    public List<Ingredient> getIngredients() {
        return Collections.unmodifiableList(sandwich);
    }

    //Modifies: This
    //Effects: Sets the size to the given
    public void setSixinch(Boolean b) {
        this.sixinch = b;
    }


    //Effects: return whether its six inch or not.
    public Boolean getSixInch() {
        return sixinch;
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
            totalC += ingredient.getCalories();
        }
        return totalC;
    }

    //Effects: Add up all the proteins from the ingredients in the current sandwich
    public int calculateTotalProtein() {
        for (Ingredient ingredient : sandwich) {
            totalP += ingredient.getProtein();
        }
        return totalP;
    }

    //Effects: Add up all the sugars  from the ingredients in the current sandwich
    public int calculateTotalSugar() {
        for (Ingredient ingredient : sandwich) {
            totalS += ingredient.getSugar();
        }
        return totalS;
    }

    //Effects: Return the sandwich's name
    public String getName() {
        return name;
    }


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("size", sixinch);
        json.put("Ingredients", thingiesToJson());
        return json;
    }

    // EFFECTS: returns things in this workroom as a JSON array
    private JSONArray thingiesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Ingredient ingredient : sandwich) {
            jsonArray.put(ingredient.toJson());
        }

        return jsonArray;
    }

}

