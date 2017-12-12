package br.com.prog3.Trabalho7.MatheusDeAzevedoFeitosa;

import java.util.List;
public interface AlunoDAO {

	public String save(Aluno aluno);

	public String delete(Aluno aluno);

	public String update(Aluno aluno);

	public List<Aluno> listAll();

	public Aluno findByMatricula(int matricula);

}
