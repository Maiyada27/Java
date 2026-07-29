import java.util.ArrayList;

public class ScoreAnalysisandManagementSystem {

    static int[] score = {52, 83, 67, 97, 88, 74, 68, 97, 57, 64, 87, 93, 67, 96, 82}; /*create array and add score values to it*/
    static ArrayList<Integer> scores = new ArrayList<>(); /*create an empty arraylist*/

    public static void main(String[] args) {
        /*add the values from the array to the array list*/
        for (int number : score) {
            scores.add(number);
        }
        /*call methods*/
        displayScore();
        scoreStatistics();
        numberClassification();
        search();
        updateValue();
        reverse();
        sort();

    }

    /*create method to display the size of list and all the values with their indexes*/
    static void displayScore() {
        IO.println("Total number of scores: " + scores.size());
        for (int i = 0; i <= scores.size() - 1; i++) {
            IO.println("Score " + i + ": " + scores.get(i));

        }
    }

    /*create method to calculate the average and show the max and min scores*/
    static void scoreStatistics() {
        int total = 0;
        int largest = scores.get(0);
        int smallest = scores.get(0);
        for (int i = 0; i <= scores.size() - 1; i++) {
            total += scores.get(i);

            if (scores.get(i) < smallest) {
                smallest = scores.get(i);
            } else if (scores.get(i) > largest) {
                largest = scores.get(i);
            }
        }
        double average = (double) total / scores.size();
        IO.println("Average score: " + average);
        IO.println("Highest score : " + largest + " ,Lowest score : " + smallest);
    }

    /*create method to classify the numbers in the list*/
    static void numberClassification() {
        int evenNumbers = 0;
        int oddNumbers = 0;
        int negativeNumbers = 0;
        int positiveNumbers = 0;

        for (int i = 0; i <= scores.size() - 1; i++) {
            if (scores.get(i) % 2 == 0) {
                evenNumbers += 1;
            } else if (scores.get(i) % 2 != 0) {
                oddNumbers += 1;          /*Start a loop to go through every number in list, check if it is even or odd number and update counter accordingly*/
            }
            if (scores.get(i) < 0) {
                negativeNumbers += 1;
            } else if (scores.get(i) > 0) {
                positiveNumbers += 1;      /*check if number is positive or negative*/
            }
        }
        IO.println("Count of even numbers = " + evenNumbers);
        IO.println("Count of odd numbers = " + oddNumbers);
        IO.println("Count of positive numbers = " + positiveNumbers);
        IO.println("Count of negative numbers = " + negativeNumbers);

    }

    static void search() {
        int searchNum = Integer.parseInt(IO.readln("Enter number you want search for: "));
        int count = 0;
        int searchIndex = 0;
        if (scores.contains(searchNum)) {
            for (int i = 0; i <= scores.size() - 1; i++) {
                if (scores.get(i) == searchNum) {
                    searchIndex = i;
                    break;
                }
            }
            for (int i = 0; i <= scores.size() - 1; i++) {
                if (scores.get(i) == searchNum) {
                    count += 1;
                }
            }
            IO.println("Number first appears at index: " + searchIndex + ", and appears " + count + " times.");
        } else {
            IO.println("Number not found");
        }

    }

    static void updateValue() {
        /*prompt user to enter index number for updating the value and the new value.*/
        int ind = Integer.parseInt(IO.readln("Enter index number: "));
        int newScore = Integer.parseInt(IO.readln("Enter new value: "));
        scores.set(ind, newScore);/*update the value in the list*/
        IO.println("Updated List: ");
        for (int sc : scores) {
            IO.println(sc);
        }
    }

    /*create method to display reverse of the list*/
    static void reverse(){
        for (int i = scores.size()-1; i >= 0; i--) {
            IO.println(scores.get(i));
        }

    }

    static void sort(){
        ArrayList<Integer>copy = new ArrayList<>(scores);
        copy.sort(null);
        IO.println("Sorted list from smallest to largest: ");
        for(int c : copy) {
            IO.println(c);
        }
        IO.println("Smallest value: " + copy.get(0));
        IO.println("Largest value: " + copy.get(copy.size()-1));

    }
}
