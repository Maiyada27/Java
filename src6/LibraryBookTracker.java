import java.util.HashMap;
import java.util.HashSet;

public class LibraryBookTracker {
    static HashSet<Integer> bookId = new HashSet<>();
    static HashMap<Integer,String>books = new HashMap<>();
    static Integer newId;
    static String newTitle;
    static int numbersToAdd;
    static int duplicates;


    public static void main(String[] args){
        /*prompt user to enter number of books to add to the set*/
        numbersToAdd = Integer.parseInt(IO.readln("Enter number of books to add: "));
        /*use if statement to check if number added is more than 0 then start a loop repeating depending on how many books the user wants to add*/
        if (numbersToAdd <= 0) {
            IO.println("Invalid number of books");
        } else {
            for (int i = 1; i <= numbersToAdd; i++) {
                newId = Integer.parseInt(IO.readln("Enter Book Id: "));
                if (bookId.contains(newId)) {                                /*check if there are duplicates*/
                    IO.println("Duplicate book Id. Record not added.");
                    duplicates += 1;
                } else {
                    bookId.add(newId); /*add book Id to the set */
                    newTitle = IO.readln("Enter book title: "); /*prompt user to enter book title*/
                    books.put(newId,newTitle);  /*add book id and title to the map as key and value*/
                }
            }
        }
        /*call methods*/
        search();
        display();
        classify();
    }
    /*create method to search for a book in the map */
    static void search(){
        IO.println("Book search:");
        Integer searchID = Integer.parseInt(IO.readln("Enter Book ID: "));
        if(books.containsKey(searchID)) {
            IO.println("Book ID: " + searchID);
            IO.println("Book title: " + books.get(searchID));
        }else {
            IO.println("Book not found.");
        }
    }
    /*create method to classify library*/
    static void classify(){
        if(books.size()<5) {
            IO.println("Small Library.");
        } else if (books.size()>= 5 && books.size()<=10) {
            IO.println("Medium Library.");
        } else if (books.size()>10) {
            IO.println("Large Library.");
        }
    }

    static void display(){
        IO.println("Total book records entered: " + (numbersToAdd));
        IO.println("Total unique books: " + books.size());
        for (Integer key : books.keySet()) {
            IO.println("Book ID: " + key + ", title: " + books.get(key) + ".");
        }
    }
}
