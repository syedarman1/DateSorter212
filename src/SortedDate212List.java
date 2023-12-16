import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * The SortedDate212List class maintains a sorted list of Date212 objects using an ArrayList.
 */
public class SortedDate212List {

    public ArrayList<Date212> dates;

    /**
     * Constructs a SortedDate212List initializing the ArrayList.
     */
    public SortedDate212List() {
        dates = new ArrayList<>();
    }

    /**
     * Adds a Date212 object to the sorted list while maintaining the sorted order.
     *
     * @param d The Date212 object to add to the sorted list.
     */
    public void add(Date212 d) {
        // Add the date to the list and re-sort it
        dates.add(d);
        Collections.sort(dates);
    }

    /**
     * Reads dates from a .txt file and adds them to the sorted list.
     *
     * @param fileName The path to the .txt file containing dates.
     */
    public void readAndAddDatesFromFile(String fileName) {
        try {
            // Create a buffered reader to read from the file
            BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
            String line;
            // Read each line from the file
            while ((line = br.readLine()) != null) {
                try {
                    // Try to create a Date212 object from the line and add it to the sorted list
                    Date212 date = new Date212(line);
                    add(date);
                } catch (IllegalDate212Exception e) {
                    // Handle exceptions for invalid date formats
                    System.out.println("Invalid Date212 format: " + line);
                }
            }
            // Close the buffered reader
            br.close();
        } catch (IOException ex) {
            // Handle exceptions for file IO errors
            ex.printStackTrace();
        }
    }

    /**
     * Displays the contents of the sorted list.
     */
    public void displaySortedDates() {
        System.out.println("Sorted Dates:");
        for (Date212 date : dates) {
            System.out.println(date);
        }
    }

    /**
     * Retrieves the sorted dates as a formatted string.
     *
     * @return A string containing the sorted dates.
     */
    public String getSortedDatesAsString() {
        // Build a string with each sorted date on a new line
        StringBuilder datesAsString = new StringBuilder();
        for (Date212 date : dates) {
            datesAsString.append(date).append("\n");
        }
        return datesAsString.toString();
    }



    public SortedDate212List filterByYear(String yearString) {
        int year = Integer.parseInt(yearString); // Convert the input string to an integer
        SortedDate212List filteredList = new SortedDate212List();

        for (Date212 date : dates) { // Use the appropriate list variable
            System.out.println("Checking date: " + date); // Debugging line
            if (date.getYear() == year) {
                filteredList.add(date);
            }
        }

        return filteredList;


    }





}
