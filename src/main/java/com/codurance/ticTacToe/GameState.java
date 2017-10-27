package com.codurance.ticTacToe;

public interface GameState {
    GameState playOn(Square square) throws InvalidMoveException;
}