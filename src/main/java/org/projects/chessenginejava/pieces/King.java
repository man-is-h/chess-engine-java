package org.projects.chessenginejava.pieces;

import org.projects.chessenginejava.board.Chessboard;
import org.projects.chessenginejava.board.Square;
import org.projects.chessenginejava.utils.Color;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
    int[] xDir = {1, 1, 0, -1, -1, -1, 0, 1};
    int[] yDir = {0, 1, 1, 1, 0, -1, -1, -1};
    public King(Color color) {
        super(color);
    }

    public List<String> getPossibleMoves(Chessboard board, Square currentSquare) {
        int currentRank = currentSquare.getRank();
        int currentFile = currentSquare.getFile() - 'a';

        List<String> res = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            int nextRank = currentRank + yDir[i];
            int nextFile = currentFile + xDir[i];
            if (nextRank > 0 && nextRank <= 8 && nextFile >= 0 && nextFile < 8 &&
                    (board.getSquare(nextRank, (char) nextFile).getPiece() == null ||
                            board.getSquare(nextRank, (char) nextFile).getPiece().getColor() != this.getColor())) {
                res.add((char) (nextFile + 'a') + "" + nextRank);
            }
        }
        return res;
    }

    @Override
    public String toString() {
        return this.getColor() == Color.WHITE ? "K" : "k";
    }
}
