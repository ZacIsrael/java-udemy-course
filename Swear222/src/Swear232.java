public class Swear232 {

        public static void main(String[] args) {

            String[] x = new String[]{"idiot", "dumb"};
            System.out.println(cleanText("He is an idiot, a very dumb idiot.", x));
            String[] s = new String[]{"stupid", "lazy", "moron"};
            System.out.println(cleanText("You are so lazy, I am sick and tired of your stupid nonsense. You lazy moron.....just stupid!",s));
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
                for (int j = 0; j < wordLength - 2; j++) {
                    sanitizedCurseWord += "*";
                }
                //This is the sanitized curse word
                sanitizedCurseWord += lastCharacter;
                //System.out.println(curse +" " + sanitizedCurseWord);
                //Replace all occurrences of this particular curse word with its sanitized version
                cleanTextVersion = cleanTextVersion.replaceAll(curse,sanitizedCurseWord);
            }
            return cleanTextVersion;
        }
    }


