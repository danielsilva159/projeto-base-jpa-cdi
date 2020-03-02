package com.stefanini.teste;

import java.time.LocalDate;
import java.util.List;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.stefanini.dao.PessoaDao;
import com.stefanini.model.Endereco;
import com.stefanini.model.Pessoa;
import com.stefanini.servico.PessoaServico;


public class App {


	@Inject
	private PessoaServico pessoaServico;
	
	
	public static void main(String[] args) {
		//CONFIGURACAO PARA INICIAR O CONTAINER PARA GERENCIAMENTO DO CDI
		SeContainerInitializer initializer = SeContainerInitializer.newInstance();
		try (final SeContainer container = initializer.initialize()) {
			App app = container.select(App.class).get();
			app.buscarPorId();
		}
	}


	public void executar() {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Daniel3");
		pessoa.setDataNascimento(LocalDate.of(1991, 12, 27));
		pessoa.setEmail("daniel@email.com");
		pessoa.setSituacao(true);
		Endereco endereco = new Endereco();
		endereco.setLogradouro("Quadra 01");
		endereco.setComplemento("Perto do Conjunto");
		endereco.setBairro("Plano Piloto");
		endereco.setCidade("Brasília");
		endereco.setUf("DF");
		endereco.setCep("72000000");
		endereco.setPessoa(pessoa);
		
		pessoa.getEnderecos().add(endereco);
		
		pessoaServico.salvar(pessoa);
	}
	
	
	public void buscarPorId() {
		List<Pessoa> pessoa = pessoaServico.encontrar(1L);
	}

}
