public class FractalMickeyMouse {

    public static void main(String[] args) {

        Turtle t = new Turtle();
        t.delay(2);
        // Test cases are below
        fractalMickeyMouse(t, 120, 4);
        //fractalMickeyMouse(t, 160, 4);
        //fractalMickeyMouse(t, 200, 4);
        //fractalMickeyMouse3(t, 240, 3);


    }
    public static void fractalMickeyMouse(Turtle t, double r, int level) {
        if (level == 0) { // if the level equal zero, do not draw anything
            return;
        } else if (level == 1) { // if the level equals 1, draw a mickeyFace
            mickeyFace(t, r);
        } else { // Otherwise,
                // My mickeyMouse method starts from the top so I am drawing all of the smaller circles first
                // The number of circles in each level equal 2 to the power of the level -1
                // I am running that loop that number ^ minus 1 because I did not want to take the turtle past the last circle
                // after the for loop I just added the circle
            for (int i = 0; i < Math.pow(2, level - 1) - 1; i++) {

                mickeyFace(t, r / Math.pow(2, level - 1)); // Draws the circles for the highest level
                // The radius of a circle in a specific row is always the radius in the test case
                // divided by 2 to the power of the level - 1.
                t.penup();
                t.forward(2 * (r / Math.pow(2, level - 2)));
                t.forward(r / Math.pow(2, level + 1));
                // In order to get to the middle of the next circle, the turtle must move forward the
                // 2 times the radius of the circle that is in a level below it (larger radius) plus \
                // the radius of a circle that would be two levels above it
                t.pendown();

            }
            mickeyFace(t, r / Math.pow(2, level - 1));

            for (int i = 0; i < Math.pow(2, level - 1) - 1; i++) {
               // This for loop takes the Turtle back to the middle of the first circle it drew in this row
                t.backward(2 * (r / Math.pow(2, level - 2)));
                t.backward(r / Math.pow(2, level + 1));
            }
            t.right(45); // turn right diagonally
            t.forward(r / Math.pow(2, level - 1));
            //Move forward the current radius of the circle
            t.forward(r / Math.pow(2, level - 2));
            // Move forward double the current radius of the circle (aka , the following circle's radius).
            t.left(45); // turn the turtle left 45 degrees so it can be at (0,0) in order to start the next row of circles
            t.pendown();

            fractalMickeyMouse(t, r, level - 1); // Recursion


        }
    }

    public static void mickeyFace(Turtle t, double r) {
        t.penup(); // starting from the center of the circle

        t.forward(r);
        t.left(90);
        t.pendown();


        //Draw shape of face
        drawFaceShape(t, r);
        t.penup();

        t.right(90);
        t.backward(r);
        t.forward(r / 3);
        t.pendown();
        //Draw one eye
        drawEye(t, r);

        t.penup();
        t.backward(2 * (r / 3));
        t.pendown();
        //Draw another eye
        drawEye(t, r);

        t.penup();
        t.forward(r / 3);
        t.right(120);
        t.pendown();

        //Draw nose
        drawNose(t, r);

        drawMouth(t, r);


    }

    private static void drawFaceShape(Turtle t, double radius) {
        for (int i = 0; i < radius; i++) { // for loop that draws the face

            t.left(360.0 / radius);
            t.forward(Math.PI * 2); // circumference of a circle is 2 * pi * r
        }
    }

    private static void drawEye(Turtle t, double radius) { // draws an eye

        int iMax = (int) (radius * 2);

        for (int i = 0; i < iMax; i++) {
            t.forward(radius / 360);
            t.left(180 / radius);
        }

    }

    private static void drawNose(Turtle t, double radius) { // draws the triangle nose
        double steps = radius / 5;

        for (int i = 0; i < 2; i++) {
            t.forward(steps);
            t.left(120);
        }
        t.forward(steps);
        t.right(120);
    }

