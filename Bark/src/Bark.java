public class Bark {

    public static void main(String[] args) {
        bark(true, 1);
        bark(false, 2);
        bark(true, 8);
        bark(true, -1);

    }

    public static boolean bark(boolean barking, int hourOfDay) {
        boolean wakeUp = false;

        if (hourOfDay < 0 || hourOfDay > 23) {
            wakeUp = false;
            System.out.println("Wake up?" + wakeUp);
        } else if (hourOfDay >= 8 && hourOfDay <= 22) {
            wakeUp = false;
            System.out.println("Wake up?" + wakeUp);
        } else if ((barking == true) && (hourOfDay < 8 || hourOfDay > 22)) {
            wakeUp = true;
            System.out.println("Wake up?" + wakeUp);
        } else {
            wakeUp = false;
        }
        return wakeUp;

    }

}
