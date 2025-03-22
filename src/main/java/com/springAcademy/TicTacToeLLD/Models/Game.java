package com.springAcademy.TicTacToeLLD.Models;

import java.util.List;

public class Game
{
    private Board board;
    private List<Player> players;
    private List<Move> moves;

    private Player winner;
    private int nextPlayermoveIndex;

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
}
