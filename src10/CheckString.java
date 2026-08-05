public class CheckString {

    public static void main(String[] args) {

     IO.println("Does the word 'computer' contains the letter 't'? " + contain("computer", 't'));
    }

    static boolean contain(String s, char c) {
        if (s.isEmpty()) {   /*base case*/
            return false;
        }
        if (s.charAt(0) == c) {
            return true;    /*stop and return true when character is found*/
        }
        return contain(s.substring(1), c); /*continue calling method and using substring of the word deleting the first char*/
    }
}
