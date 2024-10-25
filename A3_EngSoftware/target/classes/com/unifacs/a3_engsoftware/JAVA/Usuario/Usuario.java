package com.unifacs.a3_engsoftware.JAVA.Usuario;

public class Usuario {

    private String nome;
    private String usuario;
    private String email;
    private String senha;


    public Usuario(String usuario, String nome, String email, String senha){
        this.usuario = usuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
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

}
