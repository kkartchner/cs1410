import java.util.ArrayList;

/**
 * Public class for creating an arena with game entities. Utilizes methods for adding entities, moving the hero, and
 * for retrieving the status of entities it contains.
 *
 * @author Ky Kartchner
 * @version 1.0
 */
public class Arena {
    /*************************************************** Variables ***************************************************/
    /**
     * private ArrayList of Entity arrays used as a grid for storing game entities.
     */
    private ArrayList<Entity[]> grid;

    /**
     * private Hero used for storing the arena's hero information.
     */
    private Hero hero;


    /************************************************* Constructors **************************************************/
    /**
     * Constructor for creating a new Arena with specified size.
     *
     * @param sizeX Width of the arena
     * @param sizeY Height of the arena
     */
    public Arena(int sizeX, int sizeY) {
        grid = new ArrayList<>();
        for (int y = 0; y < sizeY; y++) {
            grid.add(new Entity[sizeX]);
        }
    }


    /*************************************************** Methods *****************************************************/
    /**
     * Attempts to add the specified entity to the arena.
     *
     * @param e The entity to add
     * @return True if successfully added entity; False if not
     */
    public boolean add(Entity e) {
        int x = e.getPosition().x;
        int y = e.getPosition().y;

        if (grid.get(y)[x] != null) {
            System.out.printf("Could not add %s because another entity is already there.\n", e.toString());
            return false;           //  Entity already at grid position, so return false
        } else {
            if (e instanceof Hero) {
                if (this.hero == null) {
                    this.hero = (Hero) e;
                } else {
                    System.out.printf("Could not add %s because there is already a hero in the arena.\n", e.toString());
                    return false;
                }
            }

            grid.get(y)[x] = e;
            System.out.printf("Successfully added %s to the game arena.\n", e.toString());
            return true;
        }
    }

    /**
     * Moves the hero to the specified location. If an entity already exists there, the hero attack function is called.
     * The hero is removed from it's previous index on the grid by setting the index to null.
     *
     * @param x X position of location
     * @param y Y position of location
     */
    public void moveHero(int x, int y) {
        if (grid.get(y)[x] != null) {
            this.hero.attack(grid.get(y)[x]);
        }

        int oldX = this.hero.getPosition().x;
        int oldY = this.hero.getPosition().y;

        this.hero.setPosition(x, y);
        grid.get(y)[x] = this.hero;

        System.out.printf("%s moved to (%d, %d)\n", this.hero.getName(), x, y);

        grid.get(oldY)[oldX] = null;

    }

    /**
     * Calls the hero's report method to print the hero's position and treasures obtained.
     */
    public void reportHero() {
        this.hero.report();
    }

    /**
     * Searches the grid for entities and adds each occurrence to the total entity count.
     *
     * @return entityCount
     */
    public int getEntityCount() {
        int entityCount = 0;
        for (int y = 0; y < grid.size(); y++) {
            for (int x = 0; x < grid.get(y).length; x++) {
                if (grid.get(y)[x] != null) {
                    entityCount++;
                }
            }
        }
        return entityCount;
    }

    /**
     * Searches the grid for dragons and adds each occurrence to the total dragon count.
     *
     * @return dragonCount
     */
    public int getDragonCount() {
        int dragonCount = 0;
        for (int y = 0; y < grid.size(); y++) {
            for (int x = 0; x < grid.get(y).length; x++) {
                if (grid.get(y)[x] instanceof Dragon) {
                    dragonCount++;
                }
            }
        }
        return dragonCount;
    }

    /**
     * Counts the number of specified treasure currently on the grid (not counting ones that can be earned from killing
     * Golden dragons)
     *
     * @param type The type of treasure to count up
     * @return treasureCount
     */
    public int getTreasureCount(Treasure type) {
        int treasureCount = 0;
        for (int y = 0; y < grid.size(); y++) {
            for (int x = 0; x < grid.get(y).length; x++) {
                Entity e = grid.get(y)[x];
                if (e instanceof Crate) {
                    if (((Crate) e).getTreasure() == type) {
                        treasureCount++;
                    }
                }
            }
        }
        return treasureCount;
    }


    /******************************************* Accessor/Mutator Methods ********************************************/
    /**
     * Accessor for the grid.
     *
     * @return this.grid
     */
    public ArrayList<Entity[]> getGrid() {
        return this.grid;
    }

    /**
     * Accessor for the hero.
     *
     * @return this.hero
     */
    public Hero getHero() {
        return this.hero;
    }
}
