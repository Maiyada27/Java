public class CircleCalculator {

    public static void main(String[] args){

        double pi = 3.14;   /*Set pi value as double*/
        Double radius =  Double.parseDouble(IO.readln("Enter Radius: ")); /*Prompt user to input radius then use parse double function to convert the radius to double*/
        double area = 0; /*set area to 0*/
        double circumference =0; /*set circumference to 0*/
        String classification = " ";



        if (radius <= 0) {
            IO.print("Invalid radius. Radius must be greater than zero.");
        }else{
            area = 2*pi* Math.pow(radius, 2);
            circumference = 2*pi*radius;               /*Use if condition to calculate area and radius if radius is greater than 0, and displays message if it is equal to 0*/

        }
        if(radius<5){
            classification = "Small Circle";
        } else if (radius>5 && radius<15) {
            classification = "Medium Circle";
        } else if (radius>15) {
            classification = "Large Circle";    /*use if else to classify the circle based on radius*/

        }
        IO.println("Radius= " + radius);
        IO.println("Area of the circle= " + area);
        IO.println("Circumference of the circle= " + circumference);
        IO.println("Classification= " + classification);   /*print results*/
    }
}
