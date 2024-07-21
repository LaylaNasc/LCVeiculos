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
public class ListarVeiculosTableModel extends AbstractTableModel{
    
    private final List<Veiculo> veiculos; 
     private final String[] colunas;
    
   
    public ListarVeiculosTableModel(List<Veiculo> veiculos) {
        this.colunas = new String[]{"idVeiculo", "Placa", "Fabricante", "Modelo", "AnoModelo", "qtdPortas", "acessorios"};
        this.veiculos = veiculos;
        
        System.out.println("Veículos passados para o TableModel: " + veiculos);
    }
    

    @Override
    public int getRowCount() {
        return (veiculos ==null) ? 0 : veiculos.size();
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
        if (veiculos == null || rowIndex >= veiculos.size()) {
            return null;   
        }
        
        Veiculo veiculo = veiculos.get(rowIndex);

        switch (columnIndex) {
            case 0: return veiculo.getIdVeiculo();
            case 1: return veiculo.getPlaca();
            case 2: return veiculo.getFabricante();
            case 3: return veiculo.getModelo();
            case 4: return veiculo.getAnoModelo();
            case 5: return veiculo.getQtdPortas();
            case 6: return veiculo.getAcessorios();
            default: return null;
        }
    }   

 }  

