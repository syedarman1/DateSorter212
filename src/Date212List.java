/**
 * The Date212List class represents an abstract list of Date212 objects.
 *
 * <p>This abstract class provides basic functionality for managing lists of Date212 objects.</p>
 */
public abstract class Date212List {
    // The first and last nodes of the list
    protected Date212Node first = new Date212Node(null);
    protected Date212Node last = first;

    // The length of the list
    protected int length = 0;

    /**
     * Constructs a Date212List.
     */
    public Date212List() {
        // Constructor
    }

    /**
     * Returns the length of the Date212List.
     *
     * @return The length of the Date212List.
     */
    public int getLength() {
        // Returns the length of Date212List
        return length;
    }

    /**
     * Appends a Date212 object to the end of the Date212List.
     *
     * @param d The Date212 object to append.
     */
    public void append(Date212 d) {
        // Adds a Date212Node to the end of the Date212List

        // Create a new node with the given Date212 object
        Date212Node n = new Date212Node(d);

        // Update the last node to point to the new node
        last.next = n;

        // Update the last reference to the new node
        last = n;

        // Set the next reference of the new node to null
        n.next = null;

        // Increments the length of the list
        length++;
    }


}