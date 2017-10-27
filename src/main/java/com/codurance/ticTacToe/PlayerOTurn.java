package com.codurance.ticTacToe;

import static com.codurance.ticTacToe.Player.O;

public class PlayerOTurn implements GameState {
    private Board board;

    public PlayerOTurn(Board board) {
        this.board = board;
    }

    public GameState playOn(Square square) throws InvalidMoveException {
        return new PlayerXTurn(board.play(O, square));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayerOTurn that = (PlayerOTurn) o;

        return board != null ? board.equals(that.board) : that.board == null;
    }

    @Override
    public int hashCode() {
        return board != null ? board.hashCode() : 0;
    }
}
