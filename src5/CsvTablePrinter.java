import java.util.ArrayList;
import java.util.Arrays;

public class CsvTablePrinter {

    public static void main(String[] args) {

        String[] data = {"Name,Age,City", "Ali,25,Muscat ", "Sara,30,Nizwa ", "Omar,28,Sohar", "Layla,22" };
        String[] new_data = data[0].split(",");

        for (String d : new_data) {              /*print header in a table formated way*/
            IO.print(String.format("%-15s", d));
        }
        IO.println();
        IO.println("__________________________________________");
        int shownRows = 0;

        for (int i = 1; i < data.length; i++) {
            String[] new_entry = data[i].split(",");

            if (new_entry.length != 3) {
                System.out.println("Skipping malformed row: " + data[i]);     /*If data is not equal to 3 columns it will not be added to the teable*/
                continue;
            }

            for (String info : new_entry) {    /*print every data as a new row*/
                IO.print(String.format("%-15s", info));
            }

            IO.println();
            shownRows++;
        }

        IO.println();
        IO.println("Data rows shown: " + shownRows);  /*print count for number of rows*/


    }
}

