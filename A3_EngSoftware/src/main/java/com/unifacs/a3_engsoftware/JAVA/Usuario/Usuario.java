package com.unifacs.a3_engsoftware.JAVA.Usuario;

public class Usuario {

    private int codUser;
    private String nome;
    private String usuario;
    private String email;
    private String senha;
    private int funcADM;
    
    boolean validaUsuario;
    boolean validaNome;
    boolean validaEmail;
    boolean validaSenha;


    public Usuario(String usuario, String nome, String email, String senha){
        this.usuario = usuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    
    public boolean validarUsuario(){
        if(usuario == null || usuario.isEmpty() || usuario.length() > 10){
            validaUsuario = false;
            return validaUsuario;
        } else {
            validaUsuario = true;
            return validaUsuario;
        }
    }
    
    public boolean validarNome(){
        if(nome == null || nome.isEmpty() || nome.length() > 50){
            validaNome = false;
            return validaNome;
        } else {
            validaNome = true;
            return validaNome;
        }
    }
    
    public boolean validarEmail() {
        if(email == null || !email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            validaEmail = false;
            return validaEmail;
        } else {
            validaEmail = true;
            return validaEmail;
        }
    }
    
   public boolean validarSenha() {
        if (senha == null || senha.length() < 6) {
            validaSenha = false;
            return validaSenha;
        } else {
            validaSenha = true;
            return validaSenha;
        }
    }
    
    public boolean validarCadastro() {
        if (!validarUsuario()) {
            return false; // Usuário vazio ou nulo
        }
        if (!validarNome()) {
            return false; // Nome vazio ou nulo
        }
        if (!validarEmail()) {
            return false; // E-mail inválido
        }
        if (!validarSenha()) {
            return false; // Senha nula ou com menos de 6 caracteres
        }
        return true; // Cadastro válido
    }

    public void mostrarDadosUsuario(){
        System.out.println(nome);
        System.out.println(usuario);
        System.out.println(email);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getCodUser() {
        return codUser;
    }

    public void setCodUser(int codUser) {
        this.codUser = codUser;
    }

    public int getFuncADM() {
        return funcADM;
    }

    public void setFuncADM(int funcADM) {
        this.funcADM = funcADM;
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
