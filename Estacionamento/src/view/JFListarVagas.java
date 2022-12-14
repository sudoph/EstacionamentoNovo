/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;
import model.bean.Vaga;
import model.dao.VagaDAO;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 01945083077
 */
public class JFListarVagas extends javax.swing.JFrame {

    /**
     * Creates new form JFListarVaga
     */
    public JFListarVagas() {
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTVaga = new javax.swing.JTable();
        jBtnCadastrar = new javax.swing.JButton();
        jBtnEditar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel1.setText("Listar Vagas");

        jTVaga.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID da Vaga", "Número", "Rua", "Obllíqua"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTVaga);

        jBtnCadastrar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jBtnCadastrar.setText("Cadastrar Vaga");
        jBtnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCadastrarActionPerformed(evt);
            }
        });

        jBtnEditar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jBtnEditar.setText("Editar Vaga");
        jBtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditarActionPerformed(evt);
            }
        });

        jBtnExcluir.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jBtnExcluir.setText("Excluir Vaga");
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnCadastrar)
                        .addGap(64, 64, 64)
                        .addComponent(jBtnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnExcluir)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnCadastrar)
                    .addComponent(jBtnEditar)
                    .addComponent(jBtnExcluir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCadastrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnCadastrarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        readJTable();
    }//GEN-LAST:event_formWindowOpened

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        // TODO add your handling code here:
        if (jTVaga.getSelectedRow() != -1) {
            int opcao = JOptionPane.showConfirmDialog(
                    null,
                    "Deseja excluir a vaga selecionada?",
                    "Exclusão",
                    JOptionPane.YES_NO_OPTION
            );

            if (opcao == 0) {
                VagaDAO dao = new VagaDAO();
                Vaga v = new Vaga();

                v.setIdVaga((int) jTVaga.getValueAt(jTVaga.getSelectedRow(), 0));
                dao.delete(v);
            }
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Selecione uma vaga!",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
        readJTable();
    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jBtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarActionPerformed
        // TODO add your handling code here:
        if (jTVaga.getSelectedRow() != -1) {
            int vagaSelecionada = (int)jTVaga.getValueAt(jTVaga.getSelectedRow(), 0);
            
            JFAtualizarVaga av = new JFAtualizarVaga(vagaSelecionada);
            av.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma vaga.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        readJTable();
    }//GEN-LAST:event_jBtnEditarActionPerformed

    public void readJTable() {
        DefaultTableModel modelo = (DefaultTableModel) jTVaga.getModel();
        modelo.setNumRows(0);
        VagaDAO dao = new VagaDAO();

        for (Vaga v : dao.read()) {
            modelo.addRow(new Object[]{
                v.getIdVaga(),
                v.getNumero(),
                v.getRua(),
                v.isObliqua()
            });
        }

    }

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
            java.util.logging.Logger.getLogger(JFListarVagas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFListarVagas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFListarVagas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFListarVagas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFListarVagas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCadastrar;
    private javax.swing.JButton jBtnEditar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTVaga;
    // End of variables declaration//GEN-END:variables
}
