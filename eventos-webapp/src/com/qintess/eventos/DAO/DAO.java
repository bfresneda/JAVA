package com.qintess.eventos.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Repository
@EnableTransactionManagement
public class DAO {

	@Autowired
	SessionFactory sessionFactory;
	
	
	@Transactional
	public <T> void salvar(T entidade) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.save(entidade);
	}
	
	
	@Transactional
	public <T> void deletar(T entidade){
		
		Session session = this.sessionFactory.getCurrentSession();
		session.remove(entidade);
	}

	
	@Transactional
	public <T> void atualizar(T entidade){
		
		Session session = this.sessionFactory.getCurrentSession();
		session.merge(entidade);
	}

	
	@SuppressWarnings("unchecked")
	@Transactional
	public <T> List<T> buscarTodos(Class<T> nomeClasse){
		
		Session session = this.sessionFactory.getCurrentSession();
		
		return session.createQuery("from " + nomeClasse.getName()).getResultList();
	}

	
	@Transactional
	public <T> T buscarPorId(Class<T> nomeClasse, Integer id){
		Session session = this.sessionFactory.getCurrentSession();
		
		return session.find(nomeClasse, id);
	}
	
	
	
	
}
