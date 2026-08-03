import java.io.IOError;
import java.util.Stack;

public class NumberStackAnalyzer {
    static Stack<Integer> values = new Stack<>();

    public static void main(String[] args) {

        /*prompt user to enter number of values to add then start a loop to prompt user to enter values*/
        int valuesToAdd = Integer.parseInt(IO.readln("Enter number of values: "));
        if (valuesToAdd <= 0) {
            IO.println("Invalid number of values.");
        } else {
            for (int i = 1; i <= valuesToAdd; i++) {
                Integer newValue = Integer.parseInt(IO.readln("Enter Value: "));
                values.push(newValue);  /*add value to stack*/
            }
        }

        int choice;   /*create a menu*/
        do {
            IO.println("----- Menu -----");
            IO.println("1. Add Number");
            IO.println("2. Remove Top Number ");
            IO.println("3. View Top Number");
            IO.println("4. Display All Numbers");
            IO.println("5. Analyze Numbers");
            IO.println("6. Exit");
            choice = Integer.parseInt(IO.readln("Enter your choice: "));

            switch (choice) {
                case 1:
                    addNumber();
                    break;
                case 2:
                    removeTop();
                    break;
                case 3:
                    viewTop();
                    break;
                case 4:
                    display();
                    break;
                case 5:
                    statistics();
                    break;
                case 6:
                    IO.println("Thank you. Goodbye.");
                    break;
                default:
                    IO.println("Invalid choice. Please enter a valid number.");
                    break;

            }
        } while (choice != 6);

    }
    static void addNumber() {
        Integer newNumber = Integer.parseInt(IO.readln("Enter new number: "));
        values.push(newNumber);
        IO.println("Number added successfully");
    }

    static void removeTop() {
        if (values.isEmpty()) {
            IO.println("Stack is empty");
        } else {
            IO.println("Number removed: " + values.pop());
        }
    }

    static void viewTop() {
        if (values.isEmpty()) {
            IO.println("Stack is empty");
        } else {
            IO.println("Top number: " + values.peek());
        }}

    static void display() {
        for (int i = 0; i <= values.size() - 1; i++) {
            IO.println("Number: " + values.get(i));
        }
    }

    static void statistics() {
        int sum = 0;
        int positiveCount = 0;
        int negativeCount = 0;
        int zeroCount = 0;
        int evenCount = 0;
        int oddCount = 0;
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        for (int n : values) {
            sum += n;

            if (n > 0) {
                positiveCount += 1;
            } else if (n < 0) {
                negativeCount += 1;
            } else {
                zeroCount += 1;
            }
            if (n % 2 == 0) {
                evenCount += 1;
            } else {
                oddCount += 1;
            }

            if (n > largest) {
                largest = n;
            }
            if (n < smallest) {
                smallest = n;
            }
        }
        int average = (sum / values.size());
        IO.println("Total number of elements: " + values.size());
        IO.println("Sum of all values: " + sum);
        IO.println("Average: " + average);
        IO.println("Largest number: " + largest);
        IO.println("Smallest number: " + smallest);
        IO.println("Total even numbers: " + evenCount);
        IO.println("Total odd numbers: " + oddCount);
        IO.println("Total positive numbers: " + positiveCount);
        IO.println("Total negative numbers: " + negativeCount);
        IO.println("Total zeros: " + zeroCount);
    }



}
