package com.codurance.ticTacToe;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class TicTacToeBoardShould {
    @Test
    public void
    result_in_win_for_player_x_on_first_row() {
        TicTacToeBoard board = new TicTacToeBoard();

        String result = board.play(asList(
                new Position(0, 0),
                new Position(1, 0),
                new Position(0, 1),
                new Position(1, 1),
                new Position(0, 2)
        ));

        assertThat(result, equalTo("X"));
    }
}
