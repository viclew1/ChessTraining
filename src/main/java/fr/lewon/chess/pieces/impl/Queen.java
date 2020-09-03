package fr.lewon.chess.pieces.impl;

import java.util.ArrayList;
import java.util.List;

import fr.lewon.chess.moves.Move;
import fr.lewon.chess.pieces.ChessPiece;
import fr.lewon.chess.pieces.PieceType;

public class Queen extends ChessPiece {

	public Queen(boolean isWhite) {
		super(PieceType.QUEEN, isWhite);
	}

	@Override
	public List<Move> getPossibleMoves() {
		//TODO implémenter
		return new ArrayList<>();
	}
	
	@Override
	public ChessPiece copy() {
		return new Queen(isWhite());
	}
	
}
