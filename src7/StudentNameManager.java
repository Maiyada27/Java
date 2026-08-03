import java.util.ArrayList;

public interface StudentNameManager {

    static ArrayList<String> students = new ArrayList<>();

    public static void main(String[] args) {

        /*prompt user to enter number of students to add to the array*/
        Integer number = Integer.parseInt(IO.readln("Enter number of students: "));

        if (number <= 0) {
            IO.println("Invalid number of students.");
        } else {
            for (int i = 1; i <= number; i++) {    /*start a loop with number of students to add. prompt user to add a name and add it to the string array.*/
                String name = IO.readln("Enter student name: ");
                students.add(name);

            }
        }
        /*create a menu and call each method depending on choice*/
        int choice;
        do {
            IO.println("----- Menu -----");
            IO.println("1. Add Student Name");
            IO.println("2. Search Student Name");
            IO.println("3. Update Student Name");
            IO.println("4. Display All Student Names");
            IO.println("5. Analyze Names");
            IO.println("6. Compare Two Names");
            IO.println("7. Exit");
            choice = Integer.parseInt(IO.readln("Enter choice: "));

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    search();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    display();
                    break;
                case 5:
                    analyze();
                    break;
                case 6:
                    compare();
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

    static void addStudent() {
        String newName = IO.readln("Enter student name: ");
        for (String s : students) {
            if (s.equalsIgnoreCase(newName)) {
                IO.println("Student name already exists");
            } else {
                students.add(newName);
                IO.println("Student added successfully.");
            }
        }
    }

    static void search() {
        String searchName = IO.readln("Enter student name: ");
        for (String s : students) {
            if (s.equalsIgnoreCase(searchName)) {
                IO.println("Student found.");
                break;
            } else {
                IO.println("Student not found.");
            }
        }
    }

    static void update() {
        String name = IO.readln("Enter student name: ");
        String updatedName = IO.readln("Enter updated student name: ");
        if (students.contains(name)) {
            int index = students.indexOf(name);
            students.set(index, updatedName);
            IO.println("Student name updated successfully.");
        } else {
            IO.println("Student not found.");

        }
    }

    static void display() {
        for (int i = 0; i <= students.size() - 1; i++) {
            IO.println((i + 1) + ". " + students.get(i));

        }
    }

    static void analyze() {
        IO.println("Total number of students: " + students.size());
        String longestName = "";
        Integer longest = Integer.MIN_VALUE;
        String shortestName = "";
        Integer shortest = Integer.MAX_VALUE;
        int total = 0;
        for (String s : students) {
            if (s.length() > longest) {   /*get the longest and shortest names in the list*/
                longest = s.length();
                longestName = s;
            }
            if (s.length() < shortest) {
                shortest = s.length();
                shortestName = s;
            }
            total += s.length();  /*calculate the total characters*/

        }
        int average = total / students.size();
        IO.println("Longest student name: " + longestName);
        IO.println("Shortest student name: " + shortestName);
        IO.println("Total characters in all names: " + total);
        IO.println("Average name length: " + average);
        int counta = 0;
        int countA = 0;
        for (String s : students) {
            if (s.startsWith("A")) {
                countA += 1;
            }
            if (s.endsWith("a")) {
                counta += 1;
            }
        }
        IO.println("Number of names starting with \"A\": " + countA);
        IO.println("Number of names ending with \"a\": " + counta);
    }

    static void compare(){
        String name1 = IO.readln("Enter student name: ");
        String name2 = IO.readln("Enter student name: ");
        int compare= name1.compareTo(name2);
        boolean equals = name1.equals(name2)? true : false;
        boolean equalsIgnoreCase = name1.equalsIgnoreCase(name2)? true : false;

        IO.println("Name 1 equals name 2? " + equals);
        IO.println("Name 1 equals name 2 (ignoring case)? " + equalsIgnoreCase);
        if (compare == 0 ){
            IO.println("The two names are equal.");
        }else{
            IO.println("The names are not equal.");
    }}
}