    private static void drawMouth(Turtle t, double radius) {
        t.penup(); // moves the turtle from the center of the circle to the position to start the mouth
        t.forward(radius);
        t.right(90);
        t.forward(radius / 2);
        t.right(105);
        t.forward(radius / 3);
        t.left(90);
        t.pendown();

        double n = radius * 0.6;

        for (int i = 0; i < radius / 2; i++) { // draws the mouth
            t.right(180 / n);
            t.forward((Math.PI * 2 * n) / radius);
        }

        t.left(180);

        for (int i = 0; i < radius / 2; i++) {
            t.forward((Math.PI * 2 * n) / radius);
            t.left(180 / n);
        }
        t.penup(); // move the turtle back to the center of the circle
        t.right(90);
        t.forward(radius / 3);
        t.left(105);
        t.forward(radius / 2);
        t.right(90);
        t.backward(radius);

    }

//    public static void drawMouth2(Turtle t, double radius) {
//        t.right(90);
//        t.penup();
//        t.forward(radius * 0.6);
//        t.pendown();
//        t.right(90);
//
//
//        for (int i = 0; i < 2; i++) {
//            t.forward(radius * 0.4);
//            t.left(90);
//            t.forward(radius * 0.2);
//            t.left(90);
//            t.forward(radius * 0.4);
//        }
//        t.right(90);
//        t.penup();
//        t.forward(radius * 0.6);
//        t.right(90);
//    }
//
//    public static void fractalMickeyMouse3(Turtle t, double r, int level) {
//
//        if (level >= -1000000 && level <= 0) {
//            return;
//        } else if (level < -1000000) {
//
//            //Convert a positive zero-based level value
//            int currentLevel = level + 1000000;
//            currentLevel = -currentLevel;
//            int numberOfMickeyFaces = (int) Math.pow(2, currentLevel);
//            double circleRadius = r / numberOfMickeyFaces;
//
//
//            for (int i = 0; i < numberOfMickeyFaces / 2; i++) {
//                t.left(135);
//                t.forward(3 * circleRadius);
//                t.right(135);
//                mickeyFace(t, circleRadius);
//                t.right(45);
//                t.forward(3 * circleRadius);
//                t.left(90);
//                t.forward(3 * circleRadius);
//                t.right(45);
//                mickeyFace(t, circleRadius);
//
//            }
//
//            t.left(45);
//            t.backward(3 * circleRadius);
//            t.left(90);
//            t.forward(3 * circleRadius);
//            t.right(135);
//
//        } else {
//            mickeyFace(t, r);
//            for (int i = 1; i < level; i++) {
//                int tempLevel = -i - 1000000;
//                fractalMickeyMouse3(t, r, tempLevel);
//            }
//        }
//    }
//
//    public static void fractalMickeyMouse2(Turtle t, double r, int level) {
//        if (level >= 1) {
//
//            int numberOfMickeyFaces = (int) Math.pow(2, level - 1);
//            double circleRadius = r / numberOfMickeyFaces;
//
//            System.out.println("Level:  " + level + ", Total faces:  " + numberOfMickeyFaces + ", Radius:  " + circleRadius);
//
//
//            for (int i = 0; i < numberOfMickeyFaces - 1; i++) {
//                mickeyFace(t, circleRadius);
//
//                t.forward(circleRadius * 4);
//                t.forward(circleRadius / (Math.pow(2, level)));
//                t.right(360 / (circleRadius * 3.9));
//            }
//            mickeyFace(t, circleRadius);
//            for (int i = 0; i < numberOfMickeyFaces - 1; i++) {
//                t.pendown();
//                t.backward(circleRadius * 4);
//                t.backward(circleRadius / (Math.pow(2, level)));
//            }
//            t.right(45);
//            t.forward(circleRadius);
//            t.forward(circleRadius * 2);
//            t.left(45);
//            t.pendown();
//
//            fractalMickeyMouse2(t, r, level - 1);
//        }
//
//
//    }
//    public static void fractalMickeyMouse1(Turtle t, double r, int level) {
//        if (level <= 0) {
//            return;
//        } else if (level == 1) {
//            mickeyFace(t, r);
//        } else {
//
//            mickeyFace(t, r);
//            t.left(45);
//            t.forward(r + r / 2);
//            t.right(45);
//            fractalMickeyMouse1(t, r / 2, level - 1);
//            t.left(45);
//            t.backward((r / Math.pow(2, level - 1)) + (r / Math.pow(2, level - 2)));
//            t.left(90);
//            t.forward(r + r / 2);
//            t.right(135);
//            fractalMickeyMouse1(t, r / 2, level - 1);
//            t.left(135);
//            t.backward((r / Math.pow(2, level - 1)) + (r / Math.pow(2, level - 2)));
//            t.right(90);
//            t.backward(r + r/2);
//            t.left(-45);
//
//        }
//    }

}