package com.example.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public final class TicTacToeGame {
    private final Board board;
    private final List<Player> players;
    private final WinningStrategy winningStrategy;
    private final List<Move> moveHistory = new ArrayList<>();

    private int currentPlayerIndex;
    private GameStatus status = GameStatus.IN_PROGRESS;
    private Player winner;

    public TicTacToeGame(
            int boardSize,
            Player firstPlayer,
            Player secondPlayer,
            WinningStrategy winningStrategy
    ) {
        Objects.requireNonNull(firstPlayer, "First player is required");
        Objects.requireNonNull(secondPlayer, "Second player is required");
        this.winningStrategy = Objects.requireNonNull(winningStrategy, "Winning strategy is required");

        if (firstPlayer.playerId().equals(secondPlayer.playerId())) {
            throw new IllegalArgumentException("Players must have different IDs");
        }
        if (firstPlayer.mark() == secondPlayer.mark()) {
            throw new IllegalArgumentException("Players must have different marks");
        }

        this.board = new Board(boardSize);
        this.players = List.of(firstPlayer, secondPlayer);
    }

    public synchronized Move makeMove(String playerId, int row, int column) {
        return makeMove(playerId, new Position(row, column));
    }

    public synchronized Move makeMove(String playerId, Position position) {
        Objects.requireNonNull(playerId, "Player ID is required");
        Objects.requireNonNull(position, "Position is required");

        if (status != GameStatus.IN_PROGRESS) {
            throw new GameAlreadyFinishedException(status);
        }

        Player player = currentPlayer();
        if (!player.playerId().equals(playerId.strip())) {
            throw new NotPlayersTurnException(playerId, player.playerId());
        }

        board.placeMark(position, player.mark());
        Move move = new Move(player, position);
        moveHistory.add(move);

        if (winningStrategy.hasWon(board, move)) {
            status = GameStatus.WON;
            winner = player;
        } else if (board.isFull()) {
            status = GameStatus.DRAW;
        } else {
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }

        return move;
    }

    public synchronized Player currentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public synchronized GameStatus status() {
        return status;
    }

    public synchronized Optional<Player> winner() {
        return Optional.ofNullable(winner);
    }

    public synchronized List<Move> moveHistory() {
        return List.copyOf(moveHistory);
    }

    public String renderBoard() {
        return board.render();
    }
}
