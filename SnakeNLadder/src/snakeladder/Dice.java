package snakeladder;

/** Replaceable dice contract: randomness stays outside Game. */
public interface Dice {
    /** Return a value in 1..getSides(), inclusive. */
    int roll();

    int getSides();
}
