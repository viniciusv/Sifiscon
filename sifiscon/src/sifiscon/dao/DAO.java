package sifiscon.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import sifiscon.dao.HibernateJPAUtil;
import sifiscon.modelo.Fornecedor;

public class DAO<T> {

	private final Class<T> classe;

	public DAO(Class<T> classe) {
		this.classe = classe;
	}

	public void adicionar(T t) {

		EntityManager em = new HibernateJPAUtil().getEntityManager();
		em.getTransaction().begin();

		em.persist(t);
		
		em.getTransaction().commit();
		em.close();
	}

	public void remover(T t) {
		EntityManager em = new HibernateJPAUtil().getEntityManager();
		em.getTransaction().begin();

		em.remove(em.merge(t));

		em.getTransaction().commit();
		em.close();
	}

	public void atualizar(T t) {
		EntityManager em = new HibernateJPAUtil().getEntityManager();
		em.getTransaction().begin();

		em.merge(t);

		em.getTransaction().commit();
		em.close();
	}

	public List<T> listar() {
		EntityManager em = new HibernateJPAUtil().getEntityManager();
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));

		List<T> lista = em.createQuery(query).getResultList();

		em.close();
		return lista;
	}

	public Fornecedor buscarPorCnpj(String cnpjParam) {
		EntityManager em = new HibernateJPAUtil().getEntityManager();
		Fornecedor fornecedor;
		try{
		Query query = em.createQuery("select f from Fornecedor as f where f.cnpj = :cnpjParam");
		query.setParameter("cnpjParam", cnpjParam);
		fornecedor = (Fornecedor) query.getSingleResult();
		}catch(NoResultException e){
			System.out.println("Não achou o fornecedor no banco retorna NULL");
			
			fornecedor = null;
		}finally {
			em.close();
		}
		
		
		return fornecedor;
	}
	
	public T buscarId(Integer id) {
		EntityManager em = new HibernateJPAUtil().getEntityManager();
		T instancia = em.find(classe, id);
		em.close();
		return instancia;
	}

	public int contar() {
		EntityManager em = new HibernateJPAUtil().getEntityManager();
		long result = (Long) em.createQuery("select count(n) from livro n")
				.getSingleResult();
		em.close();

		return (int) result;
	}

	public List<T> listarPaginacao(int firstResult, int maxResults) {
		EntityManager em = new HibernateJPAUtil().getEntityManager();
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));

		List<T> lista = em.createQuery(query).setFirstResult(firstResult)
				.setMaxResults(maxResults).getResultList();

		em.close();
		return lista;
	}

}
