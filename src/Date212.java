import java.util.Objects;

/**
 * The Date212 class represents a date in the format YYYYMMDD.
 * It provides methods to handle and manipulate date information.
 */
public class Date212 implements Comparable<Date212> {
    private int year;
    private int month;
    private int day;

    /**
     * Constructs a Date212 object from the given string.
     *
     * @param s The date string in the format YYYYMMDD.
     * @throws IllegalDate212Exception If the provided date string is invalid.
     */
    public Date212(String s) {
        if (!isValidDate(s)) {
            throw new IllegalDate212Exception("Invalid Date212 format: " + s);
        }

        // Extract year, month, and day from the input string
        year = Integer.parseInt(s.substring(0, 4));
        month = Integer.parseInt(s.substring(4, 6));
        day = Integer.parseInt(s.substring(6, 8));

    }


    /**
     * Sets the date based on the provided string.
     *
     * @param s The date string in the format YYYYMMDD.
     * @throws IllegalDate212Exception If the provided date string is invalid.
     */
    public void setDate212(String s) {
        if (!isValidDate(s)) {
            throw new IllegalDate212Exception("Invalid Date212 format: " + s);
        }

        // Update year, month, and day based on the input string
        year = Integer.parseInt(s.substring(0, 4));
        month = Integer.parseInt(s.substring(4, 6));
        day = Integer.parseInt(s.substring(6, 8));
    }

    /**
     * Retrieves the date in the format YYYYMMDD.
     *
     * @return The date string in the format YYYYMMDD.
     */
    public String getDate212() {
        // Format the date components into the desired string format
        String date = "" + year;
        if (month < 10) date += ("0" + month);
        else date += month;
        if (day < 10) date += ("0" + day);
        else date += day;
        return date;
    }

    /**
     * Retrieves the year of the date.
     *
     * @return The year of the date.
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the year of the date.
     *
     * @param year The year to set.
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Retrieves the month of the date.
     *
     * @return The month of the date.
     */
    public int getMonth() {
        return month;
    }

    /**
     * Sets the month of the date.
     *
     * @param month The month to set.
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * Retrieves the day of the date.
     *
     * @return The day of the date.
     */
    public int getDay() {
        return day;
    }

    /**
     * Sets the day of the date.
     *
     * @param day The day to set.
     */
    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return month + "/" + day + "/" + year;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Date212 date212 = (Date212) other;
        return year == date212.year && month == date212.month && day == date212.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }

    @Override
    public int compareTo(Date212 other) {
        // Compare date strings for sorting
        String thisDate = this.getDate212();
        String otherDate = other.getDate212();
        return thisDate.compareTo(otherDate);
    }

    /**
     * Checks if the given date string is valid.
     *
     * @param date The date string in the format YYYYMMDD.
     * @return True if the date string is valid, false otherwise.
     */
    private boolean isValidDate(String date) {
        if (date.length() != 8) {
            return false; // Date should be 8 characters long (YYYYMMDD)
        }

        try {
            Integer.parseInt(date); // Check if it's a valid number
        } catch (NumberFormatException e) {
            return false;
        }

        // Extract year, month, and day from the input string
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(4, 6));
        int day = Integer.parseInt(date.substring(6, 8));

        // Basic validation for year, month, and day ranges
        if (year < 0 || month < 1 || month > 12 || day < 1 || day > 31) {
            return false;
        }

        return true;
    }
}