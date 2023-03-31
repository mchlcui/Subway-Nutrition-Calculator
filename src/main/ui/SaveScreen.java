package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ListOfSandwich;
import model.Sandwich;
import persistence.JsonWriter;
import persistence.JsonReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class SaveScreen {

    private static final String JSON_STORE = "./data/sandwich.json"; // the place JSON is stored to
    private static JsonWriter jsonWriter = new JsonWriter(JSON_STORE); // JSON writer that is used
    private static JsonReader jsonReader = new JsonReader(JSON_STORE); // JSON reader that is used
    private static Sandwich sw;
    private static String name;
    private static boolean clicked;

    private static JButton btnSaving = new JButton("Save");

    private static JButton btnDNS = new JButton("Do Not Save");
    private static JButton okButton = new JButton("Okay!");


    private static ListOfSandwich sandwiches = new ListOfSandwich();

    public static void main(String[] args) {
        showWindow();
    }

    // shows the save screen frame

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public static void showWindow() {
        JFrame save = new JFrame("Save?");

        save.setBounds(100, 100, 450, 450);
        save.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        save.getContentPane().setLayout(null);
        save.getContentPane().add(btnSaving);
        save.setVisible(true);

        btnSaving.setBounds(0, 0, 450, 225);
        btnSaving.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clicked = true;
                save.setVisible(false);
                name = JOptionPane.showInputDialog(save, "Enter Sandwich Name");
                if (name != null && clicked) {

                    sw = new Sandwich(name);
                    sandwiches.addSandwich(sw);
                    saveSandwich();
                    JOptionPane.showMessageDialog(null, "Successfully Added!");
                    SandwichBuilderMenu sb = new SandwichBuilderMenu();
                    sb.showWindow();
                    clicked = false;
                }

            }
        });


        btnDNS.setBounds(0, 225, 450, 225);
        save.getContentPane().add(btnDNS);
        btnDNS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save.setVisible(false);
                SandwichBuilderMenu sb = new SandwichBuilderMenu();
                sb.showWindow();
            }
        });


    }

    // saves the sandwiches to JSON file
    private static void saveSandwich() {
        try {
            jsonWriter.open();
            jsonWriter.write(sandwiches);
            jsonWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file.");
        }
    }

//    protected List<Sandwich> getSandwiches() {
//        return sandwiches;
//    }

    protected String getName() {
        return name;
    }
}


