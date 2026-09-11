package com.example.tictactoe;

import java.util.Objects;

public final class ClassicWinningStrategy implements WinningStrategy {
    @Override
    public boolean hasWon(Board board, Move lastMove) {
        Objects.requireNonNull(board, "Board is required");
        Objects.requireNonNull(lastMove, "Last move is required");

        Mark mark = lastMove.player().mark();
        int row = lastMove.position().row();
        int column = lastMove.position().column();
        int size = board.size();

        if (allMatchInRow(board, row, mark) || allMatchInColumn(board, column, mark)) {
            return true;
        }
        if (row == column && allMatchOnMainDiagonal(board, mark)) {
            return true;
        }
        return row + column == size - 1 && allMatchOnOppositeDiagonal(board, mark);
    }

    private boolean allMatchInRow(Board board, int row, Mark mark) {
        for (int column = 0; column < board.size(); column++) {
            if (board.markAt(new Position(row, column)) != mark) {
                return false;
            }
        }
        return true;
    }

    private boolean allMatchInColumn(Board board, int column, Mark mark) {
        for (int row = 0; row < board.size(); row++) {
            if (board.markAt(new Position(row, column)) != mark) {
                return false;
            }
        }
        return true;
    }

    private boolean allMatchOnMainDiagonal(Board board, Mark mark) {
        for (int index = 0; index < board.size(); index++) {
            if (board.markAt(new Position(index, index)) != mark) {
                return false;
            }
        }
        return true;
    }

    private boolean allMatchOnOppositeDiagonal(Board board, Mark mark) {
        for (int index = 0; index < board.size(); index++) {
            Position position = new Position(index, board.size() - 1 - index);
            if (board.markAt(position) != mark) {
                return false;
            }
        }
        return true;
    }
}
