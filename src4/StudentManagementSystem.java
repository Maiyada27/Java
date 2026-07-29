import java.util.ArrayList;

public class StudentManagementSystem {

    public static void main(String[]args){
        ArrayList<String>students= new ArrayList<>();

        students.add("Ali");
        students.add("Lama");
        students.add("Bader");
        students.add("May");
        students.add("Salma");
        students.add("Salim");
        students.add("Mohamed");
        students.add("Buthaina");
        students.add("Maryam");
        students.add("Sama");

        /*use a loop to display all names in the list with their index*/
       IO.println("Total number of students= " + students.size());
       for(int i=0; i<= students.size()-1; i++){
           IO.println("Student " + i + " : " + students.get(i));
       }

       String newName = IO.readln("Enter Student name: ");   /*prompt user to enter new name*/
        students.add(students.size(), newName);/*add the name to the end of the list which index will be size of the current list. Or choose any index to choose where to add the name*/
        IO.println("Student added successfully. \n Updated List: " + students);  /*display updated list*/


    }
}
