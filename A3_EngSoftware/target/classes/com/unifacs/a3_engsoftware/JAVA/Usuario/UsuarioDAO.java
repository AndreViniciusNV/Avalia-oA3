package com.unifacs.a3_engsoftware.JAVA.Usuario;

import java.sql.Connection;
import java.sql.SQLException;

import com.unifacs.a3_engsoftware.ConexaoBD.Conexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {
    boolean acesso;
    boolean vfsenha;

    public void cadastrarUsuario(Usuario novoUsuario) throws SQLException{
        Connection conexao = new Conexao().getConnection();
        String sql = "INSERT INTO usuarios (usuario, nome, email, senha) VALUES ('"+novoUsuario.getUsuario()+"','"+novoUsuario.getNome()+"','"+novoUsuario.getEmail()+"','"+novoUsuario.getSenha()+"')";
        PreparedStatement statment = conexao.prepareStatement(sql);
        statment.execute();
        conexao.close();
    }

    public void loginUsuario(String usuario, String senha) throws SQLException{
        Connection conexao = new Conexao().getConnection();
        String sql = "SELECT usuario, senha FROM usuarios WHERE usuario = '"+usuario+"';";
        PreparedStatement statment = conexao.prepareStatement(sql);
        ResultSet rs = statment.executeQuery();
        
        if(rs.next()){
            verificarUsuario(rs, senha);
            setAcesso(true);
        } else {
            setAcesso(false);
        }

        conexao.close();
    }

    public boolean verificarUsuario(ResultSet rs, String senha) throws SQLException{
       String senhaCorreta = rs.getString("senha"); 
        if(senhaCorreta.equals(senha)){
           setVfsenha(true);
        } else {
            setVfsenha(false);
        }
        return vfsenha;
    }

    public boolean getAcesso() {
        return acesso;
    }

    public void setAcesso(boolean acesso) {
        this.acesso = acesso;
    }

    public boolean getVfsenha() {
        return vfsenha;
    }

    public void setVfsenha(boolean vfsenha) {
        this.vfsenha = vfsenha;
    }
}