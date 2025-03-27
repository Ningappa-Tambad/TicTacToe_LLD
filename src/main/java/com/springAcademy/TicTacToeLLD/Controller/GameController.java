package com.springAcademy.TicTacToeLLD.Controller;

import com.springAcademy.TicTacToeLLD.Exception.DuplicateSymbolFoundException;
import com.springAcademy.TicTacToeLLD.Exception.InvlidPlayerCountException;
import com.springAcademy.TicTacToeLLD.Models.Game;
import com.springAcademy.TicTacToeLLD.Models.GameState;
import com.springAcademy.TicTacToeLLD.Models.Player;

import java.util.List;

public class GameController {


    public static Game startGame(int dimension, List<Player> players) throws InvlidPlayerCountException, DuplicateSymbolFoundException {

        return Game.getBuilder()
                .setDimension(dimension)
                .setPlayers(players)
                .build();
    }

    public void makeMove(Game game) throws InvlidPlayerCountException, DuplicateSymbolFoundException {
          game.makeMove();
    }

    public Player getWinner(Game game)
    {

        return game.getWinner();
    }

    public void unDo(Game game)
    {

    }

    public void displayTheBoard(Game game)
    {
         game.displayBoard();

    }

    public GameState getGameState(Game game)
    {
        return game.getGameState();
    }

}
