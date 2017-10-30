package com.codurance.ticTacToe.gameState;

import com.codurance.ticTacToe.GameFinishedException;
import com.codurance.ticTacToe.InvalidMoveException;
import com.codurance.ticTacToe.Result;
import com.codurance.ticTacToe.Square;
import com.codurance.ticTacToe.board.NextBoard;

import java.util.Optional;

import static com.codurance.ticTacToe.Player.X;
import static java.util.Optional.empty;

public class PlayerXTurn implements GameState {
    private NextBoard board;

    public PlayerXTurn(NextBoard board) {
        this.board = board;
    }

    public GameState playOn(Square square) throws InvalidMoveException, GameFinishedException {
        NextBoard nextBoard = board.play(X, square);
        Optional<Result> result = nextBoard.result();

        return result.isPresent()
            ? new EndGame(result.get())
            : new PlayerOTurn(nextBoard);
    }

    public Optional<Result> result() {
        return empty();
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
