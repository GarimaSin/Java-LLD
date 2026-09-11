package com.example.tictactoe;

import java.util.Arrays;
import java.util.Objects;

public final class Board {
    private final int size;
    private final Mark[][] cells;
    private int occupiedCells;

    public Board(int size) {
        if (size < 3) {
            throw new IllegalArgumentException("Board size must be at least 3");
        }

        this.size = size;
        this.cells = new Mark[size][size];
        for (Mark[] row : cells) {
            Arrays.fill(row, Mark.EMPTY);
        }
    }

    public int size() {
        return size;
    }

    public synchronized Mark markAt(Position position) {
        validatePosition(position);
        return cells[position.row()][position.column()];
    }

    public synchronized boolean isFull() {
        return occupiedCells == size * size;
    }

    synchronized void placeMark(Position position, Mark mark) {
        validatePosition(position);
        Objects.requireNonNull(mark, "Mark is required");

        if (mark == Mark.EMPTY) {
            throw new IllegalArgumentException("Cannot place the EMPTY mark");
        }
        if (cells[position.row()][position.column()] != Mark.EMPTY) {
            throw new CellAlreadyOccupiedException(position);
        }

        cells[position.row()][position.column()] = mark;
        occupiedCells++;
    }

    public synchronized String render() {
        StringBuilder output = new StringBuilder();

        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                output.append(" ").append(cells[row][column].symbol()).append(" ");
                if (column < size - 1) {
                    output.append("|");
                }
            }
            output.append(System.lineSeparator());

            if (row < size - 1) {
                for (int column = 0; column < size; column++) {
                    output.append("---");
                    if (column < size - 1) {
                        output.append("+");
                    }
                }
                output.append(System.lineSeparator());
            }
        }

        return output.toString();
    }

    private void validatePosition(Position position) {
        Objects.requireNonNull(position, "Position is required");
        if (position.row() >= size || position.column() >= size) {
            throw new InvalidPositionException(position.row(), position.column());
        }
    }
}
