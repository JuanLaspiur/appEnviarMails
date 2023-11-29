/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/Application.java to edit this template
 */
package vista;

import vista.consultas.ListaDeConsultas;
import vista.reclutador.AgregarReclutador;
import vista.reclutador.EnviarCorreo;
import vista.reclutador.ListaDeReclutadores;

/**
 *
 * @author Cosquin
 */
public class BDTrabajo extends javax.swing.JFrame {

    /**
     * Creates new form BDTrabajo
     */
    public BDTrabajo() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        ListaReclutadoresItem = new javax.swing.JMenuItem();
        itemEnviarMail = new javax.swing.JMenuItem();
        fileMenu1 = new javax.swing.JMenu();
        item_listaConsultas = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 917, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 423, Short.MAX_VALUE)
        );

        fileMenu.setMnemonic('f');
        fileMenu.setText("Opciones");
        fileMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileMenuActionPerformed(evt);
            }
        });

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Agregar Reclutador");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);

        ListaReclutadoresItem.setText("Lista de Reclutadores");
        ListaReclutadoresItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListaReclutadoresItemActionPerformed(evt);
            }
        });
        fileMenu.add(ListaReclutadoresItem);

        itemEnviarMail.setText("Enivar Mail");
        itemEnviarMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEnviarMailActionPerformed(evt);
            }
        });
        fileMenu.add(itemEnviarMail);

        menuBar.add(fileMenu);

        fileMenu1.setMnemonic('f');
        fileMenu1.setText("Consultas");

        item_listaConsultas.setMnemonic('o');
        item_listaConsultas.setText("Lista de Consultas");
        item_listaConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_listaConsultasActionPerformed(evt);
            }
        });
        fileMenu1.add(item_listaConsultas);

        menuBar.add(fileMenu1);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        AgregarReclutador pagina1 = new AgregarReclutador();
        pagina1.setVisible(true);
        jDesktopPane1.add(pagina1);
        jDesktopPane1.moveToFront(pagina1);

    }//GEN-LAST:event_openMenuItemActionPerformed

    private void itemEnviarMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEnviarMailActionPerformed
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        EnviarCorreo pagina2 = new EnviarCorreo();
        pagina2.setVisible(true);
        jDesktopPane1.add(pagina2);
        jDesktopPane1.moveToFront(pagina2);
    }//GEN-LAST:event_itemEnviarMailActionPerformed

    private void item_listaConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_listaConsultasActionPerformed
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        ListaDeConsultas pagina2 = new ListaDeConsultas();
        pagina2.setVisible(true);
        jDesktopPane1.add(pagina2);
        jDesktopPane1.moveToFront(pagina2);
    }//GEN-LAST:event_item_listaConsultasActionPerformed

    private void fileMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileMenuActionPerformed

    }//GEN-LAST:event_fileMenuActionPerformed

    private void ListaReclutadoresItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListaReclutadoresItemActionPerformed
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        ListaDeReclutadores pagina2 = new ListaDeReclutadores();
        pagina2.setVisible(true);
        jDesktopPane1.add(pagina2);
        jDesktopPane1.moveToFront(pagina2);
    }//GEN-LAST:event_ListaReclutadoresItemActionPerformed

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
            java.util.logging.Logger.getLogger(BDTrabajo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BDTrabajo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BDTrabajo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BDTrabajo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BDTrabajo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ListaReclutadoresItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu fileMenu1;
    private javax.swing.JMenuItem itemEnviarMail;
    private javax.swing.JMenuItem item_listaConsultas;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    // End of variables declaration//GEN-END:variables

}