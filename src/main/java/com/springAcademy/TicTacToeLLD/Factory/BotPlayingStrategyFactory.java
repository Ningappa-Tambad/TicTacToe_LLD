package com.springAcademy.TicTacToeLLD.Factory;

import com.springAcademy.TicTacToeLLD.Models.BotDifficultyLevel;
import com.springAcademy.TicTacToeLLD.Stratergy.GameWinningStrategy.BotPlayingSTrategy.BotPlayingStrategy;
import com.springAcademy.TicTacToeLLD.Stratergy.GameWinningStrategy.BotPlayingSTrategy.EasyBotPlayingStrategy;
import com.springAcademy.TicTacToeLLD.Stratergy.GameWinningStrategy.BotPlayingSTrategy.HardBotPlayingStrategy;
import com.springAcademy.TicTacToeLLD.Stratergy.GameWinningStrategy.BotPlayingSTrategy.MediumBotPlayingStrategy;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel botDifficultyLevel) {
        if (botDifficultyLevel.equals(BotDifficultyLevel.EASY)) {
            return new EasyBotPlayingStrategy();
        } else if (botDifficultyLevel.equals(BotDifficultyLevel.MEDIUM)) {
            return new MediumBotPlayingStrategy();
        } else if(botDifficultyLevel.equals(BotDifficultyLevel.HARD)) {
            return new HardBotPlayingStrategy();
        }
        return null;
    }
}
