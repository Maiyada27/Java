public class TrapezoidCalculator {

    public static void main(String[] args) {
        double base1 = Double.parseDouble(IO.readln("Enter Trapezoid base1: "));   /*prompt user to enter two bases, the height, and the two legs and set them as variables */
        double base2 = Double.parseDouble(IO.readln("Enter Trapezoid base2: "));
        double height = Double.parseDouble(IO.readln("Enter Trapezoid height: "));
        double leg1 = Double.parseDouble(IO.readln("Enter Trapezoid leg 1: "));
        double leg2 = Double.parseDouble(IO.readln("Enter Trapezoid leg 2: "));
        double area =0;
        double perimeter =0;
        String classification=" ";



        if (base1 == 0 || height == 0 || base2 == 0 || leg1 == 0 || leg2 == 0) {
            IO.println("Invalid input. All values must be greater than zero.");
        } else {
            area=((base1 + base2)*height)/2;
            perimeter=base1 +base2 +leg1 + leg2;   /*Calculate area and perimeter if all parameters provided by used is greater than 0*/
        }
        if (perimeter<30) {
            classification= "Small Trapezoid";
        } else if (perimeter >=30 && perimeter<=60) {
            classification= "Medium Trapezoid";
        } else if (perimeter >60) {
            classification= "Large Trapezoid";  /*checks perimeter and classify depending on it*/
        }
        IO.println("base1= " + base1 + " ,base2= " + base2 +" ,height= " + height+ " ,leg1= " +leg1 + " ,leg2= " + leg2);
        IO.println("Area of trapezoid =" + area);
        IO.println("Perimeter of trapezoid =" + perimeter);
        IO.println("Trapezoid is a " +classification);   /*print all results*/


    }
}
