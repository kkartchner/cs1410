/**
 * Public class for creating and storing information about a dragon game entity.
 *
 * @author Ky Kartchner
 * @version 1.0
 */
public class Dragon extends Entity {
    /*************************************************** Variables ***************************************************/
    /**
     * private String for storing the color of the dragon.
     */
    private String color;


    /************************************************* Constructors **************************************************/
    /**
     * Constructs a new dragon with the specified color and position.
     *
     * @param color The color of the dragon
     * @param x     X value of the position
     * @param y     Y value of the position
     */
    public Dragon(String color, int x, int y) {
        super(x, y);
        this.color = color;
    }


    /*************************************************** Methods *****************************************************/
    /**
     * Overrides the toString() method inherited from the Object base class.
     *
     * @return String of dragon description
     */
    @Override
    public String toString() {
        return String.format("\"The %s dragon breathing fire at %s\"", this.color, super.getPosition().toString());
    }


    /******************************************* Accessor/Mutator Methods ********************************************/
    /**
     * Accessor for the color variable.
     *
     * @return this.color
     */
    public String getColor() {
        return this.color;
    }
}
