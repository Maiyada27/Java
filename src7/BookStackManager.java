import java.io.IOException;
import java.util.Stack;

public class BookStackManager {
    static Stack<String> bookStack = new Stack<>();

    public static void main(String[] args) {

        /*prompt user to enter number of books to add then start a loop to prompt user to enter book title*/
        int numbersToAdd = Integer.parseInt(IO.readln("Enter number of books to add: "));
        if (numbersToAdd <= 0) {
            IO.println("Invalid number of books.");
        } else {
            for (int i = 1; i <= numbersToAdd; i++) {
                String newBook = IO.readln("Enter book title: ");
                bookStack.push(newBook);  /*add book to stack*/
            }
        }

        int choice;   /*create a menu*/
        do {
            IO.println("----- Menu -----");
            IO.println("1. Add Book");
            IO.println("2. Remove Top Book");
            IO.println("3. View Top Book ");
            IO.println("4. Search Book");
            IO.println("5. Display All Books");
            IO.println("6. Display Stack Statistics");
            IO.println("7. Exit");
            choice = Integer.parseInt(IO.readln("Enter your choice: "));

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    viewTop();
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
                    IO.println("Thank you. Goodbye.");
                    break;
                default:
                    IO.println("Invalid choice. Please enter a valid number.");
                    break;

            }
        } while (choice != 7);
    }

    static void addBook() {
        String newTitle = IO.readln("Enter book title: ");
        bookStack.push(newTitle);
        IO.println("Book added successfully");
    }

    static void removeBook() {
        if (bookStack.isEmpty()) {
            IO.println("No books available");
        } else {
            IO.println("Book removed: " + bookStack.pop());
        }
    }

    static void viewTop() {
        IO.println("Top book: " + bookStack.peek());
    }

    static void search() {
        String searchBook = IO.readln("Enter book title: ");
        int position = bookStack.search(searchBook);   /*search function return position from the top of the stack*/
        if (position != -1) {
            IO.println("Book found. Position of the book from the top of the stack: " + position);
        } else {  /*search function returns -1 when object is not found*/
            IO.println("Book not found.");
        }
    }

    static void display() {
        for (int i = 0; i <= bookStack.size() - 1; i++) {
            IO.println("Book title: " + bookStack.get(i));
        }
    }

    static void statistics(){
        IO.println("Total number of books: " + bookStack.size());
        IO.println("Top book: " + bookStack.pop());
        boolean isEmpty = bookStack.isEmpty()? true : false ;
        IO.println("Is stack empty? " + isEmpty);
    }

}





