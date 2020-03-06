package com.stefanini.teste;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
import com.stefanini.servico.Perfil;
import com.stefanini.servico.PessoaServico;


public class App {


	@Inject
	private PessoaServico servico;
	
	
	public static void main(String[] args) {
		//CONFIGURACAO PARA INICIAR O CONTAINER PARA GERENCIAMENTO DO CDI
		SeContainerInitializer initializer = SeContainerInitializer.newInstance();
		try (final SeContainer container = initializer.initialize()) {
			App app = container.select(App.class).get();
			app.executar();
		}
	}
	
	public void executar() {
		//encontrar();
		buscarTodos();
		//salvar();
	}
		


	private void salvar(){
		for(int i = 0; i < 10; i++) {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Daniel"+i);
		pessoa.setDataNascimento(LocalDate.of(1991, 12, 27));
		pessoa.setEmail("daniel"+i+"@email.com");
		if(i%2==0) {
		pessoa.setSituacao(true);
		}else {
			pessoa.setSituacao(false);
		}
		Endereco endereco = new Endereco();
		endereco.setLogradouro("Quadra "+i);
		endereco.setComplemento("Perto do Conjunto"+i);
		endereco.setBairro("Plano Piloto");
		endereco.setCidade("Brasília");
		endereco.setUf("DF");
		endereco.setCep("7200000"+i);
		endereco.setPessoa(pessoa);
		pessoa.getEnderecos().add(endereco);
		servico.salvar(pessoa);
		}
		//Perfil perfil = new Perfil();
	//	perfil.setNome("Administrador");
	//	perfil.setPerfil("Dono do sistema");
		
		
		
	}
	
	
	private void encontrar() {
		Optional<Pessoa> pessoa = servico.encontrar(1L);
		if (pessoa.isPresent()) {
			System.out.println("Pessoa encontrada");
			System.out.println(pessoa.get());
		} else {
			System.out.println("Pessoa não encontrada");
		}

}
	private void buscarTodos() {
		servico.getList(true).ifPresent(i -> {
			i.forEach(b -> {
				System.out.println(b.getEnderecos());
				System.out.println(b);
			});
		});
//		System.out.println();
	}
	
}
