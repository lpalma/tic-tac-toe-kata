package com.codurance.ticTacToe.board;

import com.codurance.ticTacToe.*;

import java.util.Optional;

public interface NextBoard {
    NextBoard play(Player x, Square square) throws InvalidMoveException, GameFinishedException;

    Optional<Result> result();
}
