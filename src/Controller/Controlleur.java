package Controller;

import GUI.Boutique;
import GUI.InventoryWindow;
import Model.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
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
        inventory.AjouterArme(0,new ArmeAFeu("Vandal",new Skin("Reaver", Rarete.rare,"MesImages/vandal_defaut.png"), Categorie.Assaut,3,3,3,3,3));
        inventory.AjouterArme(0,new ArmeAFeu("Spectre",new Skin("Reaver",Rarete.rare,"MesImages/spectre_defaut.png"),Categorie.SMG,3,3,4,3,3));
        inventory.AjouterArme(0,new ArmeAFeu("Operator",new Skin("Reaver",Rarete.rare,"MesImages/operator_defaut.png"),Categorie.Sniper,3,8,3,10,3));
        inventory.AjouterArme(0,new ArmeCAC("Knife",new Skin("Reaver",Rarete.rare,"MesImages/knife_defaut.png"),Categorie.CAC,3,3));
        inventory.AjouterArme(0,new ArmeCAC());
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
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand() == "boutonInventaire")
        {
            return;
        }
        if(e.getActionCommand() == "boutonBoutique")
        {
            if(this.boutiqueWindow == null)
            {
                this.boutiqueWindow = new Boutique();
                this.boutiqueWindow.setControleur(this);
                DefaultListModel<Arme> model = new DefaultListModel<>();
                for (Arme arme : inventory.getBoutiqueList())
                {
                    model.addElement(arme);
                }
                this.boutiqueWindow.listeArmes.setModel(model);
            }
            this.boutiqueWindow.setVisible(true);
            return;
        }
        if(e.getActionCommand() == "boutonParametre")
        {
            return;
        }
        if(e.getActionCommand() == "comboBoxAssaut")
        {
            int index = inventoryWindow.comboBoxAssaut.getSelectedIndex();
            inventoryWindow.jImageAssaut.setIcon(inventoryWindow.scaleImage(Inventaire.getInstance().getAssautList().get(index).getSkin().getImage()));
        }
        if(e.getActionCommand() == "comboBoxSMG")
        {
            int index = inventoryWindow.comboBoxSMG.getSelectedIndex();
            inventoryWindow.jImageSMG.setIcon(new ImageIcon(Inventaire.getInstance().getAssautList().get(index).getSkin().getImage()));
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
    public void valueChanged(ListSelectionEvent e) {

        if(inventory.getBoutiqueList().get(boutiqueWindow.listeArmes.getSelectedIndex()) instanceof ArmeAFeu)
        {
            ArmeAFeu arme = (ArmeAFeu) inventory.getBoutiqueList().get(boutiqueWindow.listeArmes.getSelectedIndex());
            boutiqueWindow.labelValeurDegat.setText(String.valueOf(arme.getDegatsTete()));
            boutiqueWindow.labelValeurChargeur.setText(String.valueOf(arme.getCapaciteChargeur()));
            boutiqueWindow.labelValeurPortee.setText(String.valueOf(arme.getPortee()));
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
        //super.windowClosing(e);
    }
}
