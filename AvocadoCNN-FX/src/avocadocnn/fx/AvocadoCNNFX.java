/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avocadocnn.fx;

import java.io.IOException;
import java.util.logging.Level;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *AvocadoCNNFX
 * @author IZETTER 10-10-2019
 */
public class AvocadoCNNFX extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;
    
    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root; 
            root = FXMLLoader.load(AvocadoCNNFX.class.getResource("/Resources/Views/SceneCarga.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("CARGA DE IMÁGENES");
            primaryStage.show();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(AvocadoCNNFX.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
