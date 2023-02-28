package Assignment04_000315902;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Main Method Class(View) that asks user for number of dice and number of sides for each
 * die then, creates dice collection and prints to screen. Menu is presented to user containing
 * roll options.
 * @author Armand Amores 000315902
 */
public class DiceMainView {
    /**
     * @param args Main Method that takes user input and displays user
     *             interface.
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in); // create scanner variable for input.
        int numOfDice = 0; // initialize number of dice, user will be asked how much.
        int count = 0; // used to help iterate through dices.

        //Asks user for number of dice while error checking.
        while (numOfDice <= 0) { // User to provide correct input to break.
            System.out.println("How many Dice?: ");
            if (keyboard.hasNextInt()) { //used to make sure user inputs integer.
                numOfDice = keyboard.nextInt();
                if (numOfDice <= 0) { // makes sure user does not input negative number.
                    System.out.println("Invalid input. Please enter positive integer.");
                }
            } else {
                System.out.println("Invalid input. Please enter positive integer.");
                keyboard.next(); // take the invalid input to prevent an infinite loop.
            }
        }
        int [] numOfSides = new int[numOfDice]; //Based on number of dice, an array is created to store n amount of dices.

        // Based of n dices,  sides of each dice to be decided using for loop.
        for (int i = 1; i <= numOfDice; i++) { //started at 1 to number each dice so that user will not see Dice 0.
            int sides = 0; // initialize dice sides.
            while(sides <=0) { // a die can not have less than or 0 sides.
                System.out.println("How many sides would you like for Dice " + i + "?");
                if (keyboard.hasNextInt()) { // makes sure user inputs an integer.
                    sides = keyboard.nextInt(); // stores user input for the number of sides.
                    if (sides <= 0) {
                        System.out.println("Invalid input. Please enter a positive integer.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a positive integer.");
                    keyboard.next(); // take the invalid input to prevent an infinite loop.
                }
            }
            numOfSides[count] = sides; // due to array starting at zero, count variable used to help iterate and makes the first index(0)=to side and so forth.
            count++; //increment to get each dice side

        }
        System.out.println("Your Dice Collection and their sides: " + Arrays.toString(numOfSides));

        DiceCollection arrayOfDice = new DiceCollection(numOfSides); //create dice collection object and pass each die with # of sides
        int rolls = 0; //initialize number of rolls
        boolean flag = false; // used to control dice menu
        while (!flag) { // only way to make true is if user quits

            System.out.println("\n1=roll once, 2=roll 100,000, 3= quit: "); // dice menu
            if(keyboard.hasNextInt()){ //ensures integer input
                rolls = keyboard.nextInt();
                switch (rolls) { //switch menu created for 3 options
                    case 1 -> arrayOfDice.roll(); //single roll using method from DiceCollection(model)
                    case 2 ->
                            arrayOfDice.histogram(100_000); //rolls dice that many times and provides histogram created from DiceCollection Class
                    case 3 -> {
                        System.out.println("Bye!");
                        flag = true; // used to end program
                    }
                    default -> System.out.println("Invalid input");
                }
            }else {
                System.out.println("Invalid input");
                keyboard.next(); // takes invalid input to prevent infinite loop
            }
        }


    }
}
