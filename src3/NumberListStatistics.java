import java.util.ArrayList;

public class NumberListStatistics {

    public static void main(String[] args) {
        ArrayList<Integer> numbers= new ArrayList<>(); /*create an empty array list*/
        int sum=0;
        int average=0;
        int evenNumbers=0;
        int oddNumbers=0;
        int positiveNumbers=0;
        int negativeNumbers=0;
        int largestNumber;
        int smallestNumber;   /*create variables*/

        for (Integer i=-2; i<=20; i++){
            numbers.add(i);

        }                       /*for loop to add values to list including negative values and zero*/

        largestNumber= numbers.getFirst();
        smallestNumber= numbers.getFirst();  /*initialize largest and smallest number by setting them to the first number in the list*/

        for(Integer i=0; i<= numbers.size()-1; i++){
            if (numbers.get(i) %2 ==0){
                evenNumbers += 1;
            }else if (numbers.get(i) %2 !=0){
                oddNumbers += 1;          /*Start a loop to go through every number in list, check if it is even or odd number and update counter accordingly*/
            }
            if(numbers.get(i)<0){
                negativeNumbers += 1;
            } else if (numbers.get(i)>0) {
                positiveNumbers += 1;      /*check if number is positive or negative*/
            }
            if(numbers.get(i) > largestNumber){
                largestNumber = numbers.get(i);
            }else if (numbers.get(i) < smallestNumber){
                smallestNumber = numbers.get(i);  /*use another if statement to get the largest and smallest number*/
            }

            sum += numbers.get(i);
            average = (sum/numbers.size());

        }
        IO.println("All numbers:");
        for (int number :numbers){
            IO.println(number);
        }        /*loops through the list to display all numbers*/

        IO.println("Sum of all numbers = " + sum);
        IO.println("Average = " + average);
        IO.println("Largest number = " + largestNumber);
        IO.println("Smallest number = " + smallestNumber);
        IO.println("Count of even numbers = " + evenNumbers);
        IO.println("Count of odd numbers = " + oddNumbers);
        IO.println("Count of positive numbers = " + positiveNumbers);
        IO.println("Count of negative numbers = " + negativeNumbers);  /*print all results*/



    }
}
