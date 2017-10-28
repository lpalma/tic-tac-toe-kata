package com.codurance.ticTacToe;

import org.junit.Test;

import static com.codurance.ticTacToe.Result.X_WON;
import static com.codurance.ticTacToe.Square.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class TicTacToeShould {

    @Test
    public void
    start_empty_board_with_player_X_turn() {
       assertThat(TicTacToe.newGame(), equalTo(new PlayerXTurn(Board.empty())));
    }

    @Test
    public void
    result_in_victory_to_player_X() throws InvalidMoveException, GameFinishedException {
        GameState result = TicTacToe.newGame()
                .playOn(TOP_LEFT)
                .playOn(MIDDLE_LEFT)
                .playOn(TOP_CENTER)
                .playOn(MIDDLE_CENTER)
                .playOn(TOP_RIGHT);

        assertThat(result, equalTo(new EndGame(X_WON)));
    }
}
