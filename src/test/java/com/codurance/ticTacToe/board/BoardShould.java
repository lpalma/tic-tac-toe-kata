package com.codurance.ticTacToe.board;

import com.codurance.ticTacToe.GameFinishedException;
import com.codurance.ticTacToe.InvalidMoveException;
import org.junit.Test;

import java.util.Optional;

import static com.codurance.ticTacToe.Player.O;
import static com.codurance.ticTacToe.Player.X;
import static com.codurance.ticTacToe.Square.TOP_LEFT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class BoardShould {

    @Test(expected = InvalidMoveException.class)
    public void
    not_allow_multiple_plays_on_a_square() throws InvalidMoveException, GameFinishedException {
        Board.empty()
                .play(X, TOP_LEFT)
                .play(O, TOP_LEFT);
    }

    @Test
    public void
    not_have_a_result() {
        Board board = Board.empty();

        assertThat(board.result(), equalTo(Optional.empty()));
    }
}