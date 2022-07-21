public class Swear2 {

    public static void main(String[] args) {


        String[] x = new String[]{"idiot", "dumb"};
        System.out.println(cleanText("He is an idiot, a very dumb idiot.", x));
    }
    public static String cleanText(String text, String[] curses) {
        String cleanTextVersion = text;
        for (int i = 0; i < curses.length; i++) {
            String curse = curses[i];

            //Sanitize the curse word
            int wordLength = curse.length();
            char firstCharacter = curse.charAt(0);
            char lastCharacter = curse.charAt(wordLength - 1);
            String sanitizedCurseWord = "" + firstCharacter;
            for (int j = 0; j < wordLength - 2; i++) {
                sanitizedCurseWord += "*";
            }
            //This is the sanitized curse word
            sanitizedCurseWord += lastCharacter;
            //Replace all occurrences of this particular curse word with its sanitized version
            cleanTextVersion = cleanTextVersion.replaceAll(curse,sanitizedCurseWord);
        }
        return cleanTextVersion;
    }

    public static String cleanWord(String curse) {
        int wordLength = curse.length();
        char firstCharacter = curse.charAt(0);
        char lastCharacter = curse.charAt(wordLength - 1);
        String cleanVersion = "" + firstCharacter;
        for (int i = 0; i < wordLength - 2; i++) {
            cleanVersion += "*";
        }
        cleanVersion += lastCharacter;
        return cleanVersion;
    }
}
