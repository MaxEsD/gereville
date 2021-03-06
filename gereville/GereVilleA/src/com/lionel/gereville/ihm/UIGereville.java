package com.lionel.gereville.ihm;

import java.awt.AWTEvent;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.lionel.gereville.model.Pays;
import com.lionel.gereville.model.Ville;

/**
 * <p>Titre : </p>
 * <p>Description : </p>
 * <p>Copyright : Copyright (c) 2002</p>
 * <p>Société : </p>
 * @author non attribué
 * @version 1.0
 */

public class UIGereville extends JFrame {
  /**
	 * 
	 */
  private static final long serialVersionUID = 1L;
	
  private JPanel contentPane;
  private JLabel lblPays = new JLabel();
  private JComboBox<Pays> cbPays = new JComboBox<>();
  private JButton btnNewPays = new JButton("+");
  private JButton btnNewVille = new JButton();
  private JButton btnQuit = new JButton();
  private UIlistVille uiListVilles = new UIlistVille();

 
  private JScrollPane jScrollPane1 = new JScrollPane();
  private JTextArea txtArea = new JTextArea();
  private GridBagLayout gridBagLayout1 = new GridBagLayout();
  
  //listeners
  private List<UIGerevilleEventsListener> listeners = new ArrayList<UIGerevilleEventsListener>();


  public UIGereville() {
	  
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);

    jbInit();

  }
  
  public void addListener(UIGerevilleEventsListener listener){
	  listeners.add(listener);
	  uiListVilles.addListener(listener);
  }
  
  
  //Initialiser le composant
  private void jbInit()  {
	  
	this.setSize(new Dimension(493, 312));
	this.setTitle("Consultation des villes de pays");

	contentPane = (JPanel) this.getContentPane();
	contentPane.setLayout(gridBagLayout1);
	
	
    lblPays.setFont(new java.awt.Font("SansSerif", 1, 16));
    lblPays.setText("Pays");
    
    JPanel pPanel = new JPanel();
    pPanel.add(lblPays);
    pPanel.add(cbPays);
    pPanel.add(btnNewPays);
    
    btnNewPays.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnNewPays_event(e);
      }
    });
    
    
    btnNewVille.setText("Nouvelle Ville");
    btnNewVille.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnNewVille_event(e);
      }
    });
    
    btnQuit.setToolTipText("");
    btnQuit.setText("Quitter");
    btnQuit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton2_actionPerformed(e);
      }
    });
    
    
   
    
    cbPays.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(ActionEvent e) {
			
			listePays_clicked();
			
		}
	});
    
    txtArea.setEditable(false);
    
    contentPane.add(pPanel);
    contentPane.add(btnQuit,  new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(24, 31, 28, 52), 11, 5));
    contentPane.add(btnNewVille,  new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(24, 53, 28, 0), 0, 5));
     contentPane.add(jScrollPane1,  new GridBagConstraints(0, 1, 3, 1, 1.0, 1.0
            ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(15, 39, 0, 41), 409, 153));
    jScrollPane1.getViewport().add(uiListVilles, null);

   

  }

  //Supplanté, ainsi nous pouvons sortir quand la fenêtre est fermée
    @Override
  protected void processWindowEvent(WindowEvent e) {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      System.exit(0);
    }
  }

  private void jButton2_actionPerformed(ActionEvent e)
  {
    System.exit(0);
  }

  private void btnNewVille_event(ActionEvent e)
  {

	  for (UIGerevilleEventsListener listener: listeners){
		  listener.onBtnNewVilleClicked();
	  }
  }

  private void btnNewPays_event(ActionEvent e){
	  for (UIGerevilleEventsListener listener: listeners){
		  listener.onBtnNewPaysClicked();
	  }
  }
 

  // fonction consulterPays()
  
  public void afficheListePays(List<Pays> payss)
  {
	//reinit
	cbPays.removeAllItems();
	
	cbPays.addItem(new Pays("TOUS"));
	for (Pays pays: payss){
		 cbPays.addItem(pays);
	}
	  
	
  }
  
  public void selectPays(Pays pays){
	  cbPays.setSelectedItem(pays);
	  
  }
  
  public void afficherVilles(List<Ville> listeVilles){
	  uiListVilles.afficherListe(listeVilles);
  }
  
  public void clearListVilles(){
	  uiListVilles.clear();
  }
  
  public void displayErrorMessage(String msg){
	  JOptionPane.showMessageDialog(this,msg,"Erreur",
              JOptionPane.WARNING_MESSAGE);
  }
  
  public void displaySuccessMessage(String msg){
	  JOptionPane.showMessageDialog(this,msg,"Succ�s",
              JOptionPane.INFORMATION_MESSAGE);
  }

  


  
 //selection d'un pays
  void listePays_clicked()
  {
	  if (cbPays.getSelectedIndex()>-1){
		  
	 
		  for (UIGerevilleEventsListener listener: listeners){
		    	listener.onSelectedPays((Pays)cbPays.getSelectedItem());
		    }
	  }
  
  }

}