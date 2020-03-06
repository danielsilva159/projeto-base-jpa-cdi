package com.stefanini.servico;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.stefanini.model.Pessoa;

@Entity
public class PessoaPerfil {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "co_seq_pessoal_perfil")
	private Long id;
	@ManyToOne
	@JoinColumn(name = "co_seq_pessoa")
	private Pessoa pessoa;
	@ManyToOne
	@JoinColumn(name = "co_seq_perfil")
	private Perfil perfil;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	

}
