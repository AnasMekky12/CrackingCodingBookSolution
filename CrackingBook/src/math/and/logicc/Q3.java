package math.and.logicc;
/**
 * There is an 8×8 chessboard in which two diagonally opposite corners have been removed.
 * You are given 31 dominoes, and each domino can cover exactly two squares.
 * Can you use the 31 dominoes to cover the entire board? Prove why it is impossible.
 */
public class Q3 {

    public static void main(String[] args) {
        int boardSize = 8;
        int[][] board = new int[boardSize][boardSize];

        board[0][0] = -1;
        board[7][7] = -1;

        int whiteSquares = 0;
        int blackSquares = 0;

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (board[i][j] == -1) {
                    continue;
                }
                if ((i + j) % 2 == 0) {
                    blackSquares++;
                } else {
                    whiteSquares++;
                }
            }
        }

        System.out.println("Number of white squares: " + whiteSquares);
        System.out.println("Number of black squares: " + blackSquares);

        if (blackSquares != whiteSquares) {
            System.out.println("It is impossible to cover the board with 31 dominoes.");
        } else {
            System.out.println("It is theoretically possible to cover the board with 31 dominoes (but constraints make it impossible).");
        }
    }
}
