package org.alpesjug.specialeffects;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author ehugonnet
 */
public class SampleController implements Initializable {
  
  @FXML 
  private ImageView juggy;
  
  @FXML 
  private AnchorPane background;
  
  @FXML
  private TextField input;
  
  @FXML
  private Text title;
  
  
  
  @FXML
  private void addReflection(ActionEvent event) {
     background.setStyle("-fx-background-color: #FFFFFF");
    juggy.setEffect(new Reflection());
  }
  
  @FXML
  private void glow(ActionEvent event) {
    background.setStyle("-fx-background-color: #000000");
    juggy.setStyle("-fx-background-color: #000000");
    juggy.setEffect(new Glow(50.0D));
  }
  
  @FXML
  private void displayMessage(ActionEvent event) {    
     background.setStyle("-fx-background-color: #FFFFFF");    
     title.setText( input.getText());
     DropShadow shadow = new DropShadow(20.d,8.0d, 8.0d, new Color(0, 0, 0, 0.1));
     DropShadow dropShadow2 = new DropShadow(4.0d, Color.web("#21233f"));
     dropShadow2.setSpread(0.9d);
     InnerShadow innerShadow1 = new InnerShadow(5d, -4.0d, -4.0d, Color.web("#cee3f4"));
     innerShadow1.setChoke(0.7d);
     InnerShadow innerShadow2 = new InnerShadow(7.0d, 2.0d, 2.0d, Color.web("#6c7fee"));
     innerShadow2.setChoke(0.2d);
     InnerShadow innerShadow3 = new InnerShadow(4.0d, -2.0d, -2.0d, Color.web("#a5ebff"));
     title.setEffect((new Blend(BlendMode.SRC_OVER, shadow, new Blend(BlendMode.SRC_OVER, dropShadow2, 
         new Blend(BlendMode.DARKEN, innerShadow1, new Blend(BlendMode.MULTIPLY, innerShadow2, innerShadow3))))));
     title.setFill(Color.web("#f7fafb"));
     title.setStrokeWidth(3.0d);
     title.setFont(new Font("Kabel", 120.0d));
     title.autosize();
  }
  
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
  }  
}
