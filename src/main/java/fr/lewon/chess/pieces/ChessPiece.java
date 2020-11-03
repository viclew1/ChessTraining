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
	 * 
	 * @param board
	 * @param tile
	 * @return
	 */
	public List<ChessTile> getAccessibleTiles(ChessBoard board, ChessTile tile) {
		return getAccessibleTiles(board, tile.getRow(), tile.getCol());
	}

	/**
	 * Retourne les cases accessibles par la pièce située sur la case identifiable à
	 * partir des lignes et colonnes en paramètres
	 * 
	 * @param board
	 * @param row
	 * @param col
	 * @return
	 */
	public List<ChessTile> getAccessibleTiles(ChessBoard board, int row, int col) {
		List<ChessTile> accessibleTiles = new ArrayList<>();
		List<Move> possibleMoves = getPossibleMoves();

		for (Move move : possibleMoves) {

			int limit = move.isRepeatable() ? 8 : 1;
			
			ChessPiece chessPiece = board.getTile(row, col).getPiece();
			chessPiece.getType();
			
			
			for (int i = 0; i < limit; i++) {

				int newRow = row + move.getdRow() * (i + 1);
				int newCol = col + move.getdCol() * (i + 1);

				if (newRow < 0 || newRow >= 8 || newCol < 0 || newCol >= 8) {
					break;
				}
				ChessPiece potentialChessPiece = board.getTile(newRow, newCol).getPiece();

				if (potentialChessPiece != null && potentialChessPiece.isWhite == this.isWhite) {
					break;
				}
				accessibleTiles.add(board.getTile(newRow, newCol));
			}
		}

		return accessibleTiles;

	}

	/**
	 * Retourne les {@link Move} réalisables pour la pièce en question
	 * 
	 * @return
	 */
	protected abstract List<Move> getPossibleMoves();

	public abstract ChessPiece copy();

}
