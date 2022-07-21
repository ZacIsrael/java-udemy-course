public class ExtractMovieTitle {

    public static void main(String[] args) {
        // Test cases
        System.out.println(extractTitle("<item><title>Split (2017)</title><meta><imbd></meta>"));
        System.out.println(extractTitle("<we><jsjsj><sbhhshs>jsjsjsj<title>The Pursuit of Happiness (2005)</title>sjnsb<>"));
        System.out.println(extractTitle("<title> Men in Black (2003) </title><item><love><meta><awesome><imbd>"));
        System.out.println(extractTitle("<item><imbd><life><cool><title>Transformers (2009)</title>"));
        System.out.println(extractTitle("<title>Love is in the air (2019) <item><oxtail> <imdb>"));
        System.out.println(extractTitle("<idbm><meta> Josh the Simpsons</title><we><in>"));

    }

    public static String extractTitle(String movie) {

        String j = movie.replaceAll(".*<title>", "");
        //Replace all of the text before and including "<title>"  in the string movie with an empty string
        // Call this new string j
        String o = j.replaceAll("</title>.*","");
        // Replace all of the text from "</title>" and after in string j with an empty string
        // Call this string o

        return o;
        // return o

        // If there is only a "<title>" and not a "</title> in the test case, then the method will return string j.

        // If there is only a "</title>" and not a "<title>" in the test case, then the method will return everything
        // that occurs before before "</title>".

        // If the test case does not have "<title>" nor "</title>" in it, then  the method will just return movie.
    }
}
