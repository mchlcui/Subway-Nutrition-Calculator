//package ui;
//
//import javax.swing.*;
//import javax.swing.event.ListSelectionEvent;
//import javax.swing.event.ListSelectionListener;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import model.Sandwich;
//import persistence.JsonWriter;
//import persistence.JsonReader;
//
//import model.ListOfSandwich;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//public class ModifySandwich extends JPanel
//        implements ListSelectionListener  {
//
//    private static JFrame view = new JFrame("All Sandwiches");
//    private static JLabel sw = new JLabel("sandwiches");
//    private static JButton btnSelect = new JButton("Select");
//    private ListOfSandwich sandwiches = new ListOfSandwich();
//
//    private static DefaultListModel listSandwiches = new DefaultListModel<>();
//    private static JList<Sandwich> list;
//    private static final String JSON_STORE = "./data/sandwich.json";
//    private static JsonWriter jsonWriter = new JsonWriter(JSON_STORE);
//    private static JsonReader jsonReader = new JsonReader(JSON_STORE);
//    private static Sandwich sando;
//
//
//    public static void main(String[] args) {
//        showWindow();
//    }
//
//    public static void showWindow() {
//
//        //Create and set up the window.
//
//        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        //Create and set up the content pane.
//        JComponent newContentPane = new ModifySandwich();
//        newContentPane.setOpaque(true); //content panes must be opaque
//        view.setContentPane(newContentPane);
//        view.add(list);
//
//        //Display the window.
//        view.pack();
//        view.setVisible(true);
//
//    }
//
//    public ModifySandwich() {
//        super(new BorderLayout());
//
//        SaveScreen ss = new SaveScreen();
//
//        for (Sandwich sw : sandwiches.getSandwiches()) {
//            listSandwiches.addElement(sw.getName());
//        }
//
//        list = new JList(listSandwiches);
//        list.setSelectedIndex(0);
//        list.addListSelectionListener(this);
//        list.setVisibleRowCount(5);
//
//        // building a list of sandwiches
//        JList sws = new JList<>(listSandwiches);
//        sws.setBounds(50,50,225,225);
//
//        // making a scroll pane to check them
//        JScrollPane ssp = new JScrollPane();
//        sws.setVisibleRowCount(10);
//        ssp.setViewportView(list);
//        sws.setLayoutOrientation(JList.VERTICAL);
//        ssp.setBounds(25,25,225,225);
//
//        view.add(ssp);
//        view.getContentPane().add(btnSelect);
//        view.add(sw);
//
//    }
//
//    public void loadSandwiches() {
//        try {
//            sando = jsonReader.read();
//        } catch (IOException e) {
//            System.out.println("Unable to load!");
//        }
//    }
//
//    @Override
//    public void valueChanged(ListSelectionEvent e) {
//
//    }
//}

package ui;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import javax.swing.event.*;

import model.ListOfSandwich;
import model.Sandwich;
import persistence.JsonWriter;
import persistence.JsonReader;

