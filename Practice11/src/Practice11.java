public class Practice11 {

    public static void main (String[] args) throws Exception{
        /*a();
        System.out.println("q");
        a(0);
        System.out.println(clearEmojis("LOL :-D")); */

        int[] a = {3,5,8,7,6};
        System.out.println(foo(a, 4));
        System.out.println(foo(a, 1));
        System.out.println(foo(a, 0));
    }
    public static int foo(int[] a, int i) {
        try {
            if(i > 2) {
                i = a[a.length] + 1;
            } else {
                i = (1 / 0) + a[a.length];
            }
        } catch(ArithmeticException e) {
            i += 4;
        } catch(ArrayIndexOutOfBoundsException e) {
            i += 3;
        } catch(Exception e) {
            i += 5;
        } finally {
            i += 2;
        }
        i++;
        return i;
    }


    /*public static void a() {
        try {
            System.out.println("a");
            b();
            System.out.println("k");
        }
        catch (Exception e) {
            System.out.println("g");
        }
        finally {
            System.out.println("z");
        }
    }

    public static void b() throws Exception {
        try {
            System.out.println("b");
            c();
            System.out.println("z");
        }
        catch(Exception e) {
            System.out.println("d");
            throw new Exception();
        }
        finally {
            System.out.println("e");
        }
        System.out.println("f");
    }

    public static void c() throws Exception {
        System.out.println("c");
        throw new Exception();
    }


    public static void a(int count) throws Exception {
        try {
            System.out.println("count = " + count++);
            count = count / 0;
        } catch (ArithmeticException e) {
            System.out.println("count = " + count++);
            b(count);
        } catch (Exception e) {
            b(count);
        } finally {
            System.out.println("count = " + count++);
        }
    }

    public static void b(int count) throws Exception {
        try {
            int x = 0;
            int y = count / x;
            System.out.println("count = " + count--);
        } catch(Exception e) {
            System.out.println("count = " + count++);
            c(count);
        } finally {
            count++;
            System.out.println("count = " + count);
        }
    }

    public static void c(int count) {
        count++;
    }

    public static String clearEmojis(String sms) {
        return sms.replaceAll("(\\w*)(\\s+)(:-?[)DP])","$1.");
    }
*/


}
