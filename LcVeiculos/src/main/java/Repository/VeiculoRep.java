/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Conexao.Conexao;
import Entidades.Veiculo;
import Views.TelaListarVeiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author layla
 */
public class VeiculoRep {

    public ResultSet findAll(){
      Connection conn = null;
      Conexao con = new Conexao();
      PreparedStatement pst = null;
      ResultSet rs= null;
        try {
            conn = con.connection();
            pst = conn.prepareStatement("Select * from Veiculo");
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException e) {
        }
        return null;
    }
    
    
    public Integer cadastrarveiculo(Veiculo veiculo ){
    Connection conn = null;
        Conexao con = new Conexao();
        PreparedStatement cadastrarStmt = null;
        ResultSet generatedKeys = null;

        if (veiculo == null) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
            return null;
        }

        try {
            Integer idVeiculo = null;
            conn = con.connection();

            String sql = "INSERT INTO veiculo (placa, fabricante, modelo, anoModelo, qtdPortas, acessorios) VALUES (?, ?, ?, ?, ?, ?)";

            cadastrarStmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            cadastrarStmt.setString(1, veiculo.getPlaca());
            cadastrarStmt.setString(2, veiculo.getFabricante());
            cadastrarStmt.setString(3, veiculo.getModelo());
            cadastrarStmt.setInt(4, veiculo.getAnoModelo());
            cadastrarStmt.setInt(5, veiculo.getQtdPortas());
            cadastrarStmt.setString(6, veiculo.getAcessorios());

            cadastrarStmt.executeUpdate();

            generatedKeys = cadastrarStmt.getGeneratedKeys();

            if (generatedKeys.next()) {
                idVeiculo = generatedKeys.getInt(1);

                JOptionPane.showMessageDialog(null, "Veículo cadastrado com sucesso! ID do veículo: " + idVeiculo);
                TelaListarVeiculo.getInstancia().atualizarTabelaVeiculos();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao obter ID do veículo cadastrado.");
            }
     return idVeiculo;
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar o veículo: " + e.getMessage());
            
        } finally {
            try {
                if (generatedKeys != null) {
                    generatedKeys.close();
                }
                if (cadastrarStmt != null) {
                    cadastrarStmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao fechar os recursos: " + e.getMessage());
            }
        }
        return null;
    }
   

    public Veiculo consultarVeiculo(String idOuPlaca) throws Exception {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        conn = new Conexao().connection();

        String sql = "SELECT * FROM Veiculo WHERE idVeiculo = ? OR placa = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, idOuPlaca);
        ps.setString(2, idOuPlaca);
        rs = ps.executeQuery();

        if (!rs.next()) {
            throw new Exception("Nenhum veículo encontrado com o ID ou placa: " + idOuPlaca);
        }

        Integer idVeiculo = rs.getInt("idVeiculo");
        String placa = rs.getString("placa");
        String fabricante = rs.getString("fabricante");
        String modelo = rs.getString("modelo");
        int anoModelo = rs.getInt("anoModelo");
        int qtdPortas = rs.getInt("qtdPortas");
        String acessorios = rs.getString("acessorios");

        Veiculo veiculo = new Veiculo(idVeiculo, placa, fabricante, modelo, anoModelo, qtdPortas, acessorios);
        System.out.println(veiculo.toString());
        return veiculo;

    } catch (SQLException sqle) {
        throw new Exception("Erro ao consultar veículo: " + sqle.getMessage(), sqle);
    } finally {
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
}


   
    public void excluirVeiculo(int idVeiculo) throws Exception {
    
    if (idVeiculo <= 0) {
        throw new IllegalArgumentException("O ID do veículo deve ser um número positivo.");
    }

    Connection conn = null;
    PreparedStatement psExcluir = null;  
    PreparedStatement psVerificar = null; 
    ResultSet rs = null;  

    try {
        conn = new Conexao().connection();

        String verificarSql = "SELECT COUNT(*) AS count FROM aluguel WHERE idVeiculo = ? AND entregue = 'N'";
        psVerificar = conn.prepareStatement(verificarSql);
        psVerificar.setInt(1, idVeiculo);
        rs = psVerificar.executeQuery();

        if (rs.next()) {
            int count = rs.getInt("count");
            if (count > 0) {
                throw new Exception("Não é possível excluir o veículo, ele ainda não foi entregue.");
            }
        }

        String excluirSql = "DELETE FROM veiculo WHERE idVeiculo = ?";
        psExcluir = conn.prepareStatement(excluirSql);
        psExcluir.setInt(1, idVeiculo);
        psExcluir.executeUpdate(); 

    } catch (SQLException sqle) {
        throw new Exception("Erro ao excluir veículo: " + sqle.getMessage(), sqle);
    } finally {
        if (rs != null) {
            rs.close();
        }
        if (psVerificar != null) {
            psVerificar.close();
        }
        if (psExcluir != null) {
            psExcluir.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
}



    public void alterarVeiculo(Veiculo veiculo) throws Exception {
    if (veiculo == null || veiculo.getIdVeiculo() == null) {
        throw new Exception("O veículo ou o ID do veículo não pode ser nulo.");
    }

    Connection conn = null;
    PreparedStatement ps = null;

    try {
        conn = new Conexao().connection();

        String sql = "UPDATE Veiculo SET placa = ?, fabricante = ?, modelo = ?, anoModelo = ?, qtdPortas = ?, acessorios = ? " +
                     "WHERE idVeiculo = ?";

        ps = conn.prepareStatement(sql);
        ps.setString(1, veiculo.getPlaca());
        ps.setString(2, veiculo.getFabricante());
        ps.setString(3, veiculo.getModelo());
        ps.setInt(4, veiculo.getAnoModelo());
        ps.setInt(5, veiculo.getQtdPortas());
        ps.setString(6, veiculo.getAcessorios());
        ps.setInt(7, veiculo.getIdVeiculo());

        int rowsAffected = ps.executeUpdate();
        if (rowsAffected == 0) {
            throw new Exception("Nenhum veículo foi atualizado. Verifique o ID do veículo fornecido.");
        }

    } catch (SQLException sqle) {
        throw new Exception("Erro ao alterar veículo: " + sqle.getMessage(), sqle);
    } finally {
        if (ps != null) {
            ps.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
}

  
    
    public List<Veiculo> listarVeiculos() {
     try (Connection conn = new Conexao().connection();
             PreparedStatement ps = conn.prepareStatement("SELECT idVeiculo, placa, fabricante, modelo, anoModelo, qtdPortas, acessorios FROM veiculo");
             ResultSet rs = ps.executeQuery()) {

            List<Veiculo> veiculos = new ArrayList<>();
            while (rs.next()) {
                Integer idVeiculo = rs.getInt("idVeiculo");
                String placa = rs.getString("placa");
                String fabricante = rs.getString("fabricante");
                String modelo = rs.getString("modelo");
                Integer anoModelo = rs.getInt("anoModelo");
                Integer qtdPortas = rs.getInt("qtdPortas");
                String acessorios = rs.getString("acessorios");

                veiculos.add(new Veiculo(idVeiculo, placa, fabricante, modelo, anoModelo, qtdPortas, acessorios)); 
            }
            return veiculos;
        } catch (SQLException e) {
            System.out.println("Erro ao consultar veículos: " + e.getMessage());
            return Collections.emptyList(); 
    }
}
   
}    
   

