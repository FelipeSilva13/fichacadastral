import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author felip
 */
public class cadastro extends javax.swing.JFrame {
    private static final String URL = "jdbc:mysql://localhost:3306/dbcadastro";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "felipe87";
   
    private Connection getConnection() {
        // Esta função retorna uma conexão com o banco de dados MySQL
        try {
            // Carrega o driver JDBC para MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Retorna uma conexão com o banco de dados
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            // Lança uma exceção caso algo dê errado ao tentar estabelecer uma conexão
            JOptionPane.showMessageDialog(this, "Erro ao conectar com o banco de dados: " + ex.getMessage(),
                "Erro de Conexão", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    /**
     * Creates new form cadastro
     */
    public cadastro() {
        initComponents();
        configurarCores();
    }
    
    /**
     * Configura as cores e aparência da interface
     */
    private void configurarCores() {
        // Configurar cores do fundo
        getContentPane().setBackground(new Color(240, 248, 255)); // Alice Blue
        
        // Configurar título principal
        jLabel1.setForeground(new Color(25, 25, 112)); // Midnight Blue
        jLabel1.setFont(new Font("Arial", Font.BOLD, 24));
        
        // Configurar subtítulo
        jLabel2.setForeground(new Color(25, 25, 112)); // Steel Blue
        jLabel2.setFont(new Font("Arial", Font.ITALIC, 12));

        
        // Configurar seções
        configurarSecao(jLabel3, "DADOS PESSOAIS");
        configurarSecao(jLabel12, "DADOS MEMBRO NA IGREJA");
        
        // Configurar labels dos campos
        Color corLabel = new Color(47, 79, 79); // Dark Slate Gray
        Font fonteLabel = new Font("Arial", Font.BOLD, 12);
        
        jLabel4.setForeground(corLabel); jLabel4.setFont(fonteLabel);
        jLabel5.setForeground(corLabel); jLabel5.setFont(fonteLabel);
        jLabel6.setForeground(corLabel); jLabel6.setFont(fonteLabel);
        jLabel7.setForeground(corLabel); jLabel7.setFont(fonteLabel);
        jLabel8.setForeground(corLabel); jLabel8.setFont(fonteLabel);
        jLabel9.setForeground(corLabel); jLabel9.setFont(fonteLabel);
        jLabel10.setForeground(corLabel); jLabel10.setFont(fonteLabel);
        jLabel11.setForeground(corLabel); jLabel11.setFont(fonteLabel);
        jLabel13.setForeground(corLabel); jLabel13.setFont(fonteLabel);
        jLabel14.setForeground(corLabel); jLabel14.setFont(fonteLabel);
        jLabel15.setForeground(corLabel); jLabel15.setFont(fonteLabel);
        jLabel16.setForeground(corLabel); jLabel16.setFont(fonteLabel);
        
        // Configurar campos de texto
        configurarCampoTexto(txtnome);
        configurarCampoTexto(txtendeereco);
        configurarCampoTexto(txtcidade);
        configurarCampoTexto(txttelefones);
        configurarCampoTexto(txtbairro);
        configurarCampoTexto(txtnascimento);
        configurarCampoTexto(txtestado);
        configurarCampoTexto(txtestadocivil);
        configurarCampoTexto(txtcargo);
        configurarCampoTexto(txtdataafiliacao);
        configurarCampoTexto(txtdizimo);
        
        // Configurar área de texto
        txtobs.setBackground(new Color(255, 255, 255));
        txtobs.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180), 1));
        txtobs.setFont(new Font("Arial", Font.PLAIN, 12));
        
        // Configurar botões
        configurarBotao(btncadastrar, new Color(34, 139, 34), Color.WHITE, "CADASTRAR");
        configurarBotao(btnbuscar, new Color(70, 130, 180), Color.WHITE, "BUSCAR");
    }
    
    /**
     * Configura uma seção (título de grupo)
     */
    private void configurarSecao(JLabel label, String texto) {
        label.setText(texto);
        label.setForeground(new Color(70, 130, 180)); // Steel Blue
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setBorder(BorderFactory.createMatteBorder(0, 0, 2, -10, new Color(70, 130, 180)));
    }
    
