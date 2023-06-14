package GUI;

import Controller.Controlleur;
import Model.Arme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Boutique extends JDialog {
    private final JPanel jPanelBoutique;
    private final JPanel jPanelStats;
    public JLabel labelChargeur;
    public JLabel labelDegatTete;
    private final JLabel labelArme;
    public final JLabel labelImageArme;
    public JLabel labelDegatCorps;
    public JLabel labelPortee;
    public JLabel labelCategorie;
    public JLabel labelPrix;
    public JLabel labelRarete;
    public Image imageArme;
    private final JButton boutonAcheter;
    public JList<Arme> listeArmes;

    public Boutique(JFrame parent) {
        // Propriétés de la fenêtre
        super(parent, "Boutique", true);
        com.formdev.flatlaf.FlatDarculaLaf.install();
        setSize(new Dimension(1050,480));
        setLocationRelativeTo(null);

        // Création du jPanelBoutique
        jPanelBoutique = new JPanel();
        jPanelStats = new JPanel();
        jPanelStats.setLayout(new GridBagLayout());

        // Configuration du layout du jPanelBoutique avec un GridBagLayout
        jPanelBoutique.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;

        // Création des composants
        labelArme = new JLabel("Sélectionner une arme:");
        labelArme.setHorizontalAlignment(SwingConstants.CENTER);


        listeArmes = new JList<>();
        listeArmes.setFont(listeArmes.getFont().deriveFont(listeArmes.getFont().getSize() + 2f));

        labelImageArme = new JLabel();
        boutonAcheter = new JButton("Acheter");
        labelDegatTete=new JLabel("Dégâts Tete : ");
        labelDegatCorps=new JLabel("Dégâts Corps : ");
        labelPortee=new JLabel("Portée : ");
        labelChargeur=new JLabel("Capacité Chargeur : ");
        labelCategorie = new JLabel("Catégorie : ");
        labelPrix = new JLabel("Prix : ");
        labelRarete = new JLabel("Rareté Skin : ");

        // Chargement de l'image à partir du fichier
        ImageIcon imageIcon = new ImageIcon("MesImages/logo2.png");
        imageArme = imageIcon.getImage();

        // Ajout d'un ComponentListener pour redimensionner l'image lors du changement de taille du label
        labelImageArme.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                ImageIcon scaledIcon = new ImageIcon(imageArme.getScaledInstance(labelImageArme.getWidth(), labelImageArme.getHeight(), Image.SCALE_SMOOTH));
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

        // Ajout du jPanelStats à l'est avec largeur de 2/5 de la fenêtre
        constraints.gridx = 3;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.weightx = 0.4;
        constraints.weighty = 1;
        jPanelBoutique.add(jPanelStats, constraints);


        // Ajout des labels au jPanelStats avec les contraintes
        constraints.anchor = GridBagConstraints.NORTHWEST;

        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0;
        constraints.weighty = 0;
        jPanelStats.add(labelDegatTete, constraints);

        // Ajout des JLabel pour les valeurs au jPanelStats
        constraints.gridx = 0;
        constraints.gridy = 1;
        jPanelStats.add(labelDegatCorps, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        jPanelStats.add(labelPortee, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        jPanelStats.add(labelChargeur, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        jPanelStats.add(labelCategorie, constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;
        jPanelStats.add(labelPrix, constraints);

        constraints.gridx = 0;
        constraints.gridy = 6;
        jPanelStats.add(labelRarete, constraints);


        constraints.weighty = 1;
        constraints.gridx = 0;
        constraints.gridy = 7;
        jPanelStats.add(Box.createVerticalGlue(), constraints);



        // Ajout du boutonAcheter au sud avec largeur de 1/5 de la fenêtre
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 4;
        constraints.weightx = 0;
        constraints.weighty = 0;
        jPanelBoutique.add(boutonAcheter, constraints);

        // Ajout du jPanelBoutique à la fenêtre
        add(jPanelBoutique);

        setContentPane(jPanelBoutique);
    }

    public void setControleur(Controlleur c)
    {
        listeArmes.addListSelectionListener(c);
        boutonAcheter.addActionListener(c);
        boutonAcheter.setActionCommand("boutonAcheter");
        this.addWindowListener(c);
    }

}

