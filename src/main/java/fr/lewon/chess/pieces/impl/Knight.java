package fr.lewon.chess.pieces.impl;

import java.util.Arrays;
import java.util.List;

import fr.lewon.chess.moves.Move;
import fr.lewon.chess.pieces.ChessPiece;
import fr.lewon.chess.pieces.PieceType;

public class Knight extends ChessPiece {

	public Knight(boolean isWhite) {
		super(PieceType.KNIGHT, isWhite);
	}

	@Override
	public String draw() {
		return "H";
	}

	@Override
	public List<Move> getPossibleMoves() {
		return Arrays.asList(
				new Move(2, 1, false, true, true),  
				new Move(2, -1, false, true, true), 
				new Move(-2, 1, false, true, true), 
				new Move(-2, -1, false, true, true),
				new Move(1, 2, false, true, true),  
				new Move(1, -2, false, true, true), 
				new Move(-1, 2, false, true, true),
				new Move(-1, -2, false, true, true));
	}
	
	@Override
	public ChessPiece copy() {
		return new Knight(isWhite());
	}

}
