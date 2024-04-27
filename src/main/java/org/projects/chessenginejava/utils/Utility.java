package org.projects.chessenginejava.utils;

import org.projects.chessenginejava.board.Chessboard;
import org.projects.chessenginejava.pieces.*;

import java.util.ArrayList;

public class Utility {

    public static void initChessBoard(String fenNotation) {
        // split string on '/' to get pieces in each rank

        ArrayList<String> ranks;
        ranks = splitFenNotation(fenNotation);
        createChessBoard(ranks);
    }

    private static ArrayList<String> splitFenNotation(String fenNotation) {
        ArrayList<String> ranks = new ArrayList<>();
        String[] splitFen = fenNotation.split("/");
        for (String rank : splitFen) {
            ranks.add(rank);
        }
        return ranks;
    }

    private static void printRanks(ArrayList<String> ranks) {
        for (String rank : ranks) {
            print(rank);
        }
    }

    private static void print(String rank) {
        System.out.print("|");
        for (int i = 0; i < rank.length(); i++) {
            char c = rank.charAt(i);
            if (Character.isDigit(c)) {
                for (int j = 0; j < Character.getNumericValue(c); j++) {
                    System.out.print(" |");
                }
            } else {
                System.out.print(c+"|");
            }
        }
        System.out.println();
    }

    private static Chessboard createChessBoard(ArrayList<String> ranks) {
        Chessboard board = Chessboard.getInstance();
        for (int i = 8; i >= 1; i--) {
            String rank = ranks.get(8-i);
            int col = 0;
            for (int j = 0; j < rank.length(); j++) {
                char c = rank.charAt(j);
                if (Character.isDigit(c)) {
                    for (int k = 0; k < Character.getNumericValue(c); k++) {
                        board.getSquare(i,col).setPiece(null);
                        col++;
                    }
                } else {
                    board.getSquare(i,col).setPiece(getPiece(c));
                    col++;
                }
            }
        }
        return board;
    }

    private static Piece getPiece(char c) {
        return switch (c) {
            case 'p' -> new Pawn(Color.BLACK);
            case 'P' -> new Pawn(Color.WHITE);
            case 'r' -> new Rook(Color.BLACK);
            case 'R' -> new Rook(Color.WHITE);
            case 'n' -> new Knight(Color.BLACK);
            case 'N' -> new Knight(Color.WHITE);
            case 'b' -> new Bishop(Color.BLACK);
            case 'B' -> new Bishop(Color.WHITE);
            case 'q' -> new Queen(Color.BLACK);
            case 'Q' -> new Queen(Color.WHITE);
            case 'k' -> new King(Color.BLACK);
            case 'K' -> new King(Color.WHITE);
            default -> null;
        };
    }
}
