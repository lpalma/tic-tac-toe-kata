package com.codurance.ticTacToe;

import java.util.HashMap;

public class Board {
    private HashMap<Player, Square> plays;

    public Board(HashMap<Player, Square> playerSquareHashMap) {
        plays = playerSquareHashMap;
    }

    public static Board empty() {
        return new Board(new HashMap<>());
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
