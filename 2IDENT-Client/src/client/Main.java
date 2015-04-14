/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

/**
 *
 * @author Benjamin (LOL)
 */
public class Main {
    private static InterfacePseudo itfPseudo;
    private static InterfaceSalon itfSalon;
    private static InterfaceJeu itfJeu;
    
    public static void main(String[] args) {
        itfPseudo = new InterfacePseudo();
        itfPseudo.setVisible(true);
    }
}
