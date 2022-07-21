public class LeapYear {

    public static void main(String[] args) {

        isLeapYear(-1600);
        isLeapYear(1600);



    } public static boolean isLeapYear(int year){

        boolean Leap = false;

        if ((year < 1) || (year > 9999)){
            Leap = false;
            System.out.println("There was a leap year this year. True or False?  " + Leap);
        } else if (((year % 4 == 0) && (year % 100 != 0 ) ) || (year % 400 == 0)){
            Leap = true;
            System.out.println("There was a leap year this year. True or False? " + Leap);
        } else {
            Leap = false;
        }
        return Leap;




    }
}
