import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class HospitalPatientManager {
    static Queue<String> patientQueue = new LinkedList<>();
    static Stack<String> treatmentStack = new Stack<>();


        public static void main(String[] args) {
            int numberOfPatients = Integer.parseInt(IO.readln("Enter number of patients waiting: "));
            if (numberOfPatients <= 0) {
                IO.println("Invalid number of patients.");
            } else {
                for (int i = 1; i <= numberOfPatients; i++) {
                    String name = IO.readln("Enter patient name: ");
                    patientQueue.offer(name); // add to queue
                }
            }

            int choice;
            do {
                IO.println("----- Menu -----");
                IO.println("1. Add Patient");
                IO.println("2. Treat Patient");
                IO.println("3. View Next Patient");
                IO.println("4. Undo Last Treatment");
                IO.println("5. Search Patient");
                IO.println("6. Display Waiting Patients");
                IO.println("7. Display Treated Patients");
                IO.println("8. Display Hospital Statistics");
                IO.println("9. Exit");

                choice = Integer.parseInt(IO.readln("Enter your choice: "));

                switch (choice) {
                    case 1:
                        addPatient();
                        break;
                    case 2:
                        treatPatient();
                        break;
                    case 3:
                        viewNextPatient();
                        break;
                    case 4:
                        undoTreatment();
                        break;
                    case 5:
                        searchPatient();
                        break;
                    case 6:
                        displayWaitingPatients();
                        break;
                    case 7:
                        displayTreatedPatients();
                        break;
                    case 8:
                        displayStatistics();
                        break;
                    case 9:
                        IO.println("Exiting program. Goodbye!");
                        break;
                    default:
                        IO.println("Invalid choice. Please try again.");
                        break;
                }
            } while (choice != 9);
        }

        static void addPatient() {
            String name = IO.readln("Enter patient name: ");
            patientQueue.offer(name);
            IO.println("Patient added successfully.");
        }

        static void treatPatient() {
            if (patientQueue.isEmpty()) {
                IO.println("No patients waiting for treatment.");
            } else {
                String patient = patientQueue.poll(); // remove from queue
                treatmentStack.push(patient);         // add to stack
                IO.println("Patient treatment completed successfully: " + patient);
            }
        }

        static void viewNextPatient() {
            if (patientQueue.isEmpty()) {
                IO.println("No patients available.");
            } else {
                IO.println("Next patient: " + patientQueue.peek());
            }
        }

        static void undoTreatment() {
            if (treatmentStack.isEmpty()) {
                IO.println("No completed treatments available.");
            } else {
                String undone = treatmentStack.pop();
                IO.println("Treatment undone for patient: " + undone);
            }
        }

        static void searchPatient() {
            String name = IO.readln("Enter patient name to search: ");
            if (patientQueue.contains(name)) {
                IO.println("Patient is waiting for treatment.");
            } else if (treatmentStack.contains(name)) {
                IO.println("Patient treatment completed.");
            } else {
                IO.println("Patient not found.");
            }
        }

        static void displayWaitingPatients() {
            if (patientQueue.isEmpty()) {
                IO.println("No waiting patients.");
            } else {
                IO.println("Waiting patients:");
                for (String patient : patientQueue) {
                    IO.println(patient);
                }
            }
        }

        static void displayTreatedPatients() {
            if (treatmentStack.isEmpty()) {
                IO.println("No treated patients.");
            } else {
                IO.println("Treated patients:");
                for (String patient : treatmentStack) {
                    IO.println(patient);
                }
            }
        }

        static void displayStatistics() {
            IO.println("Total waiting patients: " + patientQueue.size());
            IO.println("Total treated patients: " + treatmentStack.size());

            if (!patientQueue.isEmpty()) {
                IO.println("Next patient waiting: " + patientQueue.peek());
            }
            if (!treatmentStack.isEmpty()) {
                IO.println("Last treated patient: " + treatmentStack.peek());
            }

            IO.println("Is queue empty? " + patientQueue.isEmpty());
            IO.println("Is stack empty? " + treatmentStack.isEmpty());
        }
    }


