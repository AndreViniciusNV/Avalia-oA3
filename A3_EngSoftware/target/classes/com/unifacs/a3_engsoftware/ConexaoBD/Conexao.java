package com.unifacs.a3_engsoftware.ConexaoBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    public Connection getConnection() throws SQLException{
        String url = "jdbc:mysql://34.172.84.55:3306/a3modelagem?autoReconnect=true&useSSL=false";
        String user = "root";
        String senha = "1770";
        Connection conexao = DriverManager.getConnection(url,user,senha);
        return conexao;
    }
}

