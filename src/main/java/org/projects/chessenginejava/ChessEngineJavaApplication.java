package org.projects.chessenginejava;

import org.projects.chessenginejava.board.Chessboard;
import org.projects.chessenginejava.pieces.Piece;
import org.projects.chessenginejava.utils.Utility;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChessEngineJavaApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(ChessEngineJavaApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        String exampleNotation = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";
        Utility.printChessBoardExpression(exampleNotation);

        Chessboard board = Chessboard.getInstance();

        System.out.println(board.getSquare(1, 4).getPiece()
                .getPossibleMoves(board, board.getSquare(1, 4)));

        System.out.println(board.getSquare(1, 4).getPiece().makeMove(board, board.getSquare(1,4), board.getSquare(3,
                4)));

        System.out.println(board.getSquare(3, 4).getPiece()
                .getPossibleMoves(board, board.getSquare(3, 4)));

        System.out.println(board);

    }
}
