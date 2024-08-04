package boardgame;

public class Board {
    private int rows;
    private int columns;
    private Piece pieces[][];

    public Board(int rows, int columns) {
        setRows(rows);
        setColumns(columns);
        this.pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return this.rows;
    }

    private void setRows(int rows) {
        if (rows < 1) {
            throw new BoardException("There must be at least 1 row");
        }
        this.rows = rows;
    }

    public int getColumns() {
        return this.columns;
    }

    private void setColumns(int columns) {
        if (columns < 1) {
            throw new BoardException("There must be at least 1 row");
        }
        this.columns = columns;
    }

    private Piece piece(int row, int column) {
        if (!positionExists(row, column)) {
            throw new BoardException("Position not on the board");
        }
        return this.pieces[row][column];
    }

    public Piece piece(Position position) {
        return piece(position.getRow(), position.getColumn());
    }

    public void placePiece(Piece piece, Position position) {
        if (thereIsAPiece(position)) {
            throw new BoardException("There is already a piece on position " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    private boolean positionExists(int row, int column) {
        return row >= 0 && row < this.rows && column >= 0 && column < this.columns;
    }

    public Piece removePiece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        if (piece(position) == null) {
            return null;
        }
        Piece aux = piece(position);
        aux.position = null;
        pieces[position.getRow()][position.getColumn()] = null;
        return aux;
    }

    public boolean positionExists(Position position) {
        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        return piece(position) != null;
    }
}
