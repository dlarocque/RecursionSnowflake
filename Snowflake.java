/*
Snowflake.java

COMP 1020 Section A03
INSTRUCTOR : Bryan Wodi
ASSIGNMENT : 4
AUTHOR     : Daniel La Rocque
VERSION    : April 5, 2020

PURPOSE    : Draw a snowflake using recursion
*/

public class Snowflake {

    private static final int LEVELS = 6; // amount of levels the snowflake has
    private double penRadius = 0.013;

    public static void main(String[] args) {
        Snowflake snowflake = new Snowflake();
        snowflake.drawSnowflake(); // Draw the snowflake
        // Main method is just calling method to draw a snowflake
    }

    public Snowflake() {
        // Constructor
    }

    public void drawSnowflake() {

        StdDraw.setPenColor(StdDraw.BLACK); // Set pen color to Black
        StdDraw.setPenRadius(penRadius); // Set the pens size

        // coordinates for + sign

        // Left side of the + sign coordinates
        double leftX = 1.0 / 4;
        double leftY = 1.0 / 2;

        // Top of the + sign coordinates
        double topX = 1.0 / 2;
        double topY = (1.0 / 4) * 3;

        // Right side of the + sign coordinates
        double rightX = (1.0 / 4) * 3;
        double rightY = 1.0 / 2;

        // bottom of the + sign coordinates
        double bottomX = 1.0 / 2;
        double bottomY = 1.0 / 4;

        // Length of the first branch
        double branchLength = 1.0 / 8;

        // Horizontal line of the + sign
        StdDraw.line(leftX, leftY, rightX, rightY);
        // Vertical line of the + sign
        StdDraw.line(topX, topY, bottomX, bottomY);

        // left side branches
        drawBranch(rightX, rightY, branchLength, 0, penRadius, 1);
        // top branches
        drawBranch(topX, topY, branchLength, Math.PI / 2, penRadius, 1);
        // right branches
        drawBranch(leftX, leftY, branchLength, Math.PI, penRadius, 1);
        // bottom branches
        drawBranch(bottomX, bottomY, branchLength, 3 * (Math.PI / 2), penRadius, 1);
        /*
         * This method draws a + sign at the center of the canvas in black, then calls
         * the drawBranch() once for each side of the + sign to draw branches on each
         * side. Since the drawBranch() function is recursive, calling it once will make
         * it run LEVELS times, to create a snowflake. We pass the drawBranch function
         * the coordinates of its side of the canvas, aswell as the angle the branches
         * should be drawn from.
         */
    }

    public void drawBranch(double xStart, double yStart, double length, double angle, double penRadius, int level) {

        if (level <= LEVELS) { // If we have not drawn all of the levels yet,
            StdDraw.setPenRadius(penRadius); // set the pen radius

            // Parallel line coordinates
            double parallelLineX2 = xStart + length * (Math.cos(angle));
            double parallelLineY2 = yStart + length * (Math.sin(angle));

            // Orthogonal line coordinates
            double orthogonalLine1_X2 = xStart + length * (Math.cos(angle + (Math.PI / 2)));
            double orthogonalLine1_Y2 = yStart + length * (Math.sin(angle + (Math.PI / 2)));
            double orthogonalLine2_X2 = xStart + length * (Math.cos(angle + (3 * (Math.PI / 2))));
            double orthogonalLine2_Y2 = yStart + length * (Math.sin(angle + (3 * (Math.PI / 2))));

            // First angled line coordinates
            double angledLined1_X2 = xStart + length * (Math.cos(angle - (Math.PI / 3)));
            double angledLined1_Y2 = yStart + length * (Math.sin(angle - (Math.PI / 3)));

            // Second angled line coordinates
            double angledLined2_X2 = xStart + length * (Math.cos(angle + (Math.PI / 3)));
            double angledLined2_Y2 = yStart + length * (Math.sin(angle + (Math.PI / 3)));

            // Draw each of the lines with the given coordinates :

            StdDraw.line(xStart, yStart, parallelLineX2, parallelLineY2);

            StdDraw.line(xStart, yStart, orthogonalLine1_X2, orthogonalLine1_Y2);

            StdDraw.line(xStart, yStart, orthogonalLine2_X2, orthogonalLine2_Y2);

            StdDraw.line(xStart, yStart, angledLined1_X2, angledLined1_Y2);

            StdDraw.line(xStart, yStart, angledLined2_X2, angledLined2_Y2);

            // Draw the next level of branches

            // parallel line branch
            drawBranch(parallelLineX2, parallelLineY2, length / 2, angle, penRadius / 2, level + 1);

            // orthogonal line 1 branch
            drawBranch(orthogonalLine1_X2, orthogonalLine1_Y2, length / 2, angle + (Math.PI / 2), penRadius / 2,
                    level + 1);

            // orthogonal line 2 branch
            drawBranch(orthogonalLine2_X2, orthogonalLine2_Y2, length / 2, angle - (Math.PI / 2), penRadius / 2,
                    level + 1);

            // angled line 1 branch
            drawBranch(angledLined1_X2, angledLined1_Y2, length / 2, angle - (Math.PI / 4), penRadius / 2, level + 1);

            // angled line 2 branch
            drawBranch(angledLined2_X2, angledLined2_Y2, length / 2, angle + (Math.PI / 4), penRadius / 2, level + 1);
        }
        /*
         * This method draws 5 lines on the end of a previous branch, then calls itself
         * to draw another set of branches on each of the lines. The function will call
         * itself LEVELS times. We give the function the position we want to draw the
         * lines and the angle we want to draw them at. We want to draw lines at the end
         * of each of the 5 lines.
         */
    }
}