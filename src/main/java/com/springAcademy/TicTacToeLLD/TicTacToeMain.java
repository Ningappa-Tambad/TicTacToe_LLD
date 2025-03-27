package com.springAcademy.TicTacToeLLD;

import com.springAcademy.TicTacToeLLD.Controller.GameController;
import com.springAcademy.TicTacToeLLD.Exception.DuplicateSymbolFoundException;
import com.springAcademy.TicTacToeLLD.Exception.InvlidPlayerCountException;
import com.springAcademy.TicTacToeLLD.Models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeMain {

    public static void main(String[] args) throws InvlidPlayerCountException, DuplicateSymbolFoundException {


        System.out.println("Starting Tic Tac Toe Game");
        //Play the game
        Scanner scanner = new Scanner(System.in);
        GameController gameController = new GameController();

        List<Player> players=new ArrayList<>();
        players.add(new Player
                ("Player1",1l, new Symbol('X'), PlayerType.HUMAN));

        players.add(new Bot("BOT Move", 2l,new Symbol('O'), PlayerType.BOT, BotDifficultyLevel.EASY));

        Game game = gameController.startGame(3, players);



        while (gameController.getGameState(game).equals(GameState.IN_PROGRESS)) {
            gameController.displayTheBoard(game);

            gameController.makeMove(game);
        }

        if (gameController.getGameState(game).equals(GameState.DRAW)) {
            gameController.displayTheBoard(game);
            System.out.println("Game has DRAWN.");
        } else {
            //Someone has WON the game.
            gameController.displayTheBoard(game);
            System.out.println(gameController.getWinner(game).getName() + " has WON the game. Congratulations.");
        }

    }
}