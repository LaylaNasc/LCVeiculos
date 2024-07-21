/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import Repository.AluguelRep.VeiculoPendente;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author layla
 */
public class VeiculosPendentesTableModel  extends AbstractTableModel{
    
    private final List<VeiculoPendente> veiculosPendentes;
    private final String[] colunas;
    
    /**
     *
     * @param veiculosPendentes
     */
    public VeiculosPendentesTableModel(List<VeiculoPendente> veiculosPendentes) {
        this.colunas = new String[]{"Placa", "Modelo", "Entregue", "CPF", "Cliente", "Telefone"};
        this.veiculosPendentes = veiculosPendentes;
    }
    
    @Override
    public int getRowCount() {
         return veiculosPendentes != null ? veiculosPendentes.size() : 0;
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
          if (veiculosPendentes != null && rowIndex >= 0 && rowIndex < veiculosPendentes.size()) {
            VeiculoPendente veiculo = veiculosPendentes.get(rowIndex);
            switch (columnIndex) {
                case 0: return veiculo.getPlaca();
                case 1: return veiculo.getModelo();
                case 2: return veiculo.getEntregue();
                case 3: return veiculo.getCpf();
                case 4: return veiculo.getCliente();
                case 5: return veiculo.getTelefone();
                default: return null;
            }
        }
        return null;
    }
}
    
    
   
