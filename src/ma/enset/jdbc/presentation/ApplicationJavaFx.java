package ma.enset.jdbc.presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ApplicationJavaFx extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            BorderPane root = FXMLLoader.load(getClass().getResource("view/adherent.fxml"));
            Scene scene = new Scene(root,600,400);
            primaryStage.setTitle("Gestion des adhérents");
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
