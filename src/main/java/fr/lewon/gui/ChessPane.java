package fr.lewon.gui;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import fr.lewon.chess.ChessBoard;
import fr.lewon.chess.ChessTile;
import fr.lewon.chess.pieces.PieceType;

public class ChessPane extends JPanel implements MouseListener, MouseMotionListener {
	
	private static final long serialVersionUID = 3139012877415286207L;
	
	private ChessBoard chessBoard;
	private ChessTile hoveredTile;
	private ChessTile selectedTile;
	private List<ChessTile> possibleMoves = new ArrayList<>();

	public ChessPane() {
		resetGame();
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}

	@Override
	public void paint(Graphics g) {
		super.getRootPane().updateUI();
		int sizeCell = Math.min(getSize().width, getSize().height) / 8;
		for (int i = 0 ; i < 8 ; i++) {
			for (int j = 0 ; j < 8 ; j++) {
				ChessTile tile = chessBoard.getTile(i, j);
				int x = j * sizeCell;
				int y = i * sizeCell;
				int cellCount = i % 2 + j;
				if (tile.getPiece() != null && tile.getPiece().getType() == PieceType.KING && chessBoard.isCheck(tile.getPiece().isWhite())) {
					g.setColor(Color.RED);
				} else if (tile == selectedTile) {
					g.setColor(Color.BLUE);
				} else if (tile == hoveredTile) {
					g.setColor(Color.CYAN);
				} else if (possibleMoves.contains(tile)) {
					g.setColor(Color.GREEN);
				} else {
					g.setColor(cellCount % 2 == 0 ? Color.LIGHT_GRAY : Color.GRAY);	
				}
				g.fillRect(x, y, sizeCell, sizeCell);
				if (tile.getPiece() != null) {
					g.setColor(tile.getPiece().isWhite() ? Color.WHITE : Color.DARK_GRAY);
					g.fillRect(x + sizeCell / 5, y + sizeCell / 5, sizeCell * 3 / 5, sizeCell * 3 / 5);
					g.setColor(Color.BLACK);
					g.drawRect(x + sizeCell / 5, y + sizeCell / 5, sizeCell * 3 / 5, sizeCell * 3 / 5);
					g.setColor(tile.getPiece().isWhite() ? Color.BLACK : Color.WHITE);
					drawTextCenterRect(g, x, y, sizeCell, sizeCell, tile.getPiece().draw());
				}
				g.setColor(Color.BLACK);
				g.drawRect(x, y, sizeCell, sizeCell);
			}
		}
	}
	
	public void resetGame() {
		this.chessBoard = new ChessBoard();
		hoveredTile = null;
		selectedTile = null;
		possibleMoves = new ArrayList<>();
	}
	
	private void drawTextCenterRect(Graphics g, int x, int y, int w, int h, String text) {
		Graphics2D g2d = (Graphics2D) g;
        FontMetrics fm = g2d.getFontMetrics();
        Rectangle2D r = fm.getStringBounds(text, g2d);
        int xTxt = (x + w / 2 - (int) r.getWidth() / 2);
        int yTxt = (y + h / 2 - (int) r.getHeight() / 2) + fm.getAscent();
        g.drawString(text, xTxt, yTxt);
	}
	
	private ChessTile getTileAtLoc(int x, int y) {
		int sizeCell = Math.min(getSize().width, getSize().height) / 8;
		if (x < sizeCell * 8 && y < sizeCell * 8) {
			int row = y / sizeCell;
			int col = x / sizeCell;
			return chessBoard.getTile(row, col);
		}
		return null;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		hoveredTile = getTileAtLoc(e.getX(), e.getY());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		ChessTile tile = getTileAtLoc(e.getX(), e.getY());
		if (possibleMoves.contains(tile)) {
			playMove(selectedTile, tile);
		} else {
			selectNewTile(selectedTile, tile);
		}
	}

	private void playMove(ChessTile from, ChessTile to) {
		selectedTile = null;
		possibleMoves.clear();
		chessBoard.play(from, to);
	}

	private void selectNewTile(ChessTile previouslySelectedTile, ChessTile clickedTile) {
		selectedTile = null;
		possibleMoves.clear();
		if (clickedTile.getPiece() != null) {
			selectedTile = clickedTile;
			possibleMoves.addAll(selectedTile.getPiece().getAccessibleTiles(chessBoard, clickedTile));
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
