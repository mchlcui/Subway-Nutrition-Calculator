package ui;

import model.Event;
import model.EventLog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import javax.imageio.ImageIO;


public class SandwichBuilderMenu {
    // Represent the main menu
    private static JFrame menu = new JFrame("SandwichApp");
    private static JButton btnOpenNewSandwich = new JButton("Create New Sandwich"); // the new sandwich button
    private static JLabel imageLabel;
    private static JButton btnModifySandwich = new JButton("Modify Existing Sandwich"); // modify button
    private static JButton imageButton = new JButton("Display Image"); // image button
    private static JLabel addPlayersLabel;
    private static final String sandwichImage = "./data/sandwich image.jpeg"; // image that is used
    private static JLabel imageDescription;
    private static BufferedImage bufferedImage;
    private static File imageFile;
    private static ImageIcon displayedImage;


    public static void main(String[] args) {
        showWindow();
    }

    // Effect: shows the main menu
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public static void showWindow() {

        menu.setBounds(100,100,450,450);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.getContentPane().setLayout(null);
        menu.getContentPane().add(btnModifySandwich);
        menu.getContentPane().add(btnOpenNewSandwich);
        menu.getContentPane().add(imageButton);
        menu.setVisible(true);
        printEventLog();

        // sets the new buttons size

        btnOpenNewSandwich.setBounds(0, 0,450,100);

        // actions if new button is pressed
        btnOpenNewSandwich.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.setVisible(false);
                CreateSandwich create = new CreateSandwich();
                create.createAndShowGUI();
            }
        });

        btnModifySandwich.setBounds(0, 133,450,100);

        btnModifySandwich.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.setVisible(false);
                ModifySandwich modify = new ModifySandwich();
                modify.showWindow();
            }
        });

        // set the display image button
        imageButton.setBounds(0, 266,450,100);

        imageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame imageFrame = new JFrame();
                imageFile = new File(sandwichImage);
                try {
                    bufferedImage = ImageIO.read(imageFile);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                displayedImage = new ImageIcon(bufferedImage);
                imageLabel = new JLabel(displayedImage);

                imageDescription = new JLabel("Thank you for using Sandwich Builder!");
                imageDescription.setBounds(10, 100, 50, 50);

                imageFrame.add(imageLabel);
                imageFrame.add(imageDescription);
                imageFrame.setLayout(new FlowLayout());
                imageFrame.setVisible(true);
                imageFrame.setSize(550,550);
            }
        });


    }

    // Effect: Prints all the events that were logged
    private static void printEventLog() {
        menu.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                for (Iterator<Event> it = EventLog.getInstance().iterator(); it.hasNext(); ) {
                    Event event = it.next();
                    System.out.println(event.getDescription());
                }
                System.exit(0);
            }
        });
    }
}
