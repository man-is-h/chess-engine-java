package org.projects.chessenginejava.pieces;

import org.projects.chessenginejava.board.Chessboard;
import org.projects.chessenginejava.board.Square;
import org.projects.chessenginejava.utils.Color;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Queen extends Piece{
    public Queen(Color color) {
        super(color);
    }

    public List<String> getPossibleMoves(Chessboard board, Square currentSquare) {
        List<String> res = new ArrayList<>();
        res.addAll(getLinearMoves(board, currentSquare,4));
        res.addAll(getLinearMoves(board, currentSquare,0));
        return res;
    }

    @Override
    public String toString() {
        return this.getColor() == Color.WHITE ? "Q" : "q";
    }
}
