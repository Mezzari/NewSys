/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mezzari.frames;

import com.mezzari.Database.Database;
import com.mezzari.util.Autocomplete;
import java.util.ArrayList;
import java.util.List;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Thiago
 */
public class Inicial extends javax.swing.JFrame {
    private static final String COMMIT_ACTION = "commit";
    
    public Database db;
    /**
     * Creates new form Inicial
     */
    public Inicial() {
        db = new Database();
        db.connect();
        initComponents();
        this.setAutoComplete();
        this.jIFNotaEntrega.setVisible(false);
        
    }
    /**
     * 
     *     
     */
    public void setAutoComplete(){
        // Our words to complete
        List nomes = new ArrayList<String>();
        List cpf = new ArrayList<String>();
        
        nomes.addAll(db.getNomesPessoas());
        Autocomplete autoComplete = new Autocomplete(jTFNome, nomes);
        jTFNome.getDocument().addDocumentListener(autoComplete);
        // Maps the tab key to the commit action, which finishes the autocomplete
        // when given a suggestion
        jTFNome.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), COMMIT_ACTION);
        jTFNome.getActionMap().put(COMMIT_ACTION, autoComplete.new CommitAction());
        
        cpf.addAll(db.getCpfPessoas());
        Autocomplete autoComplete2 = new Autocomplete(jTFCpf, cpf);
        jTFCpf.getDocument().addDocumentListener(autoComplete2);
        // Maps the tab key to the commit action, which finishes the autocomplete
        // when given a suggestion
        jTFCpf.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), COMMIT_ACTION);
        jTFCpf.getActionMap().put(COMMIT_ACTION, autoComplete.new CommitAction());
    }
    
    public void preencheForm(int tipo){
        if(tipo == 0){ //tipo nome
            jTextField5.setText(db.getEmailByIdPessoa(db.getIdByNomePessoa(jTFNome.getText())));
            jTextField6.setText(db.getTelefoneByIdPessoa(db.getIdByNomePessoa(jTFNome.getText())));
            jTFCpf.setText(db.getCpfByIdPessoa(db.getIdByNomePessoa(jTFNome.getText())));
        }else{ //tipo cpf
            jTextField5.setText(db.getEmailByIdPessoa(db.getIdByCpfPessoa(jTFCpf.getText())));
            jTextField6.setText(db.getTelefoneByIdPessoa(db.getIdByCpfPessoa(jTFCpf.getText())));
            jTFNome.setText(db.getNomeByIdPessoa(db.getIdByCpfPessoa(jTFCpf.getText())));
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jIFNotaEntrega = new javax.swing.JInternalFrame();
        jLApresentandte = new javax.swing.JLabel();
        jLDocumento = new javax.swing.JLabel();
        jLAto = new javax.swing.JLabel();
        jLApresentandte1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTFNome = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLApresentandte2 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLAto1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLAto2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTextField6 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTFCpf = new javax.swing.JTextField();
        jLApresentandte3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMNotaEntrega = new javax.swing.JMenu();
        jMIIncluir = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jIFNotaEntrega.setClosable(true);
        jIFNotaEntrega.setTitle("Incluir Nota de Entrega");
        jIFNotaEntrega.setVisible(true);
        jIFNotaEntrega.getContentPane().setLayout(null);

        jLApresentandte.setFont(new java.awt.Font("Square721 BT", 0, 18)); // NOI18N
        jLApresentandte.setText("Email:");
        jIFNotaEntrega.getContentPane().add(jLApresentandte);
        jLApresentandte.setBounds(460, 50, 54, 30);

        jLDocumento.setFont(new java.awt.Font("Square721 BT", 0, 18)); // NOI18N
        jLDocumento.setText("Documento:");
        jIFNotaEntrega.getContentPane().add(jLDocumento);
        jLDocumento.setBounds(10, 90, 131, 30);

        jLAto.setFont(new java.awt.Font("Square721 BT", 0, 18)); // NOI18N
        jLAto.setText("Matriculas:");
        jIFNotaEntrega.getContentPane().add(jLAto);
        jLAto.setBounds(520, 210, 131, 30);

        jLApresentandte1.setFont(new java.awt.Font("Square721 BT", 0, 18)); // NOI18N
        jLApresentandte1.setText("Cpf:");
        jIFNotaEntrega.getContentPane().add(jLApresentandte1);
        jLApresentandte1.setBounds(10, 50, 37, 30);
        jIFNotaEntrega.getContentPane().add(jTextField2);
        jTextField2.setBounds(150, 130, 610, 30);

        jTFNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNomeActionPerformed(evt);
            }
        });
        jTFNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFNomeKeyPressed(evt);
            }
        });
        jIFNotaEntrega.getContentPane().add(jTFNome);
        jTFNome.setBounds(150, 10, 300, 30);
        jIFNotaEntrega.getContentPane().add(jTextField4);
        jTextField4.setBounds(150, 90, 610, 30);

        jLApresentandte2.setFont(new java.awt.Font("Square721 BT", 0, 18)); // NOI18N
        jLApresentandte2.setText("Fone:");
        jIFNotaEntrega.getContentPane().add(jLApresentandte2);
        jLApresentandte2.setBounds(460, 10, 48, 30);

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jIFNotaEntrega.getContentPane().add(jTextField5);
        jTextField5.setBounds(520, 50, 240, 30);

        jLAto1.setFont(new java.awt.Font("Square721 BT", 0, 18)); // NOI18N
        jLAto1.setText("Ato:");
        jIFNotaEntrega.getContentPane().add(jLAto1);
        jLAto1.setBounds(10, 130, 131, 30);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Número"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jIFNotaEntrega.getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(410, 260, 350, 170);

        jLAto2.setFont(new java.awt.Font("Square721 BT", 0, 18)); // NOI18N
        jLAto2.setText("Interessados:");
        jIFNotaEntrega.getContentPane().add(jLAto2);
        jLAto2.setBounds(120, 210, 131, 30);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable2KeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jIFNotaEntrega.getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 260, 350, 170);

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jIFNotaEntrega.getContentPane().add(jTextField6);
        jTextField6.setBounds(520, 10, 240, 30);

        jButton1.setText("SAIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jIFNotaEntrega.getContentPane().add(jButton1);
        jButton1.setBounds(620, 510, 130, 60);

        jButton2.setText("SALVAR");
        jIFNotaEntrega.getContentPane().add(jButton2);
        jButton2.setBounds(20, 510, 130, 60);

        jButton3.setText("LIMPAR");
        jIFNotaEntrega.getContentPane().add(jButton3);
        jButton3.setBounds(220, 510, 130, 60);

        jButton4.setText("PESQUISAR");
        jIFNotaEntrega.getContentPane().add(jButton4);
        jButton4.setBounds(420, 510, 130, 60);

        jTFCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFCpfActionPerformed(evt);
            }
        });
        jTFCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFCpfKeyPressed(evt);
            }
        });
        jIFNotaEntrega.getContentPane().add(jTFCpf);
        jTFCpf.setBounds(150, 50, 300, 30);

        jLApresentandte3.setFont(new java.awt.Font("Square721 BT", 0, 18)); // NOI18N
        jLApresentandte3.setText("Apresentante:");
        jIFNotaEntrega.getContentPane().add(jLApresentandte3);
        jLApresentandte3.setBounds(10, 10, 131, 30);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jIFNotaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jIFNotaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(124, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 750));

        jMNotaEntrega.setText("Nota de Entrega");

        jMIIncluir.setText("Incluir");
        jMIIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIIncluirActionPerformed(evt);
            }
        });
        jMNotaEntrega.add(jMIIncluir);

        jMenuItem1.setText("Pesquisar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMNotaEntrega.add(jMenuItem1);

        jMenuBar1.add(jMNotaEntrega);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMIIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIIncluirActionPerformed
        this.jIFNotaEntrega.setVisible(true);
    }//GEN-LAST:event_jMIIncluirActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.addRow(new Object[]{""});
        }
    }//GEN-LAST:event_jTable1KeyPressed

    private void jTable2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable2KeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.addRow(new Object[]{""});
        }
    }//GEN-LAST:event_jTable2KeyPressed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.jTFCpf.setText("");
        this.jTFNome.setText("");
        this.jTextField2.setText("");
        this.jTextField4.setText("");
        this.jTextField5.setText("");
        this.jTextField6.setText("");
        this.jIFNotaEntrega.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTFNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFNomeActionPerformed

    private void jTFNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNomeKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            preencheForm(0);
        }
    }//GEN-LAST:event_jTFNomeKeyPressed

    private void jTFCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFCpfActionPerformed

    private void jTFCpfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFCpfKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            preencheForm(1);
        }
    }//GEN-LAST:event_jTFCpfKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JInternalFrame jIFNotaEntrega;
    private javax.swing.JLabel jLApresentandte;
    private javax.swing.JLabel jLApresentandte1;
    private javax.swing.JLabel jLApresentandte2;
    private javax.swing.JLabel jLApresentandte3;
    private javax.swing.JLabel jLAto;
    private javax.swing.JLabel jLAto1;
    private javax.swing.JLabel jLAto2;
    private javax.swing.JLabel jLDocumento;
    private javax.swing.JMenuItem jMIIncluir;
    private javax.swing.JMenu jMNotaEntrega;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTextField jTFCpf;
    public javax.swing.JTextField jTFNome;
    public javax.swing.JTable jTable1;
    public javax.swing.JTable jTable2;
    public javax.swing.JTextField jTextField2;
    public javax.swing.JTextField jTextField4;
    public javax.swing.JTextField jTextField5;
    public javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
