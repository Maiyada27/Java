import java.util.ArrayList;

public class LibraryBookManagementSystem {
    static ArrayList<String> bookTitles = new ArrayList<>();
    static ArrayList<String> authors = new ArrayList<>();
    static ArrayList<Boolean> availability = new ArrayList<>();
        public static void main(String[] args) {

            // Add 10 books
            bookTitles.add("Java Programming"); authors.add("James"); availability.add(true);
            bookTitles.add("Database Systems"); authors.add("John"); availability.add(true);
            bookTitles.add("Algorithms"); authors.add("Cormen"); availability.add(false);
            bookTitles.add("Operating Systems"); authors.add("Silberschatz"); availability.add(true);
            bookTitles.add("Computer Networks"); authors.add("Tanenbaum"); availability.add(true);
            bookTitles.add("Artificial Intelligence"); authors.add("Russell"); availability.add(false);
            bookTitles.add("Data Science"); authors.add("Smith"); availability.add(true);
            bookTitles.add("Web Development"); authors.add("Brown"); availability.add(true);
            bookTitles.add("Cyber Security"); authors.add("Taylor"); availability.add(false);
            bookTitles.add("Cloud Computing"); authors.add("Williams"); availability.add(true);

            // Display all books
            IO.println("Library Books:");
            for (int i = 0; i < bookTitles.size(); i++) {
                IO.println("Book " + i + ":");
                IO.println("Title: " + bookTitles.get(i) +
                        " Author: " + authors.get(i) +
                        " Available: " + (availability.get(i) ? "Yes" : "No"));
            }

            // Add new book
            String newTitle = IO.readln("Enter Book Title: ");
            String newAuthor = IO.readln("Enter Author: ");
            boolean newAvailability = Boolean.parseBoolean(IO.readln("Available (true/false): "));
            bookTitles.add(newTitle);
            authors.add(newAuthor);
            availability.add(newAvailability);
            IO.println("Book added successfully.");

            // Update book information
            int updateIndex = Integer.parseInt(IO.readln("Enter Book Index to update: "));
            String updatedTitle = IO.readln("New Title: ");
            String updatedAuthor = IO.readln("New Author: ");
            boolean updatedAvailability = Boolean.parseBoolean(IO.readln("Available (true/false): "));
            bookTitles.set(updateIndex, updatedTitle);
            authors.set(updateIndex, updatedAuthor);
            availability.set(updateIndex, updatedAvailability);
            IO.println("Book updated successfully.");

            // Search book system
            String searchTitle = IO.readln("Enter Book Title to search: ");
            if (bookTitles.contains(searchTitle)) {
                int index = bookTitles.indexOf(searchTitle);
                IO.println("Book found at index " + index);
                IO.println("Author: " + authors.get(index));
                IO.println("Available: " + (availability.get(index) ? "Yes" : "No"));
            } else {
                IO.println("Book not found.");
            }
        }
    }


