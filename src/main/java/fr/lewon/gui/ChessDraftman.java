package fr.lewon.gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChessDraftman {

	private JPanel chessPane;
	
	public void start() {
		chessPane = new ChessPane();
		JFrame jf = new JFrame("Chess board");
		jf.setContentPane(chessPane);
		jf.setSize(new Dimension(200, 300));
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
