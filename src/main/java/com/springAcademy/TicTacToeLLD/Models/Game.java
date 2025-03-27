package com.springAcademy.TicTacToeLLD.Models;

import com.springAcademy.TicTacToeLLD.Exception.DuplicateSymbolFoundException;
import com.springAcademy.TicTacToeLLD.Exception.InvlidPlayerCountException;
import com.springAcademy.TicTacToeLLD.Stratergy.GameWinningStrategy.ColumWiseWinningStrategy;
import com.springAcademy.TicTacToeLLD.Stratergy.GameWinningStrategy.DiagonalWinningStrategy;
import com.springAcademy.TicTacToeLLD.Stratergy.GameWinningStrategy.GameWinningStrategy;
import com.springAcademy.TicTacToeLLD.Stratergy.GameWinningStrategy.RowWiseGameWinningStrategy;

import java.util.*;

public class Game
{
    private static Board board;
    private List<Player> players;
    private static List<Move> moves;

    private static Player winner;
    private int nextPlayermoveIndex;
    private static GameState gameState;
    private static List<GameWinningStrategy> gameWinningStrategies;

    private Game(int dimension, List<Player> players,List<GameWinningStrategy> gameWinningStrategies) {
        this.board = new Board(dimension);
        this.players = players;
        this.moves = new ArrayList<>();
        this.nextPlayermoveIndex = 0;
        this.gameState = GameState.IN_PROGRESS;
        this.gameWinningStrategies=gameWinningStrategies;
    }

    public static List<GameWinningStrategy> getGameWinningStrategies() {
        return gameWinningStrategies;
    }

    public static void setGameWinningStrategies(List<GameWinningStrategy> gameWinningStrategies) {
        Game.gameWinningStrategies = gameWinningStrategies;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public static Builder getBuilder()
    {
        return new Builder();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getNextPlayermoveIndex() {
        return nextPlayermoveIndex;
    }

    public void setNextPlayermoveIndex(int nextPlayermoveIndex) {
        this.nextPlayermoveIndex = nextPlayermoveIndex;
    }

    public void displayBoard()
    {
        board.printBoard();
    }

    private boolean validateMove(Move move, Board board) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Cell cell = board.getBoard().get(row).get(col);

        return row>=0 && row<board.getSize() &&
                col>=0 && col<board.getSize() &&
                cell.getCellState().equals(CellState.EMPTY);

    }


        public void makeMove() throws InvlidPlayerCountException, DuplicateSymbolFoundException
        {
            Player currentPlayer = players.get(nextPlayermoveIndex);

            System.out.println("It is "+currentPlayer.getName()+"'s turn");

            Move move = currentPlayer.makeMove(board);

            //Validate the move

            validateMove(move,board);

            //place the move on the bOARD

           int row = move.getCell().getRow();
           int col = move.getCell().getCol();
           Cell cell = board.getBoard().get(row).get(col);
           cell.setCellState(CellState.FILLED);
           cell.setPlayer(currentPlayer);

           Move finalMove = new Move(currentPlayer,cell);

           nextPlayermoveIndex+=1;
              nextPlayermoveIndex%=players.size();

              //check the winner

            if(checkWinner(board,finalMove))
            {
                gameState = GameState.ENDED;
                winner = currentPlayer;
            }
            else if(moves.size()==board.getSize()*board.getSize())
            {
                gameState = GameState.DRAW;
            }


        }

    private boolean checkWinner(Board board, Move finalMove)
    {

        for (GameWinningStrategy gameWinningStrategy : gameWinningStrategies) {

            if(gameWinningStrategy.checkWinner(board,finalMove))
                return true;
        }
        return false;
    }

    public static class Builder
    {
        private int dimension;
        private List<Player> players;
        private static int nextPlayermoveIndex;

        public int getDimension() {
            return dimension;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }





        private void validateCount() throws InvlidPlayerCountException {
            if(players.size()!=dimension-1)
            {
                throw new InvlidPlayerCountException("Number of players should be one less than dimension");
            }
        }

        private void validateUniqueSymbolCount() throws InvlidPlayerCountException, DuplicateSymbolFoundException {

            Map<Character,Integer> symbolCount = new HashMap<>();
            for (Player player : players) {
                if(!symbolCount.containsKey(player.getSymbol().getaChar()))
                {
                    symbolCount.put(player.getSymbol().getaChar(),1);
                }
                else
                {
                    symbolCount.put(player.getSymbol().getaChar(),
                            symbolCount.get(player.getSymbol().getaChar())+1);
                }

                if(symbolCount.get(player.getSymbol().getaChar())>1)
                {
                    throw new DuplicateSymbolFoundException("Player symbols should be unique");
            }
            }
        }

        private void validateBotCount() throws InvlidPlayerCountException {
            int botCount = 0;
            for (Player player : players) {
                if(player.getPlayerType().equals(PlayerType.BOT))
                {
                    botCount++;
                }
            }
            if(botCount>1)
            {
                throw new RuntimeException("Only one bot is allowed");
            }
        }


        private void validationGame(int dimension, List<Player> players) throws InvlidPlayerCountException, DuplicateSymbolFoundException {
           validateCount();
           validateUniqueSymbolCount();
           validateBotCount();
        }

        public Game build() throws InvlidPlayerCountException, DuplicateSymbolFoundException {
           //validations
            validationGame(dimension,players);
            return new Game(
                    dimension,
                    players,
                    List.of(
                           new RowWiseGameWinningStrategy(),
                            new ColumWiseWinningStrategy(),
                            new DiagonalWinningStrategy()

                    )

            );
        }

    }
}
