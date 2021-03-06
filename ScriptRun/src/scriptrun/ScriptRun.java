/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scriptrun;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Hamza Arain
 */
public class ScriptRun extends Application {
//    private double xOffset = 0;
//    private double yOffset = 0;
    
    private double xOffSet = 0;
    private double yOffSet = 0;
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLScriptRun.fxml"));
        stage.initStyle(StageStyle.TRANSPARENT);
        
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                  xOffSet = event.getSceneX();
                  yOffSet = event.getSceneY();
            }
        }); 
        
        root.setOnMouseDragged(new EventHandler<MouseEvent>(){
           @Override
           public void handle(MouseEvent event){             
                 stage.setX(event.getScreenX() - xOffSet);
                 stage.setY(event.getScreenY() - yOffSet);
                 stage.setOpacity(0.8f);
           }
        });
        
        root.setOnMouseReleased(new EventHandler<MouseEvent>(){
           @Override
           public void handle(MouseEvent event){
                stage.setOpacity(1.0f);
           }           
        });
         
        Scene scene = new Scene(root);
        scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.resizableProperty().setValue(false);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}