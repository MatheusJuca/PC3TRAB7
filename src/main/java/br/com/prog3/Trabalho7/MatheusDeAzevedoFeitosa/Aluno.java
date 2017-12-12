package br.com.prog3.Trabalho7.MatheusDeAzevedoFeitosa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "aluno")
@Proxy(lazy = false)
public class Aluno implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "matricula")
	private Integer matricula;
	@Column(name = "nome")
	private String nome;
	@Column(name = "ra")
	private String regiaoAdministrativa;

	public Aluno() {
	}

	public Aluno(Integer matricula, String nome, String regiaoAdministrativa) {
		this.matricula = matricula;
		this.nome = nome;
		this.regiaoAdministrativa = regiaoAdministrativa;
	}

	@Override
	public String toString() {
		return "Matricula: " + matricula + "\nNOME: " + nome + "\nRA: " + regiaoAdministrativa;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRegiaoAdministrativa() {
		return regiaoAdministrativa;
	}

	public void setRegiaoAdministrativa(String regiaoAdministrativa) {
		this.regiaoAdministrativa = regiaoAdministrativa;
	}

}