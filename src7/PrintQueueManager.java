import java.util.LinkedList;
import java.util.Queue;

public class PrintQueueManager {
    static Queue<String> printJob = new LinkedList<>();
    public static void main(String[] args) {

                int numberOfJobs = Integer.parseInt(IO.readln("Enter number of print jobs: "));
                if (numberOfJobs <= 0) {
                    IO.println("Invalid number of print jobs.");
                } else {
                    for (int i = 1; i <= numberOfJobs; i++) {
                        String jobName = IO.readln("Enter print job name: ");
                        printJob.offer(jobName); // add job to queue
                    }
                }

                int choice;
                do {
                    IO.println("----- Menu -----");
                    IO.println("1. Add Print Job");
                    IO.println("2. Process Next Print Job");
                    IO.println("3. View Next Print Job");
                    IO.println("4. Search Print Job");
                    IO.println("5. Remove Print Job");
                    IO.println("6. Display All Print Jobs");
                    IO.println("7. Display Queue Statistics");
                    IO.println("8. Exit");

                    choice = Integer.parseInt(IO.readln("Enter your choice: "));

                    switch (choice) {
                        case 1:
                            addPrintJob();
                            break;
                        case 2:
                            processNextJob();
                            break;
                        case 3:
                            viewNextJob();
                            break;
                        case 4:
                            searchJob();
                            break;
                        case 5:
                            removeJob();
                            break;
                        case 6:
                            displayAllJobs();
                            break;
                        case 7:
                            displayStatistics();
                            break;
                        case 8:
                            IO.println("Thank you. Goodbye.");
                            break;
                        default:
                            IO.println("Invalid choice. Please enter a valid number.");
                            break;
                    }
                } while (choice != 8);
            }

            static void addPrintJob() {
                String jobName = IO.readln("Enter print job name: ");
                printJob.offer(jobName);
                IO.println("Print job added successfully.");
            }

            static void processNextJob() {
                if (printJob.isEmpty()) {
                    IO.println("No print jobs in the queue.");
                } else {
                    /*remove first job*/
                    IO.println("Processed print job: " + printJob.poll());
                }
            }

            static void viewNextJob() {
                if (printJob.isEmpty()) {
                    IO.println("No print jobs in the queue.");
                } else {
                    IO.println("Next print job: " + printJob.peek());
                }
            }

            static void searchJob() {
                String jobName = IO.readln("Enter print job name to search: ");
                if (printJob.contains(jobName)) {
                    IO.println("Print job " + jobName + " is in the queue.");
                } else {
                    IO.println("Print job not found.");
                }
            }

            static void removeJob() {
                String jobName = IO.readln("Enter print job name to remove: ");
                boolean removed = printJob.remove(jobName);
                if (removed) {
                    IO.println("Print job removed: " + jobName);
                } else {
                    IO.println("Print job not found.");
                }
            }

            static void displayAllJobs() {
                if (printJob.isEmpty()) {
                    IO.println("No print jobs in the queue.");
                } else {
                    IO.println("All print jobs in the queue:");
                    for (String job : printJob) {
                        IO.println(job);
                    }
                }
            }

            static void displayStatistics() {
                IO.println("Total print jobs: " + printJob.size());
                if (!printJob.isEmpty()) {
                    IO.println("Next print job: " + printJob.peek());
                    // Find last job by iterating
                    String last = "";
                    for (String job : printJob) {
                        last = job;
                    }
                    IO.println("Last print job: " + last);
                }
                IO.println("Is queue empty? " + printJob.isEmpty());
            }
        }



