package org.projects.chessenginejava.pieces;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.projects.chessenginejava.board.Chessboard;
import org.projects.chessenginejava.board.Square;
import org.projects.chessenginejava.utils.Color;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public abstract class Piece {
    private final Color color;
    private final int[] xDir = {1,0,-1,0,1,-1,1,-1};
    private final int[] yDir = {0,1,0,-1,1,1,-1,-1};

    public abstract List<String> getPossibleMoves(Chessboard board, Square currentSquare);
    public abstract String toString();
    
    List<String> getHorizontalandVerticalMoves(Chessboard board, Square currentSquare) {
        int currentRank = currentSquare.getRank();
        int currentFile = currentSquare.getFile() - 'a';
        
        List<String> res = new ArrayList<>();
        
        for(int i=0; i<4; i++) {
            int nextRank = currentRank + yDir[i];
            int nextFile = currentFile + xDir[i];
            while(nextRank>=0 && nextRank<8 && nextFile>=0 && nextFile<8 &&
                    (board.getSquare(nextRank, (char)nextFile).getPiece() == null ||
                            board.getSquare(nextRank, (char)nextFile).getPiece().getColor() != this.getColor())) {
                
                res.add((char)(nextFile+'a') + "" + nextRank);
                if(board.getSquare(nextRank, (char)nextFile).getPiece()!=null && board.getSquare(nextRank,
                        (char)nextFile).getPiece().getColor() != this.getColor())
                    break;
                nextRank += yDir[i];
                nextFile += xDir[i];
            }
        }
        
        return res;
    }

    List<String> getDiagonalMoves(Chessboard board, Square currentSquare) {
        int currentRank = currentSquare.getRank();
        int currentFile = currentSquare.getFile() - 'a';

        List<String> res = new ArrayList<>();

        for(int i=4; i<8; i++) {
            int nextRank = currentRank + yDir[i];
            int nextFile = currentFile + xDir[i];
            while(nextRank>=0 && nextRank<8 && nextFile>=0 && nextFile<8 &&
                    (board.getSquare(nextRank, (char)nextFile).getPiece() == null ||
                            board.getSquare(nextRank, (char)nextFile).getPiece().getColor() != this.getColor())) {

                res.add((char)(nextFile+'a') + "" + nextRank);
                if(board.getSquare(nextRank, (char)nextFile).getPiece()!=null && board.getSquare(nextRank,
                        (char)nextFile).getPiece().getColor() != this.getColor())
                    break;
                nextRank += yDir[i];
                nextFile += xDir[i];
            }
        }

        return res;
    }

    boolean isValidTargetSquare(List<String>possibleMoves, Square target) {
        String targetMove = target.getFile() + "" + target.getRank();
        return possibleMoves.contains(targetMove);
    }

    public boolean makeMove(Chessboard board, Square current, Square target) {
        if(isValidTargetSquare(this.getPossibleMoves(board,current),target)) {
            target.setPiece(this);
            current.setPiece(null);
            return true;
        } else {
            System.out.println("Invalid move");
            return false;
        }
    }
}
