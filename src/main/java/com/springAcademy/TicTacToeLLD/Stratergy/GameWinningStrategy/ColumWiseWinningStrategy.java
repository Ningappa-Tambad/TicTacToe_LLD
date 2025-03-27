package com.springAcademy.TicTacToeLLD.Stratergy.GameWinningStrategy;

import com.springAcademy.TicTacToeLLD.Models.Board;
import com.springAcademy.TicTacToeLLD.Models.Move;
import com.springAcademy.TicTacToeLLD.Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColumWiseWinningStrategy implements GameWinningStrategy{

    Map<Integer, Map<Symbol,Integer>> colmap= new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {

        int col=move.getCell().getRow();
        Symbol symbol=move.getPlayer().getSymbol();
        if(!colmap.containsKey(col))
        {
            colmap.put(col,new HashMap<>());
        }
        Map<Symbol,Integer> currentColMap=colmap.get(col);
        if(!currentColMap.containsKey(symbol))
        {
            currentColMap.put(symbol,1);
        }
        else
        {
            currentColMap.put(symbol,currentColMap.get(symbol)+1);
        }
        return currentColMap.get(symbol)==board.getSize();
    }
}
