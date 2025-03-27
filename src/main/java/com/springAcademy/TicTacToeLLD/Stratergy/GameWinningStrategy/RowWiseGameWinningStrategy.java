package com.springAcademy.TicTacToeLLD.Stratergy.GameWinningStrategy;

import com.springAcademy.TicTacToeLLD.Models.Board;
import com.springAcademy.TicTacToeLLD.Models.Move;
import com.springAcademy.TicTacToeLLD.Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class RowWiseGameWinningStrategy implements GameWinningStrategy{


    Map<Integer, Map<Symbol,Integer>> rowmap= new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move)
    {
       int row=move.getCell().getRow();
         Symbol symbol=move.getPlayer().getSymbol();
        if(!rowmap.containsKey(row))
        {
            rowmap.put(row,new HashMap<>());
        }
       Map<Symbol,Integer> currentRowMap=rowmap.get(row);
        if(!currentRowMap.containsKey(symbol))
        {
            currentRowMap.put(symbol,1);
        }
        else
        {
            currentRowMap.put(symbol,currentRowMap.get(symbol)+1);
        }
        return currentRowMap.get(symbol)==board.getSize();
    }
}
