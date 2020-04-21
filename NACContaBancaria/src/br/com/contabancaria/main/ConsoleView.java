package br.com.contabancaria.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.contabancaria.dao.impl.BancoDAOImpl;
import br.com.contabancaria.entity.Agencia;
import br.com.contabancaria.entity.Banco;
import br.com.contabancaria.entity.Ceo;
import br.com.contabancaria.entity.Cliente;
import br.com.contabancaria.entity.ContaBancaria;
import br.com.contabancaria.entity.Genero;
import br.com.contabancaria.exception.ErroCommitException;
import br.com.contabancaria.singleton.EntityManagerFactorySingleton;

public class ConsoleView {

	public static void main(String[] args) {
		// Instanciar fabrica que cria o Manager
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager manager = fabrica.createEntityManager();
		
		Ceo ceo = new Ceo("Thiaguinho", Genero.MASCULINO, 27, 1000.00);
		
		Banco banco = new Banco("Banquinho Feliz", "BF LTDA", 99991111, 00000001, ceo);
		
		Agencia agencia = new Agencia("Agencia 01", "Av dos Patos 0101", 22244000);
		
		banco.addAgencias(agencia);
		banco.addAgencias(new Agencia("Agencia 02", "Av das Galinhas 0202", 40028922));
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(new Cliente("Carlinhos", "emaildocarlinhos@gmail.com", 1000.00, "Av dos Gatos 0303", 12345678));
		clientes.add(new Cliente("Toninho", "emaildotoninho@gmail.com", 1000.00, "Av dos Jabutis 0404", 87654321));
		
		agencia.addContas(new ContaBancaria(10000.00, Calendar.getInstance(), agencia, clientes));
		agencia.addContas(new ContaBancaria(1234.56, Calendar.getInstance(), agencia, clientes));
		
		BancoDAOImpl dao = new BancoDAOImpl(manager);
		
		try {
			dao.create(banco);
			dao.commit();
			System.out.println("Cadastro realizado com sucesso");
		} catch(ErroCommitException excecao) {
			excecao.printStackTrace();
			System.out.println("Erro no commit");
		}
		
		manager.close();
		fabrica.close();
	}

}
