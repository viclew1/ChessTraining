package fr.lewon.chess.pieces.impl;

import java.util.ArrayList;
import java.util.List;
import fr.lewon.chess.moves.Move;
import fr.lewon.chess.pieces.ChessPiece;
import fr.lewon.chess.pieces.PieceType;

public class Pawn extends ChessPiece {

	public Pawn(boolean isWhite) {
		super(PieceType.PAWN, isWhite);
	}

	@Override
	public List<Move> getPossibleMoves() {
		List<Move> moves = new ArrayList<>(); 
		
		
		if (this.isWhite() && this.isAlreadyMoved()==false) {
			moves.add(new Move(1, 0, false, true, true)); //descend d'une cases
			moves.add(new Move(2, 0, false, true, true)); //descend de deux cases
		} else if (this.isWhite() && this.isAlreadyMoved()) { 
			moves.add(new Move(1, 0, false, true, true)); //descend d'une case
		} else if (this.isWhite()==false && this.isAlreadyMoved()==false) { 
			moves.add(new Move(-1, 0, false, true, true)); //monte d'une cases
			moves.add(new Move(-2, 0, false, true, true)); //monte de deux cases
		} else if (this.isWhite()==false && this.isAlreadyMoved()) { 
			moves.add(new Move(-1, 0, false, true, true)); //monte d'une case
		}
		
//		moves.add(new Move(1, 1, false, true, true)); //descend d'une case + une case à droite
//		moves.add(new Move(1, -1, false, true, true)); //descend d'une case + une case à gauche 
//		moves.add(new Move(-1, -1, false, true, true)); //monte d'une case + une case à gauche
//		moves.add(new Move(-1, 1, false, true, true)); //monte d'une case + une case à droite 
		
		return moves;
	}
	
	@Override
	public ChessPiece copy() {
		return new Pawn(isWhite());
	}

}
