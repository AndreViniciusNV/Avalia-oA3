package com.unifacs.a3_engsoftware.ConexaoBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    public Connection getConnection() throws SQLException{
        String url = "jdbc:mysql://a3software.chma4o4yswm7.sa-east-1.rds.amazonaws.com:3355/A3ENGSOFTWARE?autoReconnect=true&useSSL=false";
        String user = "admin";
        String senha = "asBBE325a23";
        Connection conexao = DriverManager.getConnection(url,user,senha);
        return conexao;
    }
}

