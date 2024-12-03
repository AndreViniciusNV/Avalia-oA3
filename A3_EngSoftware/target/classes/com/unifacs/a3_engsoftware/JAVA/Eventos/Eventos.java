package com.unifacs.a3_engsoftware.JAVA.Eventos;

public class Eventos {
    int codevento;
    String evento;
    String endereco;
    String descricao;
    int numVagas;
    int codCategoria;
    String categoria;
    int numVagasDisponiveis;
    
    
    public Eventos(int codevento, String evento, String endereco, String descricao, int numVagas, int codCategoria, String categoria, int numVagasDisponiveis){
        this.codevento = codevento;
        this.evento = evento;
        this.endereco = endereco;
        this.descricao = descricao;
        this.numVagas = numVagas;
        this.codCategoria = codCategoria;
        this.categoria = categoria;
        this.numVagasDisponiveis = numVagasDisponiveis;
    }
  
    
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCodevento() {
        return codevento;
    }

    public void setCodevento(int codevento) {
        this.codevento = codevento;
    }

    public int getNumVagas() {
        return numVagas;
    }

    public void setNumVagas(int numVagas) {
        this.numVagas = numVagas;
    }
    
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getNumVagasDisponiveis() {
        return numVagasDisponiveis;
    }

    public void setNumVagasDisponiveis(int numVagasDisponiveis) {
        this.numVagasDisponiveis = numVagasDisponiveis;
    }

    public int getCodCategoria() {
        return codCategoria;
    }
    
    public void setCodCategoria(int codCategoria) {
        this.codCategoria = codCategoria;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

}
