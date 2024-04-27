package org.projects.chessenginejava.pieces;

import org.projects.chessenginejava.board.Chessboard;
import org.projects.chessenginejava.board.Square;
import org.projects.chessenginejava.utils.Color;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
    public Pawn(Color color) {
        super(color);
    }

    @Override
    public List<String> getPossibleMoves(Chessboard board, Square currentSquare) {
        List<String> res = new ArrayList<>();
        int currentRank = currentSquare.getRank();
        int currentFile = currentSquare.getFile() - 'a';

        if(this.getColor() == Color.WHITE) {
            if(currentRank == 2 && board.getSquare(currentRank + 2, currentFile).getPiece() == null) {
                res.add((char) (currentFile + 'a') + "" + (currentRank + 2));
            }
            if(currentRank + 1 <= 8 && board.getSquare(currentRank + 1, currentFile).getPiece() == null) {
                res.add((char) (currentFile + 'a') + "" + (currentRank + 1));
            }
        } else {
            if(currentRank == 7 && board.getSquare(currentRank - 2, currentFile).getPiece() == null) {
                res.add((char) (currentFile + 'a') + "" + (currentRank - 2));
            }
            if(currentRank - 1 >= 0 && board.getSquare(currentRank - 1, currentFile).getPiece() == null) {
                res.add((char) (currentFile + 'a') + "" + (currentRank-1));
            }
        }
        return res;
    }

    @Override
    public String toString() {
        return this.getColor() == Color.WHITE ? "P" : "p";
    }
}
