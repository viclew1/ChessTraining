package fr.lewon.chess;

import fr.lewon.chess.pieces.PieceType;

public class ChessBoard {

	private ChessTile[][] tiles;

	private boolean isWhiteTurn = true;

	public ChessBoard(ChessBoard chessBoard) {
		//TODO impl�menter
	}

	public ChessBoard() {
		this.tiles = new ChessTile[8][8];
		for (int r = 0 ; r < 8 ; r++) {
			for (int c = 0 ; c < 8 ; c++) {
				this.tiles[r][c] = new ChessTile(r, c);
			}
		}
		//TODO impl�menter
	}
	
	/**
	 * V�rifie si la couleur pass�e en param�tre est en echec, retourne true si c'est le cas, false sinon
	 * @param isWhite
	 * @return
	 */
	public boolean isCheck(boolean isWhite) {
		//TODO impl�menter
		return false;
	}

	/**
	 * Voir {@link #play(ChessTile, ChessTile)}
	 * @param fromRow
	 * @param fromCol
	 * @param toRow
	 * @param toCol
	 * @return
	 */
	public boolean play(int fromRow, int fromCol, int toRow, int toCol) {
		return play(tiles[fromRow][fromCol], tiles[toRow][toCol]);
	}

	/**
	 * D�place la pi�ce situ�e sur la case 'from' vers la case 'to'. Retourne true si le d�placement s'est bien pass�, false sinon
	 * @param from
	 * @param to
	 * @return
	 */
	public boolean play(ChessTile from, ChessTile to) {
		//TODO impl�menter
		return false;
	}
	
	/**
	 * Voir {@link #simulatePlay(ChessTile, ChessTile)}
	 * @param fromRow
	 * @param fromCol
	 * @param toRow
	 * @param toCol
	 * @return
	 */
	public ChessBoard simulatePlay(int fromRow, int fromCol, int toRow, int toCol) {
		return simulatePlay(tiles[fromRow][fromCol], tiles[toRow][toCol]);
	}
	
	/**
	 * Simule un coup sur un nouveau ChessBoard, puis rend ce chessboard
	 * @param from
	 * @param to
	 * @return
	 */
	public ChessBoard simulatePlay(ChessTile from, ChessTile to) {
		//TODO impl�menter
		return null;
	}

	/**
	 * Retourne la case pr�sente � la ligne 'row' et � la colonne 'col'
	 * @param row
	 * @param col
	 * @return
	 */
	public ChessTile getTile(int row, int col) {
		return tiles[row][col];
	}

	/**
	 * Retourne true si c'est aux blancs de jouer, false sinon
	 * @return
	 */
	public boolean isWhiteTurn() {
		return isWhiteTurn;
	}

	/**
	 * Retourne la {@link ChessTile} sur laquelle se trouve le roi de la couleur pass�e en param�tre
	 * @param isWhite
	 * @return
	 */
	public ChessTile getKingTile(boolean isWhite) {
		for (int row = 0 ; row < 8 ; row++) {
			for (int col = 0 ; col < 8 ; col++) {
				ChessTile tile = getTile(row, col);
				if (tile.getPiece() != null && tile.getPiece().getType() == PieceType.KING && tile.getPiece().isWhite() == isWhite) {
					return tile;
				}
			}
		}
		return null;
	}

}
