package com.springAcademy.TicTacToeLLD.Stratergy.GameWinningStrategy;

import com.springAcademy.TicTacToeLLD.Models.Board;
import com.springAcademy.TicTacToeLLD.Models.Move;

public interface GameWinningStrategy {
    boolean  checkWinner(Board board, Move move);

}
