/**
 * Public class for creation of game entities and their associated information.
 *
 * @author Ky Kartchner
 * @version 1.0
 */
public class Entity {
    /*************************************************** Variables ***************************************************/
    /**
     * private integer used for storing the entity's position
     */
    private Position position;


    /************************************************* Constructors **************************************************/
    /**
     * Constructs a new entity with a specified position.
     *
     * @param x X value of the position
     * @param y Y value of the position
     */
    public Entity(int x, int y) {
        this.position = new Position(x, y);
    }


    /******************************************* Accessor/Mutator Methods ********************************************/
    /**
     * Accessor for the position variable.
     *
     * @return this.position
     */
    public Position getPosition() {
        return this.position;
    }

    /**
     * Mutator method for the position variable.
     *
     * @param x X value of position to set
     * @param y Y value of the position to set
     */
    public void setPosition(int x, int y) {
        this.position.x = x;
        this.position.y = y;
    }
}
