package br.com.senac.projeto_integrador_ii.persistencia;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID gerado automaticamente
    private Long id;

    private String titulo;
    private String banda;
    private String tom;
    private String genero;
    private String semestreIniciado;
    private String url;

    // Construtor vazio exigido pelo JPA
    public Musica() {
    }

    public Musica(String titulo, String banda, String tom, String genero, String semestreIniciado, String url) {
        this.titulo = titulo;
        this.banda = banda;
        this.tom = tom;
        this.genero = genero;
        this.semestreIniciado = semestreIniciado;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSemestreIniciado() {
        return semestreIniciado;
    }

    public void setSemestreIniciado(String semestreIniciado) {
        this.semestreIniciado = semestreIniciado;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isDoGenero(String generoBuscado) {
        return this.genero != null && this.genero.equalsIgnoreCase(generoBuscado);
    }
    
}
