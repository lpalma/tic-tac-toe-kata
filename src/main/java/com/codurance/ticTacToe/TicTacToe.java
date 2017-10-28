package com.codurance.ticTacToe;

import com.codurance.ticTacToe.board.Board;
import com.codurance.ticTacToe.gameState.PlayerXTurn;

public class TicTacToe {
    public static PlayerXTurn newGame() {
        return new PlayerXTurn(Board.empty());
    }
}
