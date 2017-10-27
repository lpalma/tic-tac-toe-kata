package com.codurance.ticTacToe;

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

    @Test
    public void
    pass_turn_to_player_O_after_play() {
        PlayerXTurn playerXTurn = new PlayerXTurn(board);

        given(board.play(X, TOP_LEFT)).willReturn(board);

        PlayerOTurn nextTurn = playerXTurn.playOn(TOP_LEFT);

        assertThat(nextTurn, equalTo(new PlayerOTurn(board)));
    }
}