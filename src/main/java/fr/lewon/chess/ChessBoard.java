package fr.lewon.chess;

import fr.lewon.chess.pieces.ChessPiece;
import fr.lewon.chess.pieces.PieceType;
import fr.lewon.chess.pieces.impl.Bishop;
import fr.lewon.chess.pieces.impl.Knight;
import fr.lewon.chess.pieces.impl.King;
import fr.lewon.chess.pieces.impl.Pawn;
import fr.lewon.chess.pieces.impl.Queen;
import fr.lewon.chess.pieces.impl.Rook;

public class ChessBoard {

	private ChessTile[][] tiles;

	private boolean isWhiteTurn = true;

	public ChessBoard(ChessBoard chessBoard) {
		this.tiles = new ChessTile[8][8];
		for (int r = 0 ; r < 8 ; r++) {
			for (int c = 0 ; c < 8 ; c++) {
				this.tiles[r][c] = new ChessTile(r, c);
				ChessPiece piece = chessBoard.tiles[r][c].getPiece();
				this.tiles[r][c].setPiece(piece == null ? null : piece.copy());
			}
		}
	}

	public ChessBoard() {
		this.tiles = new ChessTile[8][8];
		for (int r = 0 ; r < 8 ; r++) {
			for (int c = 0 ; c < 8 ; c++) {
				this.tiles[r][c] = new ChessTile(r, c);
			}
		}
		tiles[0][0].setPiece(new Rook(false));
		tiles[0][7].setPiece(new Rook(false));
		tiles[7][0].setPiece(new Rook(true));
		tiles[7][7].setPiece(new Rook(true));

		tiles[0][1].setPiece(new Knight(false));
		tiles[0][6].setPiece(new Knight(false));
		tiles[7][1].setPiece(new Knight(true));
		tiles[7][6].setPiece(new Knight(true));

		tiles[0][2].setPiece(new Bishop(false));
		tiles[0][5].setPiece(new Bishop(false));
		tiles[7][2].setPiece(new Bishop(true));
		tiles[7][5].setPiece(new Bishop(true));

		tiles[0][3].setPiece(new Queen(false));
		tiles[0][4].setPiece(new King(false));
		tiles[7][3].setPiece(new Queen(true));
		tiles[7][4].setPiece(new King(true));

		for (int i = 0 ; i < 8 ; i++) {
			tiles[1][i].setPiece(new Pawn(false));
			tiles[6][i].setPiece(new Pawn(true));			
		}
	}

	public boolean isCheck(boolean isWhite) {
		for (int row = 0 ; row < 8 ; row ++) {
			for (int col = 0 ; col < 8 ; col ++) {
				ChessPiece cp = getTile(row, col).getPiece();
				if (cp != null && cp.isWhite() != isWhite) {
					for (ChessTile dest : cp.getAccessibleTiles(this, row, col, false)) {
						ChessPiece target = dest.getPiece();
						if (target != null && target.getType() == PieceType.KING) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	public String drawString() {
		StringBuilder sb = new StringBuilder();
		for (ChessTile[] line: tiles) {
			for (ChessTile tile : line) {
				sb.append(tile.draw() + "|");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public boolean play(int fromRow, int fromCol, int toRow, int toCol) {
		return play(tiles[fromRow][fromCol], tiles[toRow][toCol]);
	}

	public boolean play(ChessTile from, ChessTile to) {
		ChessPiece piece = from.getPiece();
		if (piece == null) {
			return false;
		}
		if (piece.isWhite() != isWhiteTurn) {
			return false;
		}
		from.setPiece(null);
		to.setPiece(piece);
		isWhiteTurn = !isWhiteTurn;
		piece.setAlreadyMoved(true);
		return true;
	}
	
	public ChessBoard simulatePlay(int fromRow, int fromCol, int toRow, int toCol) {
		return simulatePlay(tiles[fromRow][fromCol], tiles[toRow][toCol]);
	}
	
	public ChessBoard simulatePlay(ChessTile from, ChessTile to) {
		ChessBoard board = new ChessBoard(this);
		ChessTile newFrom = board.getTile(from.getRow(), from.getCol());
		ChessTile newTo = board.getTile(to.getRow(), to.getCol());
		ChessPiece piece = from.getPiece();
		newFrom.setPiece(null);
		newTo.setPiece(piece);
		return board;
	}


	public ChessTile getTile(int row, int col) {
		return tiles[row][col];
	}

}
