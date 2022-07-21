public class ValidFileName {

    public static void main(String[] args) {
        // Test cases
        System.out.println(isValidFilename("homework5.java", "Mac"));
        System.out.println(isValidFilename("rom_com10.txt", "Windows"));
        System.out.println(isValidFilename("hamlet21.java", "Linux"));
        System.out.println(isValidFilename("Little:Triangle.java", "Linux"));
        System.out.println(isValidFilename(" homework4.window", "Windows"));
        System.out.println(isValidFilename("fileName.javascript", "Mac"));

    }

    public static boolean isValidFilename(String filename, String sys) {
        if ((sys == "Mac" || sys == "Linux") && filename.matches("[.[^\\.\\:]]+\\.[A-Za-z]{2,6}")) {
            //If the system is a Mac or a Linux and the filename contains any character except for a period and a colon
            // followed by a period followed by an extension with a length between 2 & 6 (inclusive), return true.
            return true;
        }
        if (sys == "Windows" && filename.matches("[.[^\\s\\<\\>\\?\\:\\.\\|\\*\\/]]+[^com1-9]\\.[a-z]+")) {
            // If the system is a Windows and the filename contains any characters except for "/ ? < > \ : * | ."
            // and does not end with  "com" followed by an integer 1 through 9
            //and is followed by a period followed by lowercase letters, return true.
            return true;
        } else {
            // Otherwise, return false.
            return false;
        }
    }

}
