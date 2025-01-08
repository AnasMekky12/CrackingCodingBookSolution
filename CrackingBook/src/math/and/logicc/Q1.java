package math.and.logicc;
/**
 * You have 20 bottles of pills. 19 bottles have 1.0-gram pills, but one has pills weighing 1.1 grams.
 * Given a scale that provides an exact measurement, how would you find the heavy bottle?
 * You can only use the scale once.
 */

public class Q1 {

    public static void main(String[] args) {
        double[] bottles = new double[20];
        for (int i = 0; i < bottles.length; i++) {
            bottles[i] = 1.0;
        }
        bottles[12] = 1.1;

        double expectedWeight = 0;
        double actualWeight = 0;
        for (int i = 0; i < bottles.length; i++) {
            int pillsTaken = i + 1;
            expectedWeight += pillsTaken * 1.0;
            actualWeight += pillsTaken * bottles[i];
        }

        double weightDifference = actualWeight - expectedWeight;
        int heavyBottle = (int) Math.round(weightDifference / 0.1);

        System.out.println("The heavy bottle is Bottle #" + heavyBottle);
    }
}
