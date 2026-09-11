package com.example.tictactoe;

//Position.java
public final class Position {
	private final int row;
	private final int column;

	public Position(int row, int column) {
		if (row < 0 || column < 0) {
			throw new IllegalArgumentException("Row and column cannot be negative");
		}
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	@Override
	public String toString() {
		return "(" + row + ", " + column + ")";
	}

}


//public record Position(int row, int column) {
//public Position {
//  if (row < 0 || column < 0) {
//      throw new InvalidPositionException(row, column);
//  }
//}
//}