package com.stefanini.servico;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.validation.Valid;

import com.stefanini.dao.EnderecoDao;
import com.stefanini.model.Endereco;
import com.stefanini.util.IGenericService;

public class EnderecoServico implements IGenericService<Endereco, Long> {


		

		@Inject
		private EnderecoDao enderecoDao;
		
		
		
		@Override
		public Endereco salvar(@Valid Endereco endereco) {
			
			return enderecoDao.salvar(endereco);
		}

		@Override
		public Endereco atualizar(@Valid Endereco entity) {
			// TODO Auto-generated method stub
			return enderecoDao.atualizar(entity);
		}

		@Override
		public void remover(Long id) {
			enderecoDao.remover(id);
			
		}

		@Override
		public Optional<List<Endereco>> getList() {
			// TODO Auto-generated method stub
			return enderecoDao.getList();
		}

		@Override
		public Optional<Endereco> encontrar(Long id) {
			// TODO Auto-generated method stub
			return enderecoDao.encontrar(id);
		}

	}

