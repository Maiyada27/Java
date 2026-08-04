public class NumberOfVowels {

    public static void main(String[] args) {
        String word = "Coffee";
        IO.println("Number of vowels in the word " + word + " = " + countVowels(word));

    }

    static int countVowels(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        char c = s.toLowerCase().charAt(0);
        int count = (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') ? 1 : 0;
        return count + countVowels(s.substring(1));
    }
}
