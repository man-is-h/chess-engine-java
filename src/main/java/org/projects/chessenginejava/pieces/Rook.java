package org.projects.chessenginejava.pieces;

import org.projects.chessenginejava.board.Chessboard;
import org.projects.chessenginejava.board.Square;
import org.projects.chessenginejava.utils.Color;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece{
    public Rook(Color color) {
        super(color);
    }

    @Override
    public List<String> getPossibleMoves(Chessboard board, Square currentSquare) {
        return getLinearMoves(board, currentSquare, 0);
    }

    @Override
    public String toString() {
        return this.getColor() == Color.WHITE ? "R" : "r";
    }
}
