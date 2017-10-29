package com.codurance.ticTacToe.board;

import com.codurance.ticTacToe.InvalidMoveException;
import com.codurance.ticTacToe.Player;
import com.codurance.ticTacToe.Result;
import com.codurance.ticTacToe.Square;

import java.util.*;
import java.util.stream.Collectors;

import static com.codurance.ticTacToe.Result.X_WON;

public class Board implements NextBoard {
    private HashMap<Player, List<Square>> plays;

    public static Board empty() {
        return new Board(new HashMap<>());
    }

    public NextBoard play(Player player, Square square) throws InvalidMoveException {
        if (squareNotAvailable(square)) {
            throw new InvalidMoveException();
        }

        return nextBoard(player, square);
    }

    private NextBoard nextBoard(Player player, Square square) {
        List<Square> playerSquares = playsFrom(player);
        playerSquares.add(square);

        if (winningRowFor(playerSquares).isPresent()) {
            return new EndBoard(X_WON);
        }

        return new Board(mergePlays(player, playerSquares));
    }

    private Optional<WinningRow> winningRowFor(List<Square> playerSquares) {
        return Arrays.stream(WinningRow.values())
                .filter(row -> playerSquares.containsAll(row.squares()))
                .findFirst();
    }

    private List<Square> playsFrom(Player player) {
        return plays.getOrDefault(player, new ArrayList<>());
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
}
