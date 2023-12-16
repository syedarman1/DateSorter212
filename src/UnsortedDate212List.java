import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The UnsortedDate212List class stores Date212 objects in an unsorted ArrayList.
 */
public class UnsortedDate212List {

    private final ArrayList<Date212> unsortedDates;


    /**
     * Constructs an UnsortedDate212List initializing the ArrayList.
     */
    public UnsortedDate212List() {
        unsortedDates = new ArrayList<>();
    }

    /**
     * Adds a Date212 object to the unsorted list.
     *
     * @param d The Date212 object to add to the unsorted list.
     */
    public void add(Date212 d) {
        unsortedDates.add(d);
    }


    /**
     * Reads dates from a .txt file and adds them to the unsorted list.
     *
     * @param fileName The path to the .txt file containing dates.
     */
    public void readAndAddDatesFromFile(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    Date212 date = new Date212(line);
                    add(date);
                } catch (IllegalDate212Exception e) {
                    System.out.println("Invalid Date212 format: " + line);
                }
            }
            br.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Displays the contents of the unsorted list.
     */
    public void displayUnsortedDates() {
        System.out.println("Unsorted Dates:");
        for (Date212 date : unsortedDates) {
            System.out.println(date);
        }
    }

    /**
     * Retrieves the unsorted dates as a formatted string.
     *
     * @return A string containing the unsorted dates.
     */
    public String getUnsortedDatesAsString() {
        StringBuilder datesAsString = new StringBuilder();
        for (Date212 date : unsortedDates) {
            datesAsString.append(date.getDate212()).append("\n");
        }
        return datesAsString.toString();
    }



    public ArrayList<Date212> getUnsortedDates() {
        return unsortedDates;
    }

    public List<Date212> getDates() {
        return unsortedDates;
    }


    public UnsortedDate212List filterByYear(String yearString) {
        int year = Integer.parseInt(yearString); // Convert the input string to an integer
        UnsortedDate212List filteredList = new UnsortedDate212List();

        for (Date212 date : unsortedDates) { // Use the appropriate list variable
            System.out.println("Checking date: " + date); // Debugging line
            if (date.getYear() == year) {
                filteredList.add(date);
            }
        }

        return filteredList;
    }


}


