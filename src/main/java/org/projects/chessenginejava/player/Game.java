package org.projects.chessenginejava.player;

import org.projects.chessenginejava.board.Chessboard;
import org.projects.chessenginejava.board.Square;
import org.projects.chessenginejava.utils.Color;

import java.util.Scanner;

public class Game {
    Chessboard board;
    Color[] players = {Color.WHITE, Color.BLACK};
    int currentPlayerIdx;
    boolean gameIsRunning;
    Scanner scanner;

    public Game(Chessboard board) {
        this.board = board;
        this.currentPlayerIdx = 0;
        this.gameIsRunning = true;
        this.scanner = new Scanner(System.in);
    }

    public void play() {
        while(gameIsRunning) {
            playTurn(players[currentPlayerIdx]);
            currentPlayerIdx = (currentPlayerIdx + 1) % 2;
        }
    }

    void playTurn(Color player) {
        board.printBoard();
        getMoveInputAndPlayMove(player);
    }

    void getMoveInputAndPlayMove(Color player) {
        System.out.println("Player " + player + "'s turn, enter your move: ");
        System.out.println("Enter move in the format: <current square>_<target square>");
        String move = scanner.nextLine();
        // validate move
        boolean valid = parseAndPlayMove(move);
        if(!valid) {
            System.out.println("Invalid move, try again");
            getMoveInputAndPlayMove(player);
        }
    }

    boolean parseAndPlayMove(String move) {
        String[] squares = move.split("_").length == 2 ? move.split("_") : null;

        if(squares == null) {
            return false;
        }

        String currentSquare = squares[0];
        String targetSquare = squares[1];

        if(currentSquare.length() != 2 || targetSquare.length() != 2) {
            return false;
        }

        int currentRank = Character.getNumericValue(currentSquare.charAt(1));
        char currentFile = currentSquare.charAt(0);

        int targetRank = Character.getNumericValue(targetSquare.charAt(1));
        char targetFile = targetSquare.charAt(0);

        if(currentRank < 1 || currentRank > 8 || targetRank < 1 || targetRank > 8 ||
                currentFile < 'a' || currentFile > 'h' || targetFile < 'a' || targetFile > 'h') {
            return false;
        }

        return playMove(currentRank, currentFile, targetRank, targetFile);
    }

    boolean playMove(int currentRank, char currentFile, int targetRank, char targetFile) {

        Square currentSquare = board.getSquare(currentRank, currentFile-'a');
        Square targetSquare = board.getSquare(targetRank, targetFile-'a');

        if(currentSquare.getPiece() == null) {
            return false;
        }

        if(currentSquare.getPiece().getColor() != players[currentPlayerIdx]) {
            return false;
        }

        return currentSquare.getPiece().makeMove(board, currentSquare, targetSquare);
    }
}
