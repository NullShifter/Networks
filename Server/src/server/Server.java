/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexsanford
 */
public class Server {
    /**
     * @param args the command line arguments
     */
    public void main(String[] args) {
        int fileToGet;
        String website = "";
        ServerSocket serv = null;
        Socket clientSocket = null, fileSocket = null;
        DataInputStream cInput = null, sInput = null;
        DataOutputStream cOutput = null, sOutput = null;
        
        try {
            //Opening a connection with the client
            serv = new ServerSocket(8008);
            clientSocket = serv.accept();
            
            //Getting the URL string from the Client
            cInput = new DataInputStream(clientSocket.getInputStream());
            website = cInput.readUTF();
            
            //Determine which file to get from the server
            fileToGet = CheckForServer(website);
            
            //Make a connection to the other Server
            fileSocket = new Socket("localhost", 9009);
            sOutput = new DataOutputStream(fileSocket.getOutputStream());
            sInput = new DataInputStream(fileSocket.getInputStream());
            
            //Check to see if a succesfull connection was made with the server
            if(fileSocket != null && sOutput != null && sInput != null && fileToGet != 0){
                sOutput.writeByte(fileToGet);
                sOutput.flush();
                
                //finish writing to handle the input
                
                
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
    }
    
    
    /**
     * 
     * @param website should not be null.
     * @return returns 0 if the address entered into the clients text box was not found
     * @return The file that should be found on the server we are trying to reach
     */
    private int CheckForServer(String website){
        int getFile = 0;
        
        switch(website){
            case "www.google.com":
                getFile = 1;
                break;
            case "www.webServer.com":
                getFile = 2;
                break;
            case "www.yahoo.com":
                getFile = 3;
                break;
            default:
                getFile = 0;
            
        }
        return getFile;
    }
    
}
