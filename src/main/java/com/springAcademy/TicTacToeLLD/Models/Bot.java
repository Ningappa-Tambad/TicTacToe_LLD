package com.springAcademy.TicTacToeLLD.Models;

public class Bot extends Player {
    private BotDifficultyLevel botDifficultyLevel;

    public Bot(String name, Long id, Symbol symbol, PlayerType playerType, BotDifficultyLevel botDifficultyLevel)
    {
        super(name, id,symbol,playerType);

        this.botDifficultyLevel = botDifficultyLevel;
    }
}
