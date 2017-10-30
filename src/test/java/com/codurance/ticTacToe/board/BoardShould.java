package com.codurance.ticTacToe.board;

import com.codurance.ticTacToe.GameFinishedException;
import com.codurance.ticTacToe.InvalidMoveException;
import org.junit.Test;

import java.util.Optional;

import static com.codurance.ticTacToe.Player.O;
import static com.codurance.ticTacToe.Player.X;
import static com.codurance.ticTacToe.Result.DRAW;
import static com.codurance.ticTacToe.Result.X_WON;
import static com.codurance.ticTacToe.Square.*;
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

    @Test
    public void
    result_in_victory_to_X_when_X_wins() throws InvalidMoveException, GameFinishedException {
        NextBoard board = Board.empty()
                .play(X, TOP_LEFT)
                .play(O, MIDDLE_LEFT)
                .play(X, TOP_CENTER)
                .play(O, MIDDLE_CENTER)
                .play(X, TOP_RIGHT);

        assertThat(board.result(), equalTo(Optional.of(X_WON)));
    }

    @Test
    public void
    result_in_draw_if_game_ends_with_no_winner() throws InvalidMoveException, GameFinishedException {
        NextBoard board = Board.empty()
                .play(X, TOP_LEFT)
                .play(O, TOP_CENTER)
                .play(X, MIDDLE_CENTER)
                .play(O, TOP_RIGHT)
                .play(X, MIDDLE_RIGHT)
                .play(O, MIDDLE_LEFT)
                .play(X, BOTTOM_LEFT)
                .play(O, BOTTOM_RIGHT)
                .play(X, BOTTOM_CENTER);

        assertThat(board.result(), equalTo(Optional.of(DRAW)));
    }
}