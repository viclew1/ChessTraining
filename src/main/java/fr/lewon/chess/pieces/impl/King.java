package fr.lewon.chess.pieces.impl;

import java.util.Arrays;
import java.util.List;

import fr.lewon.chess.moves.Move;
import fr.lewon.chess.pieces.ChessPiece;
import fr.lewon.chess.pieces.PieceType;

public class King extends ChessPiece {

	public King(boolean isWhite) {
		super(PieceType.KING, isWhite);
	}

	@Override
	public String draw() {
		return "K";
	}

	@Override
	public List<Move> getPossibleMoves() {
		return Arrays.asList(
				new Move(1, -1, false, true, true),
				new Move(1, 1, false, true, true),
				new Move(-1, -1, false, true, true),
				new Move(-1, 1, false, true, true),
				new Move(0, -1, false, true, true),
				new Move(0, 1, false, true, true),
				new Move(1, 0, false, true, true),
				new Move(-1, 0, false, true, true));
	}
	
	@Override
	public ChessPiece copy() {
		return new King(isWhite());
	}

}
