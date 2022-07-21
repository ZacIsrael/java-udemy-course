public class hasTeen {

    public static void main(String[] args) {

        hasTeen(9, 99, 19);
        hasTeen(23, 15, 42);
        hasTeen(22, 23, 34);

    } public static boolean hasTeen( int a, int b, int c){

        boolean teen = false;

        if ( 13 <= a && a <= 19 || 13 <= b && b <= 19 || 13 <= c && c <= 19){
            teen = true;
            System.out.println("One of these numbers is between 13 & 19. True or False? " + teen);
        } else {
            teen = false;
            System.out.println("One of these numbers is between 13 & 19. True or False? " + teen);
        }
        return teen;

    }
}
