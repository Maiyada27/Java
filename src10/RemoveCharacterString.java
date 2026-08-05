public class RemoveCharacterString {

    public static void main(String[] args) {
      String word = "Apple";
      char c = 'p';
      IO.println(removeChar(word, c));

    }

    static String removeChar(String s, char c) {
        if (s.isEmpty()) {   /*base case*/
            return"";
        }

        if(s.charAt(0) == c) {
            return removeChar(s.substring(1), c);   /*if the character equals to the letter to remove then just call the method with substring removing the first char*/
        }else {
           return s.charAt(0) + removeChar(s.substring(1),c); /*if the character is not equal then add the character it self then call the method with substring removing the first char*/
        }

        }
    }

