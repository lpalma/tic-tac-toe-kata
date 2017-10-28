package com.codurance.ticTacToe;

import java.util.Optional;

public interface GameState {
    GameState playOn(Square square) throws InvalidMoveException, GameFinishedException;

    Optional<Result> result();
}