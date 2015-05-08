/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.BufferedReader;
import java.io.PrintWriter;

/**
 *
 * @author Quentin
 */
public class Listener extends Thread{
    String buffer;
    private BufferedReader in;
    private PrintWriter out;
    Client c;
    private static InterfaceJeu itfJeu;
    
    public Listener(BufferedReader stdin, PrintWriter stdout, Client cl, InterfaceJeu itf){
        this.in=stdin;
        this.out=stdout;
        this.c=cl;
        this.itfJeu=itf;
    }
    
    @Override
    public void run(){
        while(!Thread.currentThread().isInterrupted()){
            try{
                buffer=this.in.readLine();
                System.out.println("listened : "+buffer);
                if(buffer != null){
                    //CHAT
                    if(buffer.matches("chat::.*")){
                       itfJeu.receptionMsg("<"+buffer.split("::")[1]+"> "+buffer.split("::")[2]);
                    }
                    //EN ATTENTE DE X JOUEUR(S)
                    else if(buffer.matches("salon::attente::joueurs::.*")){
                        itfJeu.afficherMessage("En attente de "+buffer.split("::")[3]+" joueur(s)");
                    }
                    //READY
                    else if(buffer.matches("READY")){
                        c.ecrireMessage("READY");
                    }
                    //DEBUT DU JEU
                    else if(buffer.matches("jeu::demarrage")){
                        itfJeu.afficherMessage("Démarrage du jeu");
                    }
                    //INFOS JOUEURS (pseudo, rôle, nbCartes, nbPres, nbVP, nbNeutre, nbSecr, nbTrou)
                    else if(buffer.matches("jeu::infosJoueurs::.*")){
                        itfJeu.afficherInfosJoueurs(buffer.split("::")[2]);
                    }
                    //DISTRIBUTION CARTES
                    else if(buffer.matches("jeu::infosCartes::.*")){
                        itfJeu.distribuerCartes(buffer.split("::")[2]);
                    }
                    //GERER TOUR
                    else if(buffer.matches("jeu::tour::.*")){
                        itfJeu.gererTour(buffer.split("::")[2]);
                    }
                    //CARTES JOUABLES
                    else if(buffer.matches("jeu::cartesJouables::.*")){
                        itfJeu.remplirCartesJouables(buffer.split("::")[2]);
                    }
                    //CARTES POSEES
                    else if(buffer.matches("jeu::cartesPosees::.*")){
                        itfJeu.poserCartes(buffer.split("::")[2]);
                    }
                    //SESSION SUIVANTE
                    else if(buffer.matches("jeu::sessionSuivante")){
                        itfJeu.nettoyerTable();
                    }
                    // INTER-SESSION
                    else if(buffer.matches("jeu::echange::fin")){
                        itfJeu.interSession=false;
                    }
                    else if(buffer.matches("jeu::echange::.*")){
                        
                        itfJeu.jouerInterSession(buffer.split("::")[2]);
                    }
                }
            }
            catch(Exception e){
                System.out.println("error listener : "+e.getLocalizedMessage()+"  "+e.getMessage());
            }
        }
    }
}