    /**
     * Configura a aparência de um campo de texto
     */
    private void configurarCampoTexto(JTextPane campo) {
        campo.setBackground(new Color(255, 255, 255));
        campo.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180), 1));
        campo.setFont(new Font("Arial", Font.PLAIN, 12));
    }
    
    /**
     * Configura a aparência de um botão
     */
    private void configurarBotao(JButton botao, Color corFundo, Color corTexto, String texto) {
        botao.setText(texto);
        botao.setBackground(corFundo);
        botao.setForeground(corTexto);
        botao.setFont(new Font("Arial", Font.BOLD, 14));
        botao.setBorder(BorderFactory.createRaisedBevelBorder());
        botao.setFocusPainted(false);
        botao.setPreferredSize(new Dimension(120, 35));
    }
    
    /**
     * Valida os dados antes de salvar
     */
    private boolean validarDados() {
        // Verificar campos obrigatórios
        if (txtnome.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo Nome é obrigatório!", 
                "Validação", JOptionPane.WARNING_MESSAGE);
            txtnome.requestFocus();
            return false;
        }
        
        if (txttelefones.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo Telefone é obrigatório!", 
                "Validação", JOptionPane.WARNING_MESSAGE);
            txttelefones.requestFocus();
            return false;
        }
        
        // Validar formato do telefone (apenas números)
        String telefone = txttelefones.getText().trim().replaceAll("[^0-9]", "");
        if (telefone.length() < 10) {
            JOptionPane.showMessageDialog(this, "Telefone deve ter pelo menos 10 dígitos!", 
                "Validação", JOptionPane.WARNING_MESSAGE);
            txttelefones.requestFocus();
            return false;
        }
        
        return true;
    }
    
    /**
     * Limpa todos os campos do formulário
     */
    private void limparCampos() {
        txtnome.setText("");
        txtendeereco.setText("");
        txtcidade.setText("");
        txttelefones.setText("");
        txtbairro.setText("");
        txtnascimento.setText("");
        txtestado.setText("");
        txtestadocivil.setText("");
        txtcargo.setText("");
        txtdataafiliacao.setText("");
        txtdizimo.setText("");
        txtobs.setText("");
        
        // Focar no primeiro campo
        txtnome.requestFocus();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtnome = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtendeereco = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtcidade = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        txttelefones = new javax.swing.JTextPane();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtnascimento = new javax.swing.JTextPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtestado = new javax.swing.JTextPane();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtestadocivil = new javax.swing.JTextPane();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtobs = new javax.swing.JTextArea();
        jScrollPane10 = new javax.swing.JScrollPane();
        txtcargo = new javax.swing.JTextPane();
        jScrollPane11 = new javax.swing.JScrollPane();
        txtdataafiliacao = new javax.swing.JTextPane();
        jScrollPane12 = new javax.swing.JScrollPane();
        txtdizimo = new javax.swing.JTextPane();
        btncadastrar = new javax.swing.JButton();
        btnbuscar = new javax.swing.JButton();
        jScrollPane13 = new javax.swing.JScrollPane();
        txtbairro = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Cadastro - Igreja Pentecostal Viver é Cristo");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("Igreja Pentecostal Viver é Cristo         2025");

        jLabel2.setText("Avenida Otaviano Costa 735 - Ipacarai");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("DADOS PESSOAIS");

        jLabel4.setText("Nome");

        jLabel5.setText("Endereço");

        jLabel6.setText("Cidade");

        jLabel7.setText("Telefone");

        jScrollPane1.setViewportView(txtnome);

        jScrollPane2.setViewportView(txtendeereco);

        jScrollPane3.setViewportView(txtcidade);

        jScrollPane4.setViewportView(txttelefones);

        jLabel8.setText("Bairro");

        jLabel9.setText("Nascimento");

        jLabel10.setText("Estado");

        jLabel11.setText("Estado Civil");

        jScrollPane5.setViewportView(txtnascimento);

        jScrollPane7.setViewportView(txtestado);

        jScrollPane8.setViewportView(txtestadocivil);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("DADOS MEMBRO NA IGREJA");

        jLabel13.setText("Cargo");

        jLabel14.setText("Data afiliação");

        jLabel15.setText("DÍZIMO");

        jLabel16.setText("OBS");

        txtobs.setColumns(20);
        txtobs.setRows(5);
        jScrollPane9.setViewportView(txtobs);

        jScrollPane10.setViewportView(txtcargo);

        jScrollPane11.setViewportView(txtdataafiliacao);

        jScrollPane12.setViewportView(txtdizimo);

        btncadastrar.setForeground(new java.awt.Color(0, 102, 255));
        btncadastrar.setText("CADASTRAR");
        btncadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncadastrarActionPerformed(evt);
            }
        });

        btnbuscar.setForeground(new java.awt.Color(0, 102, 204));
        btnbuscar.setText("BUSCAR");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        jScrollPane13.setViewportView(txtbairro);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(184, 184, 184))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(235, 235, 235)
                                .addComponent(jLabel2))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jScrollPane4))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jScrollPane3))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jScrollPane2))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel11)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jScrollPane8))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel9)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel8)
                                                .addComponent(jLabel10))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jScrollPane7)
                                                .addComponent(jScrollPane13)))))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane9))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane10)))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btncadastrar)
                            .addComponent(btnbuscar))
                        .addGap(77, 77, 77))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel7)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(btncadastrar)
                        .addGap(18, 18, 18)
                        .addComponent(btnbuscar)
                        .addGap(44, 44, 44))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btncadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncadastrarActionPerformed
        // Validar dados antes de salvar
        if (!validarDados()) {
            return;
        }
        
        // Essa função é chamada quando o botão de cadastrar é acionado
        // Primeiro, obtenha uma conexão com o banco de dados
        Connection connection = getConnection();
        // Se a conexão é nula, não prossiga
        if (connection == null) {
            return;
        }
        
        PreparedStatement stmtDadosPessoais = null;
        PreparedStatement stmtMembro = null;
        
        try {
            // Desabilitar auto-commit para usar transação
            connection.setAutoCommit(false);
            
            // 1. Inserir na tabela dadospessoais
            String sqlDadosPessoais = "INSERT INTO dadospessoais (nome, nascimento, bairro, cidade, estado, telefone, estado_civil) VALUES (?, ?, ?, ?, ?, ?, ?)";
            stmtDadosPessoais = connection.prepareStatement(sqlDadosPessoais, PreparedStatement.RETURN_GENERATED_KEYS);
            
            // Preencher os dados pessoais
            stmtDadosPessoais.setString(1, txtnome.getText().trim());
            stmtDadosPessoais.setString(2, txtnascimento.getText().trim());
            stmtDadosPessoais.setString(3, txtbairro.getText().trim());
            stmtDadosPessoais.setString(4, txtcidade.getText().trim());
            stmtDadosPessoais.setString(5, txtestado.getText().trim());
            
            // Converter telefone para int (removendo caracteres não numéricos)
            String telefoneStr = txttelefones.getText().trim().replaceAll("[^0-9]", "");
            long telefone = telefoneStr.isEmpty() ? 0 : Long.parseLong(telefoneStr);
            stmtDadosPessoais.setLong(6, telefone);
            
            stmtDadosPessoais.setString(7, txtestadocivil.getText().trim());
            
            // Executar inserção na tabela dadospessoais
            int rowsAffectedDados = stmtDadosPessoais.executeUpdate();
            
            if (rowsAffectedDados > 0) {
                // Obter o ID gerado para os dados pessoais
                var generatedKeys = stmtDadosPessoais.getGeneratedKeys();
                int idDadosPessoais = 0;
                if (generatedKeys.next()) {
                    idDadosPessoais = generatedKeys.getInt(1);
                }
                
                // 2. Inserir na tabela membro (dados da igreja)
                String sqlMembro = "INSERT INTO membro (id_dados_pessoais, endereco, cargo, data_afiliacao, dizimo, observacoes) VALUES (?, ?, ?, ?, ?, ?)";
                stmtMembro = connection.prepareStatement(sqlMembro);
                
                // Preencher os dados do membro
                stmtMembro.setInt(1, idDadosPessoais);
                stmtMembro.setString(2, txtendeereco.getText().trim());
                stmtMembro.setString(3, txtcargo.getText().trim());
                stmtMembro.setString(4, txtdataafiliacao.getText().trim());
                stmtMembro.setString(5, txtdizimo.getText().trim());
                stmtMembro.setString(6, txtobs.getText().trim());
                
                // Executar inserção na tabela membro
                int rowsAffectedMembro = stmtMembro.executeUpdate();
                
                if (rowsAffectedMembro > 0) {
                    // Confirmar a transação
                    connection.commit();
                    
                    JOptionPane.showMessageDialog(this, 
                        "Cadastro realizado com sucesso!\n" +
                        "Membro: " + txtnome.getText() + "\n" +
                        "ID dos Dados Pessoais: " + idDadosPessoais,
                        "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    
                    // Perguntar se deseja cadastrar outro membro
                    int opcao = JOptionPane.showConfirmDialog(this,
                        "Deseja cadastrar outro membro?",
                        "Novo Cadastro",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                    
                    if (opcao == JOptionPane.YES_OPTION) {
                        limparCampos();
                    }
                } else {
                    // Reverter a transação em caso de erro
                    connection.rollback();
                    JOptionPane.showMessageDialog(this, 
                        "Erro ao cadastrar dados do membro. Operação cancelada.",
                        "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // Reverter a transação em caso de erro
                connection.rollback();
                JOptionPane.showMessageDialog(this, 
                    "Erro ao cadastrar dados pessoais. Operação cancelada.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (SQLException ex) {
            // Reverter a transação em caso de exceção
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            
            // Tratar exceções específicas
            if (ex.getMessage().contains("Duplicate entry")) {
                JOptionPane.showMessageDialog(this, 
                    "Este membro já está cadastrado no sistema!",
                    "Cadastro Duplicado", JOptionPane.WARNING_MESSAGE);
            } else if (ex.getMessage().contains("doesn't exist")) {
                JOptionPane.showMessageDialog(this, 
                    "Erro: Tabela não encontrada no banco de dados.\n" +
                    "Verifique se as tabelas 'dadospessoais' e 'membro' existem.",
                    "Erro de Estrutura", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, 
                    "Erro ao cadastrar: " + ex.getMessage(),
                    "Erro de Banco de Dados", JOptionPane.ERROR_MESSAGE);
            }
        } finally {
            // Restaurar auto-commit e fechar recursos
            try {
                if (connection != null) {
                    connection.setAutoCommit(true);
                }
                if (stmtDadosPessoais != null) {
                    stmtDadosPessoais.close();
                }
                if (stmtMembro != null) {
                    stmtMembro.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btncadastrarActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // Cria uma nova instância de BuscaFrame (a tela de busca)
        BuscarCadastro buscarCadastro = new BuscarCadastro();

        // Torna a nova tela de busca visível
        buscarCadastro.setVisible(true);

        // Fecha ou esconde a tela de cadastro atual
        dispose(); // Fecha a tela atual (CadastroFrame)
    }//GEN-LAST:event_btnbuscarActionPerformed

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
            java.util.logging.Logger.getLogger(cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncadastrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextPane txtbairro;
    private javax.swing.JTextPane txtcargo;
    private javax.swing.JTextPane txtcidade;
    private javax.swing.JTextPane txtdataafiliacao;
    private javax.swing.JTextPane txtdizimo;
    private javax.swing.JTextPane txtendeereco;
    private javax.swing.JTextPane txtestado;
    private javax.swing.JTextPane txtestadocivil;
    private javax.swing.JTextPane txtnascimento;
    private javax.swing.JTextPane txtnome;
    private javax.swing.JTextArea txtobs;
    private javax.swing.JTextPane txttelefones;
    // End of variables declaration//GEN-END:variables
}
