package fr.lewon.chess.pieces.impl;

import java.util.Arrays;
import java.util.List;
import fr.lewon.chess.moves.Move;
import fr.lewon.chess.pieces.ChessPiece;
import fr.lewon.chess.pieces.PieceType;

public class Pawn extends ChessPiece {

	public Pawn(boolean isWhite) {
		super(PieceType.PAWN, isWhite);
	}

	@Override
	public String draw() {
		return "P";
	}

	@Override
	public List<Move> getPossibleMoves() {
		return Arrays.asList(
				new Move(isWhite() ? -1 : 1, 0, false, false, true),
				new Move(isWhite() ? -2 : 2, 0, false, false, true, (b, r, c) -> !isAlreadyMoved()),
				new Move(isWhite() ? -1 : 1, 1, false, true, false),
				new Move(isWhite() ? -1 : 1, -1, false, true, false));
	}
	
	@Override
	public ChessPiece copy() {
		return new Pawn(isWhite());
	}

}
