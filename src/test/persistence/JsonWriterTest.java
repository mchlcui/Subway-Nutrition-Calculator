package persistence;

import model.Category;
import model.Ingredient;
import model.Sandwich;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
//citation: used given example as sample code
class JsonWriterTest extends JsonTest {
    //NOTE TO CPSC 210 STUDENTS: the strategy in designing tests for the JsonWriter is to
    //write data to a file and then use the reader to read it back in and check that we
    //read in a copy of what was written out.

    @Test
    void testWriterInvalidFile() {
        try {
            Sandwich sw= new Sandwich("My sandwich");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptySandwich() {
        try {
            Sandwich sw= new Sandwich("My sandwich");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptySandwich.json");
            writer.open();
            writer.write(sw);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptySandwich.json");
            sw= reader.read();
            assertEquals("My sandwich", sw.getName());
            assertEquals(0, sw.numOfIngredients());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralSandwich() {
        try {
            Sandwich sw= new Sandwich("My sandwich");
            sw.addIngredient(new Ingredient("steak", 220, 15, 5, Category.MEAT));
            sw.addIngredient(new Ingredient("lettuce", 0, 0, 0, Category.VEGETABLE));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralSandwich.json");
            writer.open();
            writer.write(sw);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralSandwich.json");
            sw= reader.read();
            assertEquals("My sandwich", sw.getName());
            List<Ingredient> ingredients = sw.getIngredients();
            assertEquals(2, ingredients.size());
            checkIngredient("steak", Category.MEAT, ingredients.get(0));
            checkIngredient("lettuce", Category.VEGETABLE, ingredients.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}