package Controller;

import GUI.InventoryWindow;
import Model.Inventaire;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

public class Controlleur extends WindowAdapter implements ActionListener
{
    private Inventaire inventory;
    private InventoryWindow inventoryWindow;
    Controlleur(Inventaire inventory, InventoryWindow inventoryWindow)
    {
        this.inventory = inventory;
        this.inventoryWindow = inventoryWindow;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        JDialog test = new JDialog();
        test.setVisible(true);
    }
}
