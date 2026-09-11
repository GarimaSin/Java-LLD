package snakeladder;

/** Lands on head (start), moves to tail (end). */
public final class Snake extends Jump {
    public Snake(int head, int tail) {
        super(head, tail);
        // Required constructor validation: head > tail. Board checks board bounds.
    }

    @Override
    public JumpType getType() { return JumpType.SNAKE; }
}
