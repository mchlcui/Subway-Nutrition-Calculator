package persistence;

import model.ListOfSandwich;
import model.Sandwich;
import org.json.JSONObject;
import java.util.List;

//citation: used given example as sample code
import java.io.*;

// Represents a writer that write json representation
public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    // EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of sandwich to file

    public void write(ListOfSandwich sw) {
        JSONObject json = sw.toJson();
        saveToFile(json.toString(TAB));
    }



    // MODIFIES: this
    // EFFECTS: closes the writer
    public void close() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: writes the given string to file
    private void saveToFile(String json) {
        writer.print(json);
    }
}
