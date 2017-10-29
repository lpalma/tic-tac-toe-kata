package com.codurance.ticTacToe;

import com.codurance.ticTacToe.board.Board;
import com.codurance.ticTacToe.gameState.GameState;
import com.codurance.ticTacToe.gameState.PlayerXTurn;
import org.junit.Test;

import java.util.Optional;

import static com.codurance.ticTacToe.Result.O_WON;
import static com.codurance.ticTacToe.Result.X_WON;
import static com.codurance.ticTacToe.Square.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class TicTacToeShould {

    @Test
    public void
    start_empty_board_on_X_turn() {
       assertThat(TicTacToe.newGame(), equalTo(new PlayerXTurn(Board.empty())));
    }

    @Test
    public void
    result_in_victory_to_X_when_X_wins() throws InvalidMoveException, GameFinishedException {
        GameState game = TicTacToe.newGame()
                .playOn(TOP_LEFT)
                .playOn(MIDDLE_LEFT)
                .playOn(TOP_CENTER)
                .playOn(MIDDLE_CENTER)
                .playOn(TOP_RIGHT);

        assertThat(game.result(), equalTo(Optional.of(X_WON)));
    }

    @Test
    public void
    result_in_victory_to_O_when_O_wins() throws InvalidMoveException, GameFinishedException {
        GameState game = TicTacToe.newGame()
                .playOn(TOP_LEFT)
                .playOn(MIDDLE_LEFT)
                .playOn(TOP_CENTER)
                .playOn(MIDDLE_CENTER)
                .playOn(BOTTOM_RIGHT)
                .playOn(MIDDLE_RIGHT);

        assertThat(game.result(), equalTo(Optional.of(O_WON)));
    }
}
