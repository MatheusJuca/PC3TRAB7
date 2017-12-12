package br.com.prog3.Trabalho7.MatheusDeAzevedoFeitosa;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class AlunoDAOImp implements AlunoDAO {

	private Session session;

	@Override
	public String save(Aluno aluno) {
		session = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(aluno);
			session.getTransaction().commit();
			return "Inserido com sucesso.";
		} catch (Exception e) {
			if (session != null)
				session.getTransaction().rollback();
			e.printStackTrace();
			return e.getMessage();
		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public String delete(Aluno aluno) {
		session = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(aluno);
			session.getTransaction().commit();
			return "Excluído com sucesso.";
		} catch (Exception e) {
			if (session != null)
				session.getTransaction().rollback();
			e.printStackTrace();
			return e.getMessage();
		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public String update(Aluno aluno) {
		session = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.update(aluno);
			session.getTransaction().commit();
			return "Alterado com sucesso.";
		} catch (Exception e) {
			if (session != null)
				session.getTransaction().rollback();
			return e.getMessage();
		} finally {
			if (session != null)
				session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Aluno> listAll() {
		List<Aluno> lista = null;
		session = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			lista = session.createQuery("from Aluno").list();
			session.getTransaction().commit();
		} catch (Exception e) {
			if (session != null)
				session.getTransaction().rollback();
			return lista;
		} finally {
			if (session != null)
				session.close();
		}
		return lista;
	}

	@Override
	public Aluno findByMatricula(int matricula) {
		Aluno aluno = null;
		session = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			aluno = (Aluno) session.load(Aluno.class, matricula);
			session.getTransaction().commit();
		} catch (Exception e) {
			if (session != null)
				session.getTransaction().rollback();
		} finally {
			if (session != null)
				session.close();
		}
		return aluno;
	}
}