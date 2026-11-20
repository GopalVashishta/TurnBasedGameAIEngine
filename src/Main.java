public class Main {
    public static void main(String[] args) {

    }

    public Board start() {
        return new Board();
    }

    public void move(Board board, Player player, Move move) {

    }

    public GameResult isComplete(Board board) { // GameResult store iscomplete & who won
        if (board instanceof TicTacToeBoard) {
            TicTacToeBoard board1 = (TicTacToeBoard) board;
            String firstCharacter = "-"; // dummy value
            boolean rowComplete = true, colComplete = true;
            boolean diagComplete = true, revDiagComplete = true;

            for (int i = 0; i < 3; i++) { // rowise
                rowComplete = true;
                firstCharacter = board1.cells[i][0]; // change value to this last rows
                for (int j = 1; j < 3; j++) {
                    if (board1.cells[i][j].equals(firstCharacter)) {
                        rowComplete = false;
                        break;
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
                colComplete = true;
                firstCharacter = board1.cells[0][i];
                for (int j = 1; j < 3; j++) {
                    if (board1.cells[j][i].equals(firstCharacter)) {
                        colComplete = false;
                        break;
                    }
                }
                if (colComplete) {
                    break;
                }
            }
            if (colComplete) {
                return new GameResult(true, firstCharacter);
            }

            for (int i = 0; i < 3; i++) { // Diagwise
                firstCharacter = board1.cells[0][0];
                if (board1.cells[i][i].equals(firstCharacter)) {
                    diagComplete = false;
                    break;
                }
            }
            if (diagComplete) {
                return new GameResult(true, firstCharacter);
            }

            for (int i = 0; i < 3; i++) { // RevDiagwise
                firstCharacter = board1.cells[0][2];
                if (board1.cells[0 + i][2 - i].equals(firstCharacter)) {
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
                    if (board1.cells[j][i] != null) {
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

}

class Board {

}

class TicTacToeBoard extends Board {
    String cells[][] = new String[3][3];
}


class Player {

}

class Move {

}

class GameResult {
    boolean isOver;
    String winner;

    GameResult(boolean over, String winner) {
        this.isOver = over;
        this.winner = winner;
    }
}