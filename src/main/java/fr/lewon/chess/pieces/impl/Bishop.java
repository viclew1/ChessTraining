package fr.lewon.chess.pieces.impl;

import java.util.Arrays;
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
		return Arrays.asList(
				new Move(1, 1, true, true, true),
				new Move(1, -1, true, true, true),
				new Move(-1, 1, true, true, true),
				new Move(-1, -1, true, true, true));
	}

	@Override
	public ChessPiece copy() {
		return new Bishop(isWhite());
	}

}
