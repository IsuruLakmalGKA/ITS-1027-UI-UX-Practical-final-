package controller;

import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;

/**
 * @author : Isuru Lakmal G K A
 * @since : 0.1.0
 **/

public class adminController {
    public AnchorPane context;
    public ImageView imgHome;
    public AnchorPane adminContext;

    void openUi(String fileName) throws IOException {
        URL resource = getClass().getResource("../view/adminPanel/" + fileName + ".fxml");
        Parent load = FXMLLoader.load(resource);
        context.getChildren().clear();
        context.getChildren().add(load);
    }
    void prevopenUi(String fileNames) throws IOException {
        Stage window = (Stage) adminContext.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/" + fileNames + ".fxml"))));

    }

    public void roomsPanelOnAction(ActionEvent actionEvent) throws IOException {
        openUi("roomsPanel");
    }

    public void mealsPackageOnAction(ActionEvent actionEvent) throws IOException {
        openUi("mealPackagePanel");
    }

    public void reportsPanelOnAction(ActionEvent actionEvent) throws IOException {
        openUi("incomeReportsPanel");
    }

    public void navigate(MouseEvent event) throws IOException {
        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();

            switch (icon.getId()){
                case "imgHome":
                    prevopenUi("login_form");
                    break;
            }
        }
    }

    public void playMouseEnterAnimation(MouseEvent event) {
        if (event.getSource() instanceof ImageView){
            ImageView icon = (ImageView) event.getSource();

            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1.2);
            scaleT.setToY(1.2);
            scaleT.play();

            DropShadow glow = new DropShadow();
            glow.setColor(Color.CORNFLOWERBLUE);
            glow.setWidth(20);
            glow.setHeight(20);
            glow.setRadius(20);
            icon.setEffect(glow);
        }
    }

    public void playMouseExitAnimation(MouseEvent event) {
        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();
            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play();

            icon.setEffect(null);
        }
    }
}
