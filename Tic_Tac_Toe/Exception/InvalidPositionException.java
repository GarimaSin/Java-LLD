package com.example.tictactoe;

public final class InvalidPositionException extends GameException {
    public InvalidPositionException(int row, int column) {
        super("Invalid position: row=" + row + ", column=" + column);
    }
}
