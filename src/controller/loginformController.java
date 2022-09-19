package controller;

import javafx.animation.ScaleTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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

public class loginformController {
    public ImageView imgAdmin;
    public ImageView imgReceptionist;
    public Label txtOptionname;
    public Label txtmsg;
    public AnchorPane loginContext;

    void openUi(String fileName) throws IOException {
        Stage window = (Stage) loginContext.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/" + fileName + ".fxml"))));

    }

    public void navigate(MouseEvent event) throws IOException {
        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();

            switch (icon.getId()){
                case "imgAdmin":
                    openUi("adminpanel");
                    break;
                case "imgReceptionist":
                    openUi("receptionistpanel");
                    break;
            }
        }
    }

    public void playMouseEnterAnimation(MouseEvent event) {
        if (event.getSource() instanceof ImageView){
            ImageView icon = (ImageView) event.getSource();

            switch (icon.getId()){
                case "imgAdmin":
                    txtOptionname.setText("Admin");
                    txtmsg.setText("To enter the admin panel & access it");
                    break;
                case "imgReceptionist":
                    txtOptionname.setText("Receptionist");
                    txtmsg.setText("To enter the Receptionist panel & access it");
                    break;
            }
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
            txtOptionname.setText("- Blue Ocean Hotel -");
            txtmsg.setText("Please select one of above main operations to proceed");

        }
    }
}
