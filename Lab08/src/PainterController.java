/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

/**
 *
 * @author Alexander Nikopoulos
 * Lab 08
 * 31/10/2025
 */
public class PainterController implements Initializable {

    private enum PenSize {
        SMALL(2),
        MEDIUM(4),
        LARGE(6);
        
        private final int radius;
        
        PenSize(int radius) {
            this.radius = radius;
        }
        
        public int getRadius() {
            return radius;
        }
    };
    
    @FXML
    private RadioButton rbBlack;
    @FXML
    private ToggleGroup colorToggleGroup;
    @FXML
    private RadioButton rbRed;
    @FXML
    private RadioButton rbGreen;
    @FXML
    private RadioButton rbBlue;
    @FXML
    private RadioButton rbSmall;
    @FXML
    private ToggleGroup sizeToggleGroup;
    @FXML
    private RadioButton rbMedium;
    @FXML
    private RadioButton rbLarge;
    @FXML
    private Button undoBtn;
    @FXML
    private Button clearBtn;
    @FXML
    private Pane drawingAreaPane;
    
    private PenSize radius = PenSize.MEDIUM;
    private Paint brushColor = Color.BLACK;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rbBlack.setUserData(Color.BLACK);
        rbRed.setUserData(Color.RED);
        rbGreen.setUserData(Color.GREEN);
        rbBlue.setUserData(Color.BLUE);
        rbSmall.setUserData(PenSize.SMALL);
        rbMedium.setUserData(PenSize.MEDIUM);
        rbLarge.setUserData(PenSize.LARGE);
    }

    @FXML
    private void colorRadioButtonSelected(ActionEvent event) {
        Toggle selectedToggle = colorToggleGroup.getSelectedToggle();
        brushColor = (Color) selectedToggle.getUserData();
    }

    @FXML
    private void sizeRadioButtonSelected(ActionEvent event) {
        Toggle selectedToggle = sizeToggleGroup.getSelectedToggle();
        radius = (PenSize) selectedToggle.getUserData();
    }

    @FXML
    private void undoButtonPressed(ActionEvent event) {
        if (drawingAreaPane.getChildren().size() > 0) {
            drawingAreaPane.getChildren().removeLast();
        }
    }

    @FXML
    private void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    private void drawingAreaMouseDragged(MouseEvent event) {
        Circle circle = new Circle(event.getX(), event.getY(), radius.getRadius(), brushColor);
        drawingAreaPane.getChildren().add(circle);
    }
}
