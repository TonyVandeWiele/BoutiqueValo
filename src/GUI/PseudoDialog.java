package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PseudoDialog extends JDialog {
    private JTextField textField;
    private JButton okButton;
    private String pseudo;

    public PseudoDialog() {
        //super(parent, "Changer le pseudo", true);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1));

        // Créer un champ de texte pour le pseudo
        textField = new JTextField();
        add(textField);

        // Créer un bouton pour confirmer le changement de pseudo
        okButton = new JButton("Confirmer");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pseudo = textField.getText();
                setVisible(false);
            }
        });
        add(okButton);
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
