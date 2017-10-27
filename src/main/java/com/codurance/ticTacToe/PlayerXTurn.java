package com.codurance.ticTacToe;

import static com.codurance.ticTacToe.Player.X;

public class PlayerXTurn {
    private Board board;

    public PlayerXTurn(Board board) {
        this.board = board;
    }

    public PlayerOTurn playOn(Square square) {
        return new PlayerOTurn(board.play(X, square));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayerXTurn that = (PlayerXTurn) o;

        return board != null ? board.equals(that.board) : that.board == null;
    }

    @Override
    public int hashCode() {
        return board != null ? board.hashCode() : 0;
    }
}
