/*
Author: Miguel Aquino
Sources: Professor Scarbnick, Ian Rysdale, Kullen Stanfield
Date: 5/13/2019
Purpose: Stores Location objects in a singly-linked circular linked list.
*/
public class MinimizeDistance {
    private Node head = null;
    private int size = 0;

    private class Node {
        private Location location;
        private Node next;

        public Node(Location location) {
            this.location = location;
            this.next = null;
        }
    }

    /*
    Purpose: Draws the route for the trip.
    Parameters: N/A
    Return: N/A
    */
    public void draw() {

        Node ptr = head;

        for (int i = 0; i < size; i++) {
            ptr.location.drawTo(ptr.next.location);
            ptr = ptr.next;
        }

    }

    /*
    Purpose: Calculates total distance of the trip.
    Parameters: N/A
    Return: Trip distance.
    */
    public double distance() {

        double distance = 0;
        Node ptr = head;
        for (int i = 0; i < size; i++) {
            distance += ptr.location.distanceTo(ptr.next.location);
            ptr = ptr.next;
        }

        return distance;

    }

    /*
    Purpose: Inserts a point using the nearest neighbor approximation.
    Parameters: Location object that contains the point.
    Return: N/A
    */
    public void insertNearest(Location location) {
        Node n = new Node(location);
        int index = 0;

        if (size == 0) {
            head = n;
            head.next = head;
        }
        else if (size == 1) {
            head.next = n;
            n.next = head;
        }
        else {
            Node ptr = head;

            double minDistance = n.location.distanceTo(head.location);

            for (int i = 0; i < size; i++) {
                if (n.location.distanceTo(ptr.location) < minDistance) {
                    minDistance = n.location.distanceTo(ptr.location);
                    index = i;
                }
                ptr = ptr.next;
            }

            ptr = head;
            for (int i = 0; i < index - 1; i++) {
                ptr = ptr.next;
            }
            n.next = ptr.next;
            ptr.next = n;
        }
        size++;
    }

    /*
    Purpose: Inserts a point using the smallest increase in total distance traveled approximation.
    Parameters: Location object that contains the point.
    Return: N/A
    */
    public void insertSmallest(Location location) {
        Node n = new Node(location);
        int index = 0;

        if (size == 0) {
            head = n;
            head.next = head;
        }
        else if (size == 1) {
            head.next = n;
            n.next = head;
        }
        else {
            Node ptr = head;

            double minDistance = distance() + n.location.distanceTo(head.location);

            for (int i = 0; i < size; i++) {
                if (distance() + (n.location.distanceTo(ptr.location)) < minDistance) {
                    minDistance = distance() + n.location.distanceTo(ptr.location);
                    index = i;
                }
                ptr = ptr.next;
            }

            ptr = head;
            for (int i = 0; i < index - 1; i++) {
                ptr = ptr.next;
            }
            n.next = ptr.next;
            ptr.next = n;
        }
        size++;
    }

    /*
    Purpose: Returns the number of Nodes in the linked list.
    Parameters: N/A
    Return: Number of nodes in int.
    */
    public int size() {
        return this.size;
    }

    /*
    Purpose: Concatenates the Strings returned by every Location object stored in the LinkedList.
    Parameters: N/A
    Return: String value to display.
    */
    public String toString() {
        Node ptr = head;
        String s = "";

        for (int i = 0; i < size; i++) {
            s += ptr.location.toString() + "\n";
            ptr = ptr.next;
        }

        return s;
    }
}