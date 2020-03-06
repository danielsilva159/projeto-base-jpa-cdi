package com.stefanini.servico;

import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Perfil {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "no_perfil", nullable = false, length = 250)
	private String nome;
	@Column(name = "ds_perfil", nullable = false, length = 1000)
	private String perfil;
	@Column(name = "dt_hora_inclusao", nullable = false)
	private Timestamp hora_inclusao;
	@Column(name = "dt_hora_alteracao", nullable = false)
	private Timestamp hora_alteracao;
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getPerfil() {
		return perfil;
	}
	public Timestamp getHora_inclusao() {
		return hora_inclusao;
	}
	public Timestamp getHora_alteracao() {
		return hora_alteracao;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	public void setHora_inclusao(Timestamp hora_inclusao) {
		this.hora_inclusao = hora_inclusao;
	}
	public void setHora_alteracao(Timestamp hora_alteracao) {
		this.hora_alteracao = hora_alteracao;
	}
	
	
}
