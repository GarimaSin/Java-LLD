package snakeladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/** Owns player positions, turn order, and the game lifecycle. Design skeleton only. */
public final class Game {
    private final String gameId;
    private final Board board;
    private final Dice dice;
    private final List<Player> players;
    private int currentPlayerIndex;
    private GameStatus status;
    private Player winner;

    public Game(String gameId, Board board, Dice dice, List<Player> players) {
        this.gameId = gameId;
        this.board = board;
        this.dice = dice;
        // Java 8: make a defensive copy, then expose a read-only list.
        List<Player> playerCopy = new ArrayList<Player>(
                Objects.requireNonNull(players, "players"));
        for (Player item : playerCopy) {
            Objects.requireNonNull(item, "players must not contain null");
        }
        this.players = Collections.unmodifiableList(playerCopy);
        this.currentPlayerIndex = 0;
        this.status = GameStatus.CREATED;
        this.winner = null;
        validatePlayers();
    }

    /** CREATED -> IN_PROGRESS. Reject an already started or finished game. */
    public void start() {
        throw new UnsupportedOperationException("LLD placeholder: start");
    }

    /**
     * 1. Validate status and current player before rolling.
     * 2. Roll and validate the dice result.
     * 3. Add the roll to the current position.
     * 4. Overshoot: keep the position; otherwise ask Board to resolve the landing.
     * 5. Update the position; declare a winner or advance the turn.
     * 6. Return an immutable TurnResult.
     * Validate and resolve the move before changing game state.
     */
    public TurnResult playTurn(String playerId) {
        throw new UnsupportedOperationException("LLD placeholder: playTurn");
    }

    /** Empty before start and after the game finishes. */
    public Optional<Player> getCurrentPlayer() {
        throw new UnsupportedOperationException("LLD placeholder: getCurrentPlayer");
    }

    /** Read-only roster; callers cannot move players through the public API. */
    public List<Player> getPlayers() { return players; }
    public Optional<Player> getWinner() { return Optional.ofNullable(winner); }
    public GameStatus getStatus() { return status; }
    public String getGameId() { return gameId; }

    /** Require non-null dependencies, >= 2 fresh players, and unique player IDs. */
    private void validatePlayers() {
        throw new UnsupportedOperationException("LLD placeholder: setup validation");
    }

    /** Reject a non-running game or a player who does not own the current turn. */
    private void validateTurn(String playerId) {
        throw new UnsupportedOperationException("LLD placeholder: turn validation");
    }

    /** Next index = (currentPlayerIndex + 1) % players.size(). */
    private void advanceTurn() {
        throw new UnsupportedOperationException("LLD placeholder: advanceTurn");
    }
}
