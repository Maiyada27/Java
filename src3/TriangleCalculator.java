public class TriangleCalculator {

    public static void main(String[] args) {
        double base = Double.parseDouble(IO.readln("Enter Triangle base: "));   /*prompt user to enter base, height and three sides values and set them as variables */
        double height = Double.parseDouble(IO.readln("Enter Triangle height: "));
        double side1 = Double.parseDouble(IO.readln("Enter Triangle side 1: "));
        double side2 = Double.parseDouble(IO.readln("Enter Triangle side 2: "));
        double side3 = Double.parseDouble(IO.readln("Enter Triangle side 3: "));
        double area=0;  /*set area and circumference to zero*/
        double circumference=0;


        if (base == 0 || height == 0 || side1 == 0 || side2 == 0 || side3 == 0) {
            IO.println("Invalid input. All values must be greater than zero.");
        } else {
            area = (base * height) / 2;
            circumference = (side1 + side2 + side3);       /*used if statement to check if any of the values entered by user is equal to zero, if not calculate area and circumference*/
        }
        if (side1 == side2 && side2 == side3) {
            IO.println("Equilateral Triangle");
        } else if (side1 == side2 || side2 == side3 || side1 == side3) {
            IO.println("Isosceles Triangle");
        } else if (side1 != side2 && side2 != side3 && side1 != side3){         /*use if else to classify triangle*/
            IO.println("Scalene Triangle");}

        IO.println("Triangle height is " + height + ",base is " + base + ", side lengths " + side1 +", " + side2 + ", " + side3 +". The area of the triangle is " + area + " and its circumference is " + circumference);
        /*print results*/
    }
}
