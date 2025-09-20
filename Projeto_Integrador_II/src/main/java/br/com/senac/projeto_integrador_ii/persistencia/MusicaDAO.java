package br.com.senac.projeto_integrador_ii.persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class MusicaDAO {

    public void cadastrar(Musica m) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(m);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    public void excluir(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Musica m = em.find(Musica.class, id);
            if (m != null) {
                em.getTransaction().begin();
                em.remove(m);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    public List<Musica> buscarPorGenero(String genero) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<Musica> query = em.createQuery(
                    "SELECT m FROM Musica m WHERE m.genero = :genero", Musica.class);
            query.setParameter("genero", genero);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Musica> buscarPorGeneroETitulo(String genero, String titulo) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            String jpql = "SELECT m FROM Musica m WHERE m.genero = :genero AND m.titulo LIKE :titulo";
            TypedQuery<Musica> query = em.createQuery(jpql, Musica.class);
            query.setParameter("genero", genero);
            query.setParameter("titulo", "%" + titulo + "%");
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
