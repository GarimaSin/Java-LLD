package snakeladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/** Immutable turn outcome; a future UI can display it without owning game logic. */
public final class TurnResult {
    private final String playerId;
    private final int diceValue;
    private final int previousPosition;
    private final int finalPosition;
    private final List<Jump> appliedJumps;
    private final boolean overshot;
    private final boolean won;
    private final Optional<String> nextPlayerId;

    public TurnResult(String playerId, int diceValue, int previousPosition,
                      int finalPosition, List<Jump> appliedJumps,
                      boolean overshot, boolean won, Optional<String> nextPlayerId) {
        this.playerId = playerId;
        this.diceValue = diceValue;
        this.previousPosition = previousPosition;
        this.finalPosition = finalPosition;
        // Java 8: make a defensive copy, then expose a read-only list.
        List<Jump> jumpCopy = new ArrayList<Jump>(
                Objects.requireNonNull(appliedJumps, "appliedJumps"));
        for (Jump item : jumpCopy) {
            Objects.requireNonNull(item, "appliedJumps must not contain null");
        }
        this.appliedJumps = Collections.unmodifiableList(jumpCopy);
        this.overshot = overshot;
        this.won = won;
        this.nextPlayerId = nextPlayerId;
    }

    public String getPlayerId() { return playerId; }
    public int getDiceValue() { return diceValue; }
    public int getPreviousPosition() { return previousPosition; }
    public int getFinalPosition() { return finalPosition; }
    public List<Jump> getAppliedJumps() { return appliedJumps; }
    public boolean isOvershot() { return overshot; }
    public boolean isWon() { return won; }
    public Optional<String> getNextPlayerId() { return nextPlayerId; }
}
