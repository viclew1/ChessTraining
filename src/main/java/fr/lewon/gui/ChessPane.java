package fr.lewon.gui;

import java.util.ArrayList;
import java.util.List;

import fr.lewon.chess.ChessBoard;
import fr.lewon.chess.ChessTile;
import fr.lewon.chess.pieces.PieceType;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class ChessPane extends GridPane {

	private ChessBoard chessBoard;
	private ChessTile hoveredTile;
	private ChessTile selectedTile;
	private ChessTile lastMoveFrom;
	private ChessTile lastMoveTo;
	private Rectangle[][] colorSquares = new Rectangle[8][8];
	private Rectangle[][] pieceSquares = new Rectangle[8][8];
	private List<ChessTile> possibleMoves = new ArrayList<>();

	public ChessPane() {
		resetGame();
		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 8; c++) {
				final int row = r;
				final int col = c;
				StackPane stack = new StackPane();
				stack.setBackground(new Background(new BackgroundFill(((row + col) % 2 == 0) ? Color.BURLYWOOD.darker() : Color.BURLYWOOD, CornerRadii.EMPTY, Insets.EMPTY)));
				stack.setStyle("-fx-border-color:black;"	);
				Rectangle pieceSquare = new Rectangle();
				Rectangle colorSquare = new Rectangle();
				
				colorSquares[row][col] = colorSquare;
				pieceSquares[row][col] = pieceSquare;
				
				colorSquare.setOpacity(0.8d);
				stack.getChildren().add(colorSquare);
				stack.getChildren().add(pieceSquare);

				colorSquare.setFill(Color.TRANSPARENT);
				pieceSquare.setFill(Color.TRANSPARENT);
				
				stack.addEventFilter(MouseEvent.MOUSE_MOVED, (e) -> {
					mouseMoved(row, col);
					updateBoard();
				});
				stack.addEventFilter(MouseEvent.MOUSE_CLICKED, (e) -> {
					mouseClicked(row, col);
					updateBoard();
				});

				ChessTile tile = chessBoard.getTile(row, col);
				if (tile.getPiece() != null) {
					String resourceName = tile.getPiece().isWhite() ? "W" : "B";
					resourceName += "_" + tile.getPiece().getType().name().toLowerCase() + ".png";
					pieceSquare.setFill(new ImagePattern(new Image("/" + resourceName)));
				}
				
				add(stack, col, row);
				pieceSquare.widthProperty().bind(widthProperty().divide(8).subtract(2));
				pieceSquare.heightProperty().bind(heightProperty().divide(8).subtract(3));
				colorSquare.widthProperty().bind(widthProperty().divide(8).subtract(2));
				colorSquare.heightProperty().bind(heightProperty().divide(8).subtract(3));
			}
		}
	}

	public void updateBoard() {
		
	}

	public void resetGame() {
		this.chessBoard = new ChessBoard();
		hoveredTile = null;
		selectedTile = null;
		possibleMoves = new ArrayList<>();
	}
	
	private void resetColor(int row, int col) {
		ChessTile tile = chessBoard.getTile(row, col);
		Rectangle colorSquare = colorSquares[row][col];
		Color color;
		if (selectedTile == tile) {
			color = Color.BLUE;
		} else if (hoveredTile == tile) {
			color = Color.CYAN;
		} else if (tile.getPiece() != null && tile.getPiece().getType() == PieceType.KING && chessBoard.isCheck(tile.getPiece().isWhite())) {
			color = Color.RED;
		} else if (possibleMoves.contains(tile)) {
			color = Color.GREEN;
		} else if (lastMoveFrom == tile) {
			color = Color.GREY;
		} else if (lastMoveTo == tile) {
			color = Color.DARKGREY;
		} else {
			color = Color.TRANSPARENT;
		}
		colorSquare.setFill(color);
	}

	public void mouseMoved(int row, int col) {
		ChessTile oldHoveredTile = hoveredTile;
		hoveredTile = chessBoard.getTile(row, col);
		if (oldHoveredTile != null) {
			resetColor(oldHoveredTile.getRow(), oldHoveredTile.getCol());
		}
		if (hoveredTile != null && hoveredTile != selectedTile) {
			resetColor(row, col);
		}
	}

	public void mouseClicked(int row, int col) {
		ChessTile tile = chessBoard.getTile(row, col);
		if (possibleMoves.contains(tile)) {
			playMove(selectedTile, tile);
		} else {
			selectNewTile(selectedTile, tile);
		}
	}

	private void playMove(ChessTile from, ChessTile to) {
		selectedTile = null;
		if (chessBoard.play(from, to)) {
			ChessTile oldLastMoveFrom = lastMoveFrom;
			ChessTile oldLastMoveTo = lastMoveTo;
			lastMoveFrom = from;
			lastMoveTo = to;
			if (oldLastMoveFrom != null) {
				resetColor(oldLastMoveFrom.getRow(), oldLastMoveFrom.getCol());
			}
			if (oldLastMoveTo != null) {
				resetColor(oldLastMoveTo.getRow(), oldLastMoveTo.getCol());				
			}
			resetColor(lastMoveFrom.getRow(), lastMoveFrom.getCol());
			resetColor(lastMoveTo.getRow(), lastMoveTo.getCol());
			Rectangle fromPieceSquare = pieceSquares[from.getRow()][from.getCol()];
			Rectangle toPieceSquare = pieceSquares[to.getRow()][to.getCol()];
			toPieceSquare.setFill(fromPieceSquare.getFill());
			fromPieceSquare.setFill(Color.TRANSPARENT);
			updatePossibleMoves(new ArrayList<>());
			ChessTile kingTile = chessBoard.getKingTile(chessBoard.isWhiteTurn());
			resetColor(kingTile.getRow(), kingTile.getCol());
		}
	}

	private void selectNewTile(ChessTile previouslySelectedTile, ChessTile clickedTile) {
		ChessTile oldSelectedTile = selectedTile;
		selectedTile = null;
		if (oldSelectedTile != null) {
			resetColor(oldSelectedTile.getRow(), oldSelectedTile.getCol());
		}
		if (clickedTile != null && clickedTile.getPiece() != null) {
			selectedTile = clickedTile;
			updatePossibleMoves(selectedTile.getPiece().getAccessibleTiles(chessBoard, clickedTile));
		} else {
			updatePossibleMoves(new ArrayList<>());
		}
	}
	
	private void updatePossibleMoves(List<ChessTile> newPossibleMoves) {
		List<ChessTile> oldPossibleMoves = possibleMoves;
		possibleMoves = newPossibleMoves;
		for (ChessTile move : oldPossibleMoves) {
			resetColor(move.getRow(), move.getCol());
		}
		for (ChessTile move : possibleMoves) {
			resetColor(move.getRow(), move.getCol());
		}
	}
	
}
