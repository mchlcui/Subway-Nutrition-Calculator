package persistence;


import model.ListOfSandwich;
import org.junit.jupiter.api.Test;

import java.io.IOException;

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