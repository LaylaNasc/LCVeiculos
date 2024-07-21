/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Views;

import Entidades.ListarVeiculosTableModel;
import Entidades.Veiculo;
import Repository.VeiculoRep;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author layla
 */
public class TelaListarVeiculo extends javax.swing.JInternalFrame {

    private static TelaListarVeiculo instancia;

   
    public static TelaListarVeiculo getInstancia() {
        if (instancia == null) {
            instancia = new TelaListarVeiculo();
        }
        return instancia;
    }

    private TelaListarVeiculo() {
        super("Lista de Veículos", true, true, true, true);
        initComponents();
        mostrarListaVeic();
        pack();
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
    
    
     private void mostrarListaVeic() {
        System.out.println("Método mostrarListaVeic() chamado."); 
        try {
            VeiculoRep veiculoRep = new VeiculoRep();
            List<Veiculo> veiculosList = veiculoRep.listarVeiculos();

            ListarVeiculosTableModel rmf = new ListarVeiculosTableModel(veiculosList);

            tabelaVeic.setModel(rmf);

            tabelaVeic.revalidate();
            tabelaVeic.repaint();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao obter veículos: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
     
     
    public void atualizarTabelaVeiculos() {
        try {
            VeiculoRep veiculoRep = new VeiculoRep();
            List<Veiculo> veiculosList = veiculoRep.listarVeiculos();

            ListarVeiculosTableModel ctm = new ListarVeiculosTableModel(veiculosList);

            tabelaVeic.setModel(ctm);

            tabelaVeic.revalidate();
            tabelaVeic.repaint();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar tabela de veículo: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    } 

    public static void main(String[] args) {
        JFrame frame = new JFrame("Teste");
        JDesktopPane desktopPane = new JDesktopPane();
        frame.setContentPane(desktopPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        TelaListarVeiculo telaListarVeiculo = TelaListarVeiculo.getInstancia();
        desktopPane.add(telaListarVeiculo);
        telaListarVeiculo.setVisible(true);

        frame.setVisible(true);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpListarVeic = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaVeic = new javax.swing.JTable();

        setClosable(true);
        setTitle("Lista de Veículos");

        tabelaVeic.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelaVeic);

        javax.swing.GroupLayout jpListarVeicLayout = new javax.swing.GroupLayout(jpListarVeic);
        jpListarVeic.setLayout(jpListarVeicLayout);
        jpListarVeicLayout.setHorizontalGroup(
            jpListarVeicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpListarVeicLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpListarVeicLayout.setVerticalGroup(
            jpListarVeicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpListarVeicLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpListarVeic, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpListarVeic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpListarVeic;
    private javax.swing.JTable tabelaVeic;
    // End of variables declaration//GEN-END:variables
}
