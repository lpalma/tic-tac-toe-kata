package com.codurance.ticTacToe.board;

import com.codurance.ticTacToe.InvalidMoveException;
import com.codurance.ticTacToe.Player;
import com.codurance.ticTacToe.Result;
import com.codurance.ticTacToe.Square;

import java.util.*;
import java.util.stream.Collectors;
import java.util.Map.Entry;

import static com.codurance.ticTacToe.Player.X;
import static com.codurance.ticTacToe.Result.X_WON;
import static com.codurance.ticTacToe.Square.*;
import static java.util.Arrays.asList;

public class Board implements NextBoard {
    private HashMap<Player, List<Square>> plays;

    private List<List<Square>> winningRows = asList(
            asList(TOP_LEFT, TOP_CENTER, TOP_RIGHT),
            asList(MIDDLE_LEFT, MIDDLE_CENTER, MIDDLE_RIGHT),
            asList(BOTTOM_LEFT, BOTTOM_CENTER, BOTTOM_RIGHT),
            asList(TOP_LEFT, MIDDLE_LEFT, BOTTOM_LEFT),
            asList(TOP_CENTER, MIDDLE_CENTER, BOTTOM_CENTER),
            asList(TOP_RIGHT, MIDDLE_RIGHT, BOTTOM_RIGHT),
            asList(TOP_LEFT, MIDDLE_CENTER, BOTTOM_RIGHT),
            asList(TOP_RIGHT, MIDDLE_CENTER, BOTTOM_LEFT)
    );

    public static Board empty() {
        return new Board(new HashMap<>());
    }

    public NextBoard play(Player player, Square square) throws InvalidMoveException {
        if (squareNotAvailable(square)) {
            throw new InvalidMoveException();
        }

        List<Square> playerSquares = playsFrom(player, square);

        Optional<List<Square>> winningRow = winningRows.stream()
                .filter(playerSquares::containsAll)
                .findFirst();

        if (winningRow.isPresent()) {
            return new EndBoard(X_WON);
        }

        return new Board(mergePlays(player, playerSquares));
    }

    private List<Square> playsFrom(Player player, Square square) {
        List<Square> squares = plays.getOrDefault(player, new ArrayList<>());

        squares.add(square);

        return squares;
    }

    public Optional<Result> result() {
        return Optional.empty();
    }

    private HashMap<Player, List<Square>> mergePlays(Player player, List<Square> squares) {
        HashMap<Player, List<Square>> newBoard = new HashMap<>(plays);

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
