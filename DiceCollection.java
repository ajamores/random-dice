package Assignment04_000315902;

import java.util.Arrays;

/**
 * Dice Collection(Model) to hold n amount of dice. Class enables rolling of dice and presents collection data.
 * @author Armand Amores 000315902
 */
public class DiceCollection {
    /** will be used to get sum of each roll of Dice(s) and array will hold value **/
    private int sum;
    /** Obtains the maximum possible sum in set of Dice Collection **/
    private int maxSum;
    /** Obtains the minimum possible sum in set of Dice Collection **/
    private int minSum;
    /** array that holds set of Die Objects **/
    private Dice [] dices;


    /**
     * @param arrayOfSides is passed, by taking number each side of dice, we also obtain the number of dice.
     *                     This takes each die and places them as a collection.
     */
    public DiceCollection(int [] arrayOfSides ) {
        this.dices = new Dice [arrayOfSides.length]; //using type Dice and declaring size based on length of passed array
        minSum = 0; // initialize minSum

        // creating each new die based on length of array
        for (int i = 0; i < arrayOfSides.length; i++) {
            dices[i] = new Dice(arrayOfSides[i]); //instance creation

            sum += dices[i].getRolledSide(); // grabs total of all rolled sides
            maxSum += dices[i].getNumOfSides(); // grabs max value of each die and adds them
            minSum ++; // based on length of array will give minimum value
        }
    }

    /**
     * Allows each die in a Die Collection to roll once
     */
    public void roll() {
        sum = 0; //reset sum value
        for (Dice die : dices) { // for each die, roll, and set rolled side
            die.setRolledSide((int) (Math.random() * die.getNumOfSides()) + 1); // sets random value from 1 to number of die sides
        }
        //obtain new sum of new randomized dice
        for(int x = 0; x < dices.length; x++ ) {
            sum += dices[x].getRolledSide(); // adds all the rolled sides for total sum
        }

        System.out.println("\n" + this.toString()); //prints dice collection data
    }


    /**
     * @param numRolls to indicate how many rolls... in DiceMainView, will feed 100_000 as argument.
     *                Creates histogram model of rolled dices by creating histogram as 2 dimensional array
     *                with a key and then a value [(key, value)].
     */
    public void histogram(int numRolls) {


        int[][] histogramArray = new int[maxSum - minSum + 1][2]; //create correct number of range for array plus keep each row to two columns
        int counter = 0; // used to help iterate through each row first position [(0,0)] - [(1,0)] etc.
        for(int i = minSum; i < maxSum + 1; i++) {
            histogramArray[counter][0] = i; // keys will range from min sum to max and will be passed values accordingly
            counter ++; // increment by 1
        }
        //simulating dice roll up to numRolls
        for(int i = 0; i < numRolls  ; i++) {
            sum = 0;
            //randomize each dice rolled side in tandem with number of sides
            for (Dice die : dices) {
                die.setRolledSide((int) (Math.random() * die.getNumOfSides()) + 1); // sets random value from 1 to number of die sides
            }
            //obtain new sum of new randomized dice
            for(int x = 0; x < dices.length; x++ ) {
                sum += dices[x].getRolledSide(); //adds all rolled sides
            }

            //sum total tracker... increments the key's value by 1 is sum matches anywhere between minSum-maxSum
            for (int y = minSum; y <= maxSum ; y++) {
                if (sum == y) {
                    histogramArray[sum-minSum][1] += 1; // key value incrementation
                }
            }
        }

        System.out.println("---Histogram---");
        //prints out histogram key and then value
        for(int h = 0; h < histogramArray.length; h++) {
            System.out.println(histogramArray[h][0] + ": " + histogramArray[h][1]);
        }
    }


    /**
     * @return Dice Collection data
     */
    @Override
    public String toString() {
        return "Dice Collection: " + Arrays.toString(this.dices) +
                "\nMin= " + this.minSum + " Max= " + this.getMaxSum() +
                " Current= " + this.sum + "\n";
    }


    /**
     * @return the Max sum
     */
    public int getMaxSum() {
        return maxSum;
    }

}
