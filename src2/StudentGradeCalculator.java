public class StudentGradeCalculator {

    public static void main(String[] args){

        double grade1 = 85; /*set three grades*/
        double grade2 = 90;
        double grade3 = 80;
        double average = (grade1 + grade2 + grade3)/3;/*Calculate average*/
        String status = "Null";/*set status variable that will change according to average*/


        IO.println("Average grade = " + average);  /*print average*/

        if(average >= 90){
            status = "Excellent";
        }else if(average >=75 && average <= 89){
            status = "Good";
        }else if(average >=60 && average <= 74) {
            status = "Pass";
        }else if(average < 60){
            status = "Fail";                     /*Set status to different status according to average using if statement*/
        }
       IO.println("Status: " + status);   /*print status*/

    }
}
