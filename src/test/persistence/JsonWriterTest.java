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
            ListOfSandwich sw= new ListOfSandwich();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptySandwich.json");
            writer.open();
            writer.write(sw);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptySandwich.json");
            sw = reader.read();

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }


}