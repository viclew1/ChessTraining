package fr.lewon.chess.pieces.impl;

import java.util.ArrayList;
import java.util.List;

import fr.lewon.chess.moves.Move;
import fr.lewon.chess.pieces.ChessPiece;
import fr.lewon.chess.pieces.PieceType;

public class Knight extends ChessPiece {

	public Knight(boolean isWhite) {
		super(PieceType.KNIGHT, isWhite);
	}

	@Override
	public List<Move> getPossibleMoves() {

		List<Move> moves = new ArrayList<>(); 
		moves.add(new Move(2, 1, false, true, true)); //descend de deux cases + une case à droite 
		moves.add(new Move(2, -1, false, true, true)); //descend de deux cases + une case à gauche
		moves.add(new Move(1, -2, false, true, true)); //descend d'une case + deux cases à gauche
		moves.add(new Move(1, 2, false, true, true)); //descend d'une case + deux cases à droite
		moves.add(new Move(-1, -2, false, true, true)); //monte d'une case + deux cases à droite
		moves.add(new Move(-1, 2, false, true, true)); //monte d'une case + deux cases à gauche
		moves.add(new Move(-2, 1, false, true, true)); //monte de deux cases + deux cases à droite
		moves.add(new Move(-2, -1, false, true, true)); //monte de deux cases + deux cases à gauche

		return moves;
	}
	
	@Override
	public ChessPiece copy() {
		return new Knight(isWhite());
	}

}
