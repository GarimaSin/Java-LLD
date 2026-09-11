package com.example.tictactoe;

public final class CellAlreadyOccupiedException extends GameException {
    public CellAlreadyOccupiedException(Position position) {
        super("Cell is already occupied: row=" + position.row() + ", column=" + position.column());
    }
}
