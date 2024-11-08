package com.unifacs.a3_engsoftware.JAVA.Usuario;

import com.unifacs.a3_engsoftware.JAVA.view.Cadastro;
import com.unifacs.a3_engsoftware.JAVA.view.Login;

import java.sql.Connection;
import java.sql.SQLException;

import com.unifacs.a3_engsoftware.ConexaoBD.Conexao;

public class UsuarioController {
    boolean acesso;
    boolean vfsenha;
    
    public void cadastroUsuario(Cadastro view) throws SQLException{
        Connection conexao = new Conexao().getConnection();
        Usuario novoUsuario = new Usuario(view.getjTextFieldUsuario().getText(),view.getjTextFieldNome().getText(),view.getjTextFieldEmail().getText(),view.getjPasswordFieldSenha().getText());
        UsuarioDAO cadastro = new UsuarioDAO();
        cadastro.cadastrarUsuario(novoUsuario);
    }

    public void loginUsuario(Login view) throws SQLException{
        Connection conexao = new Conexao().getConnection();
        UsuarioDAO login = new UsuarioDAO();
        login.loginUsuario(view.getjTextFieldUsuario().getText(),view.getjPasswordFieldSenha().getText());
        setAcesso(login.getAcesso());
        setVfsenha(login.getVfsenha());
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
