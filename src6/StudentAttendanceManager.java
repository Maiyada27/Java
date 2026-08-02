import java.util.HashMap;
import java.util.HashSet;

public class StudentAttendanceManager {
    static HashSet<Integer> studentsId = new HashSet<>();
    static HashMap<Integer, Integer> attendanceLog = new HashMap<>();
    static Integer newId;
    static Integer newAttendance;
    static int numbersToAdd;
    public static void main(String[] args) {
        /*prompt user to enter number of students to add to the set*/
        numbersToAdd = Integer.parseInt(IO.readln("Enter number of students to add: "));
        /*use if statement to check if number added is more than 0 then start a loop repeating depending on how many students the user wants to add*/
        if (numbersToAdd <= 0) {
            IO.println("Invalid number of students");
        } else {
            for (int i = 1; i <= numbersToAdd; i++) {
                newId = Integer.parseInt(IO.readln("Enter student Id: "));
                if (studentsId.contains(newId)) {                                /*check if there are duplicates*/
                    IO.println("Student ID already exists. Record not added.");
                } else {
                    studentsId.add(newId); /*add student Id to the set */
                    newAttendance = Integer.parseInt(IO.readln("Enter attendance record: ")); /*prompt user to enter attendance*/
                    attendanceLog.put(newId, newAttendance);  /*add student id and attendance to the map as key and value*/
                }
            }
        }

        int choice;
        do{
            IO.println("-----Display Menu-----");
            IO.println("1. Add Student Record");
            IO.println("2. Search Student Attendance");
            IO.println("3. Update Attendance");
            IO.println("4. Remove Student Record");
            IO.println("5. Display All Attendance Records");
            IO.println("6. Display Attendance Statistics");
            IO.println("7.Exit");
            choice = Integer.parseInt(IO.readln("Enter choice: "));

            switch (choice){
                case 1:
                    addStudent();
                    break;
                case 2:
                    searchStudent();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    removeStudent();
                    break;
                case 5:
                    displayAll();
                    break;
                case 6:
                    statistics();
                    break;
                case 7:
                    IO.println("Thank you. Goodbye");
                    break;
                default:
                    IO.println("Invalid choice. Please try again.");
                    break;


            } }while (choice != 7);
    }

    static void addStudent(){
        Integer searchId = Integer.parseInt(IO.readln("Enter Employee ID: "));
        if(studentsId.contains(searchId)) {
            IO.println("Student ID already exists.");
        }else{
            Integer addAttendance = Integer.parseInt(IO.readln("Enter attendance record: "));
            studentsId.add(searchId);
            attendanceLog.put(searchId,addAttendance);
            IO.println("Student added successfully.");
        }
    }

    static void searchStudent(){
        Integer searchId = Integer.parseInt(IO.readln("Enter Student ID: "));
        if(studentsId.contains(searchId)){
            IO.println("Attendance record: " + attendanceLog.get(searchId));
        }else{
            IO.println("Student Id not found.");
        }}

    /*create method to update attendance in the map*/
    static void update() {
        Integer replaceID = Integer.parseInt(IO.readln(("Enter Student Id: ")));
        if (attendanceLog.containsKey(replaceID)) {
            Integer updateAttendance = Integer.parseInt(IO.readln(("Enter updated attendance record: ")));
            attendanceLog.replace(replaceID, updateAttendance);
            IO.println("Student Attendance record updated successfully.");
        } else {
            IO.println("Student ID not found.");
        }
    }

    static void removeStudent(){
        Integer searchId = Integer.parseInt(IO.readln("Enter Student ID: "));
        if(attendanceLog.containsKey(searchId)){
            attendanceLog.remove(searchId);
            studentsId.remove(searchId);
            IO.println("Student record removed successfully.");
        }else {
            IO.println("Student ID not found.");
        }
    }
    /*display all attendance records*/
    static void displayAll(){
        for(Integer key: attendanceLog.keySet()){
            IO.println("Student ID: " + key + ", Attendance record: " + attendanceLog.get(key));
        }
    }

    static void statistics() {
        Double total = 0.0;
        for (Integer key : attendanceLog.keySet()) {
            total += attendanceLog.get(key);
        }
        Double average = total / studentsId.size();

        Integer highest = Integer.MIN_VALUE;  /*create variable for lowest and highest attendance and initialise it by max and min values*/
        Integer lowest = Integer.MAX_VALUE;
        Integer highestId = 0;
        Integer lowestId = 0;
        for (Integer key : attendanceLog.keySet()) {
            if (attendanceLog.get(key) > highest) {
                highest = attendanceLog.get(key);
                highestId = key;
            }
            if (attendanceLog.get(key) < lowest) {
                lowest = attendanceLog.get(key);
                lowestId = key;
            }
        }
        IO.println("Student with highest attendance: " + highestId + ", with attendance days of: " + highest);
        IO.println("Employee with lowest attendance: " + lowestId + ", with attendance days of: " + lowest);
        IO.println("Total number of students: " + studentsId.size());
        IO.println("Total attendance days: " + total);
        IO.println("Average attendance: " + average);
    }


}

