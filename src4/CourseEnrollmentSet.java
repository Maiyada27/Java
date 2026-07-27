import java.io.IOError;
import java.util.HashMap;
import java.util.HashSet;

public class CourseEnrollmentSet {
   static HashSet<String>courses= new HashSet<>();
   static String courseName;
   static int duplicates=0;
   static Integer numbersToAdd=0;



    public static void main(String[] args) {
        /*prompt user to enter number of courses to add to the set*/
        numbersToAdd = Integer.parseInt(IO.readln("Enter number of courses to add: "));

        /*use if statement to check if number added is more than 0 then start a loop repeating depending on how many course the user wants to add*/
        if (numbersToAdd <= 0) {
            IO.println("Invalid number of courses");
        } else {
            for (int i = 1; i <= numbersToAdd; i++) {
                courseName = (IO.readln("Enter course name: "));
                if (courses.contains(courseName)) {                                /*check if there are duplicates*/
                    IO.println("Course already exists. Duplicate entries are not allowed.");
                    duplicates += 1;
                } else {
                    courses.add(courseName);  /*add course to the hashset */
                }
            }
        }
        /*call methods*/
        remove();
        classify();
        display();

    }
    /*create method to remove a course from the set*/
    static void remove(){
        String removeCourse = IO.readln("Enter name of course to remove: ");
        if(courses.contains(removeCourse)) {
            courses.remove(removeCourse);
            IO.println("Course removed successfully");
        }else {
            IO.println("Course not found.");
        }
    }
    /*create method to classify the course catalog*/
    static void classify(){
        if(courses.size()<4) {
            IO.println("Small course catalog.");
        } else if (courses.size()>= 4 && courses.size()<=18) {
            IO.println("Medium course catalog.");
        } else if (courses.size()>8) {
            IO.println("Large course catalog.");
        }
    }
    /*create method to display all details about the set*/
    static void display(){
        IO.println("Total courses entered: " + numbersToAdd);
        IO.println("Total unique courses remaining: " + courses.size());
        for (String c : courses) {
            IO.println(c);
        }
    }
}