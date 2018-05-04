/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networkproject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class DNS_Server extends Application  {
    
    @Override
    public void start(Stage primaryStage) {
        System.out.println("Running DNS Server");
        
        try{startserver();}
        catch(IOException ex){
            
        }
        
        StackPane root = new StackPane();
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("DNS Server Running");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void startserver() throws IOException{
        
            ServerSocket serverSocket = new ServerSocket(8008);
            Socket browserSocket = serverSocket.accept();
           // browserSocket.setSoTimeout(0);
            DataInputStream hostname = new DataInputStream(browserSocket.getInputStream());
            String incoming = hostname.readUTF();
            DataOutputStream output = new DataOutputStream(browserSocket.getOutputStream());
            output.writeUTF("202");
            System.out.println(incoming);
            System.out.println("closed");
            hostname.close();
            browserSocket.close();
            serverSocket.close(); 
}
}
