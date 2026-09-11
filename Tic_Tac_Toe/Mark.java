package com.example.tictactoe;

public enum Mark {
    EMPTY(" "),
    X("X"),
    O("O");

    private final String symbol;

    Mark(String symbol) {
        this.symbol = symbol;
    }

    public String symbol() {
        return symbol;
    }
}
