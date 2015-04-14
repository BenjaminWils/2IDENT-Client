/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Quentin
 */
public class Client extends Thread{
    private Socket soc;
    private final String hostAddress = "192.168.70.200";
    private final int portSoc = 2000;
    private BufferedReader in;
    private PrintWriter out;
    String pseudo;
    String buffer="";
    private static InterfacePseudo itfPseudo;
    private static InterfaceSalon itfSalon;
    private static InterfaceJeu itfJeu;
    
    public Client(){}
    
    @Override
    public void run(){
        initSocket();
        try{
            this.in = new BufferedReader(new InputStreamReader(this.soc.getInputStream()));
            this.out = new PrintWriter(this.soc.getOutputStream(),true);
            
            itfPseudo = new InterfacePseudo(this);
            itfPseudo.setVisible(true);
            
            do{
                if(buffer.equals("pseudo::dispo::ko")){
                    itfPseudo.getTextError().setText("pseudo déjà pris");
                    itfPseudo.getTextError().setForeground(Color.red);
                }
                buffer = this.in.readLine();
            }
            while(buffer.equals("pseudo::dispo::ko"));

            //sleep(500000);
            itfPseudo.dispose();
            
            buffer = this.in.readLine();
            
            itfSalon = new InterfaceSalon();
            itfSalon.setVisible(true);
        }
        catch(Exception e){
            System.out.println("error client : "+e.getMessage());
        }
    }
    
    private void initSocket(){
        try {
            soc = new Socket(hostAddress, portSoc);
        }
        catch(Exception e){
            System.out.println("Problème de connexion : " +e.getMessage());
        }
    }
    
    public void ecrireMessage(String msg){
        out.println(msg);
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
    
}
