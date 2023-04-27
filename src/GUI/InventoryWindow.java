package GUI;

import métier.ArmeAFeu;
import métier.ArmeCAC;

import javax.swing.*;
import java.awt.*;

public class InventoryWindow {
    private JPanel jPanel;
    //private JButton jButton;

    public InventoryWindow() {
        jPanel.setLayout(new GridBagLayout());

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


        JButton jButtonInventaire = new JButton("Inventaire");
        JButton jButtonBoutique = new JButton("Boutique");
        JButton jButtonParametre = new JButton("Paramètre");

        GridBagConstraints gbcButton = new GridBagConstraints();
        
        jPanelMenu.add(jButtonInventaire,gbcButton);
        jPanelMenu.add(jButtonBoutique,gbcButton);
        jPanelMenu.add(jButtonParametre,gbcButton);

        JPanel jPanelProfil = new JPanel();
        jPanelProfil.setLayout(new GridBagLayout());
        JPanel jPanelContent = new JPanel(new GridBagLayout());

        gbc.weightx = 0.2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        jPanelProfil.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        jPanelCell.add(jPanelProfil,gbc);

        gbc.weightx = 0.8;
        gbc.gridx = 1;
        gbc.gridy = 0;
        jPanelContent.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        jPanelCell.add(jPanelContent,gbc);


        JPanel jPanelAssaut = new JPanel();
        JPanel jPanelSMG = new JPanel();
        JPanel jPanelSniper = new JPanel();
        JPanel jPanelCAC = new JPanel();

        gbc.weightx = 0.25;
        gbc.weighty = 0.25;
        gbc.gridx = 0;
        gbc.gridy = 0;
        jPanelAssaut.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jPanelContent.add(jPanelAssaut,gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        jPanelSMG.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jPanelContent.add(jPanelSMG,gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        jPanelSniper.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jPanelContent.add(jPanelSniper,gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        jPanelCAC.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jPanelContent.add(jPanelCAC,gbc);


        BoxLayout layoutAssaut = new BoxLayout(jPanelAssaut, BoxLayout.Y_AXIS);
        jPanelAssaut.setLayout(layoutAssaut);
        BoxLayout layoutSMG = new BoxLayout(jPanelSMG, BoxLayout.Y_AXIS);
        jPanelSMG.setLayout(layoutSMG);
        BoxLayout layoutSniper = new BoxLayout(jPanelSniper, BoxLayout.Y_AXIS);
        jPanelSniper.setLayout(layoutSniper);
        BoxLayout layoutCAC = new BoxLayout(jPanelCAC, BoxLayout.Y_AXIS);
        jPanelCAC.setLayout(layoutCAC);

        Label labelAssaut = new Label("Assaut",Label.CENTER);
        jPanelAssaut.add(labelAssaut);

        ImageIcon icon = new ImageIcon("C:\\Users\\vande\\Pictures\\valorant-reaver-vandal.png");
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newImg);
        JLabel imageLabelAssaut = new JLabel(newIcon);
        imageLabelAssaut.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        jPanelAssaut.add(imageLabelAssaut);
        jPanelAssaut.add(new JComboBox<ArmeAFeu>());


        Label labelSMG = new Label("SMG",Label.CENTER);
        jPanelSMG.add(labelSMG);
        JLabel imageLabelSMG = new JLabel(newIcon);
        imageLabelSMG.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        jPanelSMG.add(imageLabelSMG);
        jPanelSMG.add(new JComboBox<ArmeAFeu>());

        Label labelSniper = new Label("Sniper",Label.CENTER);
        jPanelSniper.add(labelSniper);

        JLabel imageLabelSniper = new JLabel(newIcon);
        imageLabelSniper.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        jPanelSniper.add(imageLabelSniper);
        jPanelSniper.add(new JComboBox<ArmeAFeu>());

        Label labelCAC = new Label("Corps à Corps",Label.CENTER);
        jPanelCAC.add(labelCAC);
        JLabel imageLabelCAC = new JLabel(newIcon);
        imageLabelCAC.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        jPanelCAC.add(imageLabelCAC);
        jPanelCAC.add(new JComboBox<ArmeCAC>());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("InventoryWindow");
        frame.setContentPane(new InventoryWindow().jPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);
    }
}
