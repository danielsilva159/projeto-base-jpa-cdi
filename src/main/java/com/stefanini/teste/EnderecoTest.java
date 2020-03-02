package com.stefanini.teste;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.stefanini.model.Endereco;
import com.stefanini.model.Pessoa;

public class EnderecoTest {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("post");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Pessoa pessoa = new Pessoa("Daniel", "daniel@email.com", LocalDate.of(1991, 12, 27), Boolean.TRUE);
		Endereco endereco = new Endereco(pessoa,"Lote 15", "Casa 32", "Taguatinga", "Brasilia", "DF", "7200000");
		//em.persist(entity);
	}
}
