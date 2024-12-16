package br.org.fundatec.repository;

import javax.persistence.*;

import br.org.fundatec.exception.VotosException;
import br.org.fundatec.model.Funcionario;
import br.org.fundatec.model.Restaurante;
import br.org.fundatec.model.Voto;
import br.org.fundatec.model.VotoPorRestaurante;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class VotoRepository {

    private EntityManager em;

    public VotoRepository() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TFinalDB");
        em = factory.createEntityManager();
    }

    public void inserir(Voto voto) {
        this.em.getTransaction().begin();
        this.em.merge(voto);
        this.em.getTransaction().commit();
    }

    public void remover(Voto voto) {
        em.getTransaction().begin();
        em.remove(voto);
        em.getTransaction().commit();
    }

    public void atualizar(Voto voto) {
        em.getTransaction().begin();
        em.merge(voto);
        em.getTransaction().commit();
    }

    public List<Voto> listarTodos() {
        TypedQuery<Voto> buscarTodos = this.em.createQuery("select vot from Voto vot", Voto.class);
        return buscarTodos.getResultList();
    }

    public List<Voto> buscarPorId(Long id) {
        Voto voto = em.find(Voto.class, id);
        return voto != null ? Collections.singletonList(voto) : Collections.emptyList();
    }

    public List<VotoPorRestaurante> apuracaoDeVotos() throws VotosException {
        try {
            Calendar hj = Calendar.getInstance();
            hj.set(Calendar.HOUR_OF_DAY, 0);
            hj.set(Calendar.MINUTE, 0);
            hj.set(Calendar.SECOND, 0);
            hj.set(Calendar.MILLISECOND, 0);

            String query =
                    "select new br.org.fundatec.model.VotoPorRestaurante(r.nome, COUNT(r.id)) " +
                            " from Voto v " +
                            " inner join v.restaurante r" +
                            " where v.data = :hj" +
                            " group by r.nome order by r.nome";

            TypedQuery<VotoPorRestaurante> VotoPorRestaurante = this.em.createQuery(query, VotoPorRestaurante.class);
            VotoPorRestaurante.setParameter("hj", hj);

            List<VotoPorRestaurante> resultado = VotoPorRestaurante.getResultList();
            if (resultado.isEmpty()) {
                throw new VotosException("Nenhum voto encontrado para a data de hoje.");
            }

            return resultado;
        } catch (PersistenceException e) {
            throw new VotosException("Erro ao apurar os votos: ");
        }
    }
}




