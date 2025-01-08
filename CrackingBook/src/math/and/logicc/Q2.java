package math.and.logicc;
/*
Question:
You have a basketball hoop and someone says that you can play one of two games:
- Game 1: You get one shot to make the hoop.
- Game 2: You get three shots and you have to make at least two out of three shots.
If p is the probability of making a particular shot, for which values of p should you pick one game or the other?
*/

public class Q2 {

    public static void main(String[] args) {
        double p = 0.4;

        if (p < 0 || p > 1) {
            System.out.println("Invalid value for p. It should be between 0 and 1.");
            return;
        }

        double game1Probability = p;
        double game2Probability = calculateGame2Probability(p);

        if (game1Probability > game2Probability) {
            System.out.println("You should choose Game 1.");
        } else if (game2Probability > game1Probability) {
            System.out.println("You should choose Game 2.");
        } else {
            System.out.println("Both games have equal probabilities. It doesn't matter which one you choose.");
        }
    }

    public static double calculateGame2Probability(double p) {
        double allThree = Math.pow(p, 3);
        double exactlyTwo = 3 * Math.pow(p, 2) * (1 - p);
        return allThree + exactlyTwo;
    }
}

