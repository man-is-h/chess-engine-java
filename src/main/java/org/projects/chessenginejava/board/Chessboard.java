package org.projects.chessenginejava.board;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
public class Chessboard {

    private static Chessboard instance;
    @Setter
    private Square[][] board;

    private Chessboard() {
        this.board = new Square[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Square(i+1, (char) ('a'+j));
            }
        }
    }

    public static Chessboard getInstance() {
        if (instance == null) {
            instance = new Chessboard();
        }
        return instance;
    }

    public Square getSquare(int rank, int file) {
        return board[rank-1][file];
    }

    @Override
    public String toString() {
        return Arrays.deepToString(board).replace("],", "|\n")
                .replace("[["," |")
                .replace("[","|")
                .replace("]]","|")
                .replace(","," ");
    }

    public void printBoard() {
        System.out.println(this);
    }
}
