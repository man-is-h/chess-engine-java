package org.projects.chessenginejava.pieces;

import org.projects.chessenginejava.board.Chessboard;
import org.projects.chessenginejava.board.Square;
import org.projects.chessenginejava.utils.Color;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {
    int[] xDir = {2, 1, -1, -2, -2, -1, 1, 2};
    int[] yDir = {1, 2, 2, 1, -1, -2, -2, -1};

    public Knight(Color color) {
        super(color);
    }

    public List<String> getPossibleMoves(Chessboard board, Square currentSquare) {
        int currentRank = currentSquare.getRank();
        int currentFile = currentSquare.getFile() - 'a';

        List<String> res = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            int nextRank = currentRank + yDir[i];
            int nextFile = currentFile + xDir[i];
            if (nextRank >= 0 && nextRank < 8 && nextFile >= 0 && nextFile < 8 &&
                    (board.getSquare(nextRank, (char) nextFile).getPiece() == null ||
                            board.getSquare(nextRank, (char) nextFile).getPiece().getColor() != this.getColor())) {
                res.add((char) (nextFile + 'a') + "" + nextRank);
            }
        }
        return res;
    }

    @Override
    public String toString() {
        return this.getColor() == Color.WHITE ? "N" : "n";
    }
}
