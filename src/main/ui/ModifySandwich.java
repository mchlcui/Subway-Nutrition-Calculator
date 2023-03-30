package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Sandwich;
import persistence.JsonWriter;
import persistence.JsonReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ModifySandwich {

    private static JFrame view = new JFrame("All Sandwiches");
    private static JLabel sw = new JLabel("sandwiches");
    private static JButton btnSelect = new JButton("Select");
    private static DefaultListModel sandwiches = new DefaultListModel<>();

    public static void main(String[] args) {
        showWindow();
    }

    public static void showWindow() {

        view.setBounds(100, 100, 450, 450);
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.getContentPane().setLayout(null);
        btnSelect.setBounds(0,0,100,100);
        SaveScreen ss = new SaveScreen();

        for (Sandwich sw : ss.getSandwiches()) {
            sandwiches.addElement(sw.getName());
        }

        // building a list of sandwiches
        JList sws = new JList<>(sandwiches);
        sws.setBounds(50,50,225,225);

        // making a scroll pane to check them
        JScrollPane ssp = new JScrollPane();
        ssp.setViewportView(sws);
        sws.setLayoutOrientation(JList.VERTICAL);
        ssp.setBounds(25,25,225,225);

        view.add(ssp);
        view.getContentPane().add(btnSelect);
        view.add(sw);


        view.setVisible(true);

    }
}
