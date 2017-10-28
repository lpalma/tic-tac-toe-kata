package com.codurance.ticTacToe.gameState;

import com.codurance.ticTacToe.GameFinishedException;
import com.codurance.ticTacToe.InvalidMoveException;
import com.codurance.ticTacToe.Result;
import com.codurance.ticTacToe.Square;

import java.util.Optional;

public interface GameState {
    GameState playOn(Square square) throws InvalidMoveException, GameFinishedException;

    Optional<Result> result();
}