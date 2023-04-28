# Dice Simulator
This is a dice game that is implemented using arrays. There are two classes, one to represent a die with an arbitrary number of sides, and another to represent a collection of dice. The purpose of the game is to roll the entire collection repeatedly and use an array to build a histogram of the results.

It demonstrates the use of several fundamental Java concepts, such as object-oriented programming, inheritance, encapsulation, and abstraction.
The project uses a model and view orientation to separate the application: the model (Dice and DiceCollection classes), and the view (DiceMainView class).
The model represents the data and logic, the view provides the user interface which handles user input and updates the model and view accordingly.
The project also utilizes arrays and loops to create and manipulate collections of objects.
The Math.random() method is used to generate random values for simulating dice rolls.
A histogram of the resulting data is constructed to visualize the frequency of different outcomes.
Overall, this project provides a practical example of how to implement essential Java programming concepts and design patterns in a real-world application.

**Die Class**

The Die class represents a die with an arbitrary number of sides. When a die is created, the number of sides is specified and cannot be changed. The Die object can report its number of sides, can report the side that is currently showing, and can be rolled. When a die is rolled, it generates and stores a new integer from 1 to n, where n is its number of sides. It has a toString() method that reports the number of sides and the number that is currently showing.

**DiceCollection Class**

The DiceCollection class holds a set of Die objects in an array. The number of sides on each Die is specified by passing an array of integers to the DiceCollection constructor. This array is used to create and store the corresponding Die objects. A DiceCollection object can report the current sum of all the sides showing on the dice, it can report the maximum and minimum possible sums, and it can roll all the dice at once. It has a toString() method that reports all the dice, the minimum possible roll, the maximum possible roll, and the current total showing on the dice. It also has a histogram method that accepts a parameter that specifies the number of rolls it should make. Then it rolls the entire collection of dice that number of times and returns an integer array of counters (i.e., a histogram) to keep track of how many times each possible sum got rolled.

**DiceMainView Class**

The DiceMainView class is the main class that contains the user interface. It asks the user for the number of dice and the number of sides for each die, creates a dice collection, and prints it to the screen. The user is then presented with a menu containing roll options. The user can choose to roll the dice once, roll the dice 100,000 times, or quit the game. After each roll, the results are displayed to the user, including the histogram of the results.

**How to use**

- Run the DiceMainView class.
- Input the number of dice that you want to play with.
- For each die, input the number of sides that you want it to have.
- Choose an option from the menu:
    - Enter 1 to roll the dice once.
    - Enter 2 to roll the dice 100,000 times.
    - Enter 3 to quit the game.
- After each roll, the results will be displayed, including the histogram of the results.
