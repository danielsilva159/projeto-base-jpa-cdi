package com.stefanini.servico;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.validation.Valid;

import com.stefanini.dao.PessoaDao;
import com.stefanini.model.Pessoa;
import com.stefanini.util.IGenericService;

public class PessoaServico implements IGenericService<Pessoa, Long>{

	

	@Inject
	private PessoaDao pessoaDao;
	
	
	
	@Override
	public Pessoa salvar(@Valid Pessoa pessoa) {
		return pessoaDao.salvar(pessoa);
	}

	@Override
	public Pessoa atualizar(@Valid Pessoa entity) {
		// TODO Auto-generated method stub
		return pessoaDao.atualizar(entity);
	}

	@Override
	public void remover(Long id) {
		pessoaDao.remover(id);
		
	}

	@Override
	public Optional<List<Pessoa>> getList() {
		// TODO Auto-generated method stub
		return pessoaDao.getList();
	}
	//@Override
	public Optional<List<Pessoa>> getList(Boolean situacao) {
		// TODO Auto-generated method stub
		return pessoaDao.getList(situacao);
	}


	@Override
	public Optional<Pessoa> encontrar(Long id) {
		try {
			System.out.println("Entrou aqui");
		} catch (Exception e) {
			e.getMessage();
		}
		return pessoaDao.encontrar(id);
	}

}
