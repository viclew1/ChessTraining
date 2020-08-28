package fr.lewon.chess.pieces;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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


	public abstract String draw();


	public boolean isWhite() {
		return isWhite;
	}

	public boolean isAlreadyMoved() {
		return alreadyMoved;
	}


	public void setAlreadyMoved(boolean alreadyMoved) {
		this.alreadyMoved = alreadyMoved;
	}
	
	public List<ChessTile> getAccessibleTiles(ChessBoard board, ChessTile tile) {
		return getAccessibleTiles(board, tile.getRow(), tile.getCol());
	}
	
	public List<ChessTile> getAccessibleTiles(ChessBoard board, int row, int col) {
		return getAccessibleTiles(board, row, col, true);
	}

	public List<ChessTile> getAccessibleTiles(ChessBoard board, int row, int col, boolean verifyCheck) {
		List<ChessTile> accessibleTiles = new ArrayList<>();
		for (Move m : getPossibleMoves()) {
			int repeat = m.isRepeatable() ? 8 : 1;
			for (int i = 1 ; i <= repeat ; i++) {
				int newRow = row + m.getdRow() * i;
				int newCol = col + m.getdCol() * i;
				if (newRow < 0 || newRow >= 8 || newCol < 0 || newCol >= 8) {
					break;
				}
				ChessTile tile = board.getTile(newRow, newCol);
				ChessPiece chessPiece = tile.getPiece();
				if (chessPiece != null) {
					if (m.isCanAttack() && chessPiece.isWhite != this.isWhite && m.getSpecificChecks().check(board, row, col)) {
						accessibleTiles.add(tile);
					}
					break;
				}
				if (m.isCanMoveTowardEmpty() && m.getSpecificChecks().check(board, row, col)) {
					accessibleTiles.add(tile);	
				}
			}
		}
		return accessibleTiles.stream()
				.filter((t) -> !verifyCheck || checkOk(board, row, col, t.getRow(), t.getCol()))
				.collect(Collectors.toList());
	}
	
	private boolean checkOk(ChessBoard board, int fromRow, int fromCol, int toRow, int toCol) {
		return !board.simulatePlay(fromRow, fromCol, toRow, toCol).isCheck(isWhite);
	}

	protected abstract List<Move> getPossibleMoves();


	public abstract ChessPiece copy();


}
