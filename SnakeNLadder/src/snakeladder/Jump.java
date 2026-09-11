package snakeladder;

/** Immutable connection shared by snakes and ladders. */
public abstract class Jump {
    private final int start;
    private final int end;

    protected Jump(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() { return start; }
    public int getEnd() { return end; }
    public abstract JumpType getType();
}
