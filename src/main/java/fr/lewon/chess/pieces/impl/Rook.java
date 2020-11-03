package fr.lewon.chess.pieces.impl;

import java.util.ArrayList;
import java.util.List;

import fr.lewon.chess.moves.Move;
import fr.lewon.chess.pieces.ChessPiece;
import fr.lewon.chess.pieces.PieceType;

public class Rook extends ChessPiece {

	public Rook(boolean isWhite) {
		super(PieceType.ROOK, isWhite);
	}

	@Override
	public List<Move> getPossibleMoves() {
		
		List<Move> moves = new ArrayList<>(); 
		moves.add(new Move(0, -1, true, true, true)); //une case � gauche
		moves.add(new Move(0, 1, true, true, true)); //une case � droite
		moves.add(new Move(1, 0, true, true, true)); //descend d'une case
		moves.add(new Move(-1, 0, true, true, true)); //monte d'une case
		
		return moves;
	}
	
	@Override
	public ChessPiece copy() {
		return new Rook(isWhite());
	}

}
