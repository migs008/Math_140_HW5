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
        //location.drawTo(StdDraw.);

    }

//    public double distance() {
//        // Use distanceTo method?
//        Node ptr = head;
//        
//        
//        
//        return ptr.distanceTo();
//    }

    public void insertNearest(Location location) {
        Node n = new Node(location);

        if (size == 0) {
            head = n;
            head.next = head;
        }
        else {
            double distance = n.location.distanceTo(head.location);
            Node ptr = head;
            for (int i = 0; i < size; i++) {
                if (n < ptr) {

                }
            }
        }
    }

    public void insertSmallest(Location location) {
        Node n = new Node(location);

        if (head != null) {

        }
    }

    public int size() {
        return this.size;
    }

//    public String toString() {
//        
//    }
}