/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.print.*;
import entidade.Membro;

/**
 *
 * @author felip
 */
public class BuscarCadastro extends javax.swing.JFrame {
    
    // Configurações de conexão com banco de dados
    private static final String URL = "jdbc:mysql://localhost:3306/dbcadastro";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "felipe87";
    
    private Membro dadosEncontrados = null;

    /**
     * Creates new form BuscarCadastro
     */
    public BuscarCadastro() {
        initComponents();
        panResultado.setVisible(false);
        configurarCores();
    }
    
    /**
     * Configura as cores e aparência da interface
     */
    private void configurarCores() {
        // Configurar cores do fundo
        getContentPane().setBackground(new Color(240, 248, 255)); // Alice Blue
        
        // Configurar painel de resultado
        panResultado.setBackground(new Color(230, 240, 250));
        panResultado.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(70, 130, 180), 2),
            "Dados Encontrados",
            0, 0, new Font("Arial", Font.BOLD, 14), new Color(70, 130, 180)
        ));
        
        // Configurar botões
        configurarBotao(jbnProcurar, new Color(34, 139, 34), Color.WHITE);
        configurarBotao(jbnAlterar, new Color(255, 140, 0), Color.WHITE);
        configurarBotao(jbnDeletar, new Color(220, 20, 60), Color.WHITE);
        configurarBotao(jbnImprimir, new Color(70, 130, 180), Color.WHITE);
        configurarBotao(jbnVoltar, new Color(128, 128, 128), Color.WHITE);
        
        // Configurar campo de texto
        txtDigiteNome.setBackground(new Color(255, 255, 255));
        txtDigiteNome.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180), 1));
        
        // Configurar labels
        jLabel1.setForeground(new Color(25, 25, 112));
    }
    
    /**
     * Configura a aparência de um botão
     */
    private void configurarBotao(JButton botao, Color corFundo, Color corTexto) {
        botao.setBackground(corFundo);
        botao.setForeground(corTexto);
        botao.setFont(new Font("Arial", Font.BOLD, 12));
        botao.setBorder(BorderFactory.createRaisedBevelBorder());
        botao.setFocusPainted(false);
    }
    
    /**
     * Estabelece conexão com o banco de dados
     */
    private Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, 
                "Erro ao conectar com o banco de dados: " + ex.getMessage(),
                "Erro de Conexão", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    /**
     * Busca um cadastro pelo nome
     */
    private Membro buscarCadastroPorNome(String nome) {
        String sql = "SELECT * FROM membro WHERE nome LIKE ? LIMIT 1";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, "%" + nome + "%");
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Membro dados = new Membro();
                dados.setId(rs.getInt("id"));
                dados.setNome(rs.getString("nome"));
                dados.setTelefone(rs.getInt("telefone"));
                // Assumindo que existe uma coluna cargo e dizimo na tabela
                // dados.setCargo(rs.getString("cargo"));
                // dados.setDizimo(rs.getString("dizimo"));
                return dados;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                "Erro ao buscar cadastro: " + ex.getMessage(),
                "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    /**
     * Atualiza um cadastro existente
     */
    private boolean atualizarCadastro(Membro dados) {
        String sql = "UPDATE membro SET nome = ?, telefone = ? WHERE id = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, dados.getNome());
            stmt.setInt(2, dados.getTelefone());
            stmt.setInt(3, dados.getId());
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                "Erro ao atualizar cadastro: " + ex.getMessage(),
                "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    /**
     * Deleta um cadastro
     */
    private boolean deletarCadastro(int id) {
        String sql = "DELETE FROM membro WHERE id = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                "Erro ao deletar cadastro: " + ex.getMessage(),
                "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
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
        jbnProcurar = new javax.swing.JButton();
        jbnAlterar = new javax.swing.JButton();
        jbnDeletar = new javax.swing.JButton();
        panResultado = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        lblCargo = new javax.swing.JLabel();
        lblDizimo = new javax.swing.JLabel();
        jbnImprimir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDigiteNome = new javax.swing.JTextPane();
        jbnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Buscar Cadastro - Sistema de Membros");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Digite o Nome do Membro");

        jbnProcurar.setText("PROCURAR");
        jbnProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbnProcurarActionPerformed(evt);
            }
        });

        jbnAlterar.setText("ALTERAR");
        jbnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbnAlterarActionPerformed(evt);
            }
        });

        jbnDeletar.setText("DELETAR");
        jbnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbnDeletarActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome");

        jLabel3.setText("Telefone");

        jLabel4.setText("Cargo");

        jLabel5.setText("DÍZIMO");

        lblNome.setText("0");

        lblTelefone.setText("0");

        lblCargo.setText("0");

        lblDizimo.setText("0");

        javax.swing.GroupLayout panResultadoLayout = new javax.swing.GroupLayout(panResultado);
        panResultado.setLayout(panResultadoLayout);
        panResultadoLayout.setHorizontalGroup(
            panResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panResultadoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panResultadoLayout.createSequentialGroup()
                        .addGroup(panResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panResultadoLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblDizimo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panResultadoLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(52, 52, 52)
                                .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22))
                    .addGroup(panResultadoLayout.createSequentialGroup()
                        .addGroup(panResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panResultadoLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panResultadoLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panResultadoLayout.setVerticalGroup(
            panResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panResultadoLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblTelefone))
                .addGap(18, 18, 18)
                .addGroup(panResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblCargo))
                .addGap(18, 18, 18)
                .addGroup(panResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblDizimo))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jbnImprimir.setText("IMPRIMIR");
        jbnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbnImprimirActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(txtDigiteNome);

        jbnVoltar.setText("VOLTAR");
        jbnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbnProcurar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbnDeletar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbnAlterar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbnImprimir, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbnVoltar, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbnProcurar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbnDeletar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbnImprimir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbnVoltar)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(panResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbnDeletarActionPerformed
        if (dadosEncontrados == null) {
            JOptionPane.showMessageDialog(this, 
                "Primeiro busque um cadastro para deletar!", 
                "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int confirmacao = JOptionPane.showConfirmDialog(this,
                "Tem certeza que deseja deletar o cadastro de " + dadosEncontrados.getNome() + "?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (confirmacao == JOptionPane.YES_OPTION) {
            if (deletarCadastro(dadosEncontrados.getId())) {
                JOptionPane.showMessageDialog(this, 
                    "Cadastro deletado com sucesso!", 
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                panResultado.setVisible(false);
                txtDigiteNome.setText("");
                dadosEncontrados = null;
            }
        }
    }//GEN-LAST:event_jbnDeletarActionPerformed

    private void jbnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbnImprimirActionPerformed
        if (dadosEncontrados == null) {
            JOptionPane.showMessageDialog(this, 
                "Primeiro busque um cadastro para imprimir!", 
                "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            // Criar um texto formatado para impressão
            String textoImpressao = String.format(
                "=== FICHA CADASTRAL ===\n\n" +
                "Nome: %s\n" +
                "Telefone: %d\n" +
                "Cargo: %s\n" +
                "Dízimo: %s\n\n" +
                "Data de Impressão: %s",
                dadosEncontrados.getNome(),
                dadosEncontrados.getTelefone(),
                lblCargo.getText(),
                lblDizimo.getText(),
                new java.util.Date().toString()
            );
            
            // Criar um JTextArea para impressão
            JTextArea areaImpressao = new JTextArea(textoImpressao);
            areaImpressao.setFont(new Font("Monospaced", Font.PLAIN, 12));
            
            // Tentar imprimir
            boolean impressaoOk = areaImpressao.print();
            
            if (impressaoOk) {
                JOptionPane.showMessageDialog(this, 
                    "Documento enviado para impressão!", 
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, 
                    "Impressão cancelada pelo usuário.", 
                    "Informação", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(this, 
                "Erro ao imprimir: " + ex.getMessage(), 
                "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbnImprimirActionPerformed

    private void jbnProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbnProcurarActionPerformed
        String nomeBusca = txtDigiteNome.getText().trim();
        
        if (nomeBusca.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Digite um nome para buscar!", 
                "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        dadosEncontrados = buscarCadastroPorNome(nomeBusca);
        
        if (dadosEncontrados != null) {
            // Exibir os dados encontrados
            lblNome.setText(dadosEncontrados.getNome());
            lblTelefone.setText(String.valueOf(dadosEncontrados.getTelefone()));
            lblCargo.setText("Membro"); // Valor padrão, pode ser alterado conforme sua estrutura de BD
            lblDizimo.setText("Em dia"); // Valor padrão, pode ser alterado conforme sua estrutura de BD
            
            panResultado.setVisible(true);
            
            JOptionPane.showMessageDialog(this, 
                "Cadastro encontrado!", 
                "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            panResultado.setVisible(false);
            JOptionPane.showMessageDialog(this, 
                "Nenhum cadastro encontrado com esse nome!", 
                "Não encontrado", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jbnProcurarActionPerformed

    private void jbnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbnVoltarActionPerformed
        cadastro cadastrar = new cadastro();
        cadastrar.setVisible(true);
        this.dispose(); // fecha a janela atual
    }//GEN-LAST:event_jbnVoltarActionPerformed

    private void jbnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbnAlterarActionPerformed
        if (dadosEncontrados == null) {
            JOptionPane.showMessageDialog(this, 
                "Primeiro busque um cadastro para alterar!", 
                "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Criar um diálogo para edição
        JDialog dialogoEdicao = new JDialog(this, "Alterar Cadastro", true);
        dialogoEdicao.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        // Campos de edição
        JTextField campoNome = new JTextField(dadosEncontrados.getNome(), 20);
        JTextField campoTelefone = new JTextField(String.valueOf(dadosEncontrados.getTelefone()), 20);
        
        // Layout do diálogo
        gbc.insets = new Insets(5, 5, 5, 5);
        
        gbc.gridx = 0; gbc.gridy = 0;
        dialogoEdicao.add(new JLabel("Nome:"), gbc);
        gbc.gridx = 1;
        dialogoEdicao.add(campoNome, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        dialogoEdicao.add(new JLabel("Telefone:"), gbc);
        gbc.gridx = 1;
        dialogoEdicao.add(campoTelefone, gbc);
        
        // Botões
        JPanel painelBotoes = new JPanel();
        JButton btnSalvar = new JButton("Salvar");
        JButton btnCancelar = new JButton("Cancelar");
        
        btnSalvar.addActionListener(e -> {
            try {
                dadosEncontrados.setNome(campoNome.getText().trim());
                dadosEncontrados.setTelefone(Integer.parseInt(campoTelefone.getText().trim()));
                
                if (atualizarCadastro(dadosEncontrados)) {
                    JOptionPane.showMessageDialog(dialogoEdicao, 
                        "Cadastro atualizado com sucesso!", 
                        "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    
                    // Atualizar a exibição
                    lblNome.setText(dadosEncontrados.getNome());
                    lblTelefone.setText(String.valueOf(dadosEncontrados.getTelefone()));
                    
                    dialogoEdicao.dispose();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialogoEdicao, 
                    "Telefone deve ser um número válido!", 
                    "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        btnCancelar.addActionListener(e -> dialogoEdicao.dispose());
        
        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnCancelar);
        
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        dialogoEdicao.add(painelBotoes, gbc);
        
        dialogoEdicao.pack();
        dialogoEdicao.setLocationRelativeTo(this);
        dialogoEdicao.setVisible(true);
    }//GEN-LAST:event_jbnAlterarActionPerformed

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
            java.util.logging.Logger.getLogger(BuscarCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarCadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbnAlterar;
    private javax.swing.JButton jbnDeletar;
    private javax.swing.JButton jbnImprimir;
    private javax.swing.JButton jbnProcurar;
    private javax.swing.JButton jbnVoltar;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblDizimo;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JPanel panResultado;
    private javax.swing.JTextPane txtDigiteNome;
    // End of variables declaration//GEN-END:variables
}
