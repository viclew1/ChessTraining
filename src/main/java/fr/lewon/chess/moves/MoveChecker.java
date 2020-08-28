package fr.lewon.chess.moves;

import fr.lewon.chess.ChessBoard;

public interface MoveChecker {
	
	boolean check(ChessBoard board, int row, int col);
	
}