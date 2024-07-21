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
public class ListarAluguelTableModel extends AbstractTableModel {
    
   private final List<Aluguel> alugueis;
   private final String[] colunas;
    
    public ListarAluguelTableModel(List<Aluguel> alugueis) {
        this.colunas = new String[]{"idAluguel", "idVeiculo", "idCliente", "dataAluguel", "dataEntrega", "entregue", "observacao", "valorPago"};
        this.alugueis = alugueis;
    }
    
    

    @Override
    public int getRowCount() {
        return (alugueis == null) ? 0 : alugueis.size();
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
         if (alugueis == null || rowIndex >= alugueis.size()) {
            return null;   
        }
        
        Aluguel aluguel = alugueis.get(rowIndex);

        switch (columnIndex) {
            case 0: return aluguel.getIdAluguel();
            case 1: return aluguel.getVeiculo().getIdVeiculo(); 
            case 2: return aluguel.getCliente().getIdCliente();
            case 3: return aluguel.getDataAluguel();
            case 4: return aluguel.getDataEntrega();
            case 5: return aluguel.getEntregue().toString(); 
            case 6: return aluguel.getObservacao();
            case 7: return aluguel.getValorPago();
            default: return null;
        }
    }   
    
}
