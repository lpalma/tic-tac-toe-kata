package com.codurance.ticTacToe.board;

import com.codurance.ticTacToe.InvalidMoveException;
import com.codurance.ticTacToe.Player;
import com.codurance.ticTacToe.Result;
import com.codurance.ticTacToe.Square;

import java.util.*;
import java.util.stream.Collectors;

public class Board implements NextBoard {
    private HashMap<Player, List<Square>> plays;

    public static Board empty() {
        return new Board(new HashMap<>());
    }

    public NextBoard play(Player player, Square square) throws InvalidMoveException {
        if (squareNotAvailable(square)) {
            throw new InvalidMoveException();
        }

        return new Board(mergePlays(player, square));
    }

    public Optional<Result> result() {
        return Optional.empty();
    }

    private HashMap<Player, List<Square>> mergePlays(Player player, Square square) {
        HashMap<Player, List<Square>> newBoard = new HashMap<>(plays);
        List<Square> squares = newBoard.getOrDefault(player, new ArrayList<>());

        squares.add(square);
        newBoard.put(player, squares);

        return newBoard;
    }

    private boolean squareNotAvailable(Square square) {
        List<Square> playedSquares = plays.values()
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        return playedSquares.contains(square);
    }

    private Board(HashMap<Player, List<Square>> playerSquareHashMap) {
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
