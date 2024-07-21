/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Conexao.Conexao;
import Entidades.Aluguel;
import Entidades.Cliente;
import Entidades.Veiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author layla
 */

public class AluguelRep {
    
    
 


public int cadastrarAluguel(Aluguel aluguel) throws SQLException {
    if (aluguel == null) {
        JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
        return -1;
    }

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        conn = new Conexao().connection();

        
        String checkSql = "SELECT COUNT(*) FROM Aluguel WHERE idVeiculo = ? AND entregue = 'N'";
        ps = conn.prepareStatement(checkSql);
        ps.setInt(1, aluguel.getVeiculo().getIdVeiculo());

        rs = ps.executeQuery();
        if (rs.next() && rs.getInt(1) > 0) {
            JOptionPane.showMessageDialog(null, "Esse veículo ainda não foi entregue.");
            return -1;
        }

        rs.close();
        ps.close();

        
        String insertSql = "INSERT INTO Aluguel (idVeiculo, dataAluguel, dataEntrega, entregue, observacao, valorPago, idCliente) VALUES (?, ?, ?, ?, ?, ?, ?)";
        ps = conn.prepareStatement(insertSql, PreparedStatement.RETURN_GENERATED_KEYS);

        ps.setInt(1, aluguel.getVeiculo().getIdVeiculo());
        ps.setDate(2, new java.sql.Date(aluguel.getDataAluguel().getTime()));
        ps.setDate(3, new java.sql.Date(aluguel.getDataEntrega().getTime()));
        ps.setString(4, String.valueOf(aluguel.getEntregue()));
        ps.setString(5, aluguel.getObservacao());
        ps.setDouble(6, aluguel.getValorPago()); 
        ps.setInt(7, aluguel.getCliente().getIdCliente());


        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int generatedId = rs.getInt(1);
                aluguel.setIdAluguel(generatedId);
                return generatedId;
            }
        }
        return -1;
    } finally {
        if (rs != null) rs.close();
        if (ps != null) ps.close();
        if (conn != null) conn.close();
    }
}