/* ListDemo.java requires no other files. */
public class ModifySandwich extends JPanel
        implements ListSelectionListener {
    private JList list;
    private DefaultListModel listModel;

    private static final String JSON_STORE = "./data/sandwich.json";
    private static final JsonReader jsonReader = new JsonReader(JSON_STORE);

    private static final String donestring = "Done";
    private static final String addstring = "Add";
    private static final String removeString = "Remove";
    private static Sandwich sandwich;
    private static ListOfSandwich sandwiches = new ListOfSandwich();



    private JButton removeButton;

    private static JFrame frame = new JFrame("Sandwich Builder");
    private JTextField ingredientName;

    public static void showWindow() {
        //Create and set up the window.
        loadSandwiches();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new ModifySandwich();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);


        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public ModifySandwich() {
        super(new BorderLayout());

        listModel = new DefaultListModel();
        for (Sandwich sw : sandwiches.getSandwiches()) {
            listModel.addElement(sw.getName());
        }


        //Create the list and put it in a scroll pane.
        list = new JList<>(listModel);
        list.setBounds(75,75,75,75);

        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.addListSelectionListener(this);
        list.setVisibleRowCount(5);
        JScrollPane listScrollPane = new JScrollPane(list);

        JButton doneButton = new JButton(donestring);
        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                SandwichBuilderMenu sb = new SandwichBuilderMenu();
                sb.showWindow();
            }
        });



        JButton addButton = new JButton(addstring);
        AddListener addListener = new AddListener(addButton);
        addButton.setActionCommand(addstring);
        addButton.addActionListener(addListener);
        addButton.setEnabled(false);

        removeButton = new JButton(removeString);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = list.getSelectedIndex();
                listModel.remove(index);

                int size = listModel.getSize();

                if (size == 0) { //No more sandwiches disable removing.
                    removeButton.setEnabled(false);

                } else { //Select an index.
                    if (index == listModel.getSize()) {
                        //removed item in last position
                        index--;
                    }

                    list.setSelectedIndex(index);
                    list.ensureIndexIsVisible(index);
                }
            }
        });

        ingredientName = new JTextField(10);
        ingredientName.addActionListener(addListener);
        ingredientName.getDocument().addDocumentListener(addListener);


        //Create a panel that uses BoxLayout.
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane,
                BoxLayout.LINE_AXIS));
        buttonPane.add(doneButton);
        buttonPane.add(removeButton);
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(new JSeparator(SwingConstants.VERTICAL));
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(ingredientName);
        buttonPane.add(addButton);
        buttonPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        add(listScrollPane, BorderLayout.CENTER);
        add(buttonPane, BorderLayout.PAGE_END);
    }

    //This listener is shared by the text field and the add button.
    class AddListener implements ActionListener, DocumentListener {
        private boolean alreadyEnabled = false;
        private JButton button;

        public AddListener(JButton button) {
            this.button = button;
        }

        //Required by ActionListener.
        public void actionPerformed(ActionEvent e) {
            String name = ingredientName.getText();

            //User didn't type in a unique name...
            if (name.equals("") || alreadyInList(name)) {
                Toolkit.getDefaultToolkit().beep();
                ingredientName.requestFocusInWindow();
                ingredientName.selectAll();
                return;
            }

            int index = list.getSelectedIndex(); //get selected index
            if (index == -1) { //no selection, so insert at beginning
                index = 0;
            } else {           //add after the selected item
                index++;
            }

            listModel.insertElementAt(ingredientName.getText(), index);
            //If we just wanted to add to the end, we'd do this:
            //listModel.addElement(ingredientName.getText());

            //Reset the text field.
            ingredientName.requestFocusInWindow();
            ingredientName.setText("");

            //Select the new item and make it visible.
            list.setSelectedIndex(index);
            list.ensureIndexIsVisible(index);
        }

        //This method tests for string equality. You could certainly
        //get more sophisticated about the algorithm.  For example,
        //you might want to ignore white space and capitalization.
        protected boolean alreadyInList(String name) {
            return listModel.contains(name);
        }

        //Required by DocumentListener.
        public void insertUpdate(DocumentEvent e) {
            enableButton();
        }

        //Required by DocumentListener.
        public void removeUpdate(DocumentEvent e) {
            handleEmptyTextField(e);
        }

        //Required by DocumentListener.
        public void changedUpdate(DocumentEvent e) {
            if (!handleEmptyTextField(e)) {
                enableButton();
            }
        }

        private void enableButton() {
            if (!alreadyEnabled) {
                button.setEnabled(true);
            }
        }

        private boolean handleEmptyTextField(DocumentEvent e) {
            if (e.getDocument().getLength() <= 0) {
                button.setEnabled(false);
                alreadyEnabled = false;
                return true;
            }
            return false;
        }
    }

    //This method is required by ListSelectionListener.
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {

            if (list.getSelectedIndex() == -1) {
                //No selection, disable fire button.
                removeButton.setEnabled(false);

            } else {
                //Selection, enable the fire button.
                removeButton.setEnabled(true);
            }
        }
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */


    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                showWindow();
            }
        });
    }

    private static void loadSandwiches() {
        try {
            sandwiches = jsonReader.read();
        } catch (IOException e) {
            System.out.println("Unable to load");
        }
    }
}
