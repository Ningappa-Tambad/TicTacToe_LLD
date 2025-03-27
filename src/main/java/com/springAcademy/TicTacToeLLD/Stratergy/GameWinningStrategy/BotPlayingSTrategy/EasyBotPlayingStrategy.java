package com.springAcademy.TicTacToeLLD.Stratergy.GameWinningStrategy.BotPlayingSTrategy;

import com.springAcademy.TicTacToeLLD.Models.Board;
import com.springAcademy.TicTacToeLLD.Models.Cell;
import com.springAcademy.TicTacToeLLD.Models.Move;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {


    @Override
    public Move makeMove(Board board) {

        for(List<Cell> cells: board.getBoard())
        {
            for(Cell cell : cells)
            {
                if(cell.isCellEmpty())
                {
                    return new Move(
                           null,
                            cell);
                }
            }
        }
     return null;
    }
}
