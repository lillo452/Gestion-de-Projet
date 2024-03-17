package files.interfacecsp;

import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

public class InterfaceController {

    @FXML
    private GridPane sudokuGrid;

    @FXML
    private Button resolutionButton;

    @FXML
    private Button resetButton;

    @FXML
    public void initialize() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                TextField textField = new TextField();
                textField.setMinSize(60, 60);
                textField.setAlignment(Pos.CENTER);
                textField.setStyle("-fx-font-size: 25; -fx-font-family: Arial;");
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    if (!newValue.matches("\\d*")) {
                        textField.setText(newValue.replaceAll("[^\\d]", ""));
                    }
                    if (newValue.length() > 1) {
                        textField.setText(oldValue);
                    }
                });

                sudokuGrid.add(textField, i*2, j*2);
            }
        }

        for (int i = 2; i <= 5; i += 3) {
            Separator vSeparator = new Separator();
            vSeparator.setValignment(VPos.CENTER);
            vSeparator.setPrefHeight(Double.MAX_VALUE);
            vSeparator.setStyle("-fx-background-color: black;");
            sudokuGrid.add(vSeparator, i*2+1, 0, 1, 17);

            Separator hSeparator = new Separator();
            hSeparator.setHalignment(HPos.CENTER);
            hSeparator.setPrefWidth(Double.MAX_VALUE);
            hSeparator.setStyle("-fx-background-color: black;");
            sudokuGrid.add(hSeparator, 0, i*2+1, 17, 1);
        }

        for (int i = 0; i < 18; i++) {
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setPrefHeight(40);
            sudokuGrid.getRowConstraints().add(rowConstraints);
        }

        resolutionButton.setPrefWidth(100);
        resolutionButton.setPrefHeight(40);
        resetButton.setPrefWidth(100);
        resetButton.setPrefHeight(40);
    }

    @FXML
    public void handleResolutionButtonAction() {
        // Add the code to solve the Sudoku grid
    }

    @FXML
    public void handleResetButtonAction() {
        // Add the code to reset the grid
    }
}