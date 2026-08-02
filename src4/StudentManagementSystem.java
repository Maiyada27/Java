import java.util.ArrayList;
import java.util.Arrays;

public class StudentManagementSystem {

    static ArrayList<String>students = new ArrayList<>();
    static String[]names = {"Ali", "Sara", "Hafsa", "Sumaya", "Omar", "Lama", "Loay", "Layla", "Layal", "Bader"};

    public static void main(String[] args) {
        /*Add names in the array list*/
        for (String n : names) {
            students.add(n);
        }
        /*call methods*/
        displayAll();
        addStudent();
        search();
        update();
        removeStudent();
        analysis();
        sort();

    }
    /*create method to display all names in the list with their indexes*/
    static void displayAll() {
        IO.println("Total number of students: " + students.size());
        for (int i = 0; i <= students.size() - 1; i++) {
            IO.println("Student " + i + " : " + students.get(i));
        }
    }

    static void addStudent(){
        String newName = IO.readln("Enter student name to add: ");
        students.add(students.size(), newName);  /*Adds the name to the end of the list*/
        for(String st: students) {
            IO.println(st);
        }
    }



    static void update(){
        int ind = Integer.parseInt(IO.readln("Enter index number: "));
        String newName = (IO.readln("Enter new name: "));
        students.set(ind, newName);/*update the value in the list*/
        IO.println("Updated List: ");
        for (String st : students) {
            IO.println(st);
        }
    }

    static void search(){
        String searchName = (IO.readln("Enter the student name you want search for: "));
        if (students.contains(searchName)) {
            IO.println("Student found at index number " + students.indexOf(searchName));
        }else{
            IO.println("Student not found");
        }}

    static void removeStudent(){
        String removeName = IO.readln("Enter name to remove: ");
        int index = students.indexOf(removeName);
        students.remove(removeName);
        IO.println("List after removal: " + students);
        }

    static void analysis(){
        IO.println("Total number of students: " + students.size());
        IO.println("Is the list empty?" + students.isEmpty());
        IO.println("First name in the list: " + students.get(0));
        IO.println("Last name in the list: " + students.get(students.size()-1));

    }

    static void sort(){
        ArrayList<String> copy = new ArrayList<>(students);
        copy.sort(null);
        IO.println("Sorted List: "+ copy);
    }
    }



