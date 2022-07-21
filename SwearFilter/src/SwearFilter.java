public class SwearFilter {

    public static void main(String[] args) {

        // Test cases
        String[] x = new String[]{"idiot", "dumb"};
        System.out.println(swearFilter("He is an idiot, a very dumb idiot.", x));
        String[] s = new String[]{"Stupid", "lazy", "moron"};
        System.out.println(swearFilter("You are so lazy, I am sick and tired of your stupid nonsense. You lazy moron.....just stupid!",s));
        String[] m = new String[]{"love", "sex", "drugs"};
        System.out.println(swearFilter("He was addicted to drugs and sex because no one loved him",m));


    }

    public static String swearFilter(String text, String[] swear) {

        for (int i = 0; i < swear.length; i++) {
            // Run this loop  as many times as there are elements in the swear Array
           String swearWord = swear[i];

           // The string swearWord will be equivalent to the current element in the swear Array

           int swearLength = swearWord.length();
            // The integer swearLength will be equivalent to the length of the current element in the swear Array

           String cleanSwear = ("" + swear[i].charAt(0));
           String cleanUpper = cleanSwear.toUpperCase();
           // The clean version of the swear word will always start with the first letter of the swear word
           for(int j = 0; j < swearLength -2; j++){

               cleanSwear += "*";
               // Add an asterisk to the clean version of the swear word until the last letter
               //That is why the loop run the length of the swear - 2
           }
           cleanSwear += swearWord.charAt(swearWord.length()-1);
           // Add the last character from the swear word on to the clean swear word

           text = text.replaceAll(swearWord.toLowerCase(),cleanSwear);
           text = text.replaceAll(swearWord.toUpperCase(), cleanSwear);
           text = text.replaceAll(swearWord, cleanSwear);
           // replace the current swear word in the text(if there are any) with the clean version of it
            // The current swearword is a String so it counts as a regular expression
        }
        return text;
        // return the text with the clean swear words in it.
    }
}
