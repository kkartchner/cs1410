import java.util.ArrayList;

/**
 * Public class for creating and storing information about a hero game entity.
 *
 * @author Ky Kartchner
 * @version 1.0
 */
public class Hero extends Entity {
    /*************************************************** Variables ***************************************************/
    /**
     * private String for storing the name of the hero.
     */
    private String name;

    /**
     * private ArrayList of Treasures for storing the treasures that the hero has obtained.
     */
    private ArrayList<Treasure> treasures;


    /************************************************* Constructors **************************************************/
    /**
     * Constructs a new hero with the specified name and position.
     *
     * @param name The name of the hero
     * @param x    X value of the position
     * @param y    Y value of the position
     */
    public Hero(String name, int x, int y) {
        super(x, y);
        this.name = name;

        this.treasures = new ArrayList<>();
    }


    /*************************************************** Methods *****************************************************/
    /**
     * Causes the hero to "attack" the specified entity. If it is a crate, add the crate's treasure to the hero's
     * treasure list. If a dragon that is a golden dragon, add coins. Otherwise just print that the hero defeated it.
     *
     * @param e The entity to "attack"
     */
    public void attack(Entity e) {
        if (e instanceof Crate) {
            this.treasures.add(((Crate) e).getTreasure());
            System.out.printf("%s crushed the crate into bits and found %s.\n", this.name, ((Crate) e).getTreasure());
        } else if (e instanceof Dragon) {
            String dragonColor = ((Dragon) e).getColor();

            if (dragonColor == "Golden") {
                this.treasures.add(Treasure.Coins);
                System.out.printf("%s bravely defeated the Golden dragon and came away with gold coins as a prize.\n",
                        this.name);
            } else {
                System.out.printf("%s bravely defeated the %s dragon.\n", this.name, dragonColor);
            }
        }
    }

    /**
     * Prints the hero's position and list of obtained treasures.
     */
    public void report() {
        System.out.printf("--- Hero report for %s ---\n", this.name);
        System.out.println("Position: " + getPosition().toString());
        System.out.println("Treasures:");
        for (Treasure t : treasures) {
            System.out.println("  " + t.name());
        }
        System.out.println();
    }

    /**
     * Overrides the toString() method inherited from the object base class to print the hero description.
     *
     * @return String with description of hero
     */
    @Override
    public String toString() {
        return String.format("\"%s standing at %s\"", this.name, getPosition().toString());
    }


    /****************************************** Accessor/Mutator Methods  ********************************************/
    /**
     * Accessor for the name variable.
     *
     * @return this.name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Accessor for the list of treasures.
     *
     * @return this.treasures
     */
    public ArrayList<Treasure> getTreasures() {
        return this.treasures;
    }
}
