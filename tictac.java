import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';
    private static boolean gameEnded = false;

    public static void main(String[] args) {
        initializeBoard();
        printBoard();
        
        Scanner scanner = new Scanner(System.in);
        
        while (!gameEnded) {
            System.out.println("Player " + currentPlayer + ", enter your move (row[1-3] column[1-3]):");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;
            
            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                
                if (checkWin()) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameEnded = true;
                } else if (checkDraw()) {
                    System.out.println("The game is a draw!");
                    gameEnded = true;
                } else {
                    switchPlayer();
                }
                
                printBoard();
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }
        
        scanner.close();
    }

    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    private static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-';
    }

    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private static boolean checkWin() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }
        
        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != '-' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return true;
            }
        }
        
        // Check diagonals
        if (board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        
        if (board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }
        
        return false;
    }

    private static boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}