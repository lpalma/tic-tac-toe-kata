package com.codurance.ticTacToe.board;

import com.codurance.ticTacToe.InvalidMoveException;
import com.codurance.ticTacToe.Player;
import com.codurance.ticTacToe.Result;
import com.codurance.ticTacToe.Square;

import java.util.*;
import java.util.stream.Collectors;

import static com.codurance.ticTacToe.Result.DRAW;
import static com.codurance.ticTacToe.Result.X_WON;

public class Board implements NextBoard {
    public static final int BOARD_SIZE = 9;

    private HashMap<Player, List<Square>> board;

    public static Board empty() {
        return new Board(new HashMap<>());
    }

    public NextBoard play(Player player, Square square) throws InvalidMoveException {
        if (squareNotAvailable(square)) {
            throw new InvalidMoveException();
        }

        return nextBoard(player, square);
    }

    public Optional<Result> result() {
        return Optional.empty();
    }

    private NextBoard nextBoard(Player player, Square square) {
        List<Square> playerSquares = playsFrom(player);
        playerSquares.add(square);

        if (winningRowFor(playerSquares).isPresent()) {
            return new EndBoard(X_WON);
        }

        if (isBoardFull(square)) {
            return new EndBoard(DRAW);
        }

        return new Board(mergePlays(player, playerSquares));
    }

    private boolean isBoardFull(Square currentSquare) {
        List<Square> playedSquares = playedSquares();
        playedSquares.add(currentSquare);

        return playedSquares.size() == BOARD_SIZE;
    }

    private Optional<WinningRow> winningRowFor(List<Square> playerSquares) {
        return Arrays.stream(WinningRow.values())
                .filter(row -> playerSquares.containsAll(row.squares()))
                .findFirst();
    }

    private List<Square> playsFrom(Player player) {
        List<Square> plays = board.getOrDefault(player, new ArrayList<>());

        return new ArrayList<>(plays);
    }

    private HashMap<Player, List<Square>> mergePlays(Player player, List<Square> squares) {
        HashMap<Player, List<Square>> newBoard = new HashMap<>(board);

        newBoard.put(player, squares);

        return newBoard;
    }

    private boolean squareNotAvailable(Square square) {
        return playedSquares().contains(square);
    }

    private List<Square> playedSquares() {
        return board.values()
                    .stream()
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());
    }

    private Board(HashMap<Player, List<Square>> playerSquareHashMap) {
        board = playerSquareHashMap;
    }
}
