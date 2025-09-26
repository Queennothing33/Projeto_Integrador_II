package br.com.senac.projeto_integrador_ii.util;

import br.com.senac.projeto_integrador_ii.persistencia.Musica;
import java.util.List;

public class MusicaUtils {
    /**
     * Conta quantas músicas existem na lista.
     */
    public static int contarMusicas(List<Musica> musicas) {
        if (musicas == null) return 0;
        return musicas.size();
    }

    /**
     * Calcula a média do semestre iniciado de todas as músicas.
     */
    public static double calcularMediaSemestre(List<Musica> musicas) {
        if (musicas == null || musicas.isEmpty()) return 0.0;

        double soma = 0.0;
        int contador = 0;

        for (Musica m : musicas) {
            try {
                soma += Double.parseDouble(m.getSemestre_iniciado());
                contador++;
            } catch (NumberFormatException e) {
                // ignora valores inválidos
            }
        }

        return contador > 0 ? soma / contador : 0.0;
    }
}
