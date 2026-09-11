package com.example.tictactoe;

public final class NotPlayersTurnException extends GameException {
    public NotPlayersTurnException(String providedPlayerId, String expectedPlayerId) {
        super("It is not player " + providedPlayerId + "'s turn; expected " + expectedPlayerId);
    }
}
