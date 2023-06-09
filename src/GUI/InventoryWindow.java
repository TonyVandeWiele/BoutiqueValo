package GUI;

import Controller.Controlleur;

import javax.swing.*;
import java.awt.*;

import static javax.swing.SwingConstants.CENTER;


public class InventoryWindow extends JFrame {
    private JPanel jPanel;
    public JPanel jPanelMenu;

    public JPanel jPanelCell;
    public JPanel jPanelProfil;

    public JPanel jPanelContent;
    public JPanel jPanelAssaut;
    public JLabel labelAssaut;
    public JLabel jImageAssaut;
    public JComboBox<String> comboBoxAssaut;

    public JPanel jPanelSMG;
    public JLabel labelSMG;
    public JLabel jImageSMG;
    public JComboBox<String> comboBoxSMG;

    public JPanel jPanelSniper;
    public JLabel labelSniper;
    public JLabel jImageSniper;
    public JComboBox<String> comboBoxSniper;

    public JPanel jPanelCAC;
    public JLabel labelCAC;
    public JLabel jImageCAC;
    public JComboBox<String> comboBoxCAC;



    public Label labelProfil;
    public Label labelBanniere;
    public JLabel jImageAvatar;
    public Label labelArgent;
    public Label labelDate;

    public JButton jButtonBoutique;
    public JButton jButtonParametre;

    public JPanel jPanelVide0;
    public JPanel jPanelVide1;
    public JPanel jPanelVide2;
    public JPanel jPanelVide3;
    public JPanel jPanelVide4;


    public JMenuBar menuBar;
    public JMenu menu1;
    public JMenu menu2;

    public JMenuItem menuItem1;
    public JMenuItem menuItem2;
    public JMenuItem menuItem3;
    public JMenuItem menuItem4;
    public JMenuItem menuItem5;
    public JMenuItem menuItem6;
    public JMenuItem menuItem7;

