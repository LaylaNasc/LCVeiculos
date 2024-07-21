/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.lc.lcveiculos;

import Conexao.Conexao;
import Views.Login;
import java.sql.Connection;
import java.sql.SQLException;



/**
 *
 * @author layla
 */
public class LcVeiculos {

    public static void main(String[] args) throws SQLException {
       Conexao con = new Conexao();
        Connection connection = con.connection();
        Login login = new Login();
     login.setVisible(true);
        
    }
}
