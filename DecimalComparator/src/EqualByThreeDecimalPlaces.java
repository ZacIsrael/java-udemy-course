public class EqualByThreeDecimalPlaces {

    public static void main(String[] args) {

        areEqualByThreeDecimalPlaces(-3.1756, -3.175);
        areEqualByThreeDecimalPlaces(3.175, 3.176);
        areEqualByThreeDecimalPlaces(3.0, 3.0);




    } public static boolean areEqualByThreeDecimalPlaces(double aa, double bb){

        boolean ThreeDecimal = false;

        int a = (int) (aa * 1000);

        int b = (int) (bb * 1000);




        if ( a  == b ){
            ThreeDecimal = true;
            System.out.println(" The numbers are equal to each other. True or False?  " + ThreeDecimal);
        } else {
            ThreeDecimal = false;
            System.out.println(" The numbers are equal to each other. True or False?  " + ThreeDecimal);
        }
        return ThreeDecimal;


    }
}
