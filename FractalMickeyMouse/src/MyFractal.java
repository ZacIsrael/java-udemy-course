public class MyFractal {

    // My fractal will draw a row of polygons followed by a stair case with some of the polygons on every other step.
    //By the (base # * 2) step on the stair case, the row of polygons will repeat itself followed by another staircase like
    // the one before

    public static void main(String[] args) {
        Turtle t = new Turtle();

        t.penup();
        t.left(90);
        t.forward(200);
        t.right(90);
        t.backward(420);
        t.pendown();
        myFractal(t, 21, 7);


    }

    public static void myFractal(Turtle t, double length, double base) {
        if (base <= 0) {
            return;
        } else if (base == 1) {
            t.forward(length);
        } else {
            double any = Math.random() * 17 - 12;
            double num = Math.random() * 9 - 5;

            int red = 255 / (int) any;
            int green = 255 - (int) (num * 15);
            int blue = (205 / 5) + 2 * (int) any;
            t.color(red, green, blue);

            for (int i = 0; i < base; i++) {
                t.forward(length);
                t.left(360 / base);
            }

            t.penup();
            t.forward(length / 2);
            t.pendown();

            myFractal(t, length * 1.2, base - 1);

            t.penup();
            t.backward(length);
            t.right(90);
            t.forward(length / 3);
            t.left(90);
            t.pendown();

            for (int i = 0; i < base; i++) {
                t.forward(length);
                t.left(360 / base);
            }


            myFractal(t, length * 1.2, base - 1);


        }

    }
}
