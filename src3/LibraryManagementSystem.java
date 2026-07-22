import java.lang.classfile.instruction.SwitchCase;
import java.util.ArrayList;

public class LibraryManagementSystem {

   static ArrayList<String>bookNames= new ArrayList<>();
   static ArrayList<String>authorNames= new ArrayList<>();
   static ArrayList<Boolean>availabilityStatus= new ArrayList<>();
   static int totalAvailable = 0;
   static int totalUnavailable = 0;


    public static void main(String[] args) {
        bookNames.add("The years");
        authorNames.add("Annie Ernoux");
        availabilityStatus.add(true);
        bookNames.add("Look At The Lights");
        authorNames.add("Annie Ernoux");
        availabilityStatus.add(false);
        bookNames.add("The white Nights");
        authorNames.add("Dosteovesky");
        availabilityStatus.add(false);
        bookNames.add("Winter Tale");
        authorNames.add("Paul Auster");
        availabilityStatus.add(true);
        bookNames.add("Orientalism");
        authorNames.add("Edward Said");
        availabilityStatus.add(true);

        Integer choice; /*start a loop so that it keeps looping while user did not choose to exit*/
        do {
            IO.println("1: Display all books");
            IO.println("2: Search for a book");
            IO.println("3: Borrow a book");
            IO.println("4: Return a book");
            IO.println("5: Display library report");
            IO.println("6: Exit");
            choice= Integer.valueOf(IO.readln("Enter your choice: "));
            switch (choice) {  /*call method for each case*/
                case 1:
                    displayBooks();
                    break;
                case 2:
                    String searchBook=IO.readln("Enter the name of the book to search for: ");
                    searchBook(searchBook);
                    break;
                case 3:
                    String borrowBook=IO.readln("Enter the name of the book to borrow: ");
                    borrowBook(borrowBook);
                    break;
                case 4:
                    String returnBook=IO.readln("Enter the name of the book to return: ");
                    returnBook(returnBook);
                    break;
                case 5:
                    displayReport();
                    break;
                case 6:
                    IO.println("GoodBye.");
                    break;

            }
        }while (choice != 6);
    }


        static void displayBooks() {
            for (int i = 0; i <= bookNames.size() - 1; i++) {
                IO.println("Book: " + bookNames.get(i) + ", Author: " + authorNames.get(i) + ", Available: " + (availabilityStatus.get(i)? "yes":"no"));
            }   /*uses loop to display all books names author and availability status*/
        }

        static void searchBook(String book){
           if (bookNames.contains(book)){
               IO.println("Book found");
           }else {
               IO.println("Book not found");
           }
        }  /*use an if statement to check is list contains book name*/

       static void borrowBook(String book) {
           int index = bookNames.indexOf(book);
           if (availabilityStatus.get(index) == true) {
               availabilityStatus.set(index, false);
               IO.println("Book Borrowed Successfully");
           }else{
               IO.println("Book is Unavailable");}
       } /*use if statement to borrow a book and change its status*/

       static void returnBook(String book){
           int index = bookNames.indexOf(book);
           availabilityStatus.set(index, true);
           IO.println("Book Return Successful");
       }/*update status of book in a list */

       static void countBooks() {
           for (int i = 0; i <= availabilityStatus.size() - 1; i++) {
               if (availabilityStatus.get(i) == true) {
                   totalAvailable += 1;
               } else {
                   totalUnavailable += 1;
               }
           }
           IO.println("Number of available books: " + totalAvailable);
           IO.println("Number of unavailable books: " + totalUnavailable);
       }  /*count number of available books and unavailable books by looping through the list and checking its status*/

    static void displayReport() {
        IO.println("Total number of books: " + bookNames.size());
        IO.println("Available book count: " + totalAvailable);
        IO.println("Unavailable book count: " + totalUnavailable);
    }






}
