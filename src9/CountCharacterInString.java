public class CountCharacterInString {


    public static void main(String[] args) {
        String s = IO.readln("write a word: ");
        char c = 'a';
        IO.println("The letter 'a' is repeated " + count(s,c) + " times.");  /*call method and display the output*/
    }

    static int count(String s, char c) {
        if (s.isEmpty()) {
            return 0;
        }
        int count = (s.charAt(0) == c)?  1:0;
        return count + count(s.substring(1), c);

        }



}