    public InventoryWindow() {
        com.formdev.flatlaf.FlatDarculaLaf.install();

        setSize(new Dimension(940,600));
        setLocationRelativeTo(null);

        jPanel = new JPanel();

        jPanel.setLayout(new GridBagLayout());

        //Panel Menu et Cell (Profil et Content)
        jPanelMenu = new JPanel();
        jPanelCell = new JPanel();
        jPanelCell.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1.0;
        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        jPanelMenu.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        jPanel.add(jPanelMenu,gbc);

        gbc.weighty = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        jPanelCell.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jPanel.add(jPanelCell,gbc);

        //Menu
        jButtonBoutique = new JButton("Boutique");
        jButtonParametre = new JButton("Paramètre");
        GridBagConstraints gbcButton = new GridBagConstraints();

        jPanelMenu.add(jButtonBoutique,gbcButton);
        jPanelMenu.add(jButtonParametre,gbcButton);

        //Panel Profil
        jPanelProfil = new JPanel();
        jPanelProfil.setLayout(new GridBagLayout());
        jPanelContent = new JPanel(new GridBagLayout());

        gbc.weightx = 0.1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        jPanelProfil.setBorder(BorderFactory.createMatteBorder(2,0,2,2,Color.black));
        jPanelCell.add(jPanelProfil,gbc);



        //Profil
        gbc.gridx = 0;
        gbc.gridy = 0;
        labelProfil = new Label("Nom du Joueur",Label.CENTER);
        labelProfil.setFont(new Font("SansSerif",Font.BOLD,16));
        jPanelProfil.add(labelProfil,gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        labelBanniere = new Label("Banière du joueur : ",Label.CENTER);
        labelBanniere.setFont(new Font("SansSerif",Font.BOLD,14));
        jPanelProfil.add(labelBanniere,gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        jImageAvatar = new JLabel();
        jImageAvatar.setIcon(scaleImage("MesImages/logo2.png",150,150));
        jImageAvatar.setHorizontalAlignment(CENTER);
        jPanelProfil.add(jImageAvatar,gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        labelArgent = new Label("Argent : ",Label.CENTER);
        labelArgent.setFont(new Font("SansSerif",Font.BOLD,14));
        jPanelProfil.add(labelArgent,gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        labelDate = new Label("Date Création Profil : ",Label.CENTER);
        labelDate.setFont(new Font("SansSerif",Font.BOLD,14));
        jPanelProfil.add(labelDate,gbc);

        jPanelVide0 = new JPanel();
        jPanelVide1 = new JPanel();
        jPanelVide2 = new JPanel();
        jPanelVide3 = new JPanel();
        jPanelVide4 = new JPanel();
        jPanelProfil.add(jPanelVide4);

        //Panel Content
        gbc.weightx = 0.8;
        gbc.gridx = 1;
        gbc.gridy = 0;
        jPanelContent.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        jPanelCell.add(jPanelContent,gbc);

        //Content
        jPanelAssaut = new JPanel();
        jPanelSMG = new JPanel();
        jPanelSniper = new JPanel();
        jPanelCAC = new JPanel();

        //Panel Assaut
        gbc.weightx = 0.25;
        gbc.weighty = 0.25;
        gbc.gridx = 0;
        gbc.gridy = 0;
        jPanelAssaut.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.black));
        jPanelContent.add(jPanelAssaut,gbc);
        //Panel SMG
        gbc.gridx = 1;
        gbc.gridy = 0;
        jPanelSMG.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.black));
        jPanelContent.add(jPanelSMG,gbc);
        //Panel Sniper
        gbc.gridx = 0;
        gbc.gridy = 1;
        jPanelSniper.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.black));
        jPanelContent.add(jPanelSniper,gbc);
        //Panel CAC
        gbc.gridx = 1;
        gbc.gridy = 1;
        jPanelCAC.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.black));
        jPanelContent.add(jPanelCAC,gbc);

        //Configuration des Layouts pour le panel Assaut, SMG, Sniper et CAC
        GridBagConstraints gbcA = new GridBagConstraints();

        GridBagLayout layoutAssaut = new GridBagLayout();
        jPanelAssaut.setLayout(layoutAssaut);
        GridBagLayout layoutSMG = new GridBagLayout();
        jPanelSMG.setLayout(layoutSMG);
        GridBagLayout layoutSniper = new GridBagLayout();
        jPanelSniper.setLayout(layoutSniper);
        GridBagLayout layoutCAC = new GridBagLayout();
        jPanelCAC.setLayout(layoutCAC);

        //ASSAUT
        gbcA.anchor = GridBagConstraints.CENTER;
        gbcA.insets = new Insets(0, 0, 10, 0);
        gbcA.gridx = 0;
        gbcA.gridy = 0;
        labelAssaut = new JLabel("Assaut",CENTER);
        labelAssaut.setFont(new Font("SansSerif",Font.BOLD,16));
        jPanelAssaut.add(labelAssaut,gbcA);

        gbcA.gridx = 0;
        gbcA.gridy = 1;
        jImageAssaut = new JLabel();
        jImageAssaut.setIcon(scaleImage("MesImages/vandal_pp.png",250,150));
        jPanelAssaut.add(jImageAssaut,gbcA);


        gbcA.insets = new Insets(0, 0, 0, 0);
        gbcA.gridx = 0;
        gbcA.gridy = 2;
        gbcA.fill = GridBagConstraints.HORIZONTAL;
        comboBoxAssaut = new JComboBox<>();
        comboBoxAssaut.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10,10,10,10),
                comboBoxAssaut.getBorder()
        ));
        comboBoxAssaut.setPreferredSize(new Dimension(5,40));
        jPanelAssaut.add(comboBoxAssaut,gbcA);

        //SMG
        gbcA.gridx = 0;
        gbcA.gridy = 0;
        labelSMG = new JLabel("SMG",CENTER);
        labelSMG.setFont(new Font("SansSerif",Font.BOLD,16));
        //labelSMG.setHorizontalAlignment(CENTER);
        jPanelSMG.add(labelSMG,gbcA);

        gbcA.gridx = 0;
        gbcA.gridy = 1;
        jImageSMG = new JLabel();
        jImageSMG.setIcon(scaleImage("MesImages/spectre_pp.png",250,150));
        jImageSMG.setHorizontalAlignment(JLabel.CENTER);
        jPanelSMG.add(jImageSMG,gbcA);

        gbcA.gridx = 0;
        gbcA.gridy = 2;
        comboBoxSMG = new JComboBox<>();
        comboBoxSMG.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10,10,10,10),
                comboBoxSMG.getBorder()
        ));
        comboBoxSMG.setPreferredSize(new Dimension(5,40));
        jPanelSMG.add(comboBoxSMG,gbcA);

        //Sniper
        gbcA.gridx = 0;
        gbcA.gridy = 0;
        labelSniper = new JLabel("Sniper",CENTER);
        labelSniper.setFont(new Font("SansSerif",Font.BOLD,16));
        jPanelSniper.add(labelSniper,gbcA);

        //jPanelSniper.add(Box.createRigidArea(new Dimension(0,50)));
        gbcA.gridx = 0;
        gbcA.gridy = 1;
        jImageSniper = new JLabel();
        jImageSniper.setIcon(scaleImage("MesImages/operator_pp.png",250,150));
        jPanelSniper.add(jImageSniper,gbcA);

        gbcA.gridx = 0;
        gbcA.gridy = 2;
        comboBoxSniper = new JComboBox<>();
        comboBoxSniper.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10,10,10,10),
                comboBoxSniper.getBorder()
        ));
        comboBoxSniper.setPreferredSize(new Dimension(5,40));
        jPanelSniper.add(comboBoxSniper,gbcA);

        //CAC
        gbcA.gridx = 0;
        gbcA.gridy = 0;
        labelCAC = new JLabel("Corps à Corps",CENTER);
        labelCAC.setFont(new Font("SansSerif",Font.BOLD,16));
        jPanelCAC.add(labelCAC,gbcA);

        gbcA.gridx = 0;
        gbcA.gridy = 1;
        jImageCAC = new JLabel();
        jImageCAC.setIcon(scaleImage("MesImages/knife_pp.png",250,150));
        jPanelCAC.add(jImageCAC,gbcA);


        gbcA.gridx = 0;
        gbcA.gridy = 2;
        comboBoxCAC = new JComboBox<>();
        comboBoxCAC.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10,10,10,10),
                comboBoxCAC.getBorder()
        ));
        comboBoxCAC.setPreferredSize(new Dimension(5,40));
        jPanelCAC.add(comboBoxCAC,gbcA);

        // Créer la barre de menu
        menuBar = new JMenuBar();

        // Créer les menus
        menu1 = new JMenu("Profil");
        menu2 = new JMenu("Action");

        // Ajouter des items aux menus
        menuItem1 = new JMenuItem("Modifier Pseudo");
        menuItem2 = new JMenuItem("Modifier Bannière");
        menuItem3 = new JMenuItem("Save");
        menuItem4 = new JMenuItem("Load");
        menuItem5=new JMenuItem("Ajouter argent");
        menuItem6=new JMenuItem("Retirer argent");
        menuItem7=new JMenuItem("Format Date");

        // Ajouter les items au premier menu
        menu1.add(menuItem1);
        menu1.add(menuItem2);

        // Ajouter les items au deuxième menu
        menu2.add(menuItem3);
        menu2.add(menuItem4);
        menu2.add(menuItem5);
        menu2.add(menuItem6);
        menu2.add(menuItem7);

        // Ajouter les menus à la barre de menus
        menuBar.add(menu1);
        menuBar.add(menu2);

        // Ajouter la barre de menus à la fenêtre
        this.setJMenuBar(menuBar);


        setContentPane(jPanel);
        setVisible(true);

    }
    public ImageIcon scaleImage(String filename, int width, int height) {
        ImageIcon icon = new ImageIcon(filename);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }

    public void setControleur(Controlleur c)
    {
        comboBoxAssaut.addActionListener(c);
        comboBoxAssaut.setActionCommand("comboBoxAssaut");

        comboBoxSMG.addActionListener(c);
        comboBoxSMG.setActionCommand("comboBoxSMG");

        comboBoxSniper.addActionListener(c);
        comboBoxSniper.setActionCommand("comboBoxSniper");

        comboBoxCAC.addActionListener(c);
        comboBoxCAC.setActionCommand("comboBoxCAC");

        jButtonBoutique.addActionListener(c);
        jButtonBoutique.setActionCommand("boutonBoutique");

        jButtonParametre.addActionListener(c);
        jButtonParametre.setActionCommand("boutonParametre");

        menuItem1.addActionListener(c);
        menuItem1.setActionCommand("menuItem1");

        menuItem2.addActionListener(c);
        menuItem2.setActionCommand("menuItem2");

        menuItem3.addActionListener(c);
        menuItem3.setActionCommand("menuItem3");

        menuItem4.addActionListener(c);
        menuItem4.setActionCommand("menuItem4");

        menuItem5.addActionListener(c);
        menuItem5.setActionCommand("menuItem5");

        menuItem6.addActionListener(c);
        menuItem6.setActionCommand("menuItem6");

        menuItem7.addActionListener(c);
        menuItem7.setActionCommand("menuItem7");

        this.addWindowListener(c);
    }

    /*public static void main(String[] args) {
        InventoryWindow window = new InventoryWindow();
        window.setContentPane(window.jPanel);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(new Dimension(940,600));
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }*/
}


