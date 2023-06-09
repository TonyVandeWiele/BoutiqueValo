package GUI;

import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import Controller.*;
import java.awt.event.WindowListener;

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



    public JButton jButtonInventaire;
    public JButton jButtonBoutique;
    public JButton jButtonParametre;

    public JPanel jPanelVide0;
    public JPanel jPanelVide1;
    public JPanel jPanelVide2;
    public JPanel jPanelVide3;
    public JPanel jPanelVide4;

    public InventoryWindow() {
        com.formdev.flatlaf.FlatDarculaLaf.install();

        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(940,600));
        setLocationRelativeTo(null);

        jPanel = new JPanel();

        jPanel.setLayout(new GridBagLayout());

        //Panel Menu et Cell(Profil et Content)
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
        jButtonInventaire = new JButton("Inventaire");
        jButtonBoutique = new JButton("Boutique");
        JButton jButtonParametre = new JButton("Paramètre");
        GridBagConstraints gbcButton = new GridBagConstraints();
        
        jPanelMenu.add(jButtonInventaire,gbcButton);
        jPanelMenu.add(jButtonBoutique,gbcButton);
        jPanelMenu.add(jButtonParametre,gbcButton);

        //Panel Profil
        jPanelProfil = new JPanel();
        jPanelProfil.setLayout(new GridBagLayout());
        jPanelContent = new JPanel(new GridBagLayout());

        gbc.weightx = 0.2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        jPanelProfil.setBorder(BorderFactory.createMatteBorder(2,0,2,2,Color.black));
        jPanelCell.add(jPanelProfil,gbc);

        BoxLayout layoutProfil = new BoxLayout(jPanelProfil, BoxLayout.Y_AXIS);
        jPanelProfil.setLayout(layoutProfil);

        //Profil
        Label labelProfil = new Label("Nom du Joueur",Label.CENTER);
        labelProfil.setFont(new Font("SansSerif",Font.BOLD,16));
        jPanelProfil.add(labelProfil);

        Label labelBanniere = new Label("Banière : ",Label.CENTER);
        labelBanniere.setFont(new Font("SansSerif",Font.BOLD,14));
        jPanelProfil.add(labelBanniere);

        ImageIcon iconProfil = new ImageIcon("C:\\Users\\vande\\Pictures\\carte.png");
        Image imgProfil = iconProfil.getImage();
        Image newImgProfil = imgProfil.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon newIconProfil = new ImageIcon(newImgProfil);
        JLabel imageLabelProfil = new JLabel(newIconProfil);
        imageLabelProfil.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        imageLabelProfil.setBorder(BorderFactory.createLineBorder(Color.black));
        jPanelProfil.add(imageLabelProfil);

        Label labelLVL = new Label("Argent : ",Label.CENTER);
        labelLVL.setFont(new Font("SansSerif",Font.BOLD,14));
        jPanelProfil.add(labelLVL);

        Label labelDate = new Label("Date Création Profil : ",Label.CENTER);
        labelLVL.setFont(new Font("SansSerif",Font.BOLD,14));
        jPanelProfil.add(labelLVL);

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
        BoxLayout layoutAssaut = new BoxLayout(jPanelAssaut, BoxLayout.Y_AXIS);
        jPanelAssaut.setLayout(layoutAssaut);
        BoxLayout layoutSMG = new BoxLayout(jPanelSMG, BoxLayout.Y_AXIS);
        jPanelSMG.setLayout(layoutSMG);
        BoxLayout layoutSniper = new BoxLayout(jPanelSniper, BoxLayout.Y_AXIS);
        jPanelSniper.setLayout(layoutSniper);
        BoxLayout layoutCAC = new BoxLayout(jPanelCAC, BoxLayout.Y_AXIS);
        jPanelCAC.setLayout(layoutCAC);

        //ASSAUT
        labelAssaut = new JLabel("Assaut",CENTER);
        labelAssaut.setFont(new Font("SansSerif",Font.BOLD,16));
        jPanelAssaut.add(labelAssaut);

        jImageAssaut = new JLabel();
        jImageAssaut.setIcon(scaleImage("MesImages/vandal_defaut.png"));
        jPanelAssaut.add(jImageAssaut);

        jPanelAssaut.add(jPanelVide0);

        comboBoxAssaut = new JComboBox<>();
        comboBoxAssaut.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10,10,10,10),
                comboBoxAssaut.getBorder()
        ));
        comboBoxAssaut.setPreferredSize(new Dimension(5,40));
        comboBoxAssaut.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list,
                                                          Object value,
                                                          int index,
                                                          boolean isSelected,
                                                          boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof ArmeAFeu) {
                    setText(((ArmeAFeu)value).getNom());
                }
                return this;
            }
        });
        jPanelAssaut.add(comboBoxAssaut);

        //SMG
        labelSMG = new JLabel("SMG",CENTER);
        labelSMG.setFont(new Font("SansSerif",Font.BOLD,16));
        jPanelSMG.add(labelSMG);

        jImageSMG = new JLabel();
        jImageSMG.setIcon(scaleImage("MesImages/spectre_defaut.png"));
        jPanelSMG.add(jImageSMG);

        jPanelSMG.add(jPanelVide1);

        comboBoxSMG = new JComboBox<>();
        comboBoxSMG.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10,10,10,10),
                comboBoxSMG.getBorder()
        ));
        jPanelSMG.add(comboBoxSMG);

        //Sniper
        labelSniper = new JLabel("Sniper",CENTER);
        labelSniper.setFont(new Font("SansSerif",Font.BOLD,16));
        jPanelSniper.add(labelSniper,CENTER);

        jPanelSniper.add(Box.createRigidArea(new Dimension(0,50)));

        jImageSniper = new JLabel();
        jImageSniper.setIcon(scaleImage("MesImages/operator_defaut.png"));
        jPanelSniper.add(jImageSniper);

        jPanelSniper.add(jPanelVide2);

        comboBoxSniper = new JComboBox<>();
        comboBoxSniper.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10,10,10,10),
                comboBoxSniper.getBorder()
        ));
        jPanelSniper.add(comboBoxSniper);

        //CAC
        labelCAC = new JLabel("Corps à Corps",CENTER);
        labelCAC.setFont(new Font("SansSerif",Font.BOLD,16));
        jPanelCAC.add(labelCAC);

        jImageCAC = new JLabel();
        jImageCAC.setIcon(scaleImage("MesImages/knife_kingdom.png"));
        jPanelCAC.add(jImageCAC);

        jPanelCAC.add(jPanelVide3);

        comboBoxCAC = new JComboBox<>();
        comboBoxCAC.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10,10,10,10),
                comboBoxCAC.getBorder()
        ));
        jPanelCAC.add(comboBoxCAC);

        setContentPane(jPanel);
        setVisible(true);

    }
    public ImageIcon scaleImage(String filename) {
        ImageIcon icon = new ImageIcon(filename);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(250, 150, Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newImg);
        return newIcon;
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

        jButtonInventaire.addActionListener(c);
        jButtonInventaire.setActionCommand("boutonInventaire");

        jButtonBoutique.addActionListener(c);
        jButtonBoutique.setActionCommand("boutonBoutique");
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


