/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jugalpesjavafxapplication;

import java.lang.reflect.Method;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.effect.Blend;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.Effect;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.MotionBlur;
import javafx.scene.effect.Reflection;
import javafx.scene.effect.SepiaTone;
import javafx.scene.effect.Shadow;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 *
 * @author matti
 */
public class SampleController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private ImageView juggy;
    
    private ParallelTransition parallelTransition;
    
    @FXML
    private void addInnerShadow(ActionEvent event) throws Exception {
        addEffect(new InnerShadow());
    }
    
    @FXML
    private void addMotionBlur(ActionEvent event) throws Exception {
        addEffect(new MotionBlur());
    }
    
    @FXML
    private void addReflection(ActionEvent event) throws Exception {
        addEffect(new Reflection());
    }
    
    @FXML
    private void addSepia(ActionEvent event) throws Exception {
        addEffect(new SepiaTone());
    }
    
    private void addEffect(Effect newEffect) throws Exception {
        Effect effect = juggy.getEffect();
        if (effect == null) {
            juggy.setEffect(newEffect);
        } else {
            Class[] args = new Class[0];
            Method getInput = effect.getClass().getMethod("getInput", args);
            Object[] vals = new Object[0];
            Effect input = (Effect) getInput.invoke(effect, vals);
            if (input == null) {
                Method setInput = newEffect.getClass().getMethod("setInput", Effect.class);
                setInput.invoke(newEffect, effect);
                juggy.setEffect(newEffect);
            } else {
                Method setInput = newEffect.getClass().getMethod("setInput", Effect.class);
                setInput.invoke(newEffect, input);
                juggy.setEffect(newEffect);
            }
        }
    }

    @FXML
    private void startAnimation(ActionEvent event) {
        parallelTransition.play();
    }

    @FXML
    private void stopAnimation(ActionEvent event) {
        parallelTransition.stop();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FadeTransition fadeTransition = 
            new FadeTransition(Duration.millis(3000), juggy);
        fadeTransition.setFromValue(1.0f);
        fadeTransition.setToValue(0.3f);
        fadeTransition.setCycleCount(2);
        fadeTransition.setAutoReverse(true);
        TranslateTransition translateTransition =
            new TranslateTransition(Duration.millis(2000), juggy);
        translateTransition.setFromX(50);
        translateTransition.setToX(350);
        translateTransition.setCycleCount(2);
        translateTransition.setAutoReverse(true);
        RotateTransition rotateTransition = 
            new RotateTransition(Duration.millis(3000), juggy);
        rotateTransition.setByAngle(180f);
        rotateTransition.setCycleCount(4);
        rotateTransition.setAutoReverse(true);
        ScaleTransition scaleTransition = 
            new ScaleTransition(Duration.millis(2000), juggy);
        scaleTransition.setToX(2f);
        scaleTransition.setToY(2f);
        scaleTransition.setCycleCount(2);
        scaleTransition.setAutoReverse(true);
        
        parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll(
                fadeTransition,
                translateTransition,
                rotateTransition,
                scaleTransition
        );
        parallelTransition.setCycleCount(Timeline.INDEFINITE);
    }    

}
