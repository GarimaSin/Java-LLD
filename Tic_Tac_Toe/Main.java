package com.example.tictactoe;

import java.util.Scanner;

public final class Main {
    private Main() {}

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String firstName = readName(scanner, "Enter Player 1 name: ", "Player 1");
            String secondName = readName(scanner, "Enter Player 2 name: ", "Player 2");

            TicTacToeGame game = new TicTacToeGame(3,
                    new Player("P1", firstName, Mark.X),
                    new Player("P2", secondName, Mark.O),
                    new ClassicWinningStrategy()
            );

            play(scanner, game);
        }
    }

    private static void play(Scanner scanner, TicTacToeGame game) {
        while (game.status() == GameStatus.IN_PROGRESS) {
            System.out.println();
            System.out.println(game.renderBoard());

            Player current = game.currentPlayer();
            System.out.printf(
                    "%s (%s), enter row and column from 1 to 3: ",
                    current.name(),
                    current.mark()
            );

            if (!scanner.hasNextLine()) {
                return;
            }

            String[] parts = scanner.nextLine().strip().split("\\s+");
            if (parts.length != 2) {
                System.out.println("Enter two numbers, for example: 1 3");
                continue;
            }

            try {
                int row = Integer.parseInt(parts[0]) - 1;
                int column = Integer.parseInt(parts[1]) - 1;
                game.makeMove(current.playerId(), row, column);
            } catch (NumberFormatException exception) {
                System.out.println("Row and column must be numbers.");
            } catch (GameException exception) {
                System.out.println(exception.getMessage());
            }
        }

        System.out.println();
        System.out.println(game.renderBoard());
        if (game.status() == GameStatus.WON) {
            System.out.println("Winner: " + game.winner().orElseThrow().name());
        } else {
            System.out.println("The game is a draw.");
        }
    }

    private static String readName(Scanner scanner, String prompt, String fallback) {
        System.out.print(prompt);
        if (!scanner.hasNextLine()) {
            return fallback;
        }

        String name = scanner.nextLine().strip();
        return name.isEmpty() ? fallback : name;
    }
}
