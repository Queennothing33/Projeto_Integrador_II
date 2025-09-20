package br.com.senac.projeto_integrador_ii.persistencia;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Musica {
    @Id
    private int id;
    
    private String titulo;
    private String banda;
    private String tom;
    private String genero;
    private String semestre_iniciado;
    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getBanda() {
        return banda;
    }

    public void setBanda(String banda) {
        this.banda = banda;
    }

    public String getTom() {
        return tom;
    }

    public void setTom(String tom) {
        this.tom = tom;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSemestre_iniciado() {
        return semestre_iniciado;
    }

    public void setSemestre_iniciado(String semestre_iniciado) {
        this.semestre_iniciado = semestre_iniciado;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    } 
}
