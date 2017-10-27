package com.codurance.ticTacToe;

import org.junit.Test;

import static com.codurance.ticTacToe.Player.O;
import static com.codurance.ticTacToe.Player.X;
import static com.codurance.ticTacToe.Square.TOP_LEFT;

public class BoardShould {

    @Test(expected = InvalidMoveException.class)
    public void
    not_allow_multiple_plays_on_a_square() throws InvalidMoveException {
        Board.empty()
                .play(X, TOP_LEFT)
                .play(O, TOP_LEFT);
    }
}