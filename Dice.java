package Assignment04_000315902;

/**
 * Gives attributes for each individual Die(Model) in Dice Collection Class
 * @author Aramnd Amores 000315902
 */
public class Dice {
    /** number of sides for a die **/
    private int numOfSides;
    /** displays current side when rolled **/
    private int rolledSide;

    /**
     * @param numOfSides is passed to indicate how many sides this particular Die has
     */
    public Dice (int numOfSides) {
        this.numOfSides = numOfSides; // passed argument is value
        this.rolledSide = (int) (Math.random() * numOfSides) + 1; // to give each die a random starting side
    }

    /**
     * @return Individual Die # of sides and rolled side
     */
    @Override
    public String toString() {
        return "Dice " +
                "#sides:" + numOfSides +
                " Rolled:" + rolledSide;
    }

    /**
     * @return How many sides
     */
    public int getNumOfSides() {
        return numOfSides;
    }

    /**
     * @return What it rolled
     */
    public int getRolledSide() {
        return rolledSide;
    }

    /**
     * @param rolledSide when dice is rolled, sets the new rolled side
     */
    public void setRolledSide(int rolledSide) {
        this.rolledSide = rolledSide;
    }


}
