package snakeladder;

import java.util.List;
import java.util.Map;

/** Resolves snakes and ladders; does not roll dice or manage turns. */
public final class Board {
    private final int size;
    private final Map<Integer, Jump> jumpsByStart;

    public Board(int size, List<Jump> jumps) {
        this.size = size;
        this.jumpsByStart = buildValidatedJumpMap(size, jumps);
    }

    public int getSize() { return size; }

    /**
     * Input must be in 1..size; Game handles overshoots before this call.
     * Repeatedly look up the current square in jumpsByStart.
     * Follow each jump, collecting the path, until no jump starts there.
     * Return the final square and all applied jumps.
     */
    public LandingResult resolveLanding(int position) {
        throw new UnsupportedOperationException("LLD placeholder: resolveLanding");
    }

    /**
     * Require a positive size and a non-null collection with non-null jumps.
     * Check bounds and directions. Reject duplicate starts BEFORE building the map.
     * Reject jump cycles, then return an immutable copy of the validated map.
     */
    private static Map<Integer, Jump> buildValidatedJumpMap(int size, List<Jump> jumps) {
        throw new UnsupportedOperationException("LLD placeholder: board validation");
    }

    /** Start: 1..size-1. End: 1..size. A jump cannot start on the winning square. */
    private static void validateJumpBounds(int size, Jump jump) {
        throw new UnsupportedOperationException("LLD placeholder: jump bounds");
    }

    /** Follow jump endpoints; reject any path that returns to a node on that path. */
    private static void validateNoCycles(Map<Integer, Jump> jumps) {
        throw new UnsupportedOperationException("LLD placeholder: cycle detection");
    }
}
