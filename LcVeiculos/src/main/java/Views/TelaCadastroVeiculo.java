/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Views;

import Entidades.Veiculo;
import Repository.VeiculoRep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author layla
 */
public class TelaCadastroVeiculo extends javax.swing.JInternalFrame {

    private static TelaCadastroVeiculo instancia;

    /**
     * Creates new form TelaCadastroVeiculo
     */
    public TelaCadastroVeiculo() {
        initComponents();
        inicializarEstadoBotoes();
    }
    
     public static TelaCadastroVeiculo getInstancia() {
        if (instancia == null) {
            instancia = new TelaCadastroVeiculo();
        }
        return instancia;
    }
     
     private void inicializarEstadoBotoes() {
        btnCadastrarVeic.setEnabled(true);
        btnAlterar.setEnabled(false);
        btnExcluir.setEnabled(false);
    } 
     
    public void centralizar(JDesktopPane parent) {
        int parentWidth = parent.getWidth();
        int parentHeight = parent.getHeight();
        int width = this.getWidth();
        int height = this.getHeight();

        int x = (parentWidth - width) / 2;
        int y = (parentHeight - height) / 2;

        this.setLocation(x, y);
    } 
     
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1TelaCadastroDeVeic = new javax.swing.JPanel();
        jLabel1TituloCadastroVeic = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLQtdPortas = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        txtFabricante = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        txtAno = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAcessorio = new javax.swing.JTextArea();
        btnCadastrarVeic = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jLIdVeiculo = new javax.swing.JLabel();
        tfIdVeiculo = new javax.swing.JTextField();
        btnConsultar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLIdVeic = new javax.swing.JLabel();
        tfIdVeic = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btnLimpar = new javax.swing.JButton();
        lbErro = new javax.swing.JLabel();
        btnListaVeiculos = new javax.swing.JButton();
        cbQtdPortas = new javax.swing.JComboBox<>();

        setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        setClosable(true);
        setTitle(" Veículo");
        setMaximumSize(new java.awt.Dimension(1000, 600));

