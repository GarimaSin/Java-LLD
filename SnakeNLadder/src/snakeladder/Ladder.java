package snakeladder;

/** Lands on bottom (start), moves to top (end). */
public final class Ladder extends Jump {
    public Ladder(int bottom, int top) {
        super(bottom, top);
        // Required constructor validation: bottom < top. Board checks board bounds.
    }

    @Override
    public JumpType getType() { return JumpType.LADDER; }
}
