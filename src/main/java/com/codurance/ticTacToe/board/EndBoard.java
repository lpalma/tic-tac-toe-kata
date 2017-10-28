package com.codurance.ticTacToe.board;

import com.codurance.ticTacToe.*;

import java.util.Optional;

public class EndBoard implements NextBoard {

    private Result result;

    public EndBoard(Result result) {
        this.result = result;
    }

    public NextBoard play(Player x, Square square) throws InvalidMoveException, GameFinishedException {
        throw new GameFinishedException();
    }

    public Optional<Result> result() {
        return Optional.of(result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EndBoard that = (EndBoard) o;

        return result == that.result;
    }

    @Override
    public int hashCode() {
        return result != null ? result.hashCode() : 0;
    }
}
