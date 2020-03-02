package com.stefanini.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_endereco")
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "co_seq_endereco")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "co_seq_pessoa", nullable = false)
	private Pessoa pessoa;
	@Column(name = "ds_logradouro", length = 150)
	private String logradouro;
	@Column(name = "ds_complemento", length = 150)
	private String complemento;
	@Column(name = "ds_bairro", length = 250)
	private String bairro;
	@Column(name = "ds_cidade")
	private String cidade;
	@Column(name = "co_uf")
	private String uf;
	@Column(name = "ds_cep", length = 8)
	private String cep;
	
	public Endereco() {
		
	}
	public Endereco(Pessoa pessoa, String logradouro, String complemento, String bairro, String cidade, String uf,
			String cep) {
		super();
		//this.pessoa = pessoa;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
	}
	public Long getId() {
		return id;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public String getComplemento() {
		return complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public String getUf() {
		return uf;
	}
	public String getCep() {
		return cep;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	
	
}
