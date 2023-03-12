package persistence;


import model.Category;
import model.Ingredient;
import model.Sandwich;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//citation: used given example as sample code
class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Sandwich sw = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptySandwich() {
        JsonReader reader = new JsonReader("./data/testReaderEmptySandwich.json");
        try {
            Sandwich sw = reader.read();
            assertEquals("My sandwich", sw.getName());
            assertEquals(0, sw.numOfIngredients());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralSandwich() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralSandwich.json");
        try {
            Sandwich sw = reader.read();
            assertEquals("My sandwich", sw.getName());
            List<Ingredient> ingredients = sw.getIngredients();
            assertEquals(2, ingredients.size());
            checkIngredient("steak", Category.MEAT, ingredients.get(0));
            checkIngredient("lettuce", Category.VEGETABLE, ingredients.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}