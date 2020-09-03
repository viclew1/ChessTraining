package fr.lewon.gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GameFrameController implements Initializable {

	@FXML
	private AnchorPane chessGamePane;

	private StackPane contentPane;

	private Rectangle disabledRectangle;

	@FXML
	private TextArea logsArea;
	@FXML
	private Button startBtn;
	@FXML
	private Button resetBtn;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		contentPane = new StackPane();
		disabledRectangle = new Rectangle();
		disabledRectangle.setFill(Color.BLACK);
		disabledRectangle.setOpacity(0.5);
		disabledRectangle.widthProperty().bind(contentPane.widthProperty());
		disabledRectangle.heightProperty().bind(contentPane.heightProperty());
		initChessGamePane();
		disable();
	}

	private void initChessGamePane() {
		ChessPane chessPane = new ChessPane();
		AnchorPane.setLeftAnchor(contentPane, 0d);
		AnchorPane.setRightAnchor(contentPane, 0d);
		AnchorPane.setTopAnchor(contentPane, 0d);
		AnchorPane.setBottomAnchor(contentPane, 0d);
		
		contentPane.getChildren().add(chessPane);
		chessGamePane.getChildren().add(contentPane);

	}

	private void disable() {
		chessGamePane.setDisable(true);
		if (!contentPane.getChildren().contains(disabledRectangle)) {
			contentPane.getChildren().add(disabledRectangle);
		}
		startBtn.setDisable(false);
		resetBtn.setDisable(true);
	}

	private void enable() {
		chessGamePane.setDisable(false);
		if (contentPane.getChildren().contains(disabledRectangle)) {
			contentPane.getChildren().remove(disabledRectangle);
		}
		startBtn.setDisable(true);
		resetBtn.setDisable(false);
	}

	public void startGame() {
		enable();
	}

	public void resetGame() {
		chessGamePane.getChildren().clear();
		initChessGamePane();
		disable();
	}

}
