/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import static javax.swing.GroupLayout.Alignment.CENTER;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Quentin
 */
public class InterfaceJeu extends javax.swing.JFrame{
    private final Client c;
    private JSONArray infosJoueurs, cartes, cartesJouables;
    private final JSONParser parser;
    private JSONObject obj;
    private String auxName, tourName;
    private ArrayList<JLabel> imgCartes, imgCartesPosees;
    private ArrayList<Component> cartesSelectionnees;
    private ArrayList<String> cartesJouablesString;

    /**
     * Creates new form InterfaceJeu
     * @param cl
     */
    public InterfaceJeu(Client cl) {
        initComponents();
        this.c=cl;
        this.infosJoueurs=new JSONArray();
        this.cartes=new JSONArray();
        this.cartesJouables=new JSONArray();
        parser = new JSONParser();
        this.imgCartes=new ArrayList();
        this.imgCartesPosees=new ArrayList();
        this.cartesSelectionnees=new ArrayList();
        this.cartesJouablesString=new ArrayList();
        this.jButton1.setVisible(false);
        this.jButton1.setEnabled(false);
        tourName="";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaChatLect = new javax.swing.JTextArea();
        btnChat = new javax.swing.JButton();
        txtFieldChatEcr = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        labelMsg = new javax.swing.JLabel();
        labelInfosJoueurs = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("2IDENT");
        setMinimumSize(new java.awt.Dimension(700, 500));
        setPreferredSize(new java.awt.Dimension(700, 500));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        txtAreaChatLect.setEditable(false);
        txtAreaChatLect.setColumns(15);
        txtAreaChatLect.setRows(5);
        jScrollPane1.setViewportView(txtAreaChatLect);

        btnChat.setText("Envoyer");
        btnChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChatActionPerformed(evt);
            }
        });

        txtFieldChatEcr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFieldChatEcrKeyPressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 102, 0));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(480, 180));

        labelMsg.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelMsg.setForeground(java.awt.Color.white);
        labelMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        labelInfosJoueurs.setForeground(java.awt.Color.white);
        labelInfosJoueurs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jButton1.setText("Jouer");

        jPanel2.setBackground(new java.awt.Color(51, 102, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelMsg, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelInfosJoueurs)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(56, 56, 56))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelInfosJoueurs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(92, 92, 92))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFieldChatEcr)
                    .addComponent(btnChat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFieldChatEcr, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChatActionPerformed
        c.ecrireMessage("chat::"+txtFieldChatEcr.getText());
        txtFieldChatEcr.setText("");
    }//GEN-LAST:event_btnChatActionPerformed

    private void txtFieldChatEcrKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldChatEcrKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            c.ecrireMessage("chat::"+txtFieldChatEcr.getText());
            txtFieldChatEcr.setText("");
        }
    }//GEN-LAST:event_txtFieldChatEcrKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if(evt.isControlDown() && evt.getKeyChar()=='C'){
            txtFieldChatEcr.grabFocus();
            txtFieldChatEcr.requestFocus();
            System.out.println("keypress");
        }
    }//GEN-LAST:event_formKeyPressed
    
    public void receptionMsg(String msg){
        txtAreaChatLect.append(msg+'\n');
    }
    
    public void afficherMessage(String msg){
        this.labelMsg.setText(msg);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChat;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelInfosJoueurs;
    private javax.swing.JLabel labelMsg;
    private javax.swing.JTextArea txtAreaChatLect;
    private javax.swing.JTextField txtFieldChatEcr;
    // End of variables declaration//GEN-END:variables

    void afficherInfosJoueurs(String infos) {
        if(!infos.equals("[]")){
            try{
                this.infosJoueurs=(JSONArray) parser.parse(infos);
            }
            catch(Exception e){
                System.out.println("error json : "+e.getLocalizedMessage());
            }
            Iterator it = infosJoueurs.iterator();
            
            String text="";
            while(it.hasNext()){
                obj = (JSONObject) it.next();
                if(!obj.get("pseudo").equals(c.pseudo)){
                    text=text+"< "+obj.get("pseudo")+" ["+obj.get("role")+"] "+obj.get("nbCartes")+" cartes > ";
                }
            }
            labelInfosJoueurs.setText(text);
        }
    }

    public void distribuerCartes(String cartesList){
        //System.out.println("distribution des cartes");
        nettoyerMain();
        if(!cartesList.equals("[]")){
            try{
                this.cartes=(JSONArray) parser.parse(cartesList);
            }
            catch(Exception e){
                System.out.println("error json : "+e.getLocalizedMessage());
            }
            Iterator it = cartes.iterator();
            int i=0;
            int j=0;
            while(it.hasNext()){
                obj = (JSONObject) it.next();
                auxName=obj.get("hauteur").toString()+'-'+obj.get("couleur").toString();
            // System.out.println(auxName);
                /*ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("images/"+auxName));
                System.out.println(img);
                JLabel label = new JLabel();
                label.setPreferredSize(new Dimension(img.getIconWidth(), img.getIconHeight()));
                //label.setIcon(img);
                label.setText("youpi!!");
                jPanel2.add(label);
                jPanel2.revalidate(); 
                jPanel2.repaint(); */
                imgCartes.add(new JLabel( new ImageIcon(ClassLoader.getSystemResource("images/"+auxName+".gif"))));
                imgCartes.get(i).setLayout(new BorderLayout());
                imgCartes.get(i).setSize(62,89);
                imgCartes.get(i).setName(auxName);
                imgCartes.get(i).addMouseListener(new MouseListener() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        //verifier si c'est son tour d'abord
                        if(tourName.equals(c.pseudo)){
                            if(cartesSelectionnees.contains(e.getComponent())){
                                deselectionnerCarte(e.getComponent());
                            }
                            else{
                                selectionnerCarte(e.getComponent());
                            }
                        }
                        //System.out.println(e.getComponent().getClass());
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                    }
                });
                imgCartes.get(i).setLocation(j, jPanel1.getHeight()-92);
                this.jPanel1.add(imgCartes.get(i), BorderLayout.SOUTH);
                i++;
                j=j+28;
                
            jPanel1.repaint();
//                ImageIcon tempImg=new ImageIcon("../images/"+auxName+".gif");
//                imgCartes.add(tempImg);
//                Image b=tempImg.getImage();
//                this.getGraphics().drawImage(b, 192, 280, null);
//                tempImg.paintIcon(this, null, 192, 280);
//                this.jPanel2.add(tempImg);
            }
            
            jButton1.setVisible(true);
            jButton1.addMouseListener(new MouseListener(){

                @Override
                public void mouseClicked(MouseEvent e) {
                    jouerCartes();
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                }
            });
        }
    }
    
    public void selectionnerCarte(Component carte){
        cartesSelectionnees.add(carte);
        carte.setLocation(carte.getLocation().x, carte.getLocation().y-10);
        verifierCartes();
    }
    
    public void deselectionnerCarte(Component carte){
        cartesSelectionnees.remove(carte);
        carte.setLocation(carte.getLocation().x, carte.getLocation().y+10);
        verifierCartes();
    }
    
    public void jouerCartes(){
        c.ecrireMessage("jeu::cartesJouees::"+listerCartesJouees());
    }
    
    public String listerCartesJouees(){
        //à modifier (ou pas) pour envoyer en JSON
        Iterator it = cartesSelectionnees.iterator();
        String liste="[";
        boolean flag=true;
        while(it.hasNext()){
            if(flag){
                flag=false;
            }
            else{
                liste=liste+",";
            }
            JLabel obj= (JLabel)it.next();
            liste=liste+"{\"couleur\":\""+obj.getName().split("-")[1]+"\",\"hauteur\":\""+obj.getName().split("-")[0]+"\"}";
        }
        liste=liste+"]";
        return liste;
    }
    
    public void gererTour(String pseudo){
        tourName=pseudo;
        if(tourName.equals(c.pseudo)){
            afficherMessage("C'est à vous de jouer");
        }
        else{
            afficherMessage("C'est à "+pseudo+" de jouer");
        }
    }
    
    public void remplirCartesJouables(String cartes){
        cartesJouables.clear();
        cartesJouablesString.clear();
            try{
                this.cartesJouables=(JSONArray) parser.parse(cartes);
            }
            catch(Exception e){
                System.out.println("error json : "+e.getLocalizedMessage());
            }
            /*
            Iterator it = cartesJouables.iterator();
            while(it.hasNext()){
                obj = (JSONObject) it.next();
                cartesJouablesString.add(obj.get("hauteur")+"-"+obj.get("couleur"));
            }*/
            System.out.println(cartesJouables.toString());
    }
    
    public void verifierCartes(){
        //on compare avec les cartes jouables
        //on créer un JSON Array depuis les cartes selectionnées
        Iterator it = cartesSelectionnees.iterator();
        JSONArray arr = new JSONArray();
        while(it.hasNext()){
            JLabel o=(JLabel)it.next();
            JSONObject obj = new JSONObject();
            obj.put("couleur", o.getName().split("-")[1]);
            obj.put("hauteur", o.getName().split("-")[0]);
            arr.add(obj);         
        }
        //si ok on enabled le bouton jouer
        if(!arr.isEmpty()&& cartesJouables.contains(arr)){
          jButton1.setEnabled(true);
        }
        else{
            jButton1.setEnabled(false);
        }
    }
    
    public void nettoyerMain(){
        try{
            Iterator it = imgCartes.iterator();
            while(it.hasNext()){
               JLabel aux = (JLabel) it.next();
               aux.getParent().remove(aux);
            }
            imgCartes.clear();
        }
        catch(Exception e){
            System.out.println("erreur nettoyage main : "+e.getMessage());
        }
    }
    
    public void poserCartes(String cartesList){
        jPanel2.removeAll();
        System.out.println("cartes posées : "+cartesList);
        if(!cartesList.equals("[]")){
            try{
                this.cartes=(JSONArray) parser.parse(cartesList);
                Iterator it = cartes.iterator();
                int i=0;
                int j=0;
                while(it.hasNext()){
                    obj = (JSONObject) it.next();
                    auxName=obj.get("hauteur").toString()+'-'+obj.get("couleur").toString();
                    imgCartesPosees.add(new JLabel( new ImageIcon(ClassLoader.getSystemResource("images/"+auxName+".gif"))));
                    imgCartesPosees.get(i).setLayout(new BorderLayout());
                    imgCartesPosees.get(i).setSize(62,89);
                    imgCartesPosees.get(i).setName(auxName);
                    imgCartesPosees.get(i).setLocation(j, jPanel2.getHeight());
                    this.jPanel2.add(imgCartesPosees.get(i), BorderLayout.CENTER);
                    i++;
                    j=j+60;

                jPanel2.repaint();
                } 
            }
            catch(Exception e){
                System.out.println("error cartePosees : "+e.getLocalizedMessage());
            }
        }
    }
}
