/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author layla
 */
public class ListarClientesTableModel extends AbstractTableModel{
    
     private final List<Cliente> clientes; 
     private final String[] colunas;
    
   
    public ListarClientesTableModel(List<Cliente> clientes) {
        this.colunas = new String[]{"Nome", "Endereço", "UF", "CPF", "Telefone", "Email"};
        this.clientes = clientes;
        
        System.out.println("Clientes passados para o TableModel: " + clientes);
    }



    @Override
    public int getRowCount() {
        return (clientes ==null) ? 0 : clientes.size();
    }

    @Override
    public int getColumnCount() {
         return colunas.length;
    }
    
    @Override
     public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (clientes == null || rowIndex >= clientes.size()) {
            return null;
    }
    
        
    Cliente cliente = clientes.get(rowIndex);

        switch (columnIndex) {
            case 0: return cliente.getNomeCliente();
            case 1: return cliente.getEndereco();
            case 2: return cliente.getUf();
            case 3: return cliente.getCpf();
            case 4: return cliente.getTelefone();
            case 5: return cliente.getEmail();
            default: return null;
        }
    }    

    
}
