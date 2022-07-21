public class Main {

    public static void main(String[] args) {

        System.out.println(area(5.0));
        System.out.println(area(-1));
        System.out.println(area(5.0, 4.0));
        System.out.println(area(-1.0, 4.0));

    } public static double area (double radius){

       double rarea = (radius * radius) * 3.14159;

        if (radius < 0 ){
            return -1.0;

        } else if (radius > 0){
            return rarea;
        }
        return rarea;

    }


    public static double area(double x, double y){

        double rectangle = (double) x * y;

        if ( (x < 0) || (y < 0) ){
                return -1.0;
            } else {
            return rectangle;
        }
    }


}
