/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networkproject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author malms
 */
public class Client extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        StackPane root = new StackPane();
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Client");
        primaryStage.setScene(scene);
        primaryStage.show();

                
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void runClient()throws IOException{
        ServerSocket serverSocket = new ServerSocket(9009);
            Socket browserSocket = serverSocket.accept();
            DataInputStream filenum = new DataInputStream(browserSocket.getInputStream());
            int incoming = filenum.readByte();
            
            if (incoming == 1){
                DataOutputStream output = new DataOutputStream(browserSocket.getOutputStream());
                output.writeUTF("this is file 1");
            }
            else if (incoming == 2){
                DataOutputStream output = new DataOutputStream(browserSocket.getOutputStream());
                output.writeUTF("this is file 2");
            }
            else if (incoming == 3){
                DataOutputStream output = new DataOutputStream(browserSocket.getOutputStream());
                output.writeUTF("this is file 3");
            }
    }
    
}
