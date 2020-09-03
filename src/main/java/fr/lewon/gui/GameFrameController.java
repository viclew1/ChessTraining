package fr.lewon.gui;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.SwingUtilities;

import javafx.embed.swing.SwingNode;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

public class GameFrameController implements Initializable {

	@FXML
	private AnchorPane chessGamePane;

	@FXML
	private TextArea logsArea;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ChessPane chessPane = new ChessPane();
		chessGamePane.getChildren().add(chessPane);
		AnchorPane.setLeftAnchor(chessPane, 0d);
		AnchorPane.setRightAnchor(chessPane, 0d);
		AnchorPane.setTopAnchor(chessPane, 0d);
		AnchorPane.setBottomAnchor(chessPane, 0d);
	}

	public void startGame() {
		System.out.println("start");
	}

	public void resetGame() {
		System.out.println("reset");
	}

}
