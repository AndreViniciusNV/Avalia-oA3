package com.unifacs.a3_engsoftware.JAVA.Usuario;

import java.sql.Connection;
import java.sql.SQLException;

import com.unifacs.a3_engsoftware.ConexaoBD.Conexao;
import com.unifacs.a3_engsoftware.JAVA.Usuario.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {
    boolean acesso;
    boolean vfsenha;
    Usuario userBD;

    public void cadastrarUsuario(Usuario novoUsuario) throws SQLException{
        Connection conexao = new Conexao().getConnection();
        String sql = "INSERT INTO usuarios (usuario, nome, email, senha) VALUES ('"+novoUsuario.getUsuario()+"','"+novoUsuario.getNome()+"','"+novoUsuario.getEmail()+"','"+novoUsuario.getSenha()+"')";
        PreparedStatement statment = conexao.prepareStatement(sql);
        statment.execute();
        conexao.close();
    }

    public void loginUsuario(String usuario, String senha) throws SQLException{
        Connection conexao = new Conexao().getConnection();
        String sql = "SELECT coduser, usuario, nome, senha, email, func_adm FROM usuarios WHERE usuario = '"+usuario+"';";
        PreparedStatement statment = conexao.prepareStatement(sql);
        ResultSet rs = statment.executeQuery();
        
        
        
        if(rs.next()){
            verificarUsuario(rs, senha);
            setAcesso(true);
            
            int coduser = rs.getInt("coduser");
            String user = rs.getString("usuario");
            String nome = rs.getString("nome");
            String senhabd = rs.getString("senha");
            String email = rs.getString("email");
            int func_adm = rs.getInt("func_adm");
            
            userBD = new Usuario(user, nome, email, senhabd);
            userBD.setCodUser(coduser);
            userBD.setFuncADM(func_adm);
            
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

    public Usuario getUserBD() {
        return userBD;
    }

    public void setUserBD(Usuario userBD) {
        this.userBD = userBD;
    }
    
}