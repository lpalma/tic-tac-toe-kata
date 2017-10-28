package com.codurance.ticTacToe;

import java.util.HashMap;
import java.util.Optional;

public class Board implements NextBoard {
    private HashMap<Player, Square> plays;

    public static Board empty() {
        return new Board(new HashMap<>());
    }

    public NextBoard play(Player player, Square square) throws InvalidMoveException {
        if (this.plays.containsValue(square)) {
            throw new InvalidMoveException();
        }

        return new Board(mergePlays(player, square));
    }

    public Optional<Result> result() {
        throw new UnsupportedOperationException();
    }

    private HashMap<Player, Square> mergePlays(Player player, Square square) {
        HashMap<Player, Square> newBoard = new HashMap<>(plays);
        newBoard.put(player, square);

        return newBoard;
    }

    private Board(HashMap<Player, Square> playerSquareHashMap) {
        plays = playerSquareHashMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Board board = (Board) o;

        return plays != null ? plays.equals(board.plays) : board.plays == null;
    }

    @Override
    public int hashCode() {
        return plays != null ? plays.hashCode() : 0;
    }
}
