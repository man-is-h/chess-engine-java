package org.projects.chessenginejava.board;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.projects.chessenginejava.pieces.Piece;

@RequiredArgsConstructor
@Getter
public class Square {
    private final int rank;
    private final char file;
    private boolean isOccupied = false;
    private Piece piece = null;

    public Square(Piece piece, int rank, char file) {
        this.isOccupied = piece != null;
        this.piece = piece;
        this.rank = rank;
        this.file = file;
    }

    public String getPosition() {
        String position = "";
        return position.concat(String.valueOf(file))
                .concat(String.valueOf(rank));
    }

    public void setPiece(Piece piece) {
        this.isOccupied = piece != null;
        this.piece = piece;
    }

    @Override
    public String toString() {
        if (isOccupied) {
            return piece.toString();
        } else {
            return " ";
        }
    }
}
