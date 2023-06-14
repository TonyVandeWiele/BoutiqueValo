package GUI;

import Controller.Controlleur;

import javax.swing.*;
import java.awt.*;

public class ParameterWindow extends JDialog {
    public JButton chooseButtonProfil;
    public JLabel labelPathProfil;
    private JButton chooseButtonBoutique;
    public JLabel labelPathBoutique;

    public ParameterWindow(JFrame parent) {
        super(parent, "Modification Chemin d'accès", true);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1));

        // Créer un bouton pour ouvrir le sélecteur de dossier
        labelPathProfil = new JLabel();
        add(labelPathProfil);
        chooseButtonProfil = new JButton("Choisir un dossier Profil");
        add(chooseButtonProfil);

        labelPathBoutique = new JLabel();
        add(labelPathBoutique);
        chooseButtonBoutique = new JButton("Choisir un dossier Boutique");
        add(chooseButtonBoutique);
    }

    public void setControleur(Controlleur c)
    {
        chooseButtonProfil.addActionListener(c);
        chooseButtonProfil.setActionCommand("chooseButtonProfil");

        chooseButtonBoutique.addActionListener(c);
        chooseButtonBoutique.setActionCommand("chooseButtonBoutique");

        this.addWindowListener(c);
    }
}
