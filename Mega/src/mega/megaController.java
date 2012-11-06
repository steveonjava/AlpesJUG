package mega;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Label;
import javafx.scene.effect.Reflection;

/**
 * Simple Graph example
 * @author bruno
 */
public class megaController implements Initializable {
    
    @FXML
    private Label label, thanks;
    
    @FXML
    private ScatterChart chart;
    
    private String[] categories = {"Alpes JUG", "Lyon JUG", "Paris JUG"};
            
    @FXML
    private void addEffect(ActionEvent event) {
        System.out.println("You clicked me!");
        //label.setText("Hello World!");
        label.setEffect( new Reflection());
        thanks.setEffect( new Reflection());
    }
    
    @FXML
    private void addPoint(ActionEvent event) {
        
        Double d = Math.random()*125;
        int c = (int) Math.round( Math.random()*(categories.length) -0.5 );
        Series series = new Series();
        series.getData().add( new Data( categories[c], d ) );
        chart.getData().add( series );
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
        Series series = new Series();
        int i=0;
        series.getData().add( new Data( categories[i++],  23 ));
        series.getData().add( new Data( categories[i++],  54 ));
        series.getData().add( new Data( categories[i++], 121 ));
        chart.getData().add( series );
    }    
}
