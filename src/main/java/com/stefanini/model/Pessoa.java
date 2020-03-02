package com.stefanini.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_PESSOA")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "co_seq_pessoa")
	private Long id;
//	@NotNull(message = "Nome da Pessoa nao pode ser nulo")
	@Column(name = "no_nome", length = 400)
	private String nome;
	@Email
	@NotNull
	@Column(name = "ds_email", length = 200)
	private String email;
	@Column(name = "dt_nascimento")
	private LocalDate dataNascimento;
	@Column(name = "st_pessoa")
	private Boolean situacao;
	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
	private List<Endereco> enderecos = new ArrayList<>();

	public Pessoa() {
//		System.out.println("CHAMEI");
	}

	public Pessoa(String nome, String email, LocalDate dataNascimento, Boolean situacao) {
		super();
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.situacao = situacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Boolean getSituacao() {
		return situacao;
	}

	public void setSituacao(Boolean situacao) {
		this.situacao = situacao;
	}
	

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	@Override
	public String toString() {
		return "Pessoa [getNome()=" + getNome() + ", getEmail()=" + getEmail() + ", getDataNascimento()="
				+ getDataNascimento() + ", getSituacao()=" + getSituacao() + "]";
	}

}
