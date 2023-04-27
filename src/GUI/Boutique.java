/*
 * Created by JFormDesigner on Thu Apr 27 11:50:51 CEST 2023
 */

package GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;


/**
 * @author hiroy
 */
public class Boutique {
    public Boutique() {
        initComponents();
    }

    public static void main(String[] args)
    {
        com.formdev.flatlaf.FlatDarculaLaf.install();
        JFrame frame=new JFrame("Boutique Valo");
        frame.setContentPane(new Boutique().ShopWindow);
        frame.pack();
        frame.setVisible(true);
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - TonyVDW
        ShopWindow = new JPanel();
        scrollPaneListeArme = new JScrollPane();
        paneldescriptionarme = new JPanel();
        labeldegat = new JLabel();
        labelprix = new JLabel();
        labelskin = new JLabel();
        labelportée = new JLabel();
        labelcapacitéchargeur = new JLabel();
        labelcatégorie = new JLabel();
        labelnom = new JLabel();
        panelValeur = new JPanel();
        textFieldskin = new JTextField();
        textFieldnom = new JTextField();
        textFielddegat = new JTextField();
        textFieldportee = new JTextField();
        textFieldcapacitechargeur = new JTextField();
        textFieldprix = new JTextField();
        comboBoxCategorie = new JComboBox();
        button9 = new JButton();
        button10 = new JButton();

        //======== ShopWindow ========
        {
            ShopWindow.setPreferredSize(new Dimension(400, 300));
            ShopWindow.setMinimumSize(new Dimension(400, 300));
            ShopWindow.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(
            new javax.swing.border.EmptyBorder(0,0,0,0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion"
            ,javax.swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM
            ,new java.awt.Font("Dia\u006cog",java.awt.Font.BOLD,12)
            ,java.awt.Color.red),ShopWindow. getBorder()));ShopWindow. addPropertyChangeListener(
            new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e
            ){if("bord\u0065r".equals(e.getPropertyName()))throw new RuntimeException()
            ;}});
            ShopWindow.setLayout(new GridBagLayout());
            ((GridBagLayout)ShopWindow.getLayout()).columnWidths = new int[] {127, 144, 123, 0};
            ((GridBagLayout)ShopWindow.getLayout()).rowHeights = new int[] {265, 0, 0};
            ((GridBagLayout)ShopWindow.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};
            ((GridBagLayout)ShopWindow.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0E-4};
            ShopWindow.add(scrollPaneListeArme, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(1, 1, 6, 6), 0, 0));

            //======== paneldescriptionarme ========
            {

                //---- labeldegat ----
                labeldegat.setText("D\u00e9gats");

                //---- labelprix ----
                labelprix.setText("Prix");

                //---- labelskin ----
                labelskin.setText("Skin");

                //---- labelportée ----
                labelportée.setText("Port\u00e9e");

                //---- labelcapacitéchargeur ----
                labelcapacitéchargeur.setText("Capacit\u00e9 chargeur");

                //---- labelcatégorie ----
                labelcatégorie.setText("Cat\u00e9gorie");

                //---- labelnom ----
                labelnom.setText("Nom");

                GroupLayout paneldescriptionarmeLayout = new GroupLayout(paneldescriptionarme);
                paneldescriptionarme.setLayout(paneldescriptionarmeLayout);
                paneldescriptionarmeLayout.setHorizontalGroup(
                    paneldescriptionarmeLayout.createParallelGroup()
                        .addGroup(paneldescriptionarmeLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(paneldescriptionarmeLayout.createParallelGroup()
                                .addComponent(labelnom, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                .addComponent(labelskin, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                .addComponent(labelcapacitéchargeur, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                .addComponent(labelportée, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                .addComponent(labeldegat, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                .addComponent(labelprix, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                .addComponent(labelcatégorie, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
                            .addContainerGap())
                );
                paneldescriptionarmeLayout.setVerticalGroup(
                    paneldescriptionarmeLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, paneldescriptionarmeLayout.createSequentialGroup()
                            .addContainerGap(13, Short.MAX_VALUE)
                            .addComponent(labelcatégorie, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                            .addComponent(labelnom, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                            .addComponent(labeldegat, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                            .addComponent(labelportée, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                            .addComponent(labelcapacitéchargeur, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                            .addComponent(labelskin, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                            .addComponent(labelprix, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(9, Short.MAX_VALUE))
                );
            }
            ShopWindow.add(paneldescriptionarme, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(1, 1, 6, 6), 0, 0));

            //======== panelValeur ========
            {

                GroupLayout panelValeurLayout = new GroupLayout(panelValeur);
                panelValeur.setLayout(panelValeurLayout);
                panelValeurLayout.setHorizontalGroup(
                    panelValeurLayout.createParallelGroup()
                        .addGroup(panelValeurLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panelValeurLayout.createParallelGroup()
                                .addComponent(textFieldportee)
                                .addComponent(textFieldcapacitechargeur, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                .addComponent(textFieldskin)
                                .addComponent(textFielddegat, GroupLayout.Alignment.TRAILING)
                                .addComponent(textFieldnom, GroupLayout.Alignment.TRAILING)
                                .addComponent(textFieldprix)
                                .addComponent(comboBoxCategorie))
                            .addContainerGap())
                );
                panelValeurLayout.setVerticalGroup(
                    panelValeurLayout.createParallelGroup()
                        .addGroup(panelValeurLayout.createSequentialGroup()
                            .addContainerGap(10, Short.MAX_VALUE)
                            .addComponent(comboBoxCategorie, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                            .addComponent(textFieldnom, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                            .addComponent(textFielddegat, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                            .addComponent(textFieldportee, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                            .addComponent(textFieldcapacitechargeur, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                            .addComponent(textFieldskin, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                            .addComponent(textFieldprix, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(10, Short.MAX_VALUE))
                );
            }
            ShopWindow.add(panelValeur, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(1, 1, 6, 1), 0, 0));

            //---- button9 ----
            button9.setText("Nouvelle Arme");
            ShopWindow.add(button9, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(1, 1, 1, 6), 0, 0));

            //---- button10 ----
            button10.setText("Acheter");
            ShopWindow.add(button10, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(1, 1, 1, 1), 0, 0));
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - TonyVDW
    private JPanel ShopWindow;
    private JScrollPane scrollPaneListeArme;
    private JPanel paneldescriptionarme;
    private JLabel labeldegat;
    private JLabel labelprix;
    private JLabel labelskin;
    private JLabel labelportée;
    private JLabel labelcapacitéchargeur;
    private JLabel labelcatégorie;
    private JLabel labelnom;
    private JPanel panelValeur;
    private JTextField textFieldskin;
    private JTextField textFieldnom;
    private JTextField textFielddegat;
    private JTextField textFieldportee;
    private JTextField textFieldcapacitechargeur;
    private JTextField textFieldprix;
    private JComboBox comboBoxCategorie;
    private JButton button9;
    private JButton button10;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
