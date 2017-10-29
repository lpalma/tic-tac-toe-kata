package com.codurance.ticTacToe;

import com.codurance.ticTacToe.board.Board;
import com.codurance.ticTacToe.gameState.GameState;
import com.codurance.ticTacToe.gameState.PlayerXTurn;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Optional;

import static com.codurance.ticTacToe.Result.O_WON;
import static com.codurance.ticTacToe.Result.X_WON;
import static com.codurance.ticTacToe.Square.*;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(JUnitParamsRunner.class)
public class TicTacToeShould {

    private Object xWins() {
        return asList(
                asList(TOP_LEFT, MIDDLE_LEFT, TOP_CENTER, MIDDLE_CENTER, TOP_RIGHT),
                asList(MIDDLE_LEFT, TOP_LEFT, MIDDLE_CENTER, TOP_CENTER, MIDDLE_RIGHT),
                asList(BOTTOM_LEFT, TOP_LEFT, BOTTOM_CENTER, TOP_CENTER, BOTTOM_RIGHT),
                asList(TOP_LEFT, TOP_CENTER, MIDDLE_LEFT, MIDDLE_CENTER, BOTTOM_LEFT),
                asList(TOP_CENTER, TOP_LEFT, MIDDLE_CENTER, MIDDLE_LEFT, BOTTOM_CENTER),
                asList(TOP_RIGHT, TOP_CENTER, MIDDLE_RIGHT, MIDDLE_CENTER, BOTTOM_RIGHT),
                asList(TOP_LEFT, TOP_CENTER, MIDDLE_CENTER, TOP_RIGHT, BOTTOM_RIGHT),
                asList(TOP_RIGHT, TOP_CENTER, MIDDLE_CENTER, TOP_LEFT, BOTTOM_LEFT)
        );
    }

    private Object oWins() {
        return asList(
                asList(MIDDLE_LEFT, TOP_LEFT, MIDDLE_CENTER, TOP_CENTER, BOTTOM_RIGHT, TOP_RIGHT),
                asList(TOP_LEFT, MIDDLE_LEFT, TOP_CENTER, MIDDLE_CENTER, BOTTOM_LEFT, MIDDLE_RIGHT),
                asList(TOP_LEFT, BOTTOM_LEFT, TOP_CENTER, BOTTOM_CENTER, MIDDLE_LEFT, BOTTOM_RIGHT),
                asList(TOP_CENTER, TOP_LEFT, MIDDLE_CENTER, MIDDLE_LEFT, TOP_RIGHT, BOTTOM_LEFT),
                asList(TOP_LEFT, TOP_CENTER, MIDDLE_LEFT, MIDDLE_CENTER, BOTTOM_RIGHT, BOTTOM_CENTER),
                asList(TOP_LEFT, TOP_RIGHT, MIDDLE_LEFT, MIDDLE_RIGHT, BOTTOM_CENTER, BOTTOM_RIGHT),
                asList(TOP_CENTER, TOP_LEFT, MIDDLE_LEFT, MIDDLE_CENTER, BOTTOM_CENTER, BOTTOM_RIGHT),
                asList(TOP_LEFT, TOP_RIGHT, TOP_CENTER, MIDDLE_CENTER, MIDDLE_RIGHT, BOTTOM_LEFT)
        );
    }

    @Test
    public void
    start_empty_board_on_X_turn() {
       assertThat(TicTacToe.newGame(), equalTo(new PlayerXTurn(Board.empty())));
    }

    @Test
    @Parameters(method = "xWins")
    public void
    result_in_victory_to_X_when_X_wins(Square[] squares) throws InvalidMoveException, GameFinishedException {
        GameState game = TicTacToe.newGame()
                .playOn(squares[0])
                .playOn(squares[1])
                .playOn(squares[2])
                .playOn(squares[3])
                .playOn(squares[4]);

        assertThat(game.result(), equalTo(Optional.of(X_WON)));
    }

    @Test
    @Parameters(method = "oWins")
    public void
    result_in_victory_to_O_when_O_wins(Square[] squares) throws InvalidMoveException, GameFinishedException {
        GameState game = TicTacToe.newGame()
                .playOn(squares[0])
                .playOn(squares[1])
                .playOn(squares[2])
                .playOn(squares[3])
                .playOn(squares[4])
                .playOn(squares[5]);

        assertThat(game.result(), equalTo(Optional.of(O_WON)));
    }
}
