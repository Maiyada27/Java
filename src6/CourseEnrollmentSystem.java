import java.util.HashMap;
import java.util.HashSet;

public class CourseEnrollmentSystem {
        static HashSet<Integer>studentID = new HashSet<>();
        static HashMap<Integer,String>courses = new HashMap<>();
        static Integer newId;
        static String newCourse;
        static int numbersToAdd;
        static int duplicates;
    public static void main(String[] args){

        /*prompt user to enter number of students to add to the set*/
        numbersToAdd = Integer.parseInt(IO.readln("Enter number of students to add: "));
        /*use if statement to check if number added is more than 0 then start a loop repeating depending on how many students the user wants to add*/
        if (numbersToAdd <= 0) {
            IO.println("Invalid number of students");
        } else {
            for (int i = 1; i <= numbersToAdd; i++) {
                newId = Integer.parseInt(IO.readln("Enter Student Id: "));
                if (studentID.contains(newId)) {                                /*check if there are duplicates*/
                    IO.println("Duplicate student Id. Record not added.");
                    duplicates += 1;
                } else {
                    studentID.add(newId); /*add student Id to the set */
                    newCourse = IO.readln("Enter course name: "); /*prompt user to enter course name*/
                    courses.put(newId,newCourse);  /*add student id and course name to the map as key and value*/
                }
            }
        }
        /*call methods*/
        update();
        display();
        classify();

    }
    /*create method to update students course in the hashmap using replace function*/
    static void update() {
        Integer replaceID = Integer.parseInt(IO.readln(("Enter Student Id to update course: ")));
        if (courses.containsKey(replaceID)) {
            String replaceCourse = IO.readln(("Enter new course: "));
            courses.replace(replaceID, replaceCourse);
            IO.println("Course updated successfully.");
        } else {
            IO.println("Student ID not found.");
        }
    }
    /*create method to classify the enrollment*/
    static void classify(){
        if(courses.size()<5) {
            IO.println("Small Enrollment.");
        } else if (courses.size()>= 5 && courses.size()<=15) {
            IO.println("Medium Enrollment.");
        } else if (courses.size()>15) {
            IO.println("Large Enrollment.");
        }
    }

    static void display(){
        IO.println("Total students records entered: " + (numbersToAdd));
        IO.println("Total unique students: " + studentID.size());
        for (Integer key : courses.keySet()) {
            IO.println("Student ID: " + key + ", Course: " + courses.get(key) + ".");
        }
    }
}
