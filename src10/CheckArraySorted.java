public class CheckArraySorted {

    public static void main(String[] args) {
        int[] numbers = {3,5,77,20,600};
        IO.println("Is the Array sorted? " + isSorted(numbers,0));

    }

    static boolean isSorted(int[] arr, int index) {
        if (index == arr.length - 1) {  /*base case if it reaches the end it is sorted and nothing remaining to compare the last value to*/
            return true;
        }

        if (arr[index] > arr[index+1]){   /*if the value in array greater than the value that comes next it is not sorted so return false*/
            return false;

        }

        return isSorted(arr, index+1);  /*if it is sorted, continue to call a copy of the method each time increasing the index by 1*/
    }
}
