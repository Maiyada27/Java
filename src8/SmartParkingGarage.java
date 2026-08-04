import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SmartParkingGarage {
    static Queue<String> waitingVehicles = new LinkedList<>();
    static Stack<String> parkedVehicles = new Stack<>();
    static int maxParking = 10;
    static int parkedCounter = 0;
    static int departedCounter = 0;

    /*create menu*/
    public static void main(String[] args) {
        int choice;
        do {
            IO.println("========= Smart Parking Garage =========");
            IO.println("1. Add Vehicle to Waiting Queue");
            IO.println("2. Park Next Vehicle");
            IO.println("3. Remove Parked Vehicle");
            IO.println("4. View Next Waiting Vehicle");
            IO.println("5. View Last Parked Vehicle");
            IO.println("6. Display Waiting Queue");
            IO.println("7. Display Parked Vehicles");
            IO.println("8.  Search Vehicle");
            IO.println("9. Display Garage Statistics");
            IO.println("10. Clear Waiting Queue");
            IO.println("11. Clear Parking Garage");
            IO.println("12. Reset Entire System");
            IO.println("13.  Exit");

            choice = Integer.parseInt(IO.readln("Enter your choice: "));
                         /*call methods in each case*/
            switch (choice) {
                case 1:
                    addVehicle();
                    break;
                case 2:
                    parkNext();
                    break;
                case 3:
                    removeParked();
                    break;
                case 4:
                    viewNext();
                    break;
                case 5:
                    lastParked();
                    break;
                case 6:
                    displayQueue();
                    break;
                case 7:
                    displayParked();
                    break;
                case 8:
                    search();
                    break;
                case 9:
                    statistics();
                    break;
                case 10:
                    clearQueue();
                    break;
                case 11:
                    clearGarage();
                    break;
                case 12:
                    reset();
                    break;
                case 13:
                    IO.println("Thank you for using Smart Parking Garage.");
                    break;
                default:
                    IO.println("Invalid choice. Please enter a valid number.");
                    break;
            }
        } while (choice != 13);
    }

    static void addVehicle() {
        String vehicleNum = IO.readln("Enter vehicle number: ");
        if (!vehicleNum.isEmpty() && !waitingVehicles.contains(vehicleNum)) {
            waitingVehicles.offer(vehicleNum);
            IO.println("Vehicle added to waiting queue.");
        }
    }

    static void parkNext() {
        boolean isEmpty = waitingVehicles.isEmpty() ? true : false;
        if (parkedVehicles.size() == maxParking) {
            IO.println("Garage is already full.");
        } else if (isEmpty) {
            IO.println("No remaining cars waiting in queue.");
        } else {
            String nextVehicle = waitingVehicles.poll();
            parkedVehicles.push(nextVehicle);
            parkedCounter += 1;
            IO.println("Vehicle: " + nextVehicle + " parked.");

        }
    }

    static void removeParked() {
        String removed = parkedVehicles.pop();
        departedCounter += 1;
        IO.println("Removed vehicle: " + removed);
        parkNext();  /*call method 'park next' inside this method*/
    }

    static void viewNext() {
        IO.println("Next vehicle waiting in queue: " + waitingVehicles.peek());
    }

    static void lastParked() {
        IO.println("Last parked vehicle: " + parkedVehicles.peek());
    }

    static void displayQueue() {
        if (!waitingVehicles.isEmpty()) {
            IO.println("Waiting vehicles: ");
            for (String v : waitingVehicles) {
                IO.println(v);
            }
            IO.println("Total waiting vehicles: " + waitingVehicles.size());
        } else {
            IO.println("No vehicles are waiting.");
        }
    }

    static void displayParked(){
        if(!parkedVehicles.isEmpty()){
            IO.println("Parked vehicles (newest parked to oldest): ");
            for (String p: parkedVehicles){
                IO.println(p);}
            IO.println("Current occupied spaces: " + parkedVehicles.size());
            IO.println("Remaining parking spaces: " + (maxParking-parkedVehicles.size()));
    }else {
            IO.println("No parked vehicles. Available parking spaces = 10");
        }}

    static void search(){
        String searchVehicle = IO.readln("Enter vehicle number: ");
        if(waitingVehicles.contains(searchVehicle)){
            IO.println("Vehicle is in waiting queue");
        } else if (parkedVehicles.contains(searchVehicle)){
            IO.println("Vehicle is parked");
        } else{
            IO.println("Vehicle not found.");
    }}

    static void statistics(){
        IO.println("Maximum capacity: " + maxParking);
        IO.println("Current parked vehicles: " + parkedVehicles.size());
        IO.println("Waiting vehicles: " + waitingVehicles.size());
        IO.println("Total Vehicles Parked Today: " + parkedCounter);
        IO.println("Total Vehicles Departed Today: " + departedCounter);
        IO.println("Total Vehicles Processed: "+ (parkedCounter+departedCounter));
        Double occupancy = ((double) parkedVehicles.size()/ maxParking)*100;
        IO.println("Garage Occupancy Percentage: " + occupancy + "%");
    }

    static void clearQueue(){
        String confirmation = IO.readln("Do you want to clear the waiting queue?");
        if( confirmation.trim().equalsIgnoreCase("yes")){
            waitingVehicles.clear();
            IO.println("Queue successfully cleared.");
    }}

    static void clearGarage(){
        parkedVehicles.clear();
        parkedCounter = 0;
        IO.println("Garage successfully cleared.");
    }

    static void reset(){
        parkedVehicles.clear();
        waitingVehicles.clear();
        parkedCounter=0;
        departedCounter=0;
        IO.println("System successfully reset.");
    }

}









