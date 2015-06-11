package exemplo3.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import exemplo3.model.Usuario;

public class UsuarioDAO {

	EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("examplePU");
	EntityManager em = factory.createEntityManager();

	public List<Usuario> listarTodos() throws Exception {
		try {
			TypedQuery<Usuario> q = em.createQuery(
					"select usu from Usuario usu", Usuario.class);
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public Usuario consultarPorPK(Long pk) throws Exception {
		try {
			TypedQuery<Usuario> q = em.createQuery(
					"select usu from Usuario usu where usu.id = " + pk,
					Usuario.class);
			return q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void remover(Long pk) throws Exception {
		try {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			
			TypedQuery<Usuario> q = em.createQuery(
					"select usu from Usuario usu where usu.id = " + pk,
					Usuario.class);
			em.remove(q.getSingleResult());
			
			em.flush();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void salvar(Usuario usuario) throws Exception {
		try {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			if(usuario.getId() == null)
				em.persist(usuario);
			else
				em.merge(usuario);
			em.flush();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
