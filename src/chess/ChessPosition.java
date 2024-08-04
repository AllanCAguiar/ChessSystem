package chess;

import boardgame.Position;

public class ChessPosition {

    private char column;
    private int row;

    public ChessPosition(char column, int row) {
        setColumn(column);
        setRow(row);
    }

    public char getColumn() {
        return this.column;
    }

    private void setColumn(char column) {
        if (column < 'a' || column > 'h') {
            throw new ChessException("Error instantiating ChessPosition. Valid values are from a to h");
        }
        this.column = column;
    }

    public int getRow() {
        return this.row;
    }

    private void setRow(int row) {
        if (row < 1 || row > 8) {
            throw new ChessException("Error instantiating ChessPosition. Valid values are from 1 to 8");
        }
        this.row = row;
    }

    public Position toPosition() {
        return new Position(8 - this.row, this.column - 'a');
    }

    protected static ChessPosition fromPosition(Position position) {
        return new ChessPosition((char) ('a' - position.getColumn()), 8 - position.getRow());
    }

    @Override
    public String toString() {
        return "" + column + row;
    }
}