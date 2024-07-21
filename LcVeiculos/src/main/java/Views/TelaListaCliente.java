/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Views;

import Entidades.Cliente;
import Entidades.ListarClientesTableModel;
import Repository.ClienteRep;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author layla
 */
public class TelaListaCliente extends JInternalFrame {
    
    private static TelaListaCliente instancia;
   
    
    public static TelaListaCliente getInstancia() {
        if (instancia == null) {
            instancia = new TelaListaCliente();
        }
        return instancia;
    }

    private TelaListaCliente() {
        super("Lista de Clientes", true, true, true, true);
        initComponents();
        mostrarLista();
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


    private void mostrarLista() {
        System.out.println("Método mostrarLista() chamado."); // Mensagem de log
        try {
            ClienteRep clienteRep = new ClienteRep();
            List<Cliente> clientesList = clienteRep.listarClientes();

            ListarClientesTableModel ctm = new ListarClientesTableModel(clientesList);

            tabelaCliente.setModel(ctm);

            tabelaCliente.revalidate();
            tabelaCliente.repaint();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao obter clientes: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void atualizarTabelaClientes() {
        try {
            ClienteRep clienteRep = new ClienteRep();
            List<Cliente> clientesList = clienteRep.listarClientes();

            ListarClientesTableModel ctm = new ListarClientesTableModel(clientesList);

            tabelaCliente.setModel(ctm);

            tabelaCliente.revalidate();
            tabelaCliente.repaint();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar tabela de clientes: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Teste");
        JDesktopPane desktopPane = new JDesktopPane();
        frame.setContentPane(desktopPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        TelaListaCliente telaListaCliente = TelaListaCliente.getInstancia();
        desktopPane.add(telaListaCliente);
        telaListaCliente.setVisible(true);

        frame.setVisible(true);
    }
  
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCliente = new javax.swing.JTable();

        setClosable(true);
        setTitle("Lista de Clientes");

        tabelaCliente.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelaCliente);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaCliente;
    // End of variables declaration//GEN-END:variables

}
