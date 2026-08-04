public class CheckIfPalindrome {

    public static void main(String[] args) {
        String s = IO.readln("write a word: ");
        IO.println("Is it a Palindrome? " + isPalindrome(s));  /*call method and display the output*/
    }

    static boolean isPalindrome(String s){
        if(s.length()<= 1) {
            return true;
        }
            if(s.charAt(0) != s.charAt(s.length() - 1)){
            return false;
        }
            return isPalindrome(s.substring(1,s.length()-1));   /*substring to remove the first and last characters of the string*/

    }

    }
