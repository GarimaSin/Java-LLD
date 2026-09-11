package com.example.tictactoe;

public final class GameAlreadyFinishedException extends GameException {
    public GameAlreadyFinishedException(GameStatus status) {
        super("Game has already finished with status: " + status);
    }
}
