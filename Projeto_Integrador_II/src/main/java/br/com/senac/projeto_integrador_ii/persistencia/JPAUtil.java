package br.com.senac.projeto_integrador_ii.persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    private static final String PERSISTENCE_UNIT = "ProjetoIntegrador-PU";
    
    private static EntityManagerFactory fabrica;
    
    // Responsável apenas por fornecer a fábrica
    private static EntityManagerFactory getEntityManagerFactory() {
        if (fabrica == null || !fabrica.isOpen()) {
            fabrica = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }
        return fabrica;
    }
    
    // Responsável por criar um novo EntityManager sob demanda
    public static EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }

    public static void closeFactory() {
        if (fabrica != null && fabrica.isOpen()) {
            fabrica.close();
        }
    }
}
