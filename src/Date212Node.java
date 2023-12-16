/**
 * The Date212Node class represents a node in a linked list of Date212 objects.
 */
public class Date212Node {
    /**
     * The Date212 object held by the node.
     */
    protected Date212 data;

    /**
     * The reference to the next Date212Node in the linked list.
     */
    protected Date212Node next;

    /**
     * Constructs a Date212Node with the specified Date212 object.
     *
     * @param d The Date212 object to be stored in the node.
     */
    public Date212Node(Date212 d) {
        data = d;
        next = null;
    }
}