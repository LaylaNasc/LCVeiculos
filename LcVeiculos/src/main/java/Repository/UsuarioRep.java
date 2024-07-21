/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Conexao.Conexao;
import Entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author layla
 */
public class UsuarioRep {
    
     /**
     *
     * @param nome
     * @param cargo
     * @param login
     * @param senha
     * @param email
     */
    
    
public void cadastrarUser(String nome, String cargo, String login, String senha, String email) {
    if (nome.isEmpty() || cargo.isEmpty() || login.isEmpty() || senha.isEmpty() || email.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios.");
        return;
    }

    String sql = "INSERT INTO Usuario (nome, cargo, login, senha, email) VALUES (?, ?, ?, ?, ?)";

    Conexao con = new Conexao();
    Connection conn = null;
    PreparedStatement cadastrarStmt = null;
    ResultSet rs = null;

    try {
        conn = con.connection();

        cadastrarStmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        cadastrarStmt.setString(1, nome);
        cadastrarStmt.setString(2, cargo);
        cadastrarStmt.setString(3, login);
        cadastrarStmt.setString(4, senha);
        cadastrarStmt.setString(5, email);

        int rowsInserted = cadastrarStmt.executeUpdate();

        if (rowsInserted > 0) {
            rs = cadastrarStmt.getGeneratedKeys();
            if (rs.next()) {
                int idGerado = rs.getInt(1); 
                JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso! ID: " + idGerado);
            } else {
                JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar funcionário.");
        }
    } catch (SQLException e) {
        System.out.println("Erro ao cadastrar funcionário: " + e.getMessage());
        JOptionPane.showMessageDialog(null, "Erro ao cadastrar funcionário: " + e.getMessage());
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (cadastrarStmt != null) {
                cadastrarStmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fechar recursos: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao fechar recursos: " + e.getMessage());
        }
    }
}

  
  
public Usuario consultarUsuario(String nomeOuLogin) throws Exception {
    if (nomeOuLogin == null || nomeOuLogin.trim().isEmpty()) {
        throw new Exception("O nome ou login não pode ser nulo ou vazio.");
    }

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        conn = new Conexao().connection();

        String sql = "SELECT * FROM Usuario WHERE idUsuario=? OR login =?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, nomeOuLogin);
        ps.setString(2, nomeOuLogin);

        rs = ps.executeQuery();

        if (!rs.next()) {
            return null; 
        }

        int idUsuario = rs.getInt("idUsuario");
        String nome = rs.getString("nome");
        String cargo = rs.getString("cargo");
        String login = rs.getString("login");
        String senha = rs.getString("senha");
        String email = rs.getString("email");

        Usuario usuario = new Usuario(idUsuario, nome, cargo, login, senha, email);
        System.out.println(usuario.toString());
        return usuario;

    } catch (SQLException sqle) {
        throw new Exception("Erro ao consultar funcionário: " + sqle.getMessage(), sqle);
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
  

public void alterar(Usuario usuario) throws Exception {
    if (usuario == null) {
        throw new Exception("O valor passado não pode ser nulo.");
    }

    Connection conn = null;
    PreparedStatement ps = null;

    try {
        conn = new Conexao().connection();
        
        String SQL = "UPDATE usuario SET nome = ?, cargo = ?, login = ?, senha = ?, email = ? WHERE idUsuario = ?";

        ps = conn.prepareStatement(SQL);
        
        ps.setString(1, usuario.getNome());
        ps.setString(2, usuario.getCargo());
        ps.setString(3, usuario.getLogin());
        ps.setString(4, usuario.getSenha());
        ps.setString(5, usuario.getEmail());
        
        if (usuario.getIdUsuario() != null) {
            ps.setInt(6, usuario.getIdUsuario());
        } else {
            throw new Exception("O ID do funcionário não pode ser nulo.");
        }

        int rowsAffected = ps.executeUpdate();

        if (rowsAffected == 0) {
            throw new Exception("Nenhum funcionário foi atualizado. Verifique o ID do funcionário fornecido.");
        }

    } catch (SQLException sqle) {
        throw new Exception("Erro ao atualizar dados: " + sqle.getMessage(), sqle);
    } finally {
        if (ps != null) {
            ps.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
}





public void excluirUsuario(Usuario usuario) throws Exception {
    if (usuario == null) {
        throw new Exception("O objeto usuário não pode ser nulo.");
    }

    Connection conn = null;
    PreparedStatement ps = null;

    try {
        conn = new Conexao().connection();

        String sql = "DELETE FROM Usuario WHERE idUsuario = ?";
        ps = conn.prepareStatement(sql);

        ps.setInt(1, usuario.getIdUsuario());

        ps.executeUpdate();
    } catch (SQLException sqle) {
        throw new Exception("Erro ao excluir usuário: " + sqle.getMessage(), sqle);
    } finally {
        if (ps != null) {
            ps.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
}

      
}
