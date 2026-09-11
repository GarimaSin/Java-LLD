package com.example.tictactoe;

public final class Player {
    private final String playerId;
    private final String name;
    private final Mark mark;

    public Player(
            String playerId,
            String name,
            Mark mark
    ) {
        this.playerId = playerId;
        this.name = name;
        this.mark = mark;
    }

    public String playerId() {
        return playerId;
    }

    public String name() {
        return name;
    }

    public Mark mark() {
        return mark;
    }

    // Java records also generate:
    // equals(), hashCode(), and toString()
}
