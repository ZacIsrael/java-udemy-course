public class MegaKilo {

    public static void main(String[] args) {
        printMegaBytesAndKiloBytes(2050);
        printMegaBytesAndKiloBytes(10000);
        printMegaBytesAndKiloBytes(0);

    }
    public static void printMegaBytesAndKiloBytes(int kiloBytes){


        int YY = 0;
        int ZZ = 0;
        if (kiloBytes >= 0) {
            YY = (kiloBytes / 1024);
            ZZ = (kiloBytes % 1024);

            System.out.println(kiloBytes + "KB = " + YY + " MB and " + ZZ + " KB");

        } else {
            System.out.println("Invalid value!");
        }
    }
}
