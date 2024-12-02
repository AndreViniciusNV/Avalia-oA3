package com.unifacs.a3_engsoftware.JAVA.Usuario;

public class Usuario {

    private int codUser;
    private String nome;
    private String usuario;
    private String email;
    private String senha;
    private int funcADM;


    public Usuario(String usuario, String nome, String email, String senha){
        this.usuario = usuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    
    public boolean validarCadastro() {
        if (usuario == null || usuario.isEmpty()) {
            return false; // Usuário vazio ou nulo
        }
        if (nome == null || nome.isEmpty()) {
            return false; // Nome vazio ou nulo
        }
        if (email == null || !email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            return false; // E-mail inválido
        }
        if (senha == null || senha.length() < 6) {
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
}
