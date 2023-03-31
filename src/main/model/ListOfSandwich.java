package model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;
import org.json.JSONArray;
import persistence.Writable;

// This class represents a list of sandwich
public class ListOfSandwich implements Writable {
    private ArrayList<Sandwich> sandwiches;

    //EFFECTS: creates a list of sandwich
    public ListOfSandwich() {

        sandwiches = new ArrayList<>();

    }

    //EFFECTS: adds Sandwich to listofsandwich
    //MODIFIES: sandwich
    public void addSandwich(Sandwich sw) {
        sandwiches.add(sw);
    }

    public Sandwich getSandwich(int i) {
        return this.sandwiches.get(i);
    }

    public ArrayList<Sandwich> getSandwiches() {
        return this.sandwiches;
    }

    public void setSandwiches(ArrayList<Sandwich> sandwiches) {
        this.sandwiches = sandwiches;
    }

    public String toString() {
        String listOfSandwiches = "";
        for (Sandwich sw : sandwiches) {
            listOfSandwiches += sw.getName() + " " + sw.getIngredients() + ", ";
        }
        return listOfSandwiches;
    }

    // EFFECTS: returns
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("sandwiches", thingiesToJson());
        return json;
    }


    // EFFECTS: returns things in this workroom as a JSON array
    private JSONArray thingiesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Sandwich sw : sandwiches) {
            jsonArray.put(sw.toJson());
        }

        return jsonArray;
    }

}
