package fr.lewon.chess;

import fr.lewon.chess.pieces.ChessPiece;
import fr.lewon.chess.pieces.PieceType;
import fr.lewon.chess.pieces.impl.Bishop;
import fr.lewon.chess.pieces.impl.King;
import fr.lewon.chess.pieces.impl.Knight;
import fr.lewon.chess.pieces.impl.Pawn;
import fr.lewon.chess.pieces.impl.Queen;
import fr.lewon.chess.pieces.impl.Rook;

public class ChessBoard {

	private ChessTile[][] tiles;

	private boolean isWhiteTurn = true;

	public ChessBoard(ChessBoard chessBoard) {
		//TODO implémenter
	}

	public ChessBoard() {
		this.tiles = new ChessTile[8][8];
		for (int r = 0 ; r < 8 ; r++) {
			for (int c = 0 ; c < 8 ; c++) {
				this.tiles[r][c] = new ChessTile(r, c);
			}
		}
		this.tiles[0][0].setPiece(new Rook(true));
		this.tiles[0][1].setPiece(new Knight(true));
		this.tiles[0][2].setPiece(new Bishop(true));
		this.tiles[0][3].setPiece(new Queen(true));
		this.tiles[0][4].setPiece(new King(true));
		this.tiles[0][5].setPiece(new Bishop(true));
		this.tiles[0][6].setPiece(new Knight(true));
		this.tiles[0][7].setPiece(new Rook(true));

		this.tiles[7][0].setPiece(new Rook(false));
		this.tiles[7][1].setPiece(new Knight(false));
		this.tiles[7][2].setPiece(new Bishop(false));
		this.tiles[7][3].setPiece(new Queen(false));
		this.tiles[7][4].setPiece(new King(false));
		this.tiles[7][5].setPiece(new Bishop(false));
		this.tiles[7][6].setPiece(new Knight(false));
		this.tiles[7][7].setPiece(new Rook(false));
		
//		
//		this.tiles[1][0].setPiece(new Pawn(true));
//		this.tiles[1][1].setPiece(new Pawn(true));
//		this.tiles[1][2].setPiece(new Pawn(true));
//		this.tiles[1][3].setPiece(new Pawn(true));
//		this.tiles[1][4].setPiece(new Pawn(true));
//		this.tiles[1][5].setPiece(new Pawn(true));
//		this.tiles[1][6].setPiece(new Pawn(true));
//		this.tiles[1][7].setPiece(new Pawn(true));
//
//
//		this.tiles[6][0].setPiece(new Pawn(false));
//		this.tiles[6][1].setPiece(new Pawn(false));
//		this.tiles[6][2].setPiece(new Pawn(false));
//		this.tiles[6][3].setPiece(new Pawn(false));
//		this.tiles[6][4].setPiece(new Pawn(false));
//		this.tiles[6][5].setPiece(new Pawn(false));
//		this.tiles[6][6].setPiece(new Pawn(false));
//		this.tiles[6][7].setPiece(new Pawn(false));

		
	}
	
	/**
	 * Vérifie si la couleur passée en paramètre est en echec, retourne true si c'est le cas, false sinon
	 * @param isWhite
	 * @return
	 */
	public boolean isCheck(boolean isWhite) {
		//TODO implémenter
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
	 * Déplace la pièce située sur la case 'from' vers la case 'to'. Retourne true si le déplacement s'est bien passé, false sinon
	 * @param from
	 * @param to
	 * @return
	 */
	public boolean play(ChessTile from, ChessTile to) {
		 
		ChessPiece movedPiece = from.getPiece();
		from.setPiece(null);
		to.setPiece(movedPiece);
		
		return true;
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
		//TODO implémenter
		return null;
	}

	/**
	 * Retourne la case présente à la ligne 'row' et à la colonne 'col'
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
	 * Retourne la {@link ChessTile} sur laquelle se trouve le roi de la couleur passée en paramètre
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
