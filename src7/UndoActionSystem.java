import java.util.ArrayList;
import java.util.Stack;

public class UndoActionSystem {
    static Stack<String> userActions = new Stack<>();
    public static void main(String[] args) {

        /*prompt user to enter number of actions to add then start a loop to prompt user to enter actions*/
        int actionsToAdd = Integer.parseInt(IO.readln("Enter number of actions: "));
        if (actionsToAdd <= 0) {
            IO.println("Invalid number of actions.");
        } else {
            for (int i = 1; i <= actionsToAdd; i++) {
                String newAction = IO.readln("Enter action: ");
                userActions.push(newAction);  /*add action to stack*/
            }
        }

        int choice;   /*create a menu*/
        do {
            IO.println("----- Menu -----");
            IO.println("1. Add Action");
            IO.println("2. Undo Last Action");
            IO.println("3. View Last Action");
            IO.println("4. Search Action");
            IO.println("5. Display All Actions");
            IO.println("6. Display Action Statistics");
            IO.println("7. Clear All Actions");
            IO.println("8. Exit");
            choice = Integer.parseInt(IO.readln("Enter your choice: "));

            switch (choice) {
                case 1:
                    addAction();
                    break;
                case 2:
                    undoAction();
                    break;
                case 3:
                    lastAction();
                    break;
                case 4:
                    search();
                    break;
                case 5:
                    display();
                    break;
                case 6:
                    statistics();
                    break;
                case 7:
                    removeAll();
                    break;
                case 8:
                    IO.println("Thank you. Goodbye.");
                    break;
                default:
                    IO.println("Invalid choice. Please enter a valid number.");
                    break;

            }
        } while (choice != 8);
    }

        static void addAction() {
            String newAction = IO.readln("Enter new action: ");
            userActions.push(newAction);
            IO.println("Action added successfully");
        }

       static void undoAction() {
        if (userActions.isEmpty()) {
            IO.println("No actions to undo");
        } else {
            IO.println("Action removed: " + userActions.pop());
        }
    }

    static void lastAction() {
        if (userActions.isEmpty()) {
            IO.println("No actions available");
        } else {
        IO.println("Last action: " + userActions.peek());
    }}

    static void search() {
        String searchAction = IO.readln("Enter action: ");
        int position = userActions.search(searchAction);   /*search function return position from the top of the stack*/
        if (position != -1) {
            IO.println("Action found. Position of the action from the top of the stack: " + position);
        } else {  /*search function returns -1 when object is not found*/
            IO.println("Action not found.");
        }
    }

    static void display() {
        for (int i = 0; i <= userActions.size() - 1; i++) {
            IO.println("Action: " + userActions.get(i));
        }
    }

    static void statistics(){
        IO.println("Total number of actions: " + userActions.size());
        IO.println("Most recent action: " + userActions.pop());
        boolean isEmpty = userActions.isEmpty()? true : false ;
        IO.println("Is stack empty? " + isEmpty);
    }

    static void removeAll(){
        userActions.clear();     /*remove all data from the stack*/
        IO.println("All actions have been cleared.");
    }

}
