package snakeladder;

/** Default game uses StandardDice(6). */
public final class StandardDice implements Dice {
    private final int sides;

    public StandardDice(int sides) {
        // Required constructor validation: sides > 0.
        this.sides = sides;
    }

    @Override
    public int getSides() { return sides; }

    @Override
    public int roll() {
        // Generate a uniformly random integer from 1 through sides.
        throw new UnsupportedOperationException("LLD placeholder: dice roll");
    }
}
