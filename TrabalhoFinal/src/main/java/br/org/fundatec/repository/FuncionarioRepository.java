package br.org.fundatec.repository;

import javax.persistence.*;

import br.org.fundatec.model.Funcionario;
import br.org.fundatec.model.Restaurante;

import java.util.List;

public class FuncionarioRepository {

    private EntityManager em;

    public FuncionarioRepository() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TFinalDB");
        em = factory.createEntityManager();
    }

    public void inserir(Funcionario funcionario) {
        em.getTransaction().begin();
        em.merge(funcionario);
        em.getTransaction().commit();
    }

    public void remover(Funcionario funcionario) {
        em.getTransaction().begin();
        em.remove(funcionario);
        em.getTransaction().commit();
    }

    public void atualizar(Funcionario funcionario) {
        em.getTransaction().begin();
        em.merge(funcionario);
        em.getTransaction().commit();
    }

    public List<Funcionario> listarTodos() {
        TypedQuery<Funcionario> listarTodos = this.em.createQuery("select fun from Funcionario fun", Funcionario.class);
        return listarTodos.getResultList();
    }

    public Funcionario buscarporId(Integer id) {
        return this.em.find(Funcionario.class, id);
    }

    public Funcionario buscarPorNome(String nome) {
        TypedQuery<Funcionario> query = this.em.createQuery("select f from Funcionario f where f.nome like :nome", Funcionario.class);
        query.setParameter("nome", nome);

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
