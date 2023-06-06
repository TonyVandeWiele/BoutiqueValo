package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Boutique extends JFrame {
    private JPanel jPanelBoutique;

    public Boutique() {
        // Propriétés de la fenêtre
        setTitle("Boutique arme");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        // Création du jPanelBoutique
        jPanelBoutique = new JPanel();

        JPanel panelStats=new JPanel(new GridBagLayout());

        // Configuration du layout du jPanelBoutique avec un GridBagLayout
        jPanelBoutique.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;

        // Création des composants
        JLabel labelArme = new JLabel("Sélectionner une arme:");
        labelArme.setHorizontalAlignment(SwingConstants.CENTER);
        JList<String> listeArmes = new JList<>(new String[]{"Pistolet", "Fusil", "Sniper", "Pompe"});
        listeArmes.setFont(listeArmes.getFont().deriveFont(listeArmes.getFont().getSize() + 2f));
        JLabel labelImageArme = new JLabel();
        JButton boutonAcheter = new JButton("Acheter");
        JLabel labelDegat=new JLabel("Dégâts :");
        JLabel labelValeurDegat=new JLabel("100-150");
        JLabel labelPortee=new JLabel("Portée");
        JLabel labelValeurPortee=new JLabel("600");
        JLabel labelTailleChargeur=new JLabel("Taille du chargeur :");
        JLabel labelValeurChargeur=new JLabel("52");

        // Chargement de l'image à partir du fichier
        ImageIcon imageIcon = new ImageIcon("F:\\Programme\\Java\\Boutique\\Picture\\integration.jpg");
        Image image = imageIcon.getImage();

        // Ajout d'un ComponentListener pour redimensionner l'image lors du changement de taille du label
        labelImageArme.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                ImageIcon scaledIcon = new ImageIcon(image.getScaledInstance(labelImageArme.getWidth(), labelImageArme.getHeight(), Image.SCALE_SMOOTH));
                labelImageArme.setIcon(scaledIcon);
            }
        });

        // Ajout du labelArme au nord avec largeur de 1/5 de la fenêtre
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.weightx = 0.2;
        constraints.weighty = 0;
        jPanelBoutique.add(labelArme, constraints);

        // Ajout de la listeArmes à l'ouest avec largeur de 1/5 de la fenêtre
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.weightx = 0.2;
        constraints.weighty = 1;
        jPanelBoutique.add(listeArmes, constraints);

        // Ajout du labelImageArme au centre avec largeur de 2/5 de la fenêtre
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.weightx = 0.4;
        constraints.weighty = 1;
        jPanelBoutique.add(labelImageArme, constraints);


        // Ajout des labels au panelStats avec les contraintes
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0;
        constraints.weighty = 0;
        panelStats.add(labelDegat, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 0;
        constraints.weighty = 0;
        panelStats.add(labelPortee, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.weightx = 0;
        constraints.weighty = 0;
        panelStats.add(labelTailleChargeur, constraints);

        // Ajout des JLabel pour les valeurs au panelStats
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 0;
        constraints.weighty = 0;
        panelStats.add(labelValeurDegat, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.weightx = 0;
        constraints.weighty = 0;
        panelStats.add(labelValeurPortee, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.weightx = 0;
        constraints.weighty = 0;
        panelStats.add(labelValeurChargeur, constraints);

        // Ajout du panelStats à l'est avec largeur de 2/5 de la fenêtre
        constraints.gridx = 3;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.weightx = 0.4;
        constraints.weighty = 1;
        jPanelBoutique.add(panelStats, constraints);

        // Ajout du boutonAcheter au sud avec largeur de 1/5 de la fenêtre
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 4;
        constraints.weightx = 0;
        constraints.weighty = 0;
        jPanelBoutique.add(boutonAcheter, constraints);

        // Ajout du jPanelBoutique à la fenêtre
        add(jPanelBoutique);

        setVisible(true);
    }

    public static void main(String[] args) {
        com.formdev.flatlaf.FlatDarculaLaf.install();
        JFrame frame = new JFrame("InventoryWindow");
        frame.setContentPane(new Boutique().jPanelBoutique);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(1190,600));
        frame.setSize(new Dimension(1190,600));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        frame.setVisible(true);
    }
}

