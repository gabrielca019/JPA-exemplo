package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Main {

	public static void main(String[] args) {
		//inserirDados();
		//buscarDadosPorId();
		//excluirDadosPorId();
	}
	
	private static void inserirDados() {
		Pessoa p1 = new Pessoa(null, "Gabriel Carvalho", "gc@gmail.com");
		Pessoa p2 = new Pessoa(null, "Kevin Levin", "kevin@gmail.com");
		Pessoa p3 = new Pessoa(null, "Lucas Andrade", "luandrade@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin(); //sempre q tiver uma transação que n seja uma simples consulta, tem que ter o transaction
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();
		System.out.println("Pronto!");
		em.close();
		emf.close();
	}
	
	private static void buscarDadosPorId() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		Pessoa p = em.find(Pessoa.class, 2);
		System.out.println(p);
		
		em.close();
		emf.close();
	}
	
	private static void excluirDadosPorId() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		Pessoa p = em.find(Pessoa.class, 2);
		em.getTransaction().begin();
		em.remove(p);
		System.out.println("Removido!");
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}