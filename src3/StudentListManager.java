import java.util.ArrayList;

public class StudentListManager {


        public static void main(String[] args) {
            ArrayList<String> students = new ArrayList<>();
            students.add("Lama");
            students.add("Ali");
            students.add("Mohammed");
            students.add("Bader");
            students.add("Fatima");
            students.add("Juhaina");
            students.add("Buthains");
            students.add("Humood");
            students.add("Safa");
            students.add("Leena");

            for (String student : students) {
                IO.println(student);
            }                        /*prints all names in list using loop*/

            IO.println("Total number of students= " + students.size());
            IO.println("First student: " + students.get(0));
            IO.println("Last student: " + students.getLast());  /*print total number, first and last names in the list*/

            if (students.contains("Samira")) {
                IO.println("List contains Samira");
            } else {
                IO.println("Samira is not in the list");  /*check if a name is in the list using if statement*/
            }

            students.remove("Ahmed");  /*removed a name from the list*/

            IO.println("Updated list: " + students);  /*Displayed the updated list*/


        }

}
