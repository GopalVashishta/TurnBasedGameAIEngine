package boards;

import game.Board;
import game.Cell;

public class TicTacToeBoard extends Board {
    String cells[][] = new String[3][3];

    public String getCell(int i, int j) {
        return cells[i][j];
    }

    public void setCell(Cell cell, String symbol) {
        cells[cell.getRow()][cell.getCol()] = symbol;
    }

    public void setCell(String symbol, Cell cell) {
        setCell(cell, symbol);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(cells[i][j] == null ? "-" : cells[i][j]);
                if (j < 2) {
                    sb.append(" | ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
