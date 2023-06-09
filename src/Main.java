import Model.*;
import GUI.*;
import Controller.*;

public class Main {
    public static void main(String[] args)
    {

        InventoryWindow inventoryWindow = new InventoryWindow();

        Controlleur controlleur = new Controlleur(Inventaire.getInstance(),inventoryWindow);

        inventoryWindow.setControleur(controlleur);

        inventoryWindow.setVisible(true);
    }
}