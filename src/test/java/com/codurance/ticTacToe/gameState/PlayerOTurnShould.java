package com.codurance.ticTacToe.gameState;

import com.codurance.ticTacToe.GameFinishedException;
import com.codurance.ticTacToe.InvalidMoveException;
import com.codurance.ticTacToe.board.Board;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static com.codurance.ticTacToe.Player.O;
import static com.codurance.ticTacToe.Square.TOP_LEFT;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class PlayerOTurnShould {

    @Mock
    private Board board;

    private PlayerOTurn playerOTurn;

    @Before
    public void setUp() {
        playerOTurn = new PlayerOTurn(board);
    }

    @Test
    public void
    pass_turn_to_player_X_after_play() throws InvalidMoveException, GameFinishedException {
        given(board.play(O, TOP_LEFT)).willReturn(board);

        GameState nextTurn = playerOTurn.playOn(TOP_LEFT);

        assertThat(nextTurn, equalTo(new PlayerXTurn(board)));
    }

    @Test(expected = InvalidMoveException.class)
    public void
    not_allow_multiple_plays_on_same_square() throws InvalidMoveException, GameFinishedException {
        given(board.play(O, TOP_LEFT)).willThrow(new InvalidMoveException());

        playerOTurn.playOn(TOP_LEFT);
    }

    @Test
    public void
    not_have_a_result() {
        MatcherAssert.assertThat(playerOTurn.result(), IsEqual.equalTo(Optional.empty()));
    }

}