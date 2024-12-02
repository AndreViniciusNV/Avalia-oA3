/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.unifacs.a3_engsoftware.JAVA.view;

import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import com.unifacs.a3_engsoftware.JAVA.Eventos.EventosController;
import com.unifacs.a3_engsoftware.JAVA.Usuario.Usuario;

/**
 *
 * @author 1272118088
 */
public class ListaEventos extends javax.swing.JFrame {

    private final Usuario usuarioLogado;

    public void atualizarTabela() {
        try {
            EventosController lista = new EventosController();
            lista.ListarEventos(this); // Atualiza o modelo da tabela
        } catch (SQLException sql) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao atualizar a tabela: " + sql.getMessage());
        }
    }

    /**
     * Creates new form Eventos
     */
    public ListaEventos(Usuario usuarioLogado) {

        this.usuarioLogado = usuarioLogado;

        initComponents();

        atualizarTabela();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTableListaEventos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableListaEventos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código Evento", "Categoria", "Evento", "Endereço", "Vagas", "Vagas Disponíveis"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });

        jTableListaEventos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EventosController evento = new EventosController();
                if (evt.getClickCount() == 2) {
                    int row = jTableListaEventos.getSelectedRow();
                    if (row != -1) { // Verifica se uma linha foi selecionada
                        // Obtém o código do evento da linha selecionada
                        String nomeEvento = (String) jTableListaEventos.getValueAt(row, 2); // Supondo que o nome do evento está na coluna 2
                        int codigoEvento = (int) jTableListaEventos.getValueAt(row, 0); // Supondo que o código do evento está na coluna 0
                        int confirm = JOptionPane.showConfirmDialog(
                                ListaEventos.this,
                                "Deseja se inscrever no evento '" + nomeEvento + "'?",
                                "Confirmação",
                                JOptionPane.YES_NO_OPTION);
                        if (confirm == JOptionPane.YES_OPTION) {
                            try {
                                if (evento.verificarUsuario(usuarioLogado.getCodUser(), codigoEvento)) {
                                    try {
                                        // Chama o método para inscrever no evento
                                        evento.inscreverUsuario(usuarioLogado.getCodUser(), codigoEvento);
                                        JOptionPane.showMessageDialog(
                                                ListaEventos.this,
                                                "Inscrição realizada com sucesso!",
                                                "Sucesso",
                                                JOptionPane.INFORMATION_MESSAGE);
                                        atualizarTabela();
                                    } catch (SQLException ex) {
                                        JOptionPane.showMessageDialog(
                                                ListaEventos.this,
                                                "Erro ao realizar inscrição: " + ex.getMessage(),
                                                "Erro",
                                                JOptionPane.ERROR_MESSAGE);
                                    }
                                } else {
                                    // Pergunta se o usuário quer cancelar a inscrição
                                    int cancelConfirm = JOptionPane.showConfirmDialog(
                                            ListaEventos.this,
                                            "Você já está inscrito no evento '" + nomeEvento + "'. Deseja cancelar a inscrição?",
                                            "Confirmação",
                                            JOptionPane.YES_NO_OPTION,
                                            JOptionPane.QUESTION_MESSAGE);
        
                                    if (cancelConfirm == JOptionPane.YES_OPTION) {
                                        try {
                                            // Chama o método para remover a inscrição do evento
                                            evento.removerEvento(usuarioLogado.getCodUser(), codigoEvento);
                                            JOptionPane.showMessageDialog(
                                                    ListaEventos.this,
                                                    "Inscrição removida com sucesso!",
                                                    "Sucesso",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                            atualizarTabela(); // Atualiza a tabela após a remoção
                                        } catch (SQLException ex) {
                                            JOptionPane.showMessageDialog(
                                                    ListaEventos.this,
                                                    "Erro ao remover inscrição: " + ex.getMessage(),
                                                    "Erro",
                                                    JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                }
                            } catch (SQLException e) {
                                JOptionPane.showMessageDialog(
                                        ListaEventos.this,
                                        "Erro ao verificar inscrição: " + e.getMessage(),
                                        "Erro",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                }
            }
        });
        
        jScrollPane2.setViewportView(jTableListaEventos);

        jLabel1.setText("Bem Vindo, ");

        jLabel2.setText(usuarioLogado.getUsuario());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 787, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListaEventos.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaEventos.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaEventos.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaEventos.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaEventos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableListaEventos;
    // End of variables declaration//GEN-END:variables

    public JTable getjTableListaEventos() {
        return jTableListaEventos;
    }

    public void setjTableListaEventos(JTable jTableListaEventos) {
        this.jTableListaEventos = jTableListaEventos;
    }
}
