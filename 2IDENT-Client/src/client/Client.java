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
    private final String hostAddress = "78.242.69.141";
    private final int portSoc = 2000;
    private BufferedReader in;
    private PrintWriter out;
    public String pseudo;
    private String buffer="";
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
            
            String[] decoup = buffer.split("::");
            
            if(decoup[0].equals("salon") && decoup[1].equals("liste")){
            
                itfSalon = new InterfaceSalon(decoup[2],this);

                itfSalon.setVisible(true);
            }
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
        System.out.println("envoyé : "+msg);
        out.println(msg);
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
    
    public void refreshSalons(){
        try{
            ecrireMessage("salon::refresh");
            buffer = this.in.readLine();

            String[] decoup = buffer.split("::");
            if(decoup[0].equals("salon") && decoup[1].equals("liste")){

                itfSalon.setLobbyList(decoup[2]);

            }
        }
        catch(Exception e){
            System.out.println("error refresh salon : "+e.getMessage());
        }
    }
    
    public void creerSalon(String nom, String nbJoueurs){
        try{
            ecrireMessage("salon::creation::"+nom+"::"+nbJoueurs);
            buffer=this.in.readLine();
            if(buffer.equals("salon::creation::ok")){
                // lancement du jeu
                lancerJeu();
            }
            else if(buffer.matches("salon::creation::erreur.*")){
                itfSalon.setError(buffer.split("::")[3]);
            }
        }
        catch(Exception e){
            System.out.println("error creer salon : "+e.getMessage());
        }
    }
    
    public void lancerJeu(){
        try{
            itfSalon.setVisible(false);

            itfJeu=new InterfaceJeu(this);
            itfJeu.setVisible(true);
        
            Listener ecouteur = new Listener(in, out, this, itfJeu);
            ecouteur.start();
        }
        catch(Exception e){
            System.out.println("error jeu : "+e.getMessage());
        }
    }
    
    public void connecterSalon(String nom){
        try{
            ecrireMessage("salon::connection::"+nom);
            buffer=this.in.readLine();
            if(buffer.equals("salon::connection::ok")){
                // lancement du jeu
                lancerJeu();
            }
            else if(buffer.matches("salon::connection::erreur.*")){
                itfSalon.setError(buffer.split("::")[3]);
            }
        }
        catch(Exception e){
            System.out.println("error connecter salon : "+e.getMessage());
        }
    }
}
