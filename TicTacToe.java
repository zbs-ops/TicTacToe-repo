import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        char currentPlayer = 'X';
        boolean gameEnded = false;

        Scanner scanner = new Scanner(System.in);

        while (!gameEnded) {
            // Display the current state of the board
            printBoard(board);

            // Get the current player's move
            System.out.print("Player " + currentPlayer + ", enter your row (0-2): ");
            int row = scanner.nextInt();
            System.out.print("Player " + currentPlayer + ", enter your column (0-2): ");
            int col = scanner.nextInt();

            // Check if the move is valid
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                board[row][col] = currentPlayer;

                // Check for a win or a tie
                gameEnded = checkWin(board, currentPlayer) || checkTie(board);

                // Switch players
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }

        // Display the final state of the board
        printBoard(board);

        scanner.close();
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }
    }

    public static boolean checkWin(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    public static boolean checkTie(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
