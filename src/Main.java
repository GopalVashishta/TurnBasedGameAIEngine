import api.GameEngine;
import game.Board;
import game.Cell;
import game.Player;
import game.Move;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = -1, col = -1;

        GameEngine gameEngine = new GameEngine();
        Board board = gameEngine.start("TicTacToe");

        // making moves in a loop
        while (!gameEngine.isComplete(board).isOver()) {
            System.out.println(board);
            System.out.println("Make your move bih");
            Player computer = new Player("O"), opponent = new Player("X");

            row = sc.nextInt();
            col = sc.nextInt();
            Move oppMove = new Move(new Cell(row, col));
            gameEngine.move(board, opponent, oppMove);

            if (!gameEngine.isComplete(board).isOver()) { // if not over only then computer makes the move
                Move compMove = gameEngine.suggestMove(computer, board);
                gameEngine.move(board, computer, compMove);
            }
        }
    }
}
