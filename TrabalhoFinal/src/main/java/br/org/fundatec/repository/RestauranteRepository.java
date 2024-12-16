package br.org.fundatec.repository;

import javax.persistence.*;

import br.org.fundatec.model.Restaurante;
import java.util.List;

public class RestauranteRepository {

    private EntityManager em;

    public RestauranteRepository() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TFinalDB");
        em = factory.createEntityManager();
    }

    public void inserir(Restaurante restaurante){
        em.getTransaction().begin();
        em.merge(restaurante);
        em.getTransaction().commit();
    }

    public void remover(Restaurante restaurante){
        em.getTransaction().begin();
        em.remove(restaurante);
        em.getTransaction().commit();
    }
    public void atualizar(Restaurante restaurante){
        em.getTransaction().begin();
        em.merge(restaurante);
        em.getTransaction().commit();
    }

    public List<Restaurante> listarTodos(){
        TypedQuery<Restaurante> listarTodos = this.em.createQuery("select res from Restaurante res",Restaurante.class);
        return listarTodos.getResultList();
    }

    public Restaurante buscarporId(Integer id) {
        return  this.em.find(Restaurante.class, id);
    }


    public Restaurante buscarPorNome(String nome) {
            TypedQuery<Restaurante> query = this.em.createQuery("select r from Restaurante r where r.nome like :nome", Restaurante.class);
            query.setParameter("nome", nome);

            try {
                return query.getSingleResult();
            } catch (NoResultException e) {
                return null;
            }

        }


}



