/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Conexao.Conexao;
import Entidades.Cliente;
import Views.TelaListaCliente;
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
public class ClienteRep {

    private int id;
    public ResultSet findAll(){
      Connection conn = null;
      Conexao con = new Conexao();
      PreparedStatement pst = null;
      ResultSet rs= null;
        try {
            conn = con.connection();
            pst = conn.prepareStatement("Select * from Cliente");
            rs =pst.executeQuery();
            return rs;
        } catch (SQLException e) {
        }
        return null;
    }
public void cadastrarCliente(Cliente cliente) {
        Connection conn = null;
        Conexao con = new Conexao();
        PreparedStatement cadastrarStmt = null;
        ResultSet generatedKeys = null;

        if (cliente == null) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
            return;
        }

        try {
            conn = con.connection();

            String sql = "INSERT INTO cliente (nome, endereco, uf, telefone, cpf, email) VALUES (?, ?, ?, ?, ?, ?)";

            cadastrarStmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            cadastrarStmt.setString(1, cliente.getNomeCliente());
            cadastrarStmt.setString(2, cliente.getEndereco());
            cadastrarStmt.setString(3, cliente.getUf());
            cadastrarStmt.setString(4, cliente.getTelefone());
            cadastrarStmt.setString(5, cliente.getCpf());
            cadastrarStmt.setString(6, cliente.getEmail());

            
            int rowsAffected = cadastrarStmt.executeUpdate();
            
            if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
            
            TelaListaCliente.getInstancia().atualizarTabelaClientes();
        }

            generatedKeys = cadastrarStmt.getGeneratedKeys();


        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar cliente: " + e.getMessage());
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
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
}
    
public Cliente procurarCliente(String cpf) throws Exception {
    if (cpf == null || cpf.trim().isEmpty()) {
        throw new Exception("O CPF não pode ser nulo ou vazio.");
    }

    Connection conn = null;
    Conexao con = new Conexao();
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        conn = con.connection();

        ps = conn.prepareStatement("SELECT * FROM Cliente WHERE cpf = ? OR idCliente=?");
        ps.setString(1, cpf);
        ps.setString(2, cpf);

        
        rs = ps.executeQuery();

        if (!rs.next()) {
            return null; 
        }

        String nome = rs.getString("nome");
        String endereco = rs.getString("endereco");
        String uf = rs.getString("uf");
        String telefone = rs.getString("telefone");
        String cpf1 = rs.getString("cpf");
        String email = rs.getString("email");
        Integer idCliente = rs.getInt("idCliente");

        Cliente cliente = new Cliente(idCliente, nome, endereco, uf, cpf1, telefone, email);
        return cliente;

    } catch (SQLException sqle) {
        throw new Exception("Erro ao consultar cliente: " + sqle.getMessage(), sqle);
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


public void alterarCliente(Cliente cliente) throws Exception {

    Connection conn = null;
    PreparedStatement ps = null;
    try {
        conn = new Conexao().connection();
        System.out.println(cliente);
    String SQL = "UPDATE cliente SET nome = ?, endereco = ?, uf = ?, email = ?, telefone = ?, cpf = ? WHERE idCliente = ?";
        ps = conn.prepareStatement(SQL);
        ps.setString(1, cliente.getNomeCliente());
        ps.setString(2, cliente.getEndereco());
        ps.setString(3, cliente.getUf());
        ps.setString(4, cliente.getEmail());
        ps.setString(5, cliente.getTelefone());
        ps.setString(6, cliente.getCpf());
        ps.setInt(7, cliente.getIdCliente());
        int rowsAffected = ps.executeUpdate();


        if (rowsAffected == 0) {
            throw new Exception("Nenhum cliente foi atualizado. Verifique o CPF fornecido: " + cliente.getCpf());
        }

    } catch (SQLException sqle) {
        throw new Exception("Erro ao atualizar dados do cliente: " + sqle.getMessage(), sqle);
    } finally {
        if (ps != null) {
            ps.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
}


public void excluir(Cliente cliente) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        PreparedStatement psVerificar = null;
        ResultSet rs = null;

        try {
            conn = new Conexao().connection();

            String verificarSql = "SELECT COUNT(*) AS count FROM aluguel WHERE idCliente = (SELECT idCliente FROM cliente WHERE cpf = ?) AND entregue = 'N'";
            psVerificar = conn.prepareStatement(verificarSql);
            psVerificar.setString(1, cliente.getCpf());
            rs = psVerificar.executeQuery();

            if (rs.next()) {
            int count = rs.getInt("count");
            if (count > 0) {
                throw new Exception("Não é possível excluir o cliente, há veículo que não foi entregue.");
            }
        }

           
            ps = conn.prepareStatement("DELETE FROM cliente WHERE cpf = ?");
            ps.setString(1, cliente.getCpf());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected == 0) {
                throw new Exception("Nenhum cliente foi excluído com o CPF fornecido.");
            } else {
                TelaListaCliente.getInstancia().atualizarTabelaClientes();
            }

        } catch (SQLException sqle) {
            throw new Exception("Erro ao excluir dados: " + sqle.getMessage(), sqle);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (psVerificar != null) {
                psVerificar.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }


public List<Cliente> listarClientes() {
    try (Connection conn = new Conexao().connection();
         PreparedStatement ps = conn.prepareStatement("SELECT nome, endereco, uf, cpf, telefone, email FROM Cliente");
         ResultSet rs = ps.executeQuery()) {

        List<Cliente> clientes = new ArrayList<>();
        while (rs.next()) {
            String nome = rs.getString("nome");
            String endereco = rs.getString("endereco");
            String uf = rs.getString("uf");
            String cpf = rs.getString("cpf");
            String telefone = rs.getString("telefone");
            String email = rs.getString("email");
            clientes.add(new Cliente(null, nome, endereco, uf, cpf, telefone, email)); 
        }
        return clientes;
    } catch (SQLException e) {
        return Collections.emptyList(); 
    }
}


}






