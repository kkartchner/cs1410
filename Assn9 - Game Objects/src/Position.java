/**
 * Public class used for storing the position of a game entity.
 *
 * @author Ky Kartchner
 * @version 1.0
 */
public class Position {
    /*************************************************** Variables ***************************************************/
    /**
     * public int for storing the x value of the position.
     */
    public int x;

    /**
     * public int for storing the y value of the position.
     */
    public int y;


    /************************************************* Constructors **************************************************/
    /**
     * Constructs a new Position with the specified values
     *
     * @param x X value of position
     * @param y Y value of position
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }


    /*************************************************** Methods *****************************************************/
    /**
     * Overrides the toString() method inherited from the Object base class, so the it prints the formatted position.
     *
     * @return String formatted to (x, y)
     */
    @Override
    public String toString() {
        return String.format("(%d, %d)", x, y);
    }
}
