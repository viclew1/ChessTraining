package fr.lewon.chess.pieces;

import java.util.ArrayList;
import java.util.List;

import fr.lewon.chess.ChessBoard;
import fr.lewon.chess.ChessTile;
import fr.lewon.chess.moves.Move;

public abstract class ChessPiece {

	private boolean alreadyMoved = false;
	private final PieceType type;
	private final boolean isWhite;


	public ChessPiece(PieceType type, boolean isWhite) {
		this.type = type;
		this.isWhite = isWhite;
	}


	public PieceType getType() {
		return type;
	}

	public boolean isWhite() {
		return isWhite;
	}

	public boolean isAlreadyMoved() {
		return alreadyMoved;
	}


	public void setAlreadyMoved(boolean alreadyMoved) {
		this.alreadyMoved = alreadyMoved;
	}
	
	/**
	 * Voir {@link #getAccessibleTiles(ChessBoard, int, int)}
	 * @param board
	 * @param tile
	 * @return
	 */
	public List<ChessTile> getAccessibleTiles(ChessBoard board, ChessTile tile) {
		return getAccessibleTiles(board, tile.getRow(), tile.getCol());
	}
	
	/**
	 * Retourne les cases accessibles par la pi�ce situ�e sur la case identifiable � partir des lignes et colonnes en param�tres
	 * 
	 * @param board
	 * @param row
	 * @param col
	 * @return
	 */
	public List<ChessTile> getAccessibleTiles(ChessBoard board, int row, int col) {
		//TODO impl�menter
		return new ArrayList<>();
	}

	/**
	 * Retourne les {@link Move} r�alisables pour la pi�ce en question
	 * @return
	 */
	protected abstract List<Move> getPossibleMoves();


	public abstract ChessPiece copy();


}
