public class EvenOddCounter {


    public static void main(String[] args){
        int start = 1; /*set the range of numbers start and end */
        int end = 10;
        int evenCount =0;/*set even counter to 0 */
        int oddCount =0;/*set odd counter to 0*/


        for(int i=start; i<=end; i++)
            if(i %2 == 0){
                evenCount= evenCount + 1;
            }else{
                oddCount= oddCount + 1;
            }                                    /*use a loop to check each number between the start and end range, use an if statement to check if the remainder to divide by 2 is zero then add to even number count and if not add it to odd number count*/


        IO.println("Even count = " + evenCount);
        IO.println("Odd count = " + oddCount);   /*print results*/

    }
}
