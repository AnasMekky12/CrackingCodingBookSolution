package math.and.logic;
/*
Ants on a Triangle: There are three ants on different vertices of a triangle.
What is the probability of collision (between any two or all of them) if they start walking
on the sides of the triangle? Assume that each ant randomly picks a direction, with either
direction being equally likely to be chosen, and that they walk at the same speed.

Similarly, find the probability of collision with n ants on an n-vertex polygon.
*/

public class Q4 {

    public static double calculateCollisionProbability(int n) {
        double sameDirectionProbability = Math.pow(0.5, n - 1);
        return 1 - sameDirectionProbability;
    }

    public static void main(String[] args) {
        int n = 3;
        double collisionProbability = calculateCollisionProbability(n);
        System.out.println("احتمالية الاصطدام للنمل " + n + " هي: " + collisionProbability);
    }
}
