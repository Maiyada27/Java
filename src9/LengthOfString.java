public class LengthOfString {

    public static void main(String[] args) {

    String s = IO.readln("write a word: ");
    IO.println("length of word: " + length(s));  /*call method and display the output*/
    }

    static int length(String s){
        if (s.isEmpty()) {
            return 0;
        }
        return 1 + length(s.substring(1));  /*substring 1 give a new string from index 1 to the rest of string. without the first character at index0*/
    }
}
