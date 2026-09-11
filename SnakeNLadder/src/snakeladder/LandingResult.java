package snakeladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/** Immutable result returned by Board after resolving all jumps. */
public final class LandingResult {
    private final int finalPosition;
    private final List<Jump> appliedJumps;

    public LandingResult(int finalPosition, List<Jump> appliedJumps) {
        this.finalPosition = finalPosition;
        // Java 8: make a defensive copy, then expose a read-only list.
        List<Jump> jumpCopy = new ArrayList<Jump>(
                Objects.requireNonNull(appliedJumps, "appliedJumps"));
        for (Jump item : jumpCopy) {
            Objects.requireNonNull(item, "appliedJumps must not contain null");
        }
        this.appliedJumps = Collections.unmodifiableList(jumpCopy);
    }

    public int getFinalPosition() { return finalPosition; }
    public List<Jump> getAppliedJumps() { return appliedJumps; }
}
