import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * The FileMenuHandler class handles actions related to the file menu in Date212GUI.
 */
public class FileMenuHandler implements ActionListener {
    private final Date212GUI parent;

    /**
     * Constructs a FileMenuHandler with a reference to the parent Date212GUI.
     *
     * @param parent The Date212GUI instance that owns this FileMenuHandler.
     */
    public FileMenuHandler(Date212GUI parent) {
        this.parent = parent;
    }

    /**
     * Invoked when an action occurs. Performs specific actions based on the action command.
     *
     * @param e The action event.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if ("Open".equals(command)) {
            // Open file dialog
            JFileChooser fileChooser = new JFileChooser();
            int returnVal = fileChooser.showOpenDialog(parent);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();

                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    String line;

                    // Read each line from the file and create Date212 objects
                    while ((line = br.readLine()) != null) {
                        Date212 date = new Date212(line);
                        parent.sortedList.add(date);
                        parent.unsortedList.add(date);
                    }

                    // Update and display both sorted and unsorted lists
                    parent.displaySortedDates();
                    parent.displayUnsortedDates();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } else if ("Quit".equals(command)) {
            // Quit the program
            System.exit(0);
        }
    }
}