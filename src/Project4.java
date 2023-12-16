import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * The Project4 class serves as the entry point for the Date212GUI application.
 * It initializes the GUI and starts the application by allowing the user
 * to select a text file containing dates to display in sorted and unsorted lists.
 */
public class Project4 {

    /**
     * The main method is the entry point of the application.
     * It creates an instance of the Date212GUI class and initiates the GUI.
     * It prompts the user to select a text file, reads dates from the file,
     * and displays them in sorted and unsorted lists in the GUI.
     * @author Syed Arman
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        // Initialize the GUI
        Date212GUI myGUI = new Date212GUI();
        myGUI.initiateGUI();

        // Create a file chooser dialog
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooser.setFileFilter(filter);

        // Show the file chooser dialog
        int returnVal = fileChooser.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            // Get the selected file
            File file = fileChooser.getSelectedFile();

            // Read dates from the selected file using the lists from myGUI
            readDatesFromFile(file.getAbsolutePath(), myGUI.unsortedList, myGUI.sortedList);

            // Display dates in the GUI
            myGUI.displaySortedDates();
            myGUI.displayUnsortedDates();
        }
    }

    /**
     * Reads dates from a file and adds them to unsorted and sorted lists.
     *
     * @param fileName     The path to the .txt file containing dates.
     * @param unsortedList The unsorted list to populate.
     * @param sortedList   The sorted list to populate.
     */
    private static void readDatesFromFile(String fileName, UnsortedDate212List unsortedList, SortedDate212List sortedList) {
        try {          // Create a buffered reader to read from the file
            BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
            String line;             // Read each line from the file
            while ((line = br.readLine()) != null) {
                try {               // Try to create a Date212 object from the line
                    Date212 date = new Date212(line);
                    unsortedList.add(date);                   // Add the date to both unsorted and sorted lists
                    sortedList.add(date);
                } catch (IllegalDate212Exception e) {
                    System.out.println("Invalid Date212 format: " + line);
                }                                        // Handle exceptions for invalid date formats
            }
            br.close();                                  // Close the buffered reader
        } catch (IOException ex) {
            ex.printStackTrace();                          // Handle exceptions for file IO errors
        }
    }
}
