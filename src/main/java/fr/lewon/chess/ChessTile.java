package fr.lewon.chess;

import fr.lewon.chess.pieces.ChessPiece;

public class ChessTile {
	
	private ChessPiece piece;
	private int row;
	private int col;
	
	public ChessTile(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public String draw() {
		return piece == null ? " " : piece.draw();
	}

	public ChessPiece getPiece() {
		return piece;
	}

	public void setPiece(ChessPiece piece) {
		this.piece = piece;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

}
