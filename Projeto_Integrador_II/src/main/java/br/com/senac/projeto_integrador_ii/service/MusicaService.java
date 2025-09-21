package br.com.senac.projeto_integrador_ii.service;

import br.com.senac.projeto_integrador_ii.persistencia.Musica;
import br.com.senac.projeto_integrador_ii.persistencia.MusicaDAO;
import java.util.List;

public class MusicaService {

    private MusicaDAO dao = new MusicaDAO();

    public void cadastrarMusica(Musica m) {
        validarCampos(m);
        dao.cadastrar(m);
    }

    public void excluirMusica(Long id) {
        dao.excluir(id);
    }

    private void validarCampos(Musica m) {
        if (m.getTitulo() == null || m.getTitulo().isBlank()
                || m.getBanda() == null || m.getBanda().isBlank()
                || m.getTom() == null || m.getTom().isBlank()
                || m.getGenero() == null || m.getGenero().isBlank()
                || m.getSemestreIniciado() == null || m.getSemestreIniciado().isBlank()
                || m.getUrl() == null || m.getUrl().isBlank()) {
            throw new IllegalArgumentException("Todos os campos devem ser preenchidos");
        }
    }

    public List<Musica> buscarPorGenero(String genero) {
        return dao.buscarPorGenero(genero);
    }

    public List<Musica> buscarMusicas(String genero, String pesquisa) {
        if (pesquisa == null || pesquisa.isBlank()) {
            return dao.buscarPorGenero(genero);
        } else {
            return dao.buscarPorGeneroETitulo(genero, pesquisa);
        }
    }
}
