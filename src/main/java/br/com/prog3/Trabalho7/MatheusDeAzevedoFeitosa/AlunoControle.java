package br.com.prog3.Trabalho7.MatheusDeAzevedoFeitosa;

import java.util.List;

import javax.faces.bean.ManagedBean;
@ManagedBean(name = "alunoControle", eager = true)
public class AlunoControle {

	private Integer matricula;
	private String nome;
	private String regiaoAdministrativa;
	private Aluno aluno;
	private String mensagem;

	public void add() {
		Aluno aluno = new Aluno(matricula, nome, regiaoAdministrativa);
		AlunoDAOImp ad = new AlunoDAOImp();
		setMensagem(ad.save(aluno));
		aluno = new Aluno();
	}

	public void edit() {
		Aluno aluno = new Aluno(matricula, nome, regiaoAdministrativa);
		AlunoDAOImp ad = new AlunoDAOImp();
		setMensagem(ad.update(aluno));
		aluno = new Aluno();
	}

	public void delete() {
		AlunoDAOImp ad = new AlunoDAOImp();
		setMensagem(ad.delete(new Aluno(matricula, null, null)));
	}

	public List<Aluno> getAlunos() {
		AlunoDAOImp ad = new AlunoDAOImp();
		return ad.listAll();
	}

	public Aluno findAluno() {
		AlunoDAOImp ad = new AlunoDAOImp();
		aluno = ad.findByMatricula(matricula);
		setMensagem(aluno.toString());
		return aluno;
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

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}