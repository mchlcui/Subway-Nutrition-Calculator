package persistence;

import model.ListOfSandwich;
import model.Sandwich;
import model.Ingredient;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;
import model.Category;

//citation: used given example as sample code
// Represents a reader that reads sandwiches from JSON data in file.
public class JsonReader {

    private String source;

    // EFFECTS: constructs a reader
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads the sandwich and returns it.
    // if there is an error that occurs, then throws an IOexception
    public ListOfSandwich read() throws IOException {
        String data = file(source);
        JSONObject jsobj;
        jsobj = new JSONObject(data);
        return parseListOfSandwich(jsobj);
    }

    // EFFECTS: reads source file as string and then return.
    private String file(String source) throws IOException {
        StringBuilder content = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> content.append(s));
        }

        return content.toString();
    }

    // EFFECTS: parses sandwich from JSON object then return
    private ListOfSandwich parseListOfSandwich(JSONObject jsobj) {
        ListOfSandwich los = new ListOfSandwich();
        addSandwiches(los, jsobj);
        return los;
    }

    // EFFECTS: parses sandwich from JSON object then return
    private Sandwich parseSandwich(JSONObject jsobj) {
        String name = jsobj.getString("name");
        boolean sixinch = jsobj.getBoolean("size");
        Sandwich sw = new Sandwich(name);
        sw.setSixinch(sixinch);
        addingredients(sw, jsobj);
        return sw;
    }


    // MODIFIES: Sandwich
    // EFFECTIONS: parses ingredients from JSON and adds it to
    private void addSandwiches(ListOfSandwich sw, JSONObject jsobj) {
        JSONArray jsonArray = jsobj.getJSONArray("sandwiches");
        for (Object json : jsonArray) {
            JSONObject nextThing = (JSONObject) json;
            addSandwich(sw, nextThing);
        }

    }

    private void addSandwich(ListOfSandwich sw, JSONObject jsobj) {
        String name = jsobj.getString("name");
        Sandwich s = new Sandwich(name);
        addingredients(s, jsobj);
        sw.addSandwich(s);
    }


    // MODIFIES: Sandwich
    // EFFECTIONS: parses ingredients from JSON and adds it to
    private void addingredients(Sandwich sw, JSONObject jsobj) {
        JSONArray jsonArray = jsobj.getJSONArray("Ingredients");
        for (Object json : jsonArray) {
            JSONObject nextThing = (JSONObject) json;
            addIngredient(sw, nextThing);
        }

    }

    // MODIFIES: ing
    // EFFECTS: parses ingredients from the JSON object and adds them to sandwich.
    private void addIngredient(Sandwich sw, JSONObject jsobj) {
        String name = jsobj.getString("name");
        int calories = jsobj.getInt("calories");
        int protein = jsobj.getInt("protein");
        int sugar = jsobj.getInt("sugar");
        Category category = Category.valueOf(jsobj.getString("category"));
        Ingredient ingredient = new Ingredient(name, calories, protein, sugar, category);
        sw.addIngredient(ingredient);
    }


}
