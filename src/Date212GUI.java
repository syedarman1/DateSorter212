import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * The Date212GUI class represents a graphical user interface for displaying and managing lists of dates.
 */

public class Date212GUI extends JFrame {
    public TextArea sortedTextArea;
    public TextArea unsortedTextArea;
    public SortedDate212List sortedList;
    public UnsortedDate212List unsortedList;

    /**
     * Constructor for Date212GUI. Initializes the GUI components and sets up the window.
     */

    public Date212GUI() {
        setSize(600, 400);
        setLocation(100, 100);
        setLayout(new GridLayout(1, 2));
        setTitle("Dates");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container myContentPane = getContentPane();
        sortedTextArea = new TextArea();
        unsortedTextArea = new TextArea();
        myContentPane.add(unsortedTextArea);  // Add unsortedTextArea first
        myContentPane.add(sortedTextArea);    // Then add sortedTextArea
        sortedTextArea.append("Sorted Dates:\n\n");
        unsortedTextArea.append("Unsorted Dates:\n\n");

        JMenuBar menuBar = new JMenuBar();
        createFileMenuBar(menuBar);
        createEditMenuBar(menuBar);  // New line added
        setJMenuBar(menuBar);

        sortedList = new SortedDate212List();
        unsortedList = new UnsortedDate212List();

        setVisible(true);
    }


    /**
     * Initiates the GUI. (Currently empty, but you can add additional setup code if needed.)
     */
    public void initiateGUI() {

    }

    /**
     * Create and set up the "File" menu in the menu bar.
     *
     * @param menuBar The menu bar to which the "File" menu is added.
     */

    private void createFileMenuBar(JMenuBar menuBar) {
        JMenuItem item1;
        JMenu fileMenu = new JMenu("File");
        item1 = new JMenuItem("Open");
        item1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnVal = fileChooser.showOpenDialog(Date212GUI.this);

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();

                    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            Date212 date = new Date212(line);
                            sortedList.add(date);
                            unsortedList.add(date);
                        }
                        displaySortedDates();
                        displayUnsortedDates();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        fileMenu.add(item1);
        fileMenu.addSeparator();
        JMenuItem item2 = new JMenuItem("Quit");
        item2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        fileMenu.add(item2);

        menuBar.add(fileMenu);
    }

    private void createEditMenuBar(JMenuBar menuBar) {
        JMenuItem searchMenuItem = new JMenuItem("Search");
        searchMenuItem.addActionListener(new EditMenuHandler(this)); // Attach the menu handler
        JMenu editMenu = new JMenu("Edit");
        editMenu.add(searchMenuItem);
        menuBar.add(editMenu);
    }

    /**
     * Display the sorted dates in the sortedTextArea.
     */

    public void displaySortedDates() {
        sortedTextArea.setText("Sorted Dates:\n\n" + sortedList.getSortedDatesAsString());
    }

    /**
     * Display the unsorted dates in the unsortedTextArea.
     */

    public void displayUnsortedDates() {
        StringBuilder formattedDates = new StringBuilder("Unsorted Dates:\n\n");
        for (Date212 date : unsortedList.getDates()) {
            formattedDates.append(date.getDate212()).append("\n");
        }
        unsortedTextArea.setText(formattedDates.toString());
    }


    /**
     * Update the sortedTextArea with new sorted dates.
     *
     * @param dates The string containing the updated sorted dates.
     */

    public void updateSortedTextArea(String dates) {
        sortedTextArea.setText("Sorted Dates:\n\n" + dates);
    }


    /**
     * Update the unsortedTextArea with new unsorted dates.
     *
     * @param dates The string containing the updated unsorted dates.
     */

    public void updateUnsortedTextArea(String dates) {
        unsortedTextArea.setText("Unsorted Dates:\n\n" + dates);
    }

}
