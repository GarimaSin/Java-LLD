package com.example.tictactoe;

import java.util.Objects;

//Move.java
public final class Move {
	private final Player player;
	private final Position position;

	public Move(Player player, Position position) {
		if (player == null) {
			throw new IllegalArgumentException("Player cannot be null");
		}

		if (position == null) {
			throw new IllegalArgumentException("Position cannot be null");
		}

		this.player = player;
		this.position = position;
	}

	public Player getPlayer() {
		return player;
	}

	public Position getPosition() {
		return position;
	}

	@Override
	public String toString() {
		return player.name()
				+ " played at "
				+ position;
	}
}


//public record Move(Player player, Position position) {
//public Move {
//  Objects.requireNonNull(player, "Player is required");
//  Objects.requireNonNull(position, "Position is required");
//}
//}