package br.com.senac.projeto_integrador_ii.util;

import br.com.senac.projeto_integrador_ii.persistencia.Musica;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MusicaUtilsTest {
    
    @Test
    public void testContarMusicas() {
        List<Musica> musicas = Arrays.asList(
                new Musica(1L, "Música A", "Banda A", "C", "Rock", "2022.1", "urlA"),
                new Musica(2L, "Música B", "Banda B", "G", "Pop", "2023.1", "urlB")
        );

        assertEquals(2, MusicaUtils.contarMusicas(musicas));
    }
    
    @Test
    public void testCalcularMediaSemestre() {
        Musica m1 = new Musica();
        m1.setSemestre_iniciado("2022.1");

        Musica m2 = new Musica();
        m2.setSemestre_iniciado("2023.2");

        Musica m3 = new Musica();
        m3.setSemestre_iniciado("2024.1");

        List<Musica> musicas = Arrays.asList(m1, m2, m3);

        double media = MusicaUtils.calcularMediaSemestre(musicas);

        // (2022.1 + 2023.2 + 2024.1) / 3
        double esperado = (2022.1 + 2023.2 + 2024.1) / 3;

        assertEquals(esperado, media, 0.001);
    }  
}