public Aluguel consultar(String id) {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
        conn = new Conexao().connection();
        ps = conn.prepareStatement("SELECT * FROM ALUGUEL WHERE idAluguel = ?");
        ps.setString(1, id);
        rs = ps.executeQuery();
        
        if (rs.next()) {
            VeiculoRep veiculorp = new VeiculoRep();
            Veiculo veiculo = veiculorp.consultarVeiculo(rs.getString("idVeiculo"));
            
            ClienteRep clienteRp = new ClienteRep();
            Cliente cliente = clienteRp.procurarCliente(rs.getString("idCliente"));
       
            Aluguel aluguel = new Aluguel();
            aluguel.setIdAluguel(rs.getInt("idAluguel"));
            aluguel.setVeiculo(veiculo);
            aluguel.setDataAluguel(rs.getDate("dataAluguel"));
            aluguel.setDataEntrega(rs.getDate("dataEntrega"));
            aluguel.setEntregue(rs.getString("entregue").charAt(0));
            aluguel.setObservacao(rs.getString("observacao"));
            aluguel.setValorPago(rs.getDouble("valorPago"));
            aluguel.setCliente(cliente);
            
            return aluguel;
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e.getMessage() + " Erro ao consultar");
    } catch (Exception ex) {
        Logger.getLogger(AluguelRep.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            Logger.getLogger(AluguelRep.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    return null;
}



    public void alterarAluguel(Aluguel aluguel) {
        
    Connection conn = null;
    PreparedStatement ps = null;
    try {
        conn = new Conexao().connection();
        ps = conn.prepareStatement("UPDATE ALUGUEL SET idVeiculo = ?, dataAluguel = ?, dataEntrega = ?, entregue = ?, observacao = ?, valorPago = ?, idCliente = ? WHERE idAluguel = ?");

        ps.setInt(1, aluguel.getVeiculo().getIdVeiculo());
        ps.setDate(2, new java.sql.Date(aluguel.getDataAluguel().getTime()));
        ps.setDate(3, new java.sql.Date(aluguel.getDataEntrega().getTime()));
        ps.setString(4, String.valueOf(aluguel.getEntregue()));
        ps.setString(5, aluguel.getObservacao());
        ps.setDouble(6, aluguel.getValorPago());
        ps.setInt(7, aluguel.getCliente().getIdCliente());
        ps.setInt(8, aluguel.getIdAluguel());

        ps.executeUpdate();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao alterar aluguel: " + e.getMessage());
    } catch (Exception ex) {
        Logger.getLogger(AluguelRep.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            Logger.getLogger(AluguelRep.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}



public void excluirAluguel(int idAluguel) throws Exception {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        conn = new Conexao().connection();

        String verificarSql = "SELECT entregue FROM aluguel WHERE idAluguel = ?";
        ps = conn.prepareStatement(verificarSql);
        ps.setInt(1, idAluguel);
        rs = ps.executeQuery();

        if (rs.next()) {
            String entregue = rs.getString("entregue");
            if ("N".equals(entregue)) {
                throw new Exception("Não é possível excluir o aluguel, pois o veículo não foi entregue.");
            }
        } else {
            throw new Exception("Aluguel não encontrado.");
        }

        ps = conn.prepareStatement("DELETE FROM aluguel WHERE idAluguel = ?");
        ps.setInt(1, idAluguel);

        int rowsAffected = ps.executeUpdate();
        if (rowsAffected == 0) {
            throw new Exception("Erro ao excluir aluguel.");
        }
    } catch (SQLException e) {
        throw new Exception("Erro ao excluir aluguel: " + e.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            Logger.getLogger(AluguelRep.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}


public List<Aluguel> findAll(){
      {
     Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Aluguel> list = new ArrayList<>();
        try {
         conn = new Conexao().connection();
         ps = conn.prepareStatement( "select * from aluguel");
         rs = ps.executeQuery();
         while(rs.next()){
            VeiculoRep veiculorp = new VeiculoRep();
            Veiculo veiculo = veiculorp.consultarVeiculo(rs.getString("idVeiculo"));
            
            ClienteRep clienteRp = new ClienteRep();
            Cliente cliente = clienteRp.procurarCliente(rs.getString("idCliente"));
            
            Aluguel aluguel = new Aluguel();
            aluguel.setIdAluguel(rs.getInt("idAluguel"));
            aluguel.setVeiculo(veiculo);
            aluguel.setDataAluguel(rs.getDate("dataAluguel"));
            aluguel.setDataEntrega(rs.getDate("dataEntrega"));
            aluguel.setEntregue(rs.getString("entregue").charAt(0));
            aluguel.setObservacao(rs.getString("observacao"));
            aluguel.setValorPago(rs.getDouble("valorPago"));
            aluguel.setCliente(cliente);
            list.add(aluguel);
         }
         return list;
    } catch (Exception e) {
            System.out.println("Erro Veiculos pendentes "+ e.getMessage());
    }
    return null;
      }
}


public double calcularFaturamento(Date dataInicio, Date dataFim) {
        double valorTotal = 0.0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = new Conexao().connection();
            String query = "SELECT SUM(valorPago) FROM aluguel WHERE dataAluguel >= ? AND dataEntrega <= ?";
            ps = conn.prepareStatement(query);
            ps.setDate(1, new java.sql.Date(dataInicio.getTime()));
            ps.setDate(2, new java.sql.Date(dataFim.getTime()));
            rs = ps.executeQuery();

            if (rs.next()) {
                valorTotal = rs.getDouble(1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao calcular faturamento: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                Logger.getLogger(AluguelRep.class.getName()).log(Level.SEVERE, null, e);
            }
    }

    return valorTotal;
}

//tabela de veiculos pendentes

    public class VeiculoPendente {
    private final String placa;
    private final String modelo;
    private final String entregue;
    private final String cpf;
    private final String cliente;
    private final String telefone;

    public VeiculoPendente(String placa, String modelo, String entregue, String cpf, String cliente, String telefone) {
        this.placa = placa;
        this.modelo = modelo;
        this.entregue = entregue;
        this.cpf = cpf;
        this.cliente = cliente;
        this.telefone = telefone;
    }

    public String getPlaca() { return placa; }
    public String getModelo() { return modelo; }
    public String getEntregue() { return entregue; }
    public String getCpf() { return cpf; }
    public String getCliente() { return cliente; }
    public String getTelefone(){ return telefone;}

        
    }

public List<VeiculoPendente> VeiculoPendente() {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    List<VeiculoPendente> list = new ArrayList<>();
    try {
        conn = new Conexao().connection();
        ps = conn.prepareStatement(
            "SELECT v.placa AS Placa, v.modelo AS Modelo, a.entregue AS Entregue, c.cpf AS CPF, c.nome AS Cliente, c.telefone AS Telefone " +
            "FROM aluguel a " +
            "JOIN veiculo v ON a.idVeiculo = v.idVeiculo " +
            "JOIN cliente c ON a.idCliente = c.idCliente " +
            "WHERE a.entregue = 'N'"
        );
        rs = ps.executeQuery();
        while (rs.next()) {
            String placa = rs.getString("Placa");
            String modelo = rs.getString("Modelo");
            String entregue = rs.getString("Entregue");
            String cpf = rs.getString("CPF");
            String cliente = rs.getString("Cliente");
            String telefone = rs.getString("telefone");
            list.add(new VeiculoPendente(placa, modelo, entregue, cpf, cliente, telefone));
        }
    } catch (SQLException e) {
        System.out.println("Erro ao consultar veículos pendentes: " + e.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            Logger.getLogger(AluguelRep.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    return list;
}

public List<Aluguel> listarAlugueis() {
        try (Connection conn = new Conexao().connection();
             PreparedStatement ps = conn.prepareStatement("SELECT idAluguel, idVeiculo, idCliente, dataAluguel, dataEntrega, entregue, observacao, valorPago FROM aluguel");
             ResultSet rs = ps.executeQuery()) {

            List<Aluguel> alugueis = new ArrayList<>();
            while (rs.next()) {
                Integer idAluguel = rs.getInt("idAluguel");
                Integer idVeiculo = rs.getInt("idVeiculo");
                Integer idCliente = rs.getInt("idCliente");
                Date dataAluguel = rs.getDate("dataAluguel");
                Date dataEntrega = rs.getDate("dataEntrega");
                String entregueStr = rs.getString("entregue");
                Character entregue = (entregueStr != null && !entregueStr.isEmpty()) ? entregueStr.charAt(0) : null;
                String observacao = rs.getString("observacao");
                Double valorPago = rs.getDouble("valorPago");

                Veiculo veiculo = new Veiculo();
                veiculo.setIdVeiculo(idVeiculo); 

                Cliente cliente = new Cliente();
                cliente.setIdCliente(idCliente); 

                Aluguel aluguel = new Aluguel(idAluguel, veiculo, dataEntrega, dataAluguel, cliente, entregue, observacao, valorPago);

                alugueis.add(aluguel); 
            }
            return alugueis;
        } catch (SQLException e) {
            System.out.println("Erro ao consultar alugueis: " + e.getMessage());
            return Collections.emptyList(); 
        }
    }

}



    
