public class FractalSun {

    public static void main(String[] args) {
        Turtle t = new Turtle();
        t.delay(5);
        // Test cases
        fractalSun(t, 180, 2);
        //fractalSun(t, 200, 2);
        // fractalSun(t, 160, 2);
    }

    public static void fractalSun(Turtle t, double r, int level) {
        // Since I used Math.random() for all of my colors, the turtle will use the colors below
        // multiplied by the integer at the end with a number between 0.0 and 0.99999.
        // The closer to 256, the more of that color the turtle will use when drawing the code
        int red = (int) (Math.random() * 250);
        int green = (int) (Math.random() *50);
        int blue = (int) (Math.random()* 50);
        t.color(red, green, blue);
        if (level <= 0) { // if the level is 0, the turtle will not draw anything
            return;
        } else if (level == 1) { // draws the circle
            t.penup();
            t.forward(r); // moving forward the radius of the circle
            t.left(90);
            t.pendown();
            for (int i = 0; i < r; i++) {
                t.left(360.0 / r);
                t.forward((Math.PI * 2));
            }
            t.penup();
            t.right(90);
            t.backward(r);
            t.fill(); // fills in the circle
            t.pendown();
        } else {
            t.penup();
            t.forward(r);
            t.left(90);
            t.pendown();
            for (int i = 0; i < r; i++) { // for loop that draws the circle
                t.left(360.0 / r);
                t.forward((Math.PI * 2)); // The circumference of a circle = 2 * pi * r
            }
            t.penup();
            t.right(90);
            t.backward(r); // Moves the turtle back to the middle so it can fill in everything inside the shape
            t.pendown();
            t.fill(); // fills in the circle with color


            for (int j = 0; j < 8; j++) { // This for loop draw the 8 rays
                t.forward(r * 2);
                fractalSun(t, r / 4, level - 1);
                t.backward(r * 2);
                t.left(45);

            }

        }
    }
}
