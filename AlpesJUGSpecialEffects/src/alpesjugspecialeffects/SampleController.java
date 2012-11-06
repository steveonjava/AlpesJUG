/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package alpesjugspecialeffects;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.effect.Reflection;
import javafx.scene.image.ImageView;

/**
 *
 * @author sjc
 */
public class SampleController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private ImageView juggy;
    
    @FXML
    private void addReflection(ActionEvent event) {
        juggy.setEffect(new Reflection());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
