package com.codurance.ticTacToe;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class TicTacToeShould {

    @Test
    public void
    start_empty_board_with_player_X_turn() {
       assertThat(TicTacToe.newGame(), equalTo(new PlayerXTurn(Board.empty())));
    }
}
