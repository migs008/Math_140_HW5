
/* Use this file to test your code.

   Run the code twice.
   The first time run the code with the insertNearest method uncommented and insertSmallest
   converted to a comment.

   The second time run the code with the insertSmallest method uncommented and insertNearest
   converted to a comment.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestHW5 {

    public static void main(String[] args) {

        File file = new File("tsp10.txt");

        try {
            Scanner in = new Scanner(file);
            int width = in.nextInt();
            int height = in.nextInt();
            int border = 20;
            StdDraw.setCanvasSize(width, height + border);
            StdDraw.setXscale(0, width);
            StdDraw.setYscale(-border, height);

            MinimizeDistance md = new MinimizeDistance();
            while (in.hasNext()) {
                double x = in.nextDouble();
                double y = in.nextDouble();
                Location p = new Location(x, y);
                //md.insertNearest(p);
                md.insertSmallest(p);
            }

            // draw to standard draw
            md.draw();

            // print tour to standard output
            System.out.println(md);
            System.out.printf("Tour length = %.4f\n", md.distance());
            System.out.printf("Number of points = %d\n", md.size());
            in.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println(args[0] + " not found");
        }
    }
}
