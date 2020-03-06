package com.stefanini.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.Valid;

import com.stefanini.dao.abstracao.GenericDao;
import com.stefanini.model.Pessoa;

public class PessoaDao extends GenericDao<Pessoa, Long> {

	public PessoaDao() {
		super();
	}
	
	/*public Optional<List<Pessoa>> getList() {
		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Pessoa> query = builder.createQuery(Pessoa.class);
		Root<Pessoa> root = query.from(Pessoa.class);
		query.where(builder.equal(root.get("nome"), "Daniel"));
		return Optional.of(getEntityManager().createQuery(query).getResultList());
	}*/
	
	public Optional<List<Pessoa>> getList(Boolean situacao) {
		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Pessoa> query = builder.createQuery(Pessoa.class);
		Root<Pessoa> root = query.from(Pessoa.class);
		Path<Boolean> path = root.<Boolean>get("situacao");
		Predicate predicate = builder.equal(path, situacao);
		query.where(predicate);
		TypedQuery<Pessoa> typedQuery = getEntityManager().createQuery(query);
		return Optional.of(typedQuery.getResultList());
	}
	
	public Optional<Pessoa> encontrar(Long id) {
		return Optional.of(getEntityManager().find(Pessoa.class, id));
	}
	
}
