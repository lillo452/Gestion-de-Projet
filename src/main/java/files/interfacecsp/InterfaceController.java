package files.interfacecsp;

import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class represents the controller of the interface.
 * It handles the actions of the buttons and the initialization of the interface.
 * @author Wail AMEUR
 * @version 1.0
 */
public class InterfaceController {

    @FXML
    private GridPane sudokuGrid;
    @FXML
    private Button resolutionButton;
    @FXML
    private Button resetButton;
    @FXML
    private Button randomGridButton;

    private Domain<Integer> domain;
    private List<Constraint<Integer>> constraintList;

    /**
     * Initializes the interface.
     */
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

        constraintList = new ArrayList<>();
        constraintList.add(new SudokuConstraintRow<>());
        constraintList.add(new SudokuConstraintColumn<>());
        constraintList.add(new SudokuConstraintGrid<>());

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

        constraintList = new ArrayList<>();
        constraintList.add(new SudokuConstraintRow<>());
        constraintList.add(new SudokuConstraintColumn<>());
        constraintList.add(new SudokuConstraintGrid<>());

        for (int i = 0; i < 18; i++) {
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setPrefHeight(40);
            sudokuGrid.getRowConstraints().add(rowConstraints);
        }

        List<Integer> domainList = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            domainList.add(i);
        }
        domain = new SudokuDomain<Integer>(domainList);

        resolutionButton.setOnAction(event -> handleResolutionButtonAction());

        resetButton.setOnAction(event -> {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    TextField textField = (TextField) sudokuGrid.getChildren().get(i * 9 + j);
                    textField.clear();
                }
            }
        });

        randomGridButton.setOnAction(event -> {
            SudokuProblem<Integer> sudokuProblem = new SudokuProblem<>();

            generateRandomGrid(sudokuProblem);

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    TextField textField = (TextField) sudokuGrid.getChildren().get(i * 9 + j);
                    if (sudokuProblem.getGrid()[i][j] != 0) {
                        textField.setText(String.valueOf(sudokuProblem.getGrid()[i][j]));
                    } else {
                        textField.clear();
                    }
                    textField.setStyle("-fx-text-fill: black; -fx-font-size: 25; -fx-font-family: Arial;");
                }
            }
        });

        resolutionButton.setPrefWidth(100);
        resolutionButton.setPrefHeight(40);
        resetButton.setPrefWidth(100);
        resetButton.setPrefHeight(40);
        randomGridButton.setPrefWidth(100);
        randomGridButton.setPrefHeight(40);
    }

    /**
     * Handles the action of the resolution button.
     */
    @FXML
    public void handleResolutionButtonAction() {
        SudokuProblem<Integer> sudokuProblem = new SudokuProblem<>();

        sudokuProblem.applyDomain((SudokuDomain<Integer>) domain);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                TextField textField = (TextField) sudokuGrid.getChildren().get(i * 9 + j);
                String text = textField.getText();
                if (!text.isEmpty()) {
                    sudokuProblem.addValue(Integer.parseInt(text), i, j);
                }
            }
        }

        if (!sudokuProblem.isValidGrid()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("The provided Sudoku grid is not valid.");
            alert.showAndWait();
            return;
        }

        Solver<Integer> solver = new Solver<>(sudokuProblem, constraintList);

        solver.solve();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                TextField textField = (TextField) sudokuGrid.getChildren().get(i * 9 + j);
                sudokuProblem.setPos(new SudokuPosition(i, j));
                int value = sudokuProblem.getGrid()[i][j];
                if (value != 0) {
                    textField.setStyle("-fx-text-fill: green; -fx-font-size: 25; -fx-font-family: Arial;");
                } else {
                    textField.setStyle("-fx-text-fill: red; -fx-font-size: 25; -fx-font-family: Arial;");
                }
                textField.setText(String.valueOf(value));
            }
        }
    }

    /**
     * Handles the action of the reset button (to complete).
     */
    @FXML
    public void handleResetButtonAction() {
    }

    /**
     * Handles the action of the random grid button (to complete).
     */
    @FXML
    public void handleRandomGridButtonAction() {
    }

    /**
     * Generates a random Sudoku grid.
     * @param sudokuProblem the Sudoku problem
     */
    private void generateRandomGrid(SudokuProblem<Integer> sudokuProblem) {
        Random random = new Random();
        int cellsToFill = 20; // Change this value to adjust the difficulty of the Sudoku grid

        for (int i = 0; i < cellsToFill; i++) {
            int row, col, value;

            do {
                row = random.nextInt(9);
                col = random.nextInt(9);
            } while (sudokuProblem.isFilled(row, col));

            do {
                value = random.nextInt(9) + 1;
            } while (!isValid(sudokuProblem, row, col, value));

            sudokuProblem.setPos(new SudokuPosition(row, col));
            sudokuProblem.setValue(value);
        }
    }

    /**
     * Checks if a value can be placed in a cell of the Sudoku grid.
     * @param sudokuProblem the Sudoku problem
     * @param row the row of the cell
     * @param col the column of the cell
     * @param value the value to be placed
     * @return true if the value can be placed, false otherwise
     */
    private boolean isValid(SudokuProblem<Integer> sudokuProblem, int row, int col, Integer value) {
        for (int i = 0; i < 9; i++) {
            if (sudokuProblem.getGrid()[row][i] == value) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (sudokuProblem.getGrid()[i][col] == value) {
                return false;
            }
        }

        int boxRow = row - row % 3;
        int boxCol = col - col % 3;

        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (sudokuProblem.getGrid()[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }
}
