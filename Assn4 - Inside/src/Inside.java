/**
 * Tests if points are inside or outside of circles and rectangles, and prints the results.
 *
 * @author Ky Kartchner
 * @version 1.0
 */
public class Inside {
    /**
     * Primary driver code that tests the "inside" capabilities of the
     * various functions.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        double[] ptX = {1, 2, 3, 4};
        double[] ptY = {1, 2, 3, 4};
        double[] circleX = {0, 5};
        double[] circleY = {0, 5};
        double[] circleRadius = {3, 3};
        double[] rectLeft = {-2.5, -2.5};
        double[] rectTop = {2.5, 5.0};
        double[] rectWidth = {6.0, 5.0};
        double[] rectHeight = {5.0, 2.5};

        System.out.println("--- Report of Points and Circles ---\n");
        for (int i = 0; i < circleX.length; i++){                           // Loop over the circles
            for (int j = 0; j < ptX.length; j++){                           //      Loop over the points
                reportPoint(ptX[j], ptY[j]);                                //          Report on each as appropriate
                if (isPointInsideCircle(ptX[j], ptY[j], circleX[i], circleY[i], circleRadius[i])){
                    System.out.print(" is inside ");
                } else {
                    System.out.print(" is outside ");
                }
                reportCircle(circleX[i], circleY[i], circleRadius[i]);
                System.out.print("\n");
            }                                                               //      End Loop
        }                                                                   // End Loop

        System.out.println("\n--- Report of Points and Rectangles ---\n");
        for (int i = 0; i < rectLeft.length; i++){                          // Loop over the rectangles
            for (int j = 0; j < ptX.length; j++){                           //      Loop over the points
                reportPoint(ptX[j], ptY[j]);                                //          Report on each as appropriate
                if (isPointInsideRectangle(ptX[j], ptY[j], rectLeft[i], rectTop[i], rectWidth[i], rectHeight[i])){
                    System.out.print(" is inside ");
                } else {
                    System.out.print(" is outside ");
                }
                reportRectangle(rectLeft[i], rectTop[i], rectWidth[i],rectHeight[i]);
                System.out.print("\n");
            }                                                               //      End Loop
        }                                                                   // End Loop
    }

    /**
     * Prints the details for a single point
     *
     * @param x X-coordinate of the point
     * @param y Y-coordinate of the point
     */
    static void reportPoint(double x, double y){
        System.out.print("Point(" + x + ", " + y + ")");
    }

    /**
     * Prints the details for a single circle
     *
     * @param x X-coordinate of the circle
     * @param y Y-coordinate of the circle
     * @param r Radius of the circle
     */
    static void reportCircle(double x, double y, double r){
        System.out.print("Circle(" + x + ", " + y + ") Radius: " + r);
    }

    /**
     * Prints the details for a single rectangle
     *
     * @param left Left value of the rectangle
     * @param top Top value of the rectangle
     * @param width Width of the rectangle
     * @param height Height of the rectangle
     */
    static void reportRectangle(double left, double top, double width, double height){
        double right = left + width;
        double bottom = top + height;
        System.out.print("Rectangle(" + left + ", " + top + ", " + right + ", " + bottom + ")");
    }

    /**
     * Tests if a point is inside a circle.
     *
     * @param ptX X-coordinate of the point
     * @param ptY Y-coordinate of the point
     * @param circleX X-coordinate of the circle
     * @param circleY Y-coordinate of the circle
     * @param circleRadius Radius of the circle
     * @return True if the point is inside the circle; False if not.
     */
    static boolean isPointInsideCircle(double ptX, double ptY, double circleX, double circleY, double circleRadius){
        double distance = Math.sqrt(Math.pow(ptX - circleX, 2) + Math.pow(ptY - circleY, 2));  // Distance formula
        return distance <= circleRadius; // The distance must be less than or equal to the radius in order to be inside
                                         //     the circle. Return True if it is; False if not.
    }

    /**
     * Tests if a point is inside a rectangle.
     *
     * @param ptX X-coordinate of the point
     * @param ptY Y-coordinate of the point
     * @param rLeft Left of the rectangle
     * @param rTop Top of the rectangle
     * @param rWidth Width of the rectangle
     * @param rHeight Height of the rectangle
     * @return True if the point is inside the rectangle; False if not.
     */
    static boolean isPointInsideRectangle(double ptX, double ptY, double rLeft, double rTop, double rWidth, double rHeight){
        double rRight = rLeft + rWidth;
        double rBottom = rTop + rHeight;
                                                                    // Point must be both in the domain and in the range
        boolean isInsideRectangleDomain = rLeft <= ptX && ptX <= rRight; //    of the rectangle in order to be inside it
        boolean isInsideRectangleRange = rTop <= ptY && ptY <= rBottom;

        return isInsideRectangleDomain && isInsideRectangleRange;

    }

}
