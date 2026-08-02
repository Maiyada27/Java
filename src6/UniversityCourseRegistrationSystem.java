import java.util.HashMap;
import java.util.HashSet;

public class UniversityCourseRegistrationSystem {
    static HashSet<Integer> studentID = new HashSet<>();
    static HashMap<Integer, HashSet<String>> coursesLog = new HashMap<>();
    static Integer newId;
    static String newCourse;
    static int numbersToAdd;
    static int totalReg=0;


    public static void main(String[] args) {

        /*prompt user to enter number of students to add to the set*/
        numbersToAdd = Integer.parseInt(IO.readln("Enter number of students to add: "));
        /*use if statement to check if number added is more than 0 then start a loop repeating depending on how many students the user wants to add*/
        if (numbersToAdd <= 0) {
            IO.println("Invalid number of students");
        } else {
            for (int i = 1; i <= numbersToAdd; i++) {
                newId = Integer.parseInt(IO.readln("Enter Student Id: "));
                if (studentID.contains(newId)) {                                /*check if there are duplicates*/
                    IO.println("Student ID already exists. Record skipped.");
                } else {
                    studentID.add(newId); /*add student Id to the set */
                    Integer numbersOfCourses = Integer.parseInt(IO.readln("Enter number of courses to add for this student: "));
                    totalReg += numbersOfCourses;
                    HashSet<String> courses = new HashSet<>();   /*create a set where courses for each student will be stored to before adding it to the map as value*/
                    for (int j = 1; j <= numbersOfCourses; j++) {
                        newCourse = IO.readln("Enter course name: "); /*prompt user to enter course name*/
                        courses.add(newCourse);
                    }
                    coursesLog.put(newId, courses);  /*add student id and courses set to the map as key and value*/
                }}}


       int choice;
        do{
        IO.println("-----Display Menu-----");
        IO.println("1. Search student");
        IO.println("2. Add Course to Student");
        IO.println("3. Remove Course from Student");
        IO.println("4. Display All Students");
        IO.println("5. Display Registration Statistics");
        IO.println("6.Exit");
        choice = Integer.parseInt(IO.readln("Enter choice: "));

            switch (choice){
            case 1:
            search();
             break;
            case 2:
            addCourse();
             break;
            case 3:
            removeCourse();
             break;
            case 4:
            display();
             break;
            case 5:
            statistics();
             break;
            case 6:
            IO.println("Thank you. Goodbye");
             break;
            default:
            IO.println("Invalid choice. Please try again.");
             break;


  } }while (choice != 6);
            }

        /*create method to search for a student and courses they are registered to*/
        static void  search(){
        Integer searchId = Integer.parseInt(IO.readln("Enter Student ID: "));
        if(studentID.contains(searchId)){
            IO.println("Registered courses for this student: " + coursesLog.get(searchId));
        }else{
            IO.println("Student Id not found.");
        }
        }

         static void addCourse(){
             Integer searchId = Integer.parseInt(IO.readln("Enter Student ID: "));
             if(studentID.contains(searchId)){
                 String addNew = IO.readln("Enter new course name: ");
                 if (coursesLog.get(searchId).contains(addNew)){
                     IO.println("Already registered to this course.");
                 }else {
                     coursesLog.get(searchId).add(addNew);
                     IO.println("Course added successfully.");
                     totalReg += 1;
                 }
             }
         }
         /*create method to remove a course from the set value in the map*/
         static void removeCourse(){
             Integer searchId = Integer.parseInt(IO.readln("Enter Student ID: "));
             if(studentID.contains(searchId)){
                 String remove = IO.readln("Enter course name to be removed: ");
                 if (coursesLog.get(searchId).contains(remove)){
                     coursesLog.get(searchId).remove(remove);
                     IO.println("Course removed successfully.");
                 }else {
                     IO.println("Course is not found.");
                 }
             }
         }

         static void display(){
             for(Integer key : coursesLog.keySet()){
                 IO.println("Student ID: " + key + ", Registered courses: " + coursesLog.get(key));
             }
         }

         static void statistics(){
             IO.println("Total number of students: " + studentID.size());
             IO.println("Total number of course registration: " + totalReg);
             Integer highest= Integer.MIN_VALUE;  /*create variable for lowest and highest registered courses and initialise it by max and min values*/
             Integer lowest= Integer.MAX_VALUE;
             Integer highestId=0;
             Integer lowestId=0;

             for(Integer key: coursesLog.keySet()){
                 if(coursesLog.get(key).size()>highest) {
                     highest = coursesLog.get(key).size();
                     highestId = key;
                 }
                 if(coursesLog.get(key).size()<lowest) {
                     lowest = coursesLog.get(key).size();
                     lowestId = key;
                 }
             }
             IO.println("Student with the highest number of registered courses: " + highestId);
             IO.println("Student with the lowest number of registered courses: " + lowestId);
             double average = (double) totalReg/studentID.size();
             IO.println("Average number of courses per student: " + average);
         }


        }


