package fr.lewon.chess.pieces.impl;

import java.util.ArrayList;
import java.util.List;

import fr.lewon.chess.moves.Move;
import fr.lewon.chess.pieces.ChessPiece;
import fr.lewon.chess.pieces.PieceType;

public class Bishop extends ChessPiece {

	public Bishop(boolean isWhite) {
		super(PieceType.BISHOP, isWhite);
	}

	@Override
	protected List<Move> getPossibleMoves() {
		//TODO impl�menter
		return new ArrayList<>();
	}

	@Override
	public ChessPiece copy() {
		return new Bishop(isWhite());
	}

}
