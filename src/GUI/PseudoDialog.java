package GUI;

import Controller.Controlleur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PseudoDialog extends JDialog {
    public static JTextField textField;
    private JButton okButton;
    private String pseudo;

    public PseudoDialog() {

        setSize(300, 150);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 1));
        com.formdev.flatlaf.FlatDarculaLaf.install();

        // Créer un champ de texte pour le pseudo
        textField = new JTextField();
        add(textField);

        // Créer un bouton pour confirmer le changement de pseudo
        okButton = new JButton("Confirmer");

        add(okButton);
    }

    public void setControleur(Controlleur c)
    {
        okButton.addActionListener(c);
        okButton.setActionCommand("okButton");

        this.addWindowListener(c);
    }

    public String getPseudo() {
        return pseudo;
    }

    public static void main(String[] args) {
        PseudoDialog dialog = new PseudoDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
