package math.and.logicc;

/*
6.6 Blue-Eyed Island:
A group of people are living on an island, and a visitor comes with a strange order: all blue-eyed people must leave the island as soon as possible.
There is a flight out at 8:00 PM every evening. Each person can see everyone else's eye color, but they do not know their own (nor is anyone allowed to tell them).
Additionally, they do not know how many people have blue eyes, although they do know that at least one person does.
How many days will it take for all the blue-eyed people to leave?

*/

public class Q6 {

    public static void main(String[] args) {
        int n = 100;
        int c = 5;

        int days = calculateDaysToLeave(c);

        System.out.println("عدد الأيام المطلوبة لمغادرة جميع الأشخاص ذوي العيون الزرقاء: " + days);
    }

    public static int calculateDaysToLeave(int c) {
        if (c <= 0) {
            return 0;
        }
        return c;
    }
}
