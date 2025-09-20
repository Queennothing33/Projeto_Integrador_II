package br.com.senac.projeto_integrador_ii.persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class MusicaDAO {

    public void cadastrar(Musica m){
          EntityManager em = JPAUtil.getEntityManager();
          try {
              em.getTransaction().begin();
              em.persist(m);
              em.getTransaction().commit();
          }catch(Exception e){
              em.getTransaction().rollback();
              throw e;
          }
          finally{
              JPAUtil.closeEtityManager();
          }
      }
    
    public void excluir(int id){
      EntityManager em = JPAUtil.getEntityManager();
      try{
          Musica m = em.find(Musica.class, id);
          if(m != null){
              em.getTransaction().begin();
              em.remove(m);
              em.getTransaction().commit();
          }
      }catch(Exception e){
          em.getTransaction().rollback();
          throw e;
      }
      finally{
          JPAUtil.closeEtityManager();
      }
    }
 public List<Musica> buscarPorGenero(String genero) {
        EntityManager em = JPAUtil.getEntityManager();
        List<Musica> lista = new ArrayList<>();
        try {
            TypedQuery<Musica> query = em.createQuery("SELECT m FROM Musica m WHERE m.genero = :genero", Musica.class);
            query.setParameter("genero", genero);
            lista = query.getResultList();
        } finally {
            JPAUtil.closeEtityManager();
        }
        return lista;
    }
    
    public List<Musica> buscarPorGeneroETitulo(String genero, String titulo) {
    EntityManager em = JPAUtil.getEntityManager();
    List<Musica> musicas = null;
    try {
        String jpql = "SELECT m FROM Musica m WHERE m.genero = :genero AND m.titulo LIKE :titulo";
        TypedQuery<Musica> query = em.createQuery(jpql, Musica.class);
        query.setParameter("genero", genero);
        query.setParameter("titulo", "%" + titulo + "%");  // Para buscar parte do título
        musicas = query.getResultList();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        em.close();
    }
    return musicas;
}   
}
