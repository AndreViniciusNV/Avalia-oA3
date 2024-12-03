package com.unifacs.a3_engsoftware.JAVA.Usuario;

import com.unifacs.a3_engsoftware.JAVA.view.Cadastro;
import com.unifacs.a3_engsoftware.JAVA.view.Login;

import java.sql.Connection;
import java.sql.SQLException;

import com.unifacs.a3_engsoftware.ConexaoBD.Conexao;

public class UsuarioController {
    boolean acesso;
    boolean vfsenha;
    Usuario userBD;
    boolean valido;
    boolean validaUsuario;
    boolean validaNome;
    boolean validaEmail;
    boolean validaSenha;
    
    
    public void cadastroUsuario(Cadastro view) throws SQLException{
        Connection conexao = new Conexao().getConnection();
        Usuario novoUsuario = new Usuario(view.getjTextFieldUsuario().getText(),view.getjTextFieldNome().getText(),view.getjTextFieldEmail().getText(),view.getjPasswordFieldSenha().getText());
        UsuarioDAO cadastro = new UsuarioDAO();
        
        valido = novoUsuario.validarCadastro();
        validaUsuario = novoUsuario.validarUsuario();
        validaNome = novoUsuario.validarNome();
        validaEmail = novoUsuario.validarEmail();
        validaSenha = novoUsuario.validarSenha();
        
        if (valido & validaUsuario & validaNome & validaEmail & validaSenha){
            cadastro.cadastrarUsuario(novoUsuario);
        }
    }

    public void loginUsuario(Login view) throws SQLException{
        Connection conexao = new Conexao().getConnection();
        UsuarioDAO login = new UsuarioDAO();
        login.loginUsuario(view.getjTextFieldUsuario().getText(),view.getjPasswordFieldSenha().getText());
        setAcesso(login.getAcesso());
        setVfsenha(login.getVfsenha());
        userBD = login.getUserBD();
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

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }

    public boolean isValidaUsuario() {
        return validaUsuario;
    }

    public void setValidaUsuario(boolean validaUsuario) {
        this.validaUsuario = validaUsuario;
    }

    public boolean isValidaNome() {
        return validaNome;
    }

    public void setValidaNome(boolean validaNome) {
        this.validaNome = validaNome;
    }

    public boolean isValidaEmail() {
        return validaEmail;
    }

    public void setValidaEmail(boolean validaEmail) {
        this.validaEmail = validaEmail;
    }

    public boolean isValidaSenha() {
        return validaSenha;
    }

    public void setValidaSenha(boolean validaSenha) {
        this.validaSenha = validaSenha;
    }
    
}

