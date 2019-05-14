/**
 *
 * @author SWC-Student
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


    public void draw() {

        Node ptr = head;

        for (int i = 0; i < size; i++) {
            ptr.location.drawTo(ptr.next.location);
            ptr = ptr.next;
        }

    }

    public double distance() {

        double distance = 0;
        Node ptr = head;
        for (int i = 0; i < size; i++) {
            distance += ptr.location.distanceTo(ptr.next.location);
            ptr = ptr.next;
        }

        return distance;

    }

    public void insertNearest(Location location) {
        Node n = new Node(location);
        int index = 0;

        if (size == 0) {
            head = n;
            //head.next = head;
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

    public void insertSmallest(Location location) {
        Node n = new Node(location);
        int index = 0;

        if (size == 0) {
            head = n;
            //head.next = head;
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

    public int size() {
        return this.size;
    }

    public String toString() {
        Node ptr = head;
        String s = "";

        for (int i = 0; i < size; i++) {
            s += ptr.location.toString() + "/n";
            ptr = ptr.next;
        }

        return s;
    }
}