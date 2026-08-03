import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StudentRegistrationManager {
    static Queue<String> registrationQueue = new LinkedList<>();
    static Stack<String> registrationStack = new Stack<>();


        public static void main(String[] args) {
            int numberOfStudents = Integer.parseInt(IO.readln("Enter number of students waiting for registration: "));
            if (numberOfStudents <= 0) {
                IO.println("Invalid number of students.");
            } else {
                for (int i = 1; i <= numberOfStudents; i++) {
                    String name = IO.readln("Enter student name: ");
                    registrationQueue.add(name); // add to queue
                }
            }

            int choice;
            do {
                IO.println(" ----- Student Registration Menu -----");
                IO.println("1. Add Student to Queue");
                IO.println("2. Process Student Registration");
                IO.println("3. View Next Student");
                IO.println("4. Undo Last Registration");
                IO.println("5. Search Student");
                IO.println("6. Display Waiting Students");
                IO.println("7. Display Registered Students");
                IO.println("8. Display Statistics");
                IO.println("9. Exit");

                choice = Integer.parseInt(IO.readln("Enter your choice: "));

                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        processRegistration();
                        break;
                    case 3:
                        viewNextStudent();
                        break;
                    case 4:
                        undoRegistration();
                        break;
                    case 5:
                        searchStudent();
                        break;
                    case 6:
                        displayWaitingStudents();
                        break;
                    case 7:
                        displayRegisteredStudents();
                        break;
                    case 8:
                        displayStatistics();
                        break;
                    case 9:
                        IO.println("Exiting program. Goodbye!");
                        break;
                    default:
                        IO.println("Invalid choice. Please try again.");
                }
            } while (choice != 9);
        }

        static void addStudent() {
            String name = IO.readln("Enter student name: ");
            registrationQueue.add(name);
            IO.println("Student added to registration queue successfully.");
        }

        static void processRegistration() {
            if (registrationQueue.isEmpty()) {
                IO.println("No students waiting for registration.");
            } else {
                String student = registrationQueue.remove(); // remove from queue
                registrationStack.push(student);             // add to stack
                IO.println("Student registration completed: " + student);
            }
        }

        static void viewNextStudent() {
            if (registrationQueue.isEmpty()) {
                IO.println("No students in the queue.");
            } else {
                IO.println("Next student: " + registrationQueue.peek());
            }
        }

        static void undoRegistration() {
            if (registrationStack.isEmpty()) {
                IO.println("No registrations to undo.");
            } else {
                String undone = registrationStack.pop();
                IO.println("Registration undone for: " + undone);
            }
        }

        static void searchStudent() {
            String name = IO.readln("Enter student name to search: ");
            if (registrationQueue.contains(name)) {
                IO.println("Student is waiting for registration.");
            } else if (registrationStack.contains(name)) {
                IO.println("Student is already registered.");
            } else {
                IO.println("Student not found.");
            }
        }

        static void displayWaitingStudents() {
            if (registrationQueue.isEmpty()) {
                IO.println("No waiting students.");
            } else {
                IO.println("Waiting students:");
                for (String student : registrationQueue) {
                    IO.println(student);
                }
            }
        }

        static void displayRegisteredStudents() {
            if (registrationStack.isEmpty()) {
                IO.println("No registered students.");
            } else {
                IO.println("Registered students:");
                for (String student : registrationStack) {
                    IO.println(student);
                }
            }
        }

        static void displayStatistics() {
            IO.println("Total waiting students: " + registrationQueue.size());
            IO.println("Total registered students: " + registrationStack.size());

            if (!registrationQueue.isEmpty()) {
                IO.println("Next student waiting: " + registrationQueue.peek());
            }
            if (!registrationStack.isEmpty()) {
                IO.println("Last registered student: " + registrationStack.peek());
            }

            IO.println("Is queue empty? " + registrationQueue.isEmpty());
            IO.println("Is stack empty? " + registrationStack.isEmpty());
        }
}
