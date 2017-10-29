package com.codurance.ticTacToe.board;

import com.codurance.ticTacToe.Square;

import java.util.List;

import static com.codurance.ticTacToe.Square.*;
import static java.util.Arrays.asList;

public enum WinningRow {
    TOP_ROW(TOP_LEFT, TOP_CENTER, TOP_RIGHT),
    MIDDLE_ROW(MIDDLE_LEFT, MIDDLE_CENTER, MIDDLE_RIGHT),
    BOTTOM_ROW(BOTTOM_LEFT, BOTTOM_CENTER, BOTTOM_RIGHT),
    LEFT_COLUMN(TOP_LEFT, MIDDLE_LEFT, BOTTOM_LEFT),
    MIDDLE_COLUMN(TOP_CENTER, MIDDLE_CENTER, BOTTOM_CENTER),
    RIGHT_COLUMN(TOP_RIGHT, MIDDLE_RIGHT, BOTTOM_RIGHT),
    LEFT_DIAGONAL(TOP_LEFT, MIDDLE_CENTER, BOTTOM_RIGHT),
    RIGHT_DIAGONAL(TOP_RIGHT, MIDDLE_CENTER, BOTTOM_LEFT);

    private List<Square> squares;

    WinningRow(Square... squares) {
        this.squares = asList(squares);
    }

    public List<Square> squares() {
        return squares;
    }
}
