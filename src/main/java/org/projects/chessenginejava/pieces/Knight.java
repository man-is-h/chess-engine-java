package org.projects.chessenginejava.pieces;

import org.projects.chessenginejava.board.Chessboard;
import org.projects.chessenginejava.board.Square;
import org.projects.chessenginejava.utils.Color;

import java.util.Collections;
import java.util.List;

public class Knight extends Piece{
    public Knight(Color color) {
        super(color);
    }

    //TODO: implement this method
    public List<String> getPossibleMoves(Chessboard board, Square square) {
        return Collections.emptyList();
    }

    @Override
    public String toString() {
        return this.getColor() == Color.WHITE ? "N" : "n";
    }
}
