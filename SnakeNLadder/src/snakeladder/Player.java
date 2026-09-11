package snakeladder;

/** A player's state in ONE game, not a reusable account object. */
public final class Player {
    private final String id;
    private final String name;
    private int position;

    public Player(String id, String name) {
        // Contract: id and name must be non-null and non-blank.
        this.id = id;
        this.name = name;
        this.position = 0;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getPosition() { return position; }

    /** Package-private: called by Game, never by the UI. */
    void moveTo(int position) {
        // Contract: Game supplies a position in 0..board.size.
        throw new UnsupportedOperationException("LLD placeholder: moveTo");
    }
}
