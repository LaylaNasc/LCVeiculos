/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author layla
 */
public class Conexao {
    
    private static final String URL = "jdbc:mysql://localhost:3306/locafacil";
    private static final String USUARIO = "root";
    private static final String SENHA = "123456";
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

    public Connection connection() throws SQLException {
        Connection conn;
        conn = null;

        try {
            Class.forName(DRIVER_NAME);

            conn = DriverManager.getConnection(URL, USUARIO, SENHA);

            System.out.println("Conexão com o banco de dados estabelecida com sucesso.");

            return conn;
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco de dados: " + e.getMessage());
            
        }
        
        return null;
    }

    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}