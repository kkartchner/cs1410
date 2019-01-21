/**
 * Public class for creating and storing information for a crate game entity.
 *
 * @author Ky Kartchner
 * @version 1.0
 */
public class Crate extends Entity {
    /*************************************************** Variables ***************************************************/
    /**
     * private Treasure enum for storing the name of the treasure that the crate contains.
     */
    private Treasure treasure;


    /************************************************* Constructors **************************************************/
    /**
     * Constructs a new crate with the specified treasure and position.
     *
     * @param treasure The treasure that the crate contains
     * @param x        X value of the position
     * @param y        Y value of the position
     */
    public Crate(Treasure treasure, int x, int y) {
        super(x, y);
        this.treasure = treasure;
    }


    /*************************************************** Methods *****************************************************/
    /**
     * Override the toString method inherited from Object base class
     *
     * @return Description of the crate
     */
    @Override
    public String toString() {
        return String.format("\"Crate with %s at %s\"", this.treasure, super.getPosition().toString());
    }


    /****************************************** Accessor/Mutator Methods  ********************************************/
    /**
     * Accessor for the treasure variable
     *
     * @return this.treasure
     */
    public Treasure getTreasure() {
        return this.treasure;
    }
}
