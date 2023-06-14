package GUI;

import Controller.Controlleur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BanniereDialog extends JDialog {
    public static JTextField textField;
    private JButton chooseButton;

    public BanniereDialog() {

        setSize(300, 150);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 1));
        com.formdev.flatlaf.FlatDarculaLaf.install();

        // Créer un champ de texte pour la bannière
        textField = new JTextField();
        textField.setEditable(false);
        add(textField);

        // Créer un bouton pour sélectionner le path
        chooseButton = new JButton("Choisir Image");
        add(chooseButton);
    }

    public void setControleur(Controlleur c)
    {
        chooseButton.addActionListener(c);
        chooseButton.setActionCommand("chooseButtonImage");

        this.addWindowListener(c);
    }

    public static void main(String[] args) {
        PseudoDialog dialog = new PseudoDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
