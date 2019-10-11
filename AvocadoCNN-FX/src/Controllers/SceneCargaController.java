/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Persistencia.DataAdapters.tblFotografiasAdapter;
import java.awt.TrayIcon;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

/**
 * FXML SceneCargaController class
 *
 * @author IZETTER 10-10-2019
 */
public class SceneCargaController implements Initializable {
  
    File fotoSeleccionada;
    FileInputStream inputStream;
    tblFotografiasAdapter tblfotografiasadapter = new tblFotografiasAdapter();
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtTituloImagen;

    @FXML
    private Button bttnGuardarImagen;

    @FXML
    private Button bttnBuscarImagen;

    @FXML
    private ImageView imgVistaPrevia;

    @FXML
    void bttnBuscarImagenActionPerformed(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fotoSeleccionada = fileChooser.showOpenDialog(null);
        if(fotoSeleccionada != null){
        imgVistaPrevia.setImage(
            new Image(fotoSeleccionada.toURI().toString())
         );
        imgVistaPrevia.setFitHeight(250);
        imgVistaPrevia.setFitWidth(300);
        }
    }

    @FXML
    void bttnGuardarImagenActionPerformed(ActionEvent event) {
        try {
            
            inputStream = new FileInputStream(fotoSeleccionada);
            
            if(tblfotografiasadapter.Insert(txtTituloImagen.getText(), inputStream) != 0){
                mostrarMensaje("C A R G A  E X I T O S A", "El registro fue guardado correctamente.", AlertType.INFORMATION);          
            }else{
                mostrarMensaje("C A R G A  N O  R E A L I Z A D A", "El registro no se pudo guardar.", AlertType.INFORMATION);                     
            }
                       
        } catch (FileNotFoundException ex) {
            mostrarMensaje("V E R I F I Q U E", "No se encuentra el archivo: ".concat(ex.getMessage()), AlertType.ERROR);
            Logger.getLogger(SceneCargaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void initialize() {
        assert txtTituloImagen != null : "fx:id=\"txtTituloImagen\" was not injected: check your FXML file 'SceneCarga.fxml'.";
        assert bttnGuardarImagen != null : "fx:id=\"bttnGuardarImagen\" was not injected: check your FXML file 'SceneCarga.fxml'.";
        assert bttnBuscarImagen != null : "fx:id=\"bttnBuscarImagen\" was not injected: check your FXML file 'SceneCarga.fxml'.";
        assert imgVistaPrevia != null : "fx:id=\"imgVistaPrevia\" was not injected: check your FXML file 'SceneCarga.fxml'.";

    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    private void mostrarMensaje(String titulo, String mensaje, AlertType tipo){
            Alert alert = new Alert(tipo);
            alert.initOwner(null);
            alert.setTitle(titulo);
            alert.setContentText(mensaje);
            alert.showAndWait();
    }
    
}
