package fr.lewon.chess.pieces.impl;

import java.util.ArrayList;
import java.util.List;

import fr.lewon.chess.moves.Move;
import fr.lewon.chess.pieces.ChessPiece;
import fr.lewon.chess.pieces.PieceType;

public class Knight extends ChessPiece {

	public Knight(boolean isWhite) {
		super(PieceType.KNIGHT, isWhite);
	}

	@Override
	public List<Move> getPossibleMoves() {

		List<Move> moves = new ArrayList<>(); 
		moves.add(new Move(1, 1, false, true, true));
		moves.add(new Move(1, -1, false, true, true));

		return moves;
	}
	
	@Override
	public ChessPiece copy() {
		return new Knight(isWhite());
	}

}
