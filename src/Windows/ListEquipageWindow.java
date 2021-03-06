/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Windows;

import Classes.Bateau;
import Classes.Marin;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Simon
 */
public class ListEquipageWindow extends javax.swing.JDialog {

    /**
     * Creates new form ListBateauWindow
     */
    
    CapitainerieWindow CW;
    Vector <Bateau> vBateauAmarré = new Vector<>();
    Vector <Marin> vMarin = new Vector<>();
    
    public ListEquipageWindow(java.awt.Frame parent, boolean modal, Vector tmpVector) {
        super(parent, modal);
        initComponents();
        CW = (CapitainerieWindow) parent;
        vBateauAmarré = tmpVector;
        
        this.setLocationRelativeTo(null);
        this.setLocation(CW.getX() - this.getWidth(), CW.getY());
        this.setResizable(false);
        this.setTitle("Capitainerie - Informations sur équipage");
        
        
        ComboBox_Bateau.addItem("---");
        for (int i = 0; i < vBateauAmarré.size(); i++) {
            ComboBox_Bateau.addItem(vBateauAmarré.get(i).getNom());
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Button_OK = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        ComboBox_Bateau = new javax.swing.JComboBox<>();
        Button_Search = new javax.swing.JButton();
        Button_Infos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Liste équipage");

        Button_OK.setText("OK");
        Button_OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_OKActionPerformed(evt);
            }
        });

        jList1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jScrollPane1.setViewportView(jList1);

        Button_Search.setText("Search");
        Button_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_SearchActionPerformed(evt);
            }
        });

        Button_Infos.setText("Infos");
        Button_Infos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_InfosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ComboBox_Bateau, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Button_Search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Button_OK, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Button_Infos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBox_Bateau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_Search))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_OK)
                    .addComponent(Button_Infos))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_OKActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_Button_OKActionPerformed

    private void Button_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_SearchActionPerformed
        // TODO add your handling code here:
        vMarin.removeAllElements();
        int i = ComboBox_Bateau.getSelectedIndex();
        
        if(i == 0)
        {
            JOptionPane.showMessageDialog(new JFrame(), "Pas de bateau sélectionné !", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            Bateau tmpBateau = vBateauAmarré.get(i-1);
            
            System.out.println(tmpBateau.display());
                        
            DefaultListModel model = new DefaultListModel();

            if (tmpBateau.getEquipage().getAUnEquipage()) {
                model.addElement(tmpBateau.getEquipage().getCapitainerie().getFonction() + " : " + tmpBateau.getEquipage().getCapitainerie().getNom());
                vMarin.addElement(tmpBateau.getEquipage().getCapitainerie());

                if (tmpBateau.getEquipage().getSecond() != null) {
                    model.addElement(tmpBateau.getEquipage().getSecond().getFonction() + " : " + tmpBateau.getEquipage().getSecond().getNom());
                    vMarin.addElement(tmpBateau.getEquipage().getSecond());
                }

                if (tmpBateau.getEquipage().getEquipage() != null) {
                    for (int j = 0; j < tmpBateau.getEquipage().getEquipage().size(); j++) {
                        model.addElement(tmpBateau.getEquipage().getEquipage().get(j).getFonction() + " : " + tmpBateau.getEquipage().getEquipage().get(j).getNom());
                        vMarin.addElement(tmpBateau.getEquipage().getEquipage().get(j));
                    }
                }
            }
            else
            {
                JOptionPane.showMessageDialog(new JFrame(), "Pas d'équipage encodé pour ce bateau !", "Erreur", JOptionPane.ERROR_MESSAGE);
            }

            jList1.setModel(model);
        }
    }//GEN-LAST:event_Button_SearchActionPerformed

    private void Button_InfosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_InfosActionPerformed
        // TODO add your handling code here:
        if(jList1.getSelectedValue() == null)
        {
            JOptionPane.showMessageDialog(new JFrame(), "Pas de marin sélectionné !", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            int i = jList1.getSelectedIndex();
            Vector <Marin> vTmp = new Vector<> ();
            vTmp.add(vMarin.get(i));

            InfoMarinWindow imw = new InfoMarinWindow(CW, true, vTmp);
            imw.setVisible(true);
        }
    }//GEN-LAST:event_Button_InfosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListEquipageWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListEquipageWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListEquipageWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListEquipageWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ListEquipageWindow dialog = new ListEquipageWindow(new javax.swing.JFrame(), true, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Infos;
    private javax.swing.JButton Button_OK;
    private javax.swing.JButton Button_Search;
    private javax.swing.JComboBox<String> ComboBox_Bateau;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
