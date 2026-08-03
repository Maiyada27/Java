import java.lang.reflect.Array;

public class PasswordStrengthChecker {

    public static void main(String[] args) {
        String password = "";
        int uppercaseCount = 0;
        int lowercaseCount = 0;
        int digitCount = 0;
        int specialCharCount = 0;
        String classification ="";
        int choice;   /*create a menu*/
        do {
            IO.println("----- Menu -----");
            IO.println("1. Enter Password");
            IO.println("2. Check Password Length");
            IO.println("3. Analyze Password Characters");
            IO.println("4. Check Password Strength");
            IO.println("5. Convert Password Format");
            IO.println("6. Display Password Report");
            IO.println("7. Exit");
            choice = Integer.parseInt(IO.readln("Enter your choice: "));

            switch (choice) {
                case 1:  /*prompt user to enter password and save it to a variable*/
                    password = IO.readln("Enter password: ");
                    IO.println("Password saved successfully.");
                    break;
                case 2:   /*check the length of the password*/
                    if(password.length()<8) {
                        IO.println("Password is too short.");
                    }else{
                        IO.println("Password length is acceptable.");}
                    break;
                case 3:
                        for(char c: password.toCharArray()){   /*convert password string to array of characters and loop through the array*/
                        if (Character.isUpperCase(c)) {   /*check if it is uppercase, lowercase, digit or special character and add it to the counter for each type*/
                            uppercaseCount += 1;
                        } else if (Character.isLowerCase(c)) {
                            lowercaseCount += 1;
                        } else if (Character.isDigit(c)) {
                            digitCount += 1;
                        } else {
                            specialCharCount += 1;
                        }
                    }
                    IO.println("Total digits: " + digitCount);
                    IO.println("Total special characters: " + specialCharCount);
                    IO.println("Classification: " + classification);
                    break;
                case 4: /*check the strength of the password*/

                    boolean hasUpper = password.matches(".*[A-Z].*");
                    boolean hasLower = password.matches(".*[a-z].*");
                    boolean hasDigit = password.matches(".*[0-9].*");
                    boolean hasSpecial = password.matches("^.*A-Za-z0-9*.");  /*check if it contains letters numbers and special characters*/
                    if(password.length()>=8 && hasLower && hasUpper && hasDigit && hasSpecial) {
                        classification = "Strong Password.";
                    } else if (password.length()>=8 && hasLower && hasDigit) {
                        classification = "Medium Password.";
                    } else if(password.length()>=8 && hasLower) {
                        classification = "Weak Password.";
                    }
                    IO.println("Classification: " + classification);
                    break;
                case 5: /*print password as uppercase and lowercase*/
                    IO.println("Password in Uppercase: " + password.toUpperCase());
                    IO.println("Password in Lowercase: " + password.toLowerCase());
                    break;
                case 6:/*pring full report of the password*/
                    IO.println("Password length: " + password.length());
                    IO.println("First character: " + password.charAt(0));
                    IO.println("Last character: " + password.charAt(password.length()-1));
                    IO.println("Uppercase letters: " + uppercaseCount);
                    IO.println("Lowercase letters: " + lowercaseCount);
                    IO.println("Total digits: " + digitCount);
                    IO.println("Total special characters: " + specialCharCount);
                    IO.println("Classification: " + classification);
                    break;
                case 7:
                    IO.println("Thank you. Goodbye.");
                    break;
                default:
                    IO.println("Invalid choice. Please enter a valid number.");
                    break;

            }
        } while (choice != 7);
    }
    }

