package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SandwichBuilderMenu {

    private static JButton btnOpenNewSandwich = new JButton("Create New Sandwich");
    private static JButton btnModifySandwich = new JButton("Modify Existing Sandwich");


    public static void main(String[] args) {
        showWindow();
    }

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public static void showWindow() {
        JFrame menu = new JFrame("SandwichApp");

        menu.setBounds(100,100,450,450);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.getContentPane().setLayout(null);
        menu.setVisible(true);


        btnOpenNewSandwich.setBounds(0, 0,450,225);
        menu.getContentPane().add(btnOpenNewSandwich);
        btnOpenNewSandwich.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.setVisible(false);
                CreateSandwich create = new CreateSandwich();
                create.createAndShowGUI();
            }
        });

        btnModifySandwich.setBounds(0, 225,450,225);
        menu.getContentPane().add(btnModifySandwich);
        btnModifySandwich.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.setVisible(false);
                CreateSandwich create = new CreateSandwich();
                create.createAndShowGUI();
            }
        });



    }
}
