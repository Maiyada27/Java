public class StringInReverse {

    public static void main(String[] args) {

        String word = IO.readln("Enter a word: ");
        printReverse(word);
    }

    static void printReverse(String s) {
        if (s.isEmpty()) {
            return;
        }
        printReverse(s.substring(1));  /*remove the first character of the string when calling the method*/
        IO.println(s.charAt(0));   /*print the new substring's first character */
    }
}
