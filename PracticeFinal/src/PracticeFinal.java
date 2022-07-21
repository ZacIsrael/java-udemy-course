public class PracticeFinal {

    public static void main (String[] args) {
        try{
            System.out.print(checkHeight("3\'3\"") + " "); // maybe
            System.out.print(checkHeight("5\'4\"") + " "); // yes
            System.out.print(checkHeight("5\'") + " "); // incomplete
            System.out.print(checkHeight("5\'4inches") + " ");// invalid
            System.out.print(checkHeight("5feet4\"") + " "); // invalid
            System.out.print(checkHeight("2\'6\"") + " ");

        } catch(RuntimeException e) {
            System.out.print("run ");
            System.out.println(e.getMessage());
        } catch(Exception e) {
            System.out.print("exception ");
            System.out.println(e.getMessage());
        }
    }

    public static String checkHeight(String height) throws RuntimeException {
        try{
            String[] tokens = height.split("\'");
            int ft = Integer.valueOf(tokens[0]);
            int in = Integer.valueOf(tokens[1].split("\"")[0]);
            if( ft < 3 || ft > 6) throw new RuntimeException("no");
            else if( ft < 4 && in < 4 ) return "maybe";
            else return "yes";
        } catch(ArrayIndexOutOfBoundsException e){
            return "incomplete";
        } catch(NumberFormatException e) {
            return "invalid";
        }
    }
}
