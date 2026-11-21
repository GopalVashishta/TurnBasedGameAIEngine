package api;

import boards.TicTacToeBoard;
import game.Board;
import game.Cell;
import game.Move;
import game.GameResult;
import game.Player;

public class GameEngine {

    public Board start(String type) throws IllegalArgumentException {
        if (type.equals("TicTacToe")) {
            return new TicTacToeBoard();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void move(Board board, Player player, Move move) throws IllegalArgumentException {
        if (board instanceof TicTacToeBoard) {
            TicTacToeBoard board1 = (TicTacToeBoard) board;
            board1.setCell(move.getCell(), player.symbol());
        } else {
            throw new IllegalArgumentException();
        }
    }

    public GameResult isComplete(Board board) { // game.GameResult store iscomplete & who won
        if (board instanceof TicTacToeBoard) {
            TicTacToeBoard board1 = (TicTacToeBoard) board;
            String firstCharacter = "-"; // dummy value
            boolean rowComplete = true, colComplete = true;
            boolean diagComplete = true, revDiagComplete = true;

            for (int i = 0; i < 3; i++) { // rowise
                firstCharacter = board1.getCell(i, 0); // change value to this last rows
                rowComplete = firstCharacter != null;

                if (firstCharacter != null) {
                    for (int j = 1; j < 3; j++) {
                        if (!firstCharacter.equals(board1.getCell(i, j))) {
                            rowComplete = false;
                            break;
                        }
                    }
                }
                if (rowComplete) {
                    break;
                }
            }
            if (rowComplete) {
                return new GameResult(true, firstCharacter);
            }

            for (int i = 0; i < 3; i++) { // colwise
                firstCharacter = board1.getCell(0, i);
                colComplete = firstCharacter != null;
                if (firstCharacter != null) {
                    for (int j = 1; j < 3; j++) {
                        if (!firstCharacter.equals(board1.getCell(j, i))) {
                            colComplete = false;
                            break;
                        }
                    }
                }
                if (colComplete) {
                    break;
                }
            }
            if (colComplete) {
                return new GameResult(true, firstCharacter);
            }

            firstCharacter = board1.getCell(0, 0);
            diagComplete = firstCharacter != null;
            for (int i = 0; i < 3; i++) { // Diagwise

                if (firstCharacter != null && !firstCharacter.equals(board1.getCell(i, i))) {
                    diagComplete = false;
                    break;
                }
            }
            if (diagComplete) {
                return new GameResult(true, firstCharacter);
            }

            firstCharacter = board1.getCell(0, 2);
            revDiagComplete = firstCharacter != null;
            for (int i = 0; i < 3; i++) { // RevDiagwise
                if (firstCharacter != null && !firstCharacter.equals(board1.getCell(0 + i, 2 - i))) {
                    revDiagComplete = false;
                    break;
                }
            }
            if (revDiagComplete) {
                return new GameResult(true, firstCharacter);
            }

            // if No One won
            int countOfFilledCells = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board1.getCell(i, j) != null) {
                        countOfFilledCells++;
                    }
                }
            }
            if (countOfFilledCells == 9) {
                return new GameResult(true, "-");
            } else {
                return new GameResult(false, "-");
            }
        } else { // for any other games like chess etc.
            return new GameResult(false, "-");
        }
    }

    public Move suggestMove(Player computer, Board board) {
        if (board instanceof TicTacToeBoard) {
            TicTacToeBoard board1 = (TicTacToeBoard) board;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board1.getCell(i, j) == null) {
                        return new Move(new Cell(i, j));
                    }
                }
            }
        }
        return null;
    }

}
