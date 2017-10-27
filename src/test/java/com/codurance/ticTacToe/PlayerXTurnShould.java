package com.codurance.ticTacToe;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.codurance.ticTacToe.Player.X;
import static com.codurance.ticTacToe.Square.TOP_LEFT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class PlayerXTurnShould {

    @Mock
    private Board board;

    private PlayerXTurn playerXTurn;

    @Before
    public void setUp() {
        playerXTurn = new PlayerXTurn(board);
    }

    @Test
    public void
    pass_turn_to_player_O_after_play() throws InvalidMoveException {
        given(board.play(X, TOP_LEFT)).willReturn(board);

        GameState nextTurn = playerXTurn.playOn(TOP_LEFT);

        assertThat(nextTurn, equalTo(new PlayerOTurn(board)));
    }

    @Test(expected = InvalidMoveException.class)
    public void
    not_allow_multiple_plays_on_same_square() throws InvalidMoveException {
        given(board.play(X, TOP_LEFT)).willThrow(new InvalidMoveException());

        playerXTurn.playOn(TOP_LEFT);
    }
}