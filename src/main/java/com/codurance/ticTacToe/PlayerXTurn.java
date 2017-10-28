package com.codurance.ticTacToe;

import java.util.Optional;

import static com.codurance.ticTacToe.Player.X;
import static com.codurance.ticTacToe.Result.X_WON;

public class PlayerXTurn implements GameState {
    private NextBoard board;

    public PlayerXTurn(NextBoard board) {
        this.board = board;
    }

    public GameState playOn(Square square) throws InvalidMoveException, GameFinishedException {
        NextBoard nextBoard = board.play(X, square);

        if (nextBoard.result().isPresent()) {
            return new EndGame(X_WON);
        }

        return new PlayerOTurn(nextBoard);
    }

    public Optional<Result> result() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayerXTurn that = (PlayerXTurn) o;

        return board != null ? board.equals(that.board) : that.board == null;
    }

    @Override
    public int hashCode() {
        return board != null ? board.hashCode() : 0;
    }
}
