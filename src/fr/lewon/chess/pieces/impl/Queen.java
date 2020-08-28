package fr.lewon.chess.pieces.impl;

import java.util.Arrays;
import java.util.List;

import fr.lewon.chess.moves.Move;
import fr.lewon.chess.pieces.ChessPiece;
import fr.lewon.chess.pieces.PieceType;

public class Queen extends ChessPiece {

	public Queen(boolean isWhite) {
		super(PieceType.QUEEN, isWhite);
	}

	@Override
	public String draw() {
		return "Q";
	}

	@Override
	public List<Move> getPossibleMoves() {
		return Arrays.asList(
				new Move(1, -1, true, true, true),
				new Move(1, 1, true, true, true),
				new Move(-1, -1, true, true, true),
				new Move(-1, 1, true, true, true),
				new Move(0, -1, true, true, true),
				new Move(0, 1, true, true, true),
				new Move(1, 0, true, true, true),
				new Move(-1, 0, true, true, true));
	}
	
	@Override
	public ChessPiece copy() {
		return new Queen(isWhite());
	}
	
}
