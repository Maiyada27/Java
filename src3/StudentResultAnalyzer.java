import java.util.ArrayList;

public class StudentResultAnalyzer {
   /*set variables names and types*/
    static String studentName;
    static ArrayList<Integer> marks= new ArrayList<Integer>();
    static int mathsMarks;
    static int scienceMarks;
    static int englishMarks;
    static int arabicMarks;
    static boolean isValid= true;
    static int total;
    static int average;
    static String grade=" ";
    static String performanceStatus= " ";


   /*create a main method and assign values to the variables*/
    public static void main(String[] args) {
        studentName = "Sumaya";
        mathsMarks = 88;
        scienceMarks = 93;
        englishMarks = 85;
        arabicMarks = 90;
        marks.add(mathsMarks);
        marks.add(scienceMarks);
        marks.add(englishMarks);
        marks.add(arabicMarks);
        /*checks if marks are valid if so then calls all methods and displays the report*/
        validateMarks();
        if (isValid == false) {
            IO.println("Invalid marks. Please check the student grades.");
        } else {
            calculateTotal();
            calculateAverage();
            calculateGrade();
            checkPerformance();
            displayReport();

        }
    }
    /*create method to check if marks are valid or not using a boolean*/
    static void validateMarks() {
        for(int mark: marks) {
            if (mark < 0) {
                isValid = false;
                break;
            }
        }
    }

    /*create method to calculate total value by looping through marks list*/
    static void calculateTotal(){
        for(int mark: marks) {
            total += mark;
        }
        IO.println("Total =" + total);
    }

    /*create method to calculate average*/
    static void calculateAverage(){
       average= total / marks.size();
       IO.println("Average =" + average);
    }

    /*create method to calculate grade using if statement*/
    static void calculateGrade() {
        if (average >= 90) {
            grade="A";
        } else if (average >= 80 && average <= 89) {
            grade="B";
        } else if (average >= 70 && average <= 79) {
            grade="C";
        } else if (average >= 60 && average <= 69) {
            grade="D";
        } else if (average < 60) {
            grade="F";
        }
        IO.println("grade= " + grade);
    }

    /*create method to check performance using if statement*/
    static void checkPerformance() {
        if (performanceStatus != "F") {
            performanceStatus = "PASS";
        } else {
            performanceStatus = "FAIL";
        }
    }

    /*create method to print report*/
    static void displayReport() {
            IO.println("Student name: " + studentName);
            IO.println("Marks: ");
            IO.println("Maths: " + mathsMarks);
            IO.println("Science: " + scienceMarks);
            IO.println("English: " + englishMarks);
            IO.println("Arabic: " + arabicMarks);
            IO.println("Total Marks: " + total);
            IO.println("Average Mark: " + average);
            IO.println("Final Grade: " + grade);
            IO.println("Performance Status: " + performanceStatus);
        }




}
