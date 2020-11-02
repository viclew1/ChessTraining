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

		List<Move> moves = new ArrayList<>(); 
		moves.add(new Move(1, 1, false, true, true)); //une case � droite + descend d'une case
		moves.add(new Move(1, -1, false, true, true)); //une case � gauche + descend d'une case
		moves.add(new Move(0, -1, false, true, true)); //une case � gauche
		moves.add(new Move(0, 1, false, true, true)); //une case � droite
		moves.add(new Move(1, 0, false, true, true)); //descend d'une case
		moves.add(new Move(-1, 0, false, true, true)); //monte d'une case
		moves.add(new Move(-1, -1, false, true, true)); //une case � gauche + monte d'une case
		moves.add(new Move(-1, 1, false, true, true)); //une case � droite + monte d'une case
		
		return moves;
	}
	
	@Override
	public ChessPiece copy() {
		return new King(isWhite());
	}

}

