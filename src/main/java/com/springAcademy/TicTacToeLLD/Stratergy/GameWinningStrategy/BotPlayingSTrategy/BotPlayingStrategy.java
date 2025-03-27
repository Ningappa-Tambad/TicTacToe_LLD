package com.springAcademy.TicTacToeLLD.Stratergy.GameWinningStrategy.BotPlayingSTrategy;

import com.springAcademy.TicTacToeLLD.Models.Board;
import com.springAcademy.TicTacToeLLD.Models.Move;

public interface BotPlayingStrategy {

    Move makeMove(Board board);
}
