package br.com.pos.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.pos.model.Pessoa;
import br.com.pos.model.Produto;
import br.com.pos.utils.EntityManagerFabrica;

public class PessoaRepository {
	
	
	private EntityManager em;
	
	public PessoaRepository() {
		em = EntityManagerFabrica.getEntityManager(); 
	}
	
	@SuppressWarnings("unchecked")
	public List<Pessoa> listarPessoas(){
		return  em.createQuery("SELECT p FROM Pessoa p join fetch p.endereco e").getResultList();
	}

	public Pessoa salvar(Pessoa p) {
		em.getTransaction().begin();
		if (p.getId() == null || p.getId() == 0) {
			em.persist(p);
		}else {
			em.merge(p);
		}
		em.getTransaction().commit();
		return p;
	}
	
	public Pessoa findPessoaById(Integer id) {
		return em.find(Pessoa.class, id);
	}
	
	public void excluir(Integer id) {

		Pessoa pessoa = findPessoaById(id);
 
		em.getTransaction().begin();
		em.remove(pessoa);
		em.getTransaction().commit();
	}
	
}
