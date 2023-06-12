package Controller;

import GUI.Boutique;
import GUI.InventoryWindow;
import Model.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Controlleur extends WindowAdapter implements ActionListener , ListSelectionListener
{
    private Inventaire inventory;
    private InventoryWindow inventoryWindow;
    private Boutique boutiqueWindow;
    public Controlleur(Inventaire inventory, InventoryWindow inventoryWindow)
    {
        this.inventory = inventory;
        this.inventoryWindow = inventoryWindow;

        initModel();
        initView();
    }
    public void initModel()
    {
        inventory.AjouterArme(0,new ArmeAFeu("Vandal",new Skin("Reaver", Rarete.rare,"MesImages/vandal_defaut.png"), Categorie.Assaut,300,160,40,90,25));
        inventory.AjouterArme(0,new ArmeAFeu("Spectre",new Skin("Reaver",Rarete.rare,"MesImages/spectre_defaut.png"),Categorie.SMG,180,60,15,40,35));
        inventory.AjouterArme(0,new ArmeAFeu("Operator",new Skin("Reaver",Rarete.rare,"MesImages/operator_defaut.png"),Categorie.Sniper,560,320,170,320,6));
        inventory.AjouterArme(0,new ArmeCAC("Knife",new Skin("Reaver",Rarete.rare,"MesImages/knife_kingdom.png"),Categorie.CAC,790,35));

        //Creation d'un profil
        if(inventory.getUser() == null)
        {
            inventory.setUser("Martin123","MesImages/logo1.png",10000);
        }
        return;
    }
    public void initView()
    {
        for (ArmeAFeu arme : inventory.getAssautList())
        {
            inventoryWindow.comboBoxAssaut.addItem(String.valueOf(arme));
        }
        for (ArmeAFeu arme : inventory.getSMGList())
        {
            inventoryWindow.comboBoxSMG.addItem(String.valueOf(arme));
        }
        for (ArmeAFeu arme : inventory.getSniperList())
        {
            inventoryWindow.comboBoxSniper.addItem(String.valueOf(arme));
        }
        for (ArmeCAC arme : inventory.getCACList())
        {
            inventoryWindow.comboBoxCAC.addItem(String.valueOf(arme));
        }

        inventoryWindow.jImageAvatar.setIcon(inventoryWindow.scaleImage(Inventaire.getInstance().getUser().getAvatar(),50,50));
        inventoryWindow.labelArgent.setText("Argent : " + inventory.getUser().getArgent());
        inventoryWindow.labelProfil.setText("Nom du Joueur ( " + inventory.getUser().getPseudo() + " )");
        inventoryWindow.labelDate.setText("Date Création Profil : " + inventory.getUser().getdateCreationProfil().format(DateTimeFormatter.ofPattern("HH:mm:ss   dd-MM-yyyy")));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("boutonInventaire"))
        {
            return;
        }
        if(e.getActionCommand().equals("boutonBoutique"))
        {
            if(this.boutiqueWindow == null)
            {
                this.boutiqueWindow = new Boutique();
                this.boutiqueWindow.setControleur(this);
                for (Arme arme : inventory.getBoutiqueList())
                {
                    boutiqueWindow.modellistesArmes.addElement(arme);
                }
                this.boutiqueWindow.listeArmes.setModel(boutiqueWindow.modellistesArmes);
            }
            this.boutiqueWindow.setVisible(true);
            return;
        }
        if(e.getActionCommand().equals("boutonParametre"))
        {
            return;
        }
        if(e.getActionCommand().equals("comboBoxAssaut"))
        {
            int index = inventoryWindow.comboBoxAssaut.getSelectedIndex();
            ArmeAFeu a = inventory.getAssautList().get(index);
            inventoryWindow.jImageAssaut.setIcon(inventoryWindow.scaleImage(a.getSkin().getImage(),250,150));

            String tooltipText = String.format("<html><body>%s &nbsp;&nbsp;&nbsp;Catégorie %s<br>%s<br>Stats:<br>&nbsp;DT: %s<br>&nbsp;DG: %s<br>&nbsp;Portée: %s<br>&nbsp;Prix: %s<br>&nbsp;Capacité Chargeur: %s</body></html>",
                    a.getNom(), a.getCategorie(), a.getSkin().toString(), a.getDegatsTete(), a.getDegatsCorps(), a.getPortee(), a.getPrix(), a.getCapaciteChargeur());

            inventoryWindow.jImageAssaut.setToolTipText(tooltipText);
        }
        if(e.getActionCommand().equals("comboBoxSMG"))
        {
            int index = inventoryWindow.comboBoxSMG.getSelectedIndex();
            ArmeAFeu a = inventory.getSMGList().get(index);
            inventoryWindow.jImageSMG.setIcon(inventoryWindow.scaleImage(a.getSkin().getImage(),250,150));

            String tooltipText = String.format("<html><body>%s &nbsp;&nbsp;&nbsp;Catégorie %s<br>%s<br>Stats:<br>&nbsp;DT: %s<br>&nbsp;DG: %s<br>&nbsp;Portée: %s<br>&nbsp;Prix: %s<br>&nbsp;Capacité Chargeur: %s</body></html>",
                    a.getNom(), a.getCategorie(), a.getSkin().toString(), a.getDegatsTete(), a.getDegatsCorps(), a.getPortee(), a.getPrix(), a.getCapaciteChargeur());
            inventoryWindow.jImageSMG.setToolTipText(tooltipText);
        }
        if(e.getActionCommand().equals("comboBoxSniper"))
        {
            int index = inventoryWindow.comboBoxSniper.getSelectedIndex();
            ArmeAFeu a = inventory.getSniperList().get(index);
            inventoryWindow.jImageSniper.setIcon(inventoryWindow.scaleImage(a.getSkin().getImage(),250,150));

            String tooltipText = String.format("<html><body>%s &nbsp;&nbsp;&nbsp;Catégorie %s<br>%s<br>Stats:<br>&nbsp;DT: %s<br>&nbsp;DG: %s<br>&nbsp;Portée: %s<br>&nbsp;Prix: %s<br>&nbsp;Capacité Chargeur: %s</body></html>",
                    a.getNom(), a.getCategorie(), a.getSkin().toString(), a.getDegatsTete(), a.getDegatsCorps(), a.getPortee(), a.getPrix(), a.getCapaciteChargeur());
            inventoryWindow.jImageSniper.setToolTipText(tooltipText);
        }
        if(e.getActionCommand().equals("comboBoxCAC"))
        {
            int index = inventoryWindow.comboBoxCAC.getSelectedIndex();
            ArmeCAC a = inventory.getCACList().get(index);
            inventoryWindow.jImageCAC.setIcon(inventoryWindow.scaleImage(a.getSkin().getImage(),250,150));
            String tooltipText = String.format("<html><body>%s &nbsp;&nbsp;&nbsp;Catégorie %s<br>%s<br>Stats:<br>&nbsp;DTr:%s <br>&nbsp;Prix:%s</body></html>",
                    a.getNom(), a.getCategorie(), a.getSkin().toString(), a.getDegatTranchant(), a.getPrix());

            inventoryWindow.jImageCAC.setToolTipText(tooltipText);
        }

        if(e.getActionCommand().equals("boutonAcheter"))
        {
            try
            {
                inventory.RetirerArgent(inventory.getBoutiqueList().get(boutiqueWindow.listeArmes.getSelectedIndex()).getPrix());
                inventoryWindow.labelArgent.setText("Argent : " + inventory.getUser().getArgent());

                inventory.AjouterArme(1,inventory.getBoutiqueList().get(boutiqueWindow.listeArmes.getSelectedIndex()));
                AjouterArme(1,inventory.getBoutiqueList().get(boutiqueWindow.listeArmes.getSelectedIndex()));
            }
            catch (IllegalArgumentException ie)
            {
                JOptionPane.showMessageDialog(null, "Une erreur est survenue : " + ie.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static <T> DefaultComboBoxModel<T> UpdateComboBox(ArrayList list) {
        DefaultComboBoxModel<T> comboBoxModel = new DefaultComboBoxModel<>();

        for (Object item : list) {
            comboBoxModel.addElement((T) item);
        }

        return comboBoxModel;
    }

    @Override
    public void valueChanged(ListSelectionEvent e)
    {
        Arme a = inventory.getBoutiqueList().get(boutiqueWindow.listeArmes.getSelectedIndex());
        if(a instanceof ArmeAFeu)
        {
            ArmeAFeu arme = (ArmeAFeu) a;
            boutiqueWindow.labelChargeur.setVisible(true);
            boutiqueWindow.labelPortee.setVisible(true);
            boutiqueWindow.labelDegatCorps.setVisible(true);
            boutiqueWindow.labelDegatTete.setText("Dégâts Tete : " + arme.getDegatsTete() + "\n");
            boutiqueWindow.labelChargeur.setText("Capacité Chargeur : " + arme.getCapaciteChargeur() + "\n");
            boutiqueWindow.labelDegatCorps.setText("Dégâts Corps : " + arme.getDegatsCorps() + "\n");
            boutiqueWindow.labelPortee.setText("Portée : " + arme.getPortee() + "\n");
            boutiqueWindow.labelCategorie.setText("Catégorie : " + arme.getCategorie() + "\n");
            boutiqueWindow.labelPrix.setText("Prix : " + arme.getPrix() + "\n");
            boutiqueWindow.labelRarete.setText("Rarete Skin: " + arme.getSkin().getRarete() + "\n");
        }
        else if (a != null)
        {
            ArmeCAC arme = (ArmeCAC) a;
            boutiqueWindow.labelDegatTete.setText("Dégâts Tranchant : " + arme.getDegatTranchant() + "\n");
            boutiqueWindow.labelCategorie.setText("Catégorie : " + arme.getCategorie() + "\n");
            boutiqueWindow.labelPrix.setText("Prix : " + arme.getPrix() + "\n");
            boutiqueWindow.labelRarete.setText("Rarete Skin: " + arme.getSkin().getRarete() + "\n");
            boutiqueWindow.labelChargeur.setVisible(false);
            boutiqueWindow.labelPortee.setVisible(false);
            boutiqueWindow.labelDegatCorps.setVisible(false);
        }

    }

    @Override
    public void windowClosing(WindowEvent e) {
        if(e.getSource() == this.inventoryWindow)
        {
            super.windowClosing(e);
            System.exit(0);
        } else if (e.getSource() == this.boutiqueWindow) {
            e.getWindow().setVisible(false);
        }
    }


    public <T extends Arme> void AjouterArme(int choix, T arme)
    {
        if(choix == 1)
        {
            if(arme instanceof ArmeAFeu)
            {
                if(arme.getCategorie().equals(Categorie.Assaut))
                {
                    inventoryWindow.comboBoxAssaut.addItem(arme.toString());
                } else if (arme.getCategorie().equals(Categorie.SMG)) {
                    inventoryWindow.comboBoxSMG.addItem(arme.toString());
                }
                else if (arme.getCategorie().equals(Categorie.Sniper)){
                    inventoryWindow.comboBoxSniper.addItem(arme.toString());
                }
            } else if (arme instanceof ArmeCAC) {
                inventoryWindow.comboBoxCAC.addItem(arme.toString());
            }
        }
        else
        {
            if(arme != null)
            {
                boutiqueWindow.modellistesArmes.addElement(arme);
            }
        }
    }
}
