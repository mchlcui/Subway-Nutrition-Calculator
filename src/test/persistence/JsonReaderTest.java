package persistence;


import model.Category;
import model.Ingredient;
import model.ListOfSandwich;
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
            ListOfSandwich sw = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }


}