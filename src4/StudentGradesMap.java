import java.util.HashMap;

public class StudentGradesMap {
    static HashMap<Integer, Double> students = new HashMap<>();
    static Integer id = 0;
    static Double grade = 0.0;
    static int numbersToAdd = 0;
    static int duplicates = 0;
    static Double average=0.0;


    public static void main(String[] args) {
        /*prompt user to enter number of students to add to the map*/
        numbersToAdd = Integer.parseInt(IO.readln("Enter number of students to add: "));
        /*use if statement to check if number added is more than 0 then start a loop repeating depending on how many students the user wants to add*/
        if (numbersToAdd <= 0) {
            IO.println("Invalid number of students");
        } else {
            for (int i = 1; i <= numbersToAdd; i++) {
                id = Integer.parseInt(IO.readln("Enter student ID: "));
                grade = Double.parseDouble(IO.readln("Enter grade: "));
                if (students.containsKey(id)) {                                /*check if there are duplicates*/
                    IO.println("Student ID already exists. Record not added.");
                    duplicates += 1;
                } else {
                    students.put(id, grade);  /*add id and grade to the hashmap */
                }
            }
        }
        /*call methods*/
        update();
        display();
        average();
        performance();

    }

    static void update() {
        Integer updateId = Integer.parseInt(IO.readln("Enter student ID: "));
        Double newGrade = Double.parseDouble(IO.readln("Enter updated grade: "));
        if (students.containsKey(updateId)) {
            students.replace(updateId, newGrade);
            IO.println("Grade updated successfully.");
        } else {
            IO.println("Student ID not found.");
        }
    }

    static void average() {
        Double total = 0.0;
        for (Integer key : students.keySet()) {
            total += students.get(key);
        }
        average = total / students.size();
        IO.println("Average grade: " + average);

    }
    /*create method to classify grades*/
    static void performance(){
        if(average <60) {
            IO.println("Needs improvement.");
        } else if (average>= 60 && average<=84) {
            IO.println("Good Performance.");
        } else if (average>=85) {
            IO.println("Excellent Performance.");
        }
    }
    /*create method to display details of the grades*/
    static void display(){
        IO.println("Total student records entered: " + numbersToAdd);

        for(Integer key: students.keySet()){
            IO.println(key + " : " + students.get(key));
        }
    }
}

