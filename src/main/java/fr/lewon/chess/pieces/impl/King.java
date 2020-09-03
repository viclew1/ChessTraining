package fr.lewon.chess.pieces.impl;

import java.util.ArrayList;
import java.util.List;

import fr.lewon.chess.moves.Move;
import fr.lewon.chess.pieces.ChessPiece;
import fr.lewon.chess.pieces.PieceType;

public class King extends ChessPiece {

	public King(boolean isWhite) {
		super(PieceType.KING, isWhite);
	}

	@Override
	public List<Move> getPossibleMoves() {
		//TODO implémenter
		return new ArrayList<>();
	}
	
	@Override
	public ChessPiece copy() {
		return new King(isWhite());
	}

}
