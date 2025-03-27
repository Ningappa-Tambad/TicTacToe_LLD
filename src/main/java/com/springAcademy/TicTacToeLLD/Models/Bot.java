package com.springAcademy.TicTacToeLLD.Models;

import com.springAcademy.TicTacToeLLD.Factory.BotPlayingStrategyFactory;
import com.springAcademy.TicTacToeLLD.Stratergy.GameWinningStrategy.BotPlayingSTrategy.BotPlayingStrategy;

public class Bot extends Player {
    private BotDifficultyLevel botDifficultyLevel;

    private BotPlayingStrategy botPlayingStrategy;

    public Bot(String name, Long id, Symbol symbol, PlayerType playerType, BotDifficultyLevel botDifficultyLevel)
    {
        super(name, id,symbol,playerType);

        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategy(botDifficultyLevel);
    }

    @Override
    public Move makeMove(Board board) {
        Move move = botPlayingStrategy.makeMove(board);
        move.setPlayer(this);
        return move;
    }
}
