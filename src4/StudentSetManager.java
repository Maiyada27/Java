import java.util.HashSet;

public class StudentSetManager {
    static HashSet<Integer> studentsId = new HashSet<>();  /*Set a HashSet and name it*/
    static int studentID = 0;
    static int repeated=0;
    public static void main(String[] args) {

        /*prompt user to enter number of studets to add to the set*/
        Integer numbersToAdd = Integer.parseInt(IO.readln("Enter number of students to add: "));

        /*use if statement to check if number added is more than 0 then start a loop repeating depending on how many ids the user wants to add*/
        if (numbersToAdd <= 0) {
            IO.println("Invalid number of students");
        } else {
            for (int i = 1; i <= numbersToAdd; i++) {
                studentID = Integer.parseInt(IO.readln("Enter student ID: "));
                if (studentsId.contains(studentID)) {                                /*check if there are duplicates*/
                    IO.println("Duplicate ID detected. ID was not added.");
                    repeated +=1;
                } else {
                    studentsId.add(studentID);  /*add id to the hashset */
                }
            }

        }

        /*call methods*/
        display();
        classifyRegs();

    }
        /*create method to display the hashset */
          static void display() {
              IO.println("Total IDs entered: " + (studentsId.size() + repeated));
              IO.println("Total unique IDs: " + studentsId.size());
            for (int id : studentsId) {
                IO.println(id);
            }
        }
        /*create method to classify registration*/
          static void classifyRegs(){
            if(studentsId.size()<5) {
                IO.println("Small Registration.");
            } else if (studentsId.size()>= 5 && studentsId.size()<=10) {
                IO.println("Medium Registration.");
            } else if (studentsId.size()>10) {
                IO.println("Large Registration");
            }

        }




    }

