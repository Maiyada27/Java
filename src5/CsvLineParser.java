public class CsvLineParser {

    public static void main(String[] args) {
        String customer = IO.readln("Enter customer deatails: ");  /*prompt user to enter data*/
        String[] details = customer.split(",");

        if(details.length != 3){
            IO.println("Invalid record");
            return;
        }

        String name = details[0].trim();
        Integer age = Integer.parseInt(details[1].trim());
        String city = details[2].trim();

        IO.println("Name: "+ name);
        IO.println("Age: "+ age);
        IO.println("City: "+ city);

        /*classify age */
        if(age < 18){
            IO.println("Minor");
        }else if (age>=18 && age < 65){
            IO.println("Adult");
        } else{
            IO.println("Senior");
        }



    }

}
