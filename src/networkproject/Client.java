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
    public void start(Stage primaryStage) throws IOException {
        
        StackPane root = new StackPane();
        for(int i = 0; i < 10; ++i){
        runClient();
        }
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Client");
        primaryStage.setScene(scene);
        primaryStage.show();
try{
    runClient(); 
}
catch(IOException ex)        {    
        
    }
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
            DataOutputStream output = new DataOutputStream(browserSocket.getOutputStream());
            int incoming = filenum.readByte();
            
<<<<<<< Updated upstream
            
            if (incoming == 1){
                DataOutputStream output = new DataOutputStream(browserSocket.getOutputStream());
                output.writeUTF("<html><title>This is Google.com</title></html>");
            }
            else if (incoming == 2){
                DataOutputStream output = new DataOutputStream(browserSocket.getOutputStream());
                output.writeUTF("<html><title>This is webServer.com</title></html>");
            }
            else if (incoming == 3){
                DataOutputStream output = new DataOutputStream(browserSocket.getOutputStream());
                output.writeUTF("<html><title>This is Yahoo.com</title></html>");
            }
=======
        switch (incoming) {
            case 1:
                output.writeUTF("this is file 1");
                break;
            case 2:
                output.writeUTF("this is file 2");
                break;
            case 3:
                output.writeUTF("this is file 3");
                break;
            default:
                break;
        }
            System.out.println("finished");
            System.out.println("closed");
            filenum.close();
            browserSocket.close();
            serverSocket.close(); 
>>>>>>> Stashed changes
    }
    
}
