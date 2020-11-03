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

		List<Move> moves = new ArrayList<>();
		moves.add(new Move(1, 1, true, true, true)); //une case à droite + descend d'une case
		moves.add(new Move(1, -1, true, true, true)); //une case à gauche + descend d'une case
		moves.add(new Move(-1, -1, true, true, true)); //une case à gauche + monte d'une case
		moves.add(new Move(-1, 1, true, true, true)); //une case à droite + monte d'une case
		
		return moves;
	}

	@Override
	public ChessPiece copy() {
		return new Bishop(isWhite());
	}

}
