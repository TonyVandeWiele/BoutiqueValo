package GUI;

import metier.ArmeAFeu;
import metier.ArmeCAC;

import javax.swing.*;
import java.awt.*;

public class InventoryWindow {
    private JPanel jPanel;
    //private JButton jButton;

    public InventoryWindow() {
        jPanel.setLayout(new GridBagLayout());

        //Panel Menu et Cell(Profil et Content)
        JPanel jPanelMenu = new JPanel();
        JPanel jPanelCell = new JPanel();
        jPanelCell.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1.0;
        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        jPanelMenu.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jPanel.add(jPanelMenu,gbc);

        gbc.weighty = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        jPanelCell.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jPanel.add(jPanelCell,gbc);

        //Menu
        JButton jButtonInventaire = new JButton("Inventaire");
        JButton jButtonBoutique = new JButton("Boutique");
        JButton jButtonParametre = new JButton("Paramètre");

        GridBagConstraints gbcButton = new GridBagConstraints();
        
        jPanelMenu.add(jButtonInventaire,gbcButton);
        jPanelMenu.add(jButtonBoutique,gbcButton);
        jPanelMenu.add(jButtonParametre,gbcButton);

        //Panel Profil
        JPanel jPanelProfil = new JPanel();
        jPanelProfil.setLayout(new GridBagLayout());
        JPanel jPanelContent = new JPanel(new GridBagLayout());

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

        JPanel jPanelVide = new JPanel();
        jPanelProfil.add(jPanelVide);

        //Panel Content
        gbc.weightx = 0.8;
        gbc.gridx = 1;
        gbc.gridy = 0;
        jPanelContent.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        jPanelCell.add(jPanelContent,gbc);

        //Content
        JPanel jPanelAssaut = new JPanel();
        JPanel jPanelSMG = new JPanel();
        JPanel jPanelSniper = new JPanel();
        JPanel jPanelCAC = new JPanel();

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
        Label labelAssaut = new Label("Assaut",Label.CENTER);
        labelAssaut.setFont(new Font("SansSerif",Font.BOLD,16));
        jPanelAssaut.add(labelAssaut);

        jPanelAssaut.add(getImage("MesImages/vandal_defaut.png"));

        JPanel jPanelVide1 = new JPanel();
        jPanelAssaut.add(jPanelVide1);

        JComboBox<ArmeAFeu> comboBoxAssaut = new JComboBox<>();
        comboBoxAssaut.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10,10,10,10),
                comboBoxAssaut.getBorder()
        ));
        jPanelAssaut.add(comboBoxAssaut);

        //SMG
        Label labelSMG = new Label("SMG",Label.CENTER);
        labelSMG.setFont(new Font("SansSerif",Font.BOLD,16));
        jPanelSMG.add(labelSMG);

        jPanelSMG.add(getImage("MesImages/spectre_defaut.png"));

        JPanel jPanelVide2 = new JPanel();
        jPanelSMG.add(jPanelVide2);

        JComboBox<ArmeAFeu> comboBoxSMG = new JComboBox<>();
        comboBoxSMG.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10,10,10,10),
                comboBoxSMG.getBorder()
        ));
        jPanelSMG.add(comboBoxSMG);

        //Sniper
        Label labelSniper = new Label("Sniper",Label.CENTER);
        labelSniper.setFont(new Font("SansSerif",Font.BOLD,16));
        jPanelSniper.add(labelSniper);

        jPanelSniper.add(getImage("MesImages/operator_defaut.png"));

        JPanel jPanelVide3 = new JPanel();
        jPanelSniper.add(jPanelVide3);

        JComboBox<ArmeAFeu> comboBoxSniper = new JComboBox<>();
        comboBoxSniper.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10,10,10,10),
                comboBoxSniper.getBorder()
        ));
        jPanelSniper.add(comboBoxSniper);

        //CAC
        Label labelCAC = new Label("Corps à Corps",Label.CENTER);
        labelCAC.setFont(new Font("SansSerif",Font.BOLD,16));
        jPanelCAC.add(labelCAC);

        jPanelCAC.add(getImage("MesImages/knife_kingdom.png"));

        JPanel jPanelVide4 = new JPanel();
        jPanelCAC.add(jPanelVide4);

        JComboBox<ArmeCAC> comboBoxCAC = new JComboBox<>();
        comboBoxCAC.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10,10,10,10),
                comboBoxCAC.getBorder()
        ));
        jPanelCAC.add(comboBoxCAC);

    }
    public JLabel getImage(String filename) {
        ImageIcon icon = new ImageIcon(filename);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(250, 125, Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newImg);

        JLabel imageLabel = new JLabel(newIcon);
        imageLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        return imageLabel;
    }

    public static void main(String[] args) {
        com.formdev.flatlaf.FlatDarculaLaf.install();
        JFrame frame = new JFrame("InventoryWindow");
        frame.setContentPane(new InventoryWindow().jPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(940,600));
        frame.setSize(new Dimension(940,600));
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}


