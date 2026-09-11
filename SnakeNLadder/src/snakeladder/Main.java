package snakeladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * The existing placeholder methods must be implemented before gameplay works.
 */
public class Main {

    public static void main(String[] args) {
        // 1. Configure snakes and ladders.
        List<Jump> jumps = new ArrayList<Jump>();
        jumps.add(new Snake(47, 16));
        jumps.add(new Snake(98, 79));
        jumps.add(new Ladder(4, 25));
        jumps.add(new Ladder(25, 40)); // Chained ladder: 4 -> 25 -> 40.
        jumps.add(new Ladder(90, 100));

        // 2. Create the board, dice, and players.
        Board board = new Board(100, jumps);
        Dice dice = new StandardDice(6);

        List<Player> players = Arrays.asList(
                new Player("P1", "Alice"),
                new Player("P2", "Bob")
        );

        // 3. Create and start the game.
        Game game = new Game("GAME-1", board, dice, players);
        game.start();

        // 4. Let Game handle each turn, movement, and winning rules.
        while (game.getStatus() == GameStatus.IN_PROGRESS) {
            Optional<Player> currentPlayer = game.getCurrentPlayer();

            if (!currentPlayer.isPresent()) {
                throw new IllegalStateException(
                        "An active game must have a current player.");
            }

            Player player = currentPlayer.get();

            TurnResult result = game.playTurn(player.getId());
            printTurn(player.getName(), result);
        }

        // 5. Display the winner.
        Optional<Player> winner = game.getWinner();

        if (winner.isPresent()) {
            System.out.println("Winner: " + winner.get().getName());
        }
    }

    private static void printTurn(String playerName, TurnResult result) {
        System.out.println(playerName + " rolled " + result.getDiceValue());
        System.out.println("Started at: " + result.getPreviousPosition());

        if (result.isOvershot()) {
            System.out.println("Overshot the last square. Position unchanged.");
        }

        for (Jump jump : result.getAppliedJumps()) {
            System.out.println(jump.getType() + ": "
                    + jump.getStart() + " -> " + jump.getEnd());
        }

        System.out.println("Final position: " + result.getFinalPosition());
        System.out.println();
    }
}