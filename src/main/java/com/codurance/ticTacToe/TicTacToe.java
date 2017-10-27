package com.codurance.ticTacToe;

public class TicTacToe {
    public static PlayerXTurn newGame() {
        return new PlayerXTurn(Board.empty());
    }
}
