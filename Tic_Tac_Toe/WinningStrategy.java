package com.example.tictactoe;

public interface WinningStrategy {
    boolean hasWon(Board board, Move lastMove);
}
