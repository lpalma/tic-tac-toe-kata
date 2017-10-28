package com.codurance.ticTacToe;

import java.util.Optional;

public class EndGame implements GameState {

    private Result result;

    public EndGame(Result result) {
        this.result = result;
    }

    public GameState playOn(Square square) throws InvalidMoveException, GameFinishedException {
        throw new GameFinishedException();
    }

    public Optional<Result> result() {
        return Optional.of(result);
    }
}
