/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networkproject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author alexsanford, Justin Malmstedt
 */
public class NetworkProject extends Application {
    
    private TextField website;
    private TextField file;
    
    @Override
    public void start(Stage primaryStage) {
        
        website = new TextField();
        website.setPrefWidth(675);
        
        Button btn = new Button();
        btn.setPrefSize(120, 20);
        
        file = new TextField();
        file.setPrefSize(600, 715);
        
        btn.setText("Search");
        //creates an Hbox to store the textbox and website.
        HBox hb = new HBox();
        hb.getChildren().addAll(website, btn);
        hb.setSpacing(10);
        
        //creates a VBox to store the hbox and the file to display
        VBox vb = new VBox();
        vb.getChildren().addAll(hb, file);
        vb.setSpacing(10);
        
        
        
        //Search button on click listner
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                file.setText("About to retrieve data");
                //holds the URL of the website that we want to go to.
                String URL = website.getText();
                
            }
        });
        //adds all of the properties to the scene
        StackPane root = new StackPane();
        root.getChildren().add(vb);
        
        Scene scene = new Scene(root, 800, 750);
        
        primaryStage.setTitle("The Ultimate Web Broweser!!!!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
