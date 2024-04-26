package org.projects.chessenginejava.pieces;


import org.projects.chessenginejava.board.Chessboard;
import org.projects.chessenginejava.board.Square;
import org.projects.chessenginejava.utils.Color;

import java.util.List;

public class Bishop extends Piece {

    public Bishop(Color color) {
        super(color);
    }

    public List<String> getPossibleMoves(Chessboard board, Square currentSquare) {
        return getDiagonalMoves(board, currentSquare);
    }

    @Override
    public String toString() {
        return this.getColor() == Color.WHITE ? "B" : "b";
    }
}
