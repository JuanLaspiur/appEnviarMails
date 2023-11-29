package vista.reclutador;

import controlador.ReclutadorData;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Reclutador;

public class ListaDeReclutadores extends javax.swing.JInternalFrame {

    DefaultTableModel model = new DefaultTableModel() {

        @Override
        public boolean isCellEditable(int f, int c) {
            return false;
        }

    };

    public ListaDeReclutadores() {
        initComponents();
        tabla.setModel(model);
        agregarCabeceraTabla();
        cargarTabla(ReclutadorData.listaDeReclutadores());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setClosable(true);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        jLabel1.setText("Lista de Reclutadores");

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Enviar Mail");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(435, 435, 435)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEliminar)
                            .addComponent(jButton2))))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addGap(14, 14, 14)
                        .addComponent(jButton3)))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int row = tabla.getSelectedRow();
        if (row > 0) {
            int id = (int) model.getValueAt(row, 0);
            int opcion = JOptionPane.showConfirmDialog(null, "¿Quieres continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);

            if (opcion == JOptionPane.YES_OPTION) {
                ReclutadorData.eliminarReclutador(id);
                vaciarTabla();
                cargarTabla(ReclutadorData.listaDeReclutadores());
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "Debe seleccionar una fila de la tabla para eliminar");
        }


    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int row = tabla.getSelectedRow();
        if (row > 0) {
            JDesktopPane desktop = getDesktopPane();
            desktop.removeAll();
            desktop.repaint();
            int id = (int) model.getValueAt(row, 0);
            EditarReclutador pagina1 = new EditarReclutador(ReclutadorData.reclutador(id));
            pagina1.setVisible(true);
            desktop.add(pagina1);
            desktop.moveToFront(pagina1);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Debe seleccionar una fila de la tabla para editar");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       int row = tabla.getSelectedRow();
        if (row > 0) {
            JDesktopPane desktop = getDesktopPane();
            desktop.removeAll();
            desktop.repaint();
            int id = (int) model.getValueAt(row, 0);
            EnviarCorreo pagina1 = new EnviarCorreo(ReclutadorData.reclutador(id));
            pagina1.setVisible(true);
            desktop.add(pagina1);
            desktop.moveToFront(pagina1);
        } else {
            
         int num= JOptionPane.showConfirmDialog(rootPane, "¿Desea ir a enviar un correo sin haber seleccionado un reclutador?");
         if(num==0){
            JDesktopPane desktop = getDesktopPane();
            desktop.removeAll();
            desktop.repaint();
            int id = (int) model.getValueAt(row, 0);
            EnviarCorreo pagina1 = new EnviarCorreo();
            pagina1.setVisible(true);
            desktop.add(pagina1);
            desktop.moveToFront(pagina1);
         }
        }
        
        
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables

    public void agregarCabeceraTabla() {
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Correo");

    }

    public void agregarFilaTabla(Reclutador reclutador) {
        model.addRow(new Object[]{reclutador.getId(), reclutador.getNombre(), reclutador.getCorreo()});
    }

    public void cargarTabla(ArrayList<Reclutador> lista) {
        for (Reclutador reclutador : lista) {
            agregarFilaTabla(reclutador);
        }
    }
    
      public void vaciarTabla() {
        int cantidadFilas = model.getRowCount();
        for (int i = cantidadFilas - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

}
