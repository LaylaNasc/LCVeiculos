/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Views;

import Conexao.Conexao;
import Entidades.Aluguel;
import Entidades.Cliente;
import Entidades.Veiculo;
import Repository.AluguelRep;
import Repository.ClienteRep;
import Repository.VeiculoRep;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;


/**
 *
 * @author layla
 */
public class TelaCadastroAluguel extends javax.swing.JInternalFrame {

    private static TelaCadastroAluguel instancia;

    
    public static TelaCadastroAluguel getInstancia() {
        if (instancia == null) {
            instancia = new TelaCadastroAluguel();
        }
        return instancia;
    }
    
     private void inicializarEstadoBotoes() {
        btnCadastrarAlug.setEnabled(true);
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
   
    public TelaCadastroAluguel() {
        
        initComponents();
        inicializarEstadoBotoes();
        carregarCbVeiculo();
        carregarCbCliente();
    }
    Vector<Integer> idVeiculo = new Vector<>();
    Vector <Integer> idCliente = new Vector<Integer>();

   
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTelaCadastAlug = new javax.swing.JPanel();
        jPanelCadastroAlug = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabelDtInc = new javax.swing.JLabel();
        jLabelDtEntreg = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelEntrega = new javax.swing.JLabel();
        jLabelObs = new javax.swing.JLabel();
        jLabelValor = new javax.swing.JLabel();
        btnCadastrarAlug = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        idAluguelConsul = new javax.swing.JLabel();
        tfAluguelConsulta = new javax.swing.JTextField();
        btnConsultar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        cbCliente = new javax.swing.JComboBox<>();
        cbVeiculo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        tfObservacao = new javax.swing.JTextField();
        idAluguel = new javax.swing.JLabel();
        tfIdAluguel = new javax.swing.JTextField();
        btnLimpar = new javax.swing.JButton();
        tfDataInc = new javax.swing.JFormattedTextField();
        tfDtEntg = new javax.swing.JFormattedTextField();
        tfValor = new javax.swing.JFormattedTextField();
        btnMeusAlugueis = new javax.swing.JButton();
        cbEntregue = new javax.swing.JComboBox<>();

        setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        setClosable(true);
        setTitle("Consultar Aluguel");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Cadastro de Aluguel");
        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jLabelDtInc.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabelDtInc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDtInc.setText("Data Inicial");
        jLabelDtInc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelDtEntreg.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabelDtEntreg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDtEntreg.setText("Data Entrega");
        jLabelDtEntreg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel6.setText("Cliente");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelEntrega.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabelEntrega.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEntrega.setText("Entregue");
        jLabelEntrega.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelObs.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabelObs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelObs.setText("Observação");
        jLabelObs.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelValor.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabelValor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelValor.setText("Valor");
        jLabelValor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnCadastrarAlug.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        btnCadastrarAlug.setText("Cadastrar");
        btnCadastrarAlug.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCadastrarAlug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cadastrar(evt);
            }
        });

        btnSair.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        btnSair.setText("sair");
        btnSair.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sair(evt);
            }
        });

        idAluguelConsul.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        idAluguelConsul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        idAluguelConsul.setText("ID");
        idAluguelConsul.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tfAluguelConsulta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfAluguelConsulta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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

        cbCliente.setToolTipText("");
        cbCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cbVeiculo.setToolTipText("");
        cbVeiculo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Veiculo");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        tfObservacao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        idAluguel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        idAluguel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        idAluguel.setText("ID Aluguel");
        idAluguel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tfIdAluguel.setEnabled(false);

        btnLimpar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimparCampos(evt);
            }
        });

        tfDataInc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        try {
            tfDataInc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfDataInc.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        tfDtEntg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        try {
            tfDtEntg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfDtEntg.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        tfValor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tfValor.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnMeusAlugueis.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        btnMeusAlugueis.setText("Meus Aluguéis");
        btnMeusAlugueis.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMeusAlugueis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMeusAlugueisActionPerformed(evt);
            }
        });

        cbEntregue.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "S", "N" }));
        cbEntregue.setToolTipText("Selecionar");

        javax.swing.GroupLayout jPanelCadastroAlugLayout = new javax.swing.GroupLayout(jPanelCadastroAlug);
        jPanelCadastroAlug.setLayout(jPanelCadastroAlugLayout);
        jPanelCadastroAlugLayout.setHorizontalGroup(
            jPanelCadastroAlugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastroAlugLayout.createSequentialGroup()
                .addGroup(jPanelCadastroAlugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCadastroAlugLayout.createSequentialGroup()
                        .addGap(307, 307, 307)
                        .addComponent(idAluguelConsul, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfAluguelConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCadastroAlugLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(idAluguel, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(tfIdAluguel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCadastroAlugLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(cbVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCadastroAlugLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(tfDataInc, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(296, 296, 296)
                        .addComponent(tfValor, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCadastroAlugLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabelDtEntreg, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(292, 292, 292)
                        .addComponent(jLabelObs, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCadastroAlugLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(tfDtEntg, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(292, 292, 292)
                        .addComponent(tfObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCadastroAlugLayout.createSequentialGroup()
                        .addGap(399, 399, 399)
                        .addComponent(btnCadastrarAlug, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCadastroAlugLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanelCadastroAlugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDtInc, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelCadastroAlugLayout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(cbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(121, 121, 121)
                        .addGroup(jPanelCadastroAlugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelCadastroAlugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cbEntregue, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelValor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)))))
                .addGap(442, 442, 442))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCadastroAlugLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCadastroAlugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCadastroAlugLayout.createSequentialGroup()
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(325, 325, 325))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCadastroAlugLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 936, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCadastroAlugLayout.createSequentialGroup()
                        .addComponent(btnMeusAlugueis)
                        .addGap(400, 400, 400))))
        );
        jPanelCadastroAlugLayout.setVerticalGroup(
            jPanelCadastroAlugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastroAlugLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMeusAlugueis, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanelCadastroAlugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCadastroAlugLayout.createSequentialGroup()
                        .addGroup(jPanelCadastroAlugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnConsultar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanelCadastroAlugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(idAluguelConsul, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfAluguelConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCadastroAlugLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(25, 25, 25)))
                .addGroup(jPanelCadastroAlugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idAluguel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfIdAluguel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelCadastroAlugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCadastroAlugLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanelCadastroAlugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanelCadastroAlugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelCadastroAlugLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelCadastroAlugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbEntregue, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)
                        .addGroup(jPanelCadastroAlugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDtInc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelValor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanelCadastroAlugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfDataInc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfValor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanelCadastroAlugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDtEntreg, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelObs, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelCadastroAlugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfDtEntg, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanelCadastroAlugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCadastrarAlug, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addComponent(btnSair))
                    .addGroup(jPanelCadastroAlugLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabelEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout jPanelTelaCadastAlugLayout = new javax.swing.GroupLayout(jPanelTelaCadastAlug);
        jPanelTelaCadastAlug.setLayout(jPanelTelaCadastAlugLayout);
        jPanelTelaCadastAlugLayout.setHorizontalGroup(
            jPanelTelaCadastAlugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTelaCadastAlugLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelCadastroAlug, javax.swing.GroupLayout.PREFERRED_SIZE, 862, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelTelaCadastAlugLayout.setVerticalGroup(
            jPanelTelaCadastAlugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelCadastroAlug, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanelTelaCadastAlug, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void carregarCbVeiculo(){
        VeiculoRep veiculo = new VeiculoRep();
        ResultSet rs = veiculo.findAll();
        
            try {
        while (rs.next()) {
            idVeiculo.addElement(rs.getInt(1));
            cbVeiculo.addItem(rs.getString(2));  
        }
} catch (SQLException e) {
    e.printStackTrace();
}
    }
    
    
    
     public void carregarCbCliente(){
       ClienteRep cliente = new ClienteRep();
        ResultSet rs = cliente.findAll();
           try {
        while (rs.next()) {
            idCliente.addElement(rs.getInt("idCliente"));
            cbCliente.addItem(rs.getString(6));  
         }
} catch (SQLException e) {
    e.printStackTrace();
}
}
     



    private void Cadastrar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cadastrar
    
     ClienteRep clienteRep = new ClienteRep();
    VeiculoRep veiculoRep = new VeiculoRep();
    AluguelRep aluguelRep = new AluguelRep();

    try {
        int selectedClienteIndex = cbCliente.getSelectedIndex();
        Cliente cliente = clienteRep.procurarCliente(idCliente.get(selectedClienteIndex).toString());

        int selectedVeiculoIndex = cbVeiculo.getSelectedIndex();
        Veiculo veiculo = veiculoRep.consultarVeiculo(idVeiculo.get(selectedVeiculoIndex).toString());

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Aluguel aluguel = new Aluguel();
        aluguel.setCliente(cliente);
        aluguel.setVeiculo(veiculo);
        aluguel.setDataAluguel(dateFormat.parse(tfDataInc.getText()));
        aluguel.setDataEntrega(dateFormat.parse(tfDtEntg.getText()));
        aluguel.setEntregue(cbEntregue.getSelectedItem().toString().charAt(0));
        aluguel.setObservacao(tfObservacao.getText().trim());

        String valorPagoStr = tfValor.getText().trim();
        NumberFormat format = NumberFormat.getInstance(new Locale("pt", "BR"));
        Number number = null;

        try {
            number = format.parse(valorPagoStr);
            Double valorPago = number.doubleValue();
            aluguel.setValorPago(valorPago);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Formato de valor inválido. Utilize o formato ##,## ou ##.##");
            return;
        }

        int generatedId = aluguelRep.cadastrarAluguel(aluguel);
        if (generatedId != -1) {
            JOptionPane.showMessageDialog(null, "Aluguel cadastrado com sucesso! O ID de Aluguel é " + generatedId);
            TelaListarAluguel.getInstancia().atualizarTabelaAlugueis();
            limpar();
        }

    } catch (ParseException e) {
        JOptionPane.showMessageDialog(null, "Formato de data inválido. Use o formato dd/MM/yyyy.");
        Logger.getLogger(TelaCadastroAluguel.class.getName()).log(Level.SEVERE, null, e);
    } catch (Exception ex) {
        Logger.getLogger(TelaCadastroAluguel.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_Cadastrar
               
        
    private void Consultar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Consultar
    AluguelRep aluguelrep = new AluguelRep();
    Aluguel obj = aluguelrep.consultar(tfAluguelConsulta.getText());

    if (obj != null) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        DecimalFormat df = new DecimalFormat("R$#,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));
        String valorPagoFormatado = df.format(obj.getValorPago());

        tfIdAluguel.setText(obj.getIdAluguel().toString());
        tfValor.setText(valorPagoFormatado);
        cbEntregue.setSelectedItem(String.valueOf(obj.getEntregue()));
        tfDataInc.setText(sdf.format(obj.getDataAluguel()));
        tfDtEntg.setText(sdf.format(obj.getDataEntrega()));
        tfObservacao.setText(obj.getObservacao());
        cbCliente.setSelectedItem(obj.getCliente().getCpf());
        cbVeiculo.setSelectedItem(obj.getVeiculo().getPlaca());

        btnExcluir.setEnabled(true);
        btnAlterar.setEnabled(true);
    } else {
        JOptionPane.showMessageDialog(null, "Aluguel não encontrado. Verifique o ID e tente novamente.");
        limpar();
    }
    }//GEN-LAST:event_Consultar

    private void Alterar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Alterar
        
    try {
        int selectedClienteIndex = cbCliente.getSelectedIndex();
        Cliente cliente = new ClienteRep().procurarCliente(idCliente.get(selectedClienteIndex).toString());

        int selectedVeiculoIndex = cbVeiculo.getSelectedIndex();
        Veiculo veiculo = new VeiculoRep().consultarVeiculo(idVeiculo.get(selectedVeiculoIndex).toString());
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Aluguel aluguel = new Aluguel();
        aluguel.setIdAluguel(Integer.valueOf(tfIdAluguel.getText()));
        aluguel.setCliente(cliente);
        aluguel.setVeiculo(veiculo);
        aluguel.setDataAluguel(dateFormat.parse(tfDataInc.getText()));
        aluguel.setDataEntrega(dateFormat.parse(tfDtEntg.getText()));
        aluguel.setEntregue(cbEntregue.getSelectedItem().toString().charAt(0));  
        aluguel.setObservacao(tfObservacao.getText());

        String valorPagoStr = tfValor.getText().trim();
        valorPagoStr = valorPagoStr.replace("R$", "").trim(); 
        valorPagoStr = valorPagoStr.replace(".", "").replace(",", ".");
        Double valorPago = null;
        try {
            valorPago = Double.valueOf(valorPagoStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Formato de valor inválido. Utilize o formato ##,## ou ##.##");
            return;
        }
        aluguel.setValorPago(valorPago);

        AluguelRep aluguelRep = new AluguelRep();
        aluguelRep.alterarAluguel(aluguel);

        DecimalFormat df = new DecimalFormat("R$#,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));
        String valorPagoFormatado = df.format(valorPago);
        tfValor.setText(valorPagoFormatado);

        JOptionPane.showMessageDialog(null, "Aluguel alterado com sucesso!");
        TelaListarAluguel.getInstancia().atualizarTabelaAlugueis();
        limpar();

    } catch (ParseException e) {
        JOptionPane.showMessageDialog(null, "Formato de data inválido. Use o formato dd/MM/yyyy.");
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Formato de valor inválido.");
    } catch (Exception ex) {
        Logger.getLogger(TelaCadastroAluguel.class.getName()).log(Level.SEVERE, null, ex);
    }
       
    }//GEN-LAST:event_Alterar

    private void Excluir(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Excluir

        try {
    int resposta = JOptionPane.showConfirmDialog(null, "Você deseja realmente excluir o Aluguel?", "Confirmação de Exclusão", JOptionPane.YES_NO_OPTION);

    if (resposta == JOptionPane.YES_OPTION) {
        int idAluguel = Integer.parseInt(tfIdAluguel.getText());

        AluguelRep aluguelRep = new AluguelRep();
        aluguelRep.excluirAluguel(idAluguel);

        JOptionPane.showMessageDialog(null, "Aluguel excluído com sucesso!");
        TelaListarAluguel.getInstancia().atualizarTabelaAlugueis();
        limpar();
    } else {
        JOptionPane.showMessageDialog(null, "Exclusão cancelada.");
    }
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(null, "ID de aluguel inválido.");
} catch (HeadlessException ex) {
    Logger.getLogger(TelaCadastroAluguel.class.getName()).log(Level.SEVERE, null, ex);
}       catch (Exception ex) {
            Logger.getLogger(TelaCadastroAluguel.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }//GEN-LAST:event_Excluir

    private void Sair(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sair
        this.dispose();
    }//GEN-LAST:event_Sair

    private void LimparCampos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimparCampos
        // TODO add your handling code here:
        tfDataInc.setText("");
        tfDtEntg.setText("");
        cbEntregue.setSelectedIndex(-1);
        tfValor.setText("");
        tfObservacao.setText("");
        tfIdAluguel.setText("");
        tfAluguelConsulta.setText("");
    }//GEN-LAST:event_LimparCampos

    private void btnMeusAlugueisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMeusAlugueisActionPerformed
        // TODO add your handling code here:
        TelaListarAluguel telaListaAluguel = TelaListarAluguel.getInstancia();
    if (!telaListaAluguel.isVisible()) {
        getParent().add(telaListaAluguel);
        telaListaAluguel.centralizar((JDesktopPane) getParent());
        telaListaAluguel.setVisible(true);
    } else {
        telaListaAluguel.requestFocus();
    }
   
    }//GEN-LAST:event_btnMeusAlugueisActionPerformed
    
    public void limpar(){
    tfDataInc.setText("");
    tfDtEntg.setText("");
    cbEntregue.setSelectedIndex(-1);
    tfValor.setText("");
    tfObservacao.setText("");
    tfIdAluguel.setText("");
    tfAluguelConsulta.setText("");
    
    inicializarEstadoBotoes();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCadastrarAlug;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnMeusAlugueis;
    private javax.swing.JButton btnSair;
    private javax.swing.JComboBox<String> cbCliente;
    private javax.swing.JComboBox<String> cbEntregue;
    private javax.swing.JComboBox<String> cbVeiculo;
    private javax.swing.JLabel idAluguel;
    private javax.swing.JLabel idAluguelConsul;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelDtEntreg;
    private javax.swing.JLabel jLabelDtInc;
    private javax.swing.JLabel jLabelEntrega;
    private javax.swing.JLabel jLabelObs;
    private javax.swing.JLabel jLabelValor;
    private javax.swing.JPanel jPanelCadastroAlug;
    private javax.swing.JPanel jPanelTelaCadastAlug;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField tfAluguelConsulta;
    private javax.swing.JFormattedTextField tfDataInc;
    private javax.swing.JFormattedTextField tfDtEntg;
    private javax.swing.JTextField tfIdAluguel;
    private javax.swing.JTextField tfObservacao;
    private javax.swing.JFormattedTextField tfValor;
    // End of variables declaration//GEN-END:variables

}
