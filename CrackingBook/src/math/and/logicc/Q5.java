package math.and.logicc;
/**
 * You have a five-quart jug, a three-quart jug, and an unlimited supply of water (but no measuring cups).
 * How would you come up with exactly four quarts of water? Note that the jugs are oddly shaped,
 * such that filling up exactly “half” of the jug would be impossible.
 */

public class Q5 {

    public static void main(String[] args) {
        int jug5 = 0;
        int jug3 = 0;

        System.out.println("Initial State: Jug5 = " + jug5 + ", Jug3 = " + jug3);

        jug5 = 5;
        System.out.println("Step 1: Fill the 5-quart jug. Jug5 = " + jug5 + ", Jug3 = " + jug3);

        jug3 = 3;
        jug5 -= 3;
        System.out.println("Step 2: Pour from Jug5 to Jug3. Jug5 = " + jug5 + ", Jug3 = " + jug3);

        jug3 = 0;
        System.out.println("Step 3: Empty the 3-quart jug. Jug5 = " + jug5 + ", Jug3 = " + jug3);

        jug3 = jug5;
        jug5 = 0;
        System.out.println("Step 4: Pour from Jug5 to Jug3. Jug5 = " + jug5 + ", Jug3 = " + jug3);

        jug5 = 5;
        System.out.println("Step 5: Fill the 5-quart jug. Jug5 = " + jug5 + ", Jug3 = " + jug3);

        int remainingCapacity = 3 - jug3;
        jug3 += remainingCapacity;
        jug5 -= remainingCapacity;
        System.out.println("Step 6: Pour from Jug5 to Jug3. Jug5 = " + jug5 + ", Jug3 = " + jug3);

        System.out.println("Done! Jug5 = " + jug5 + ", Jug3 = " + jug3);
    }
}