        jPanel1TelaCadastroDeVeic.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1TituloCadastroVeic.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel1TituloCadastroVeic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1TituloCadastroVeic.setText("Cadastro de Veículos");
        jLabel1TituloCadastroVeic.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Placa");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Fabricante");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Modelo");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Ano ");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLQtdPortas.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLQtdPortas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLQtdPortas.setText("Quantidade de Portas");
        jLQtdPortas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Acessórios");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtPlaca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtFabricante.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtModelo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtAno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtAcessorio.setColumns(20);
        txtAcessorio.setRows(5);
        txtAcessorio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(txtAcessorio);

        btnCadastrarVeic.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnCadastrarVeic.setText("Cadastrar");
        btnCadastrarVeic.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCadastrarVeic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarVeiculo(evt);
            }
        });

        btnSair.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnSair.setText("Sair");
        btnSair.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sair(evt);
            }
        });

        jLIdVeiculo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLIdVeiculo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLIdVeiculo.setText("Consultar Veiculo");
        jLIdVeiculo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tfIdVeiculo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfIdVeiculo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnConsultar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        btnConsultar.setText("Consultar");
        btnConsultar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Consultar(evt);
            }
        });

        btnAlterar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAlterar.setEnabled(false);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Alterar(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnExcluir.setEnabled(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Excluir(evt);
            }
        });

        jLIdVeic.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLIdVeic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLIdVeic.setText("ID Veículo");
        jLIdVeic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tfIdVeic.setEnabled(false);

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        btnLimpar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        lbErro.setForeground(new java.awt.Color(153, 0, 0));
        lbErro.setText("erro");

        btnListaVeiculos.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        btnListaVeiculos.setText("Meus Veículos");
        btnListaVeiculos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnListaVeiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaVeiculos(evt);
            }
        });

        cbQtdPortas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "2", "4" }));
        cbQtdPortas.setToolTipText("Selecionar");

        javax.swing.GroupLayout jPanel1TelaCadastroDeVeicLayout = new javax.swing.GroupLayout(jPanel1TelaCadastroDeVeic);
        jPanel1TelaCadastroDeVeic.setLayout(jPanel1TelaCadastroDeVeicLayout);
        jPanel1TelaCadastroDeVeicLayout.setHorizontalGroup(
            jPanel1TelaCadastroDeVeicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1TelaCadastroDeVeicLayout.createSequentialGroup()
                .addGroup(jPanel1TelaCadastroDeVeicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1TelaCadastroDeVeicLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1TelaCadastroDeVeicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLIdVeic, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfIdVeic, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1TelaCadastroDeVeicLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1TituloCadastroVeic, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1TelaCadastroDeVeicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1TelaCadastroDeVeicLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLIdVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1TelaCadastroDeVeicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1TelaCadastroDeVeicLayout.createSequentialGroup()
                                .addComponent(tfIdVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(108, Short.MAX_VALUE))
                            .addGroup(jPanel1TelaCadastroDeVeicLayout.createSequentialGroup()
                                .addComponent(lbErro, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnListaVeiculos)
                                .addGap(21, 21, 21))))
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1TelaCadastroDeVeicLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1TelaCadastroDeVeicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLQtdPortas, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1TelaCadastroDeVeicLayout.createSequentialGroup()
                                .addComponent(btnCadastrarVeic, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbQtdPortas, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(107, 107, 107))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1TelaCadastroDeVeicLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel1TelaCadastroDeVeicLayout.setVerticalGroup(
            jPanel1TelaCadastroDeVeicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1TelaCadastroDeVeicLayout.createSequentialGroup()
                .addGroup(jPanel1TelaCadastroDeVeicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1TelaCadastroDeVeicLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1TituloCadastroVeic, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1TelaCadastroDeVeicLayout.createSequentialGroup()
                        .addGroup(jPanel1TelaCadastroDeVeicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1TelaCadastroDeVeicLayout.createSequentialGroup()
                                .addComponent(lbErro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1TelaCadastroDeVeicLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(btnListaVeiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 13, Short.MAX_VALUE)))
                        .addGroup(jPanel1TelaCadastroDeVeicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfIdVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLIdVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(jPanel1TelaCadastroDeVeicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLIdVeic, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1TelaCadastroDeVeicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfIdVeic, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1TelaCadastroDeVeicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLQtdPortas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1TelaCadastroDeVeicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1TelaCadastroDeVeicLayout.createSequentialGroup()
                        .addComponent(cbQtdPortas, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1TelaCadastroDeVeicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1TelaCadastroDeVeicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1TelaCadastroDeVeicLayout.createSequentialGroup()
                        .addComponent(txtFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1TelaCadastroDeVeicLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1TelaCadastroDeVeicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1TelaCadastroDeVeicLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1TelaCadastroDeVeicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnCadastrarVeic, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(27, 27, 27)
                .addComponent(btnSair)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1TelaCadastroDeVeic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1TelaCadastroDeVeic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarVeiculo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarVeiculo
       
        Veiculo veiculo = new Veiculo();
        VeiculoRep obj = new VeiculoRep();
        veiculo.setPlaca(txtPlaca.getText());
        veiculo.setFabricante(txtFabricante.getText());
        veiculo.setModelo(txtModelo.getText()); 
        veiculo.setAnoModelo(Integer.valueOf(txtAno.getText()));
        veiculo.setQtdPortas(Integer.valueOf(cbQtdPortas.getSelectedItem().toString()));
        veiculo.setAcessorios(txtAcessorio.getText());
        Integer id = obj.cadastrarveiculo(veiculo);
        limpar();
       
    }//GEN-LAST:event_cadastrarVeiculo

    private void Consultar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Consultar
        if (tfIdVeiculo == null || tfIdVeiculo.getText().trim().isEmpty()) {
        lbErro.setText("Digite um ID ou Placa de Veículo válido.");
        return;
    }

    try {
        VeiculoRep veiculoRep = new VeiculoRep();
        String idOuPlaca = tfIdVeiculo.getText().trim(); 
        Veiculo veiculo = veiculoRep.consultarVeiculo(idOuPlaca);

        if (veiculo == null) {
            lbErro.setText("Veículo não encontrado.");
            return;
        }

        tfIdVeic.setText(String.valueOf(veiculo.getIdVeiculo()));
        txtAcessorio.setText(veiculo.getAcessorios());
        txtAno.setText(veiculo.getAnoModelo().toString());
        txtFabricante.setText(veiculo.getFabricante());
        txtPlaca.setText(veiculo.getPlaca());
        cbQtdPortas.setSelectedItem(veiculo.getQtdPortas().toString());
        txtModelo.setText(veiculo.getModelo());

        btnExcluir.setEnabled(true);
        btnAlterar.setEnabled(true);
        tfIdVeiculo.setText("");

    } catch (Exception ex) {
        lbErro.setText("Veículo não encontrado.");
        Logger.getLogger(TelaCadastroVeiculo.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }//GEN-LAST:event_Consultar

    
    
    private void Alterar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Alterar
        try {
    VeiculoRep obj = new VeiculoRep();
    Veiculo veiculo = new Veiculo();

    veiculo.setIdVeiculo(Integer.valueOf(tfIdVeic.getText())); 
    veiculo.setPlaca(txtPlaca.getText());
    veiculo.setQtdPortas(Integer.valueOf(cbQtdPortas.getSelectedItem().toString()));
    veiculo.setAcessorios(txtAcessorio.getText());
    veiculo.setAnoModelo(Integer.valueOf(txtAno.getText()));
    veiculo.setFabricante(txtFabricante.getText());
    veiculo.setModelo(txtModelo.getText());

    obj.alterarVeiculo(veiculo);

    JOptionPane.showMessageDialog(null, "Veículo alterado com sucesso!");
    TelaListarVeiculo.getInstancia().atualizarTabelaVeiculos();
    limpar();
} catch (Exception e) {
    System.out.println("Erro ao alterar veículo: " + e);
    JOptionPane.showMessageDialog(null, "Erro ao alterar o veículo: " + e.getMessage());
}

    }//GEN-LAST:event_Alterar

    private void Excluir(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Excluir
                             
    VeiculoRep veiculoRep = new VeiculoRep();

    try {
    int resposta = JOptionPane.showConfirmDialog(null, "Você deseja realmente excluir o veículo?", "Confirmação de Exclusão", JOptionPane.YES_NO_OPTION);

    if (resposta == JOptionPane.YES_OPTION) {
        Veiculo obj = veiculoRep.consultarVeiculo(tfIdVeic.getText());
        if(obj != null){
            try {
                veiculoRep.excluirVeiculo(obj.getIdVeiculo());
                JOptionPane.showMessageDialog(null, "Veículo excluído com sucesso.");
                TelaListarVeiculo.getInstancia().atualizarTabelaVeiculos(); 
                limpar(); 
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Não é possível excluir o veículo, ele não foi entregue.");
                limpar();
            }
        }
    }
} catch (NumberFormatException ex) {
    JOptionPane.showMessageDialog(null, "Por favor, insira um ID de veículo válido.");
} catch (Exception ex) {
    Logger.getLogger(TelaCadastroVeiculo.class.getName()).log(Level.SEVERE, null, ex);
}

    }//GEN-LAST:event_Excluir

    private void Sair(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sair
        this.dispose();
    }//GEN-LAST:event_Sair

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        
        cbQtdPortas.setSelectedIndex(-1);
        txtAno.setText("");
        txtFabricante.setText("");
        txtModelo.setText("");
        txtPlaca.setText("");
        tfIdVeiculo.setText("");
        tfIdVeic.setText("");
        txtAcessorio.setText("");
        lbErro.setText("");
    }//GEN-LAST:event_btnLimparActionPerformed

    private void listaVeiculos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaVeiculos
        
        TelaListarVeiculo telaListarVeiculo = TelaListarVeiculo.getInstancia();
    if (!telaListarVeiculo.isVisible()) {
        getParent().add(telaListarVeiculo); 
        telaListarVeiculo.centralizar((JDesktopPane) getParent());
        telaListarVeiculo.setVisible(true);
    } else {
        telaListarVeiculo.requestFocus();
    }
    }//GEN-LAST:event_listaVeiculos


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCadastrarVeic;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnListaVeiculos;
    private javax.swing.JButton btnSair;
    private javax.swing.JComboBox<String> cbQtdPortas;
    private javax.swing.JLabel jLIdVeic;
    private javax.swing.JLabel jLIdVeiculo;
    private javax.swing.JLabel jLQtdPortas;
    private javax.swing.JLabel jLabel1TituloCadastroVeic;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1TelaCadastroDeVeic;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbErro;
    private javax.swing.JTextField tfIdVeic;
    private javax.swing.JTextField tfIdVeiculo;
    private javax.swing.JTextArea txtAcessorio;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtFabricante;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtPlaca;
    // End of variables declaration//GEN-END:variables

    public void limpar(){
    txtAcessorio.setText("");
    cbQtdPortas.setSelectedIndex(-1);
    txtAno.setText("");
    txtFabricante.setText("");
    txtModelo.setText("");
    txtPlaca.setText("");
    tfIdVeiculo.setText("");
    lbErro.setText("");
    tfIdVeic.setText("");
    
    inicializarEstadoBotoes();
}

    
}
