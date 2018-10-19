package br.com.pos.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.pos.model.Produto;
import br.com.pos.utils.EntityManagerFabrica;

public class ProdutoRepository {

	private EntityManager em;

	public ProdutoRepository(){
		em = EntityManagerFabrica.getEntityManager(); 
	}
 
	public List<Produto> listarProdutos(){
		TypedQuery<Produto> query = em.createQuery("SELECT p FROM Produto p ORDER BY p.descricao", Produto.class);
//		return em.createQuery("SELECT p FROM ProdutoEntity p ORDER BY p.descricao").getResultList();
		return query.getResultList();
	}
	
	public Produto getProdutoById(Integer id) {
		return em.find(Produto.class, id);
	}
	
	public Produto salvar(Produto p) {
		em.getTransaction().begin();
		if (p.getId() == null) {
			em.persist(p);
		}else {
			em.merge(p);
		}
		em.getTransaction().commit();
		return p;
	}
}
