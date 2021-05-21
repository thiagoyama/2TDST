package br.com.fiap.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.ReservaDAO;
import br.com.fiap.dao.TransporteDAO;
import br.com.fiap.dao.impl.CidadeDAOImpl;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.impl.ReservaDAOImpl;
import br.com.fiap.dao.impl.TransporteDAOImpl;
import br.com.fiap.entity.Cidade;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Reserva;
import br.com.fiap.entity.Transporte;
import br.com.fiap.singleton.EntityManagerFactorySingleton;
import br.com.fiap.util.DataUtil;

public class Pesquisa {

	public static void main(String[] args) {
		//Obter um Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Instanciar uma CidadeDao
		CidadeDAO cidadeDao = new CidadeDAOImpl(em);
		
		//Exibir todas as cidades 
		List<Cidade> cidades = cidadeDao.listar();
		System.out.println("Listar todas as cidades");
		for (Cidade cidade : cidades) {
			System.out.println(cidade.getNome());
		}
		
		//Pesquisar as cidades por Estado
		cidades = cidadeDao.buscarPorEstado("SP");
		System.out.println("Buscar cidade por estado");
		cidades.forEach(c -> System.out.println(c.getNome() + " - " + c.getUf()));
		
		//Instanciar o ClienteDAO
		ClienteDAO clienteDao = new ClienteDAOImpl(em);
		
		//Listar todos os clientes
		List<Cliente> clientes = clienteDao.listar();
		System.out.println("Listar todos os clientes");
		clientes.forEach(c -> System.out.println(c.getNome()));
		
		//Pesquisar cliente por parte do nome
		clientes = clienteDao.buscarPorNome("Pa");
		System.out.println("Buscar clientes por parte do nome");
		clientes.forEach(c -> System.out.println(c.getNome()));
		
		//Instanciar um PacoteDAO e TransporteDAO
		PacoteDAO pacoteDao = new PacoteDAOImpl(em);
		TransporteDAO transporteDao = new TransporteDAOImpl(em);
		
		//Pesquisar um transporte por id
		Transporte transporte = transporteDao.pesquisar(2);
		
		//Pesquisar pacotes por transporte
		List<Pacote> pacotes = pacoteDao.buscarPorTransporte(transporte);
		System.out.println("Buscar pacotes por transporte");
		pacotes.forEach(p -> System.out.println(p.getDescricao() + " " + p.getTransporte().getEmpresa()));
		
		//Pesquisar cliente por estado
		clientes = clienteDao.buscarPorEstado("BA");
		System.out.println("Buscar clientes por estado");
		clientes.forEach(c -> System.out.println(c.getNome() + " " + c.getEndereco().getCidade().getUf()));
		
		//Buscar clientes por quantidade de dias de reserva
		clientes = clienteDao.buscarPorDiasReservas(10);
		System.out.println("Buscar clientes por qtd de dias de reserva");
		clientes.forEach(c -> System.out.println(c.getNome()));
		
		//Listar clientes com paginação
		clientes = clienteDao.listar(2, 4);
		System.out.println("Listar clientes com paginação");
		clientes.forEach(c -> System.out.println(c.getNome()));
		
		//Buscar pacotes por preço menor, retornando uma lista de vetor de objetos
		List<Object[]> listaObjetos = pacoteDao.buscarPorPrecoMenor(3000);
		System.out.println("Buscar por pacotes por preço menor, retornando um vetor de objetos");
		listaObjetos.forEach(vetor -> System.out.println(vetor[0] + " " + vetor[1]));
		
		//Buscar pacotes por preço menor, retornando uma lista de pacotes com a descricao e qtd de dias preenchidos
		pacotes = pacoteDao.buscarPorPrecoMenor2(3000);
		System.out.println("Buscar pacotes por preço menor, retornando uma lista de pacotes");
		pacotes.forEach(p -> System.out.println(p.getDescricao() + " " + p.getQtdDias() + " " + p.getDataSaida()));
		
		//Buscar por preço menor, retornando somente a descrição 
		List<String> listaString = pacoteDao.buscarPorPrecoMenor3(3000);
		System.out.println("Buscar pacotes por preço menor, retornando uma lista de String");
		listaString.forEach(s -> System.out.println(s));
		
		//Buscar pacotes por data de saída
		Calendar inicio = new GregorianCalendar(2021, Calendar.JANUARY, 1);
		Calendar fim = new GregorianCalendar(2021, Calendar.DECEMBER, 30);
		pacotes = pacoteDao.buscarPorDatas(inicio, fim);
		System.out.println("Buscar pacotes por data");
		pacotes.forEach(p -> System.out.println(p.getDescricao() + " " + DataUtil.formatar(p.getDataSaida())));
		
		//Buscar clientes por parte do nome e parte do nome da cidade
		clientes = clienteDao.buscar("a", "Sal");
		System.out.println("Buscar clientes por parte do nome e parte do nome da cidade");
		clientes.forEach(c -> System.out.println(c.getNome() + " " + c.getEndereco().getCidade().getNome()));
		
		//Buscar clientes por estados
		List<String> estados = new ArrayList<String>();
		estados.add("SP");
		estados.add("PR");
		clientes = clienteDao.buscarPorEstados(estados);
		System.out.println("Buscar clientes por estados");
		clientes.forEach(c -> System.out.println(c.getNome() + " " + c.getEndereco().getCidade().getUf()));
		
		//Pesquisar clientes por nome, sem case sensitive
		clientes = clienteDao.buscarPorNome2("A");
		System.out.println("Buscar clientes por nome, sem case sensitive");
		clientes.forEach(c -> System.out.println(c.getNome()));
		
		//Contar os clientes por estado
		long qtd = clienteDao.contarPorEstado("PR");
		System.out.println("Contar clientes por estado: " + qtd);
		
		//Somar preços dos pacotes por transporte
		transporte = transporteDao.pesquisar(1);
		double soma = pacoteDao.somarPrecoPorTransporte(transporte);
		System.out.println("A soma dos preços dos pacotes por transporte: " + soma);
		
		//Instanciar uma ReservaDao
		ReservaDAO reservaDao = new ReservaDAOImpl(em);
		//Pesquisar a reserva por cpf
		List<Reserva> reservas = reservaDao.buscarPorCpfCliente("88892992922");
		//Exibir o nome, cpf e data de reserva
		reservas.forEach(r -> System.out.println(r.getCliente().getNome() + " " + 
				r.getCliente().getCpf() + " " + DataUtil.formatar(r.getDataReserva())));
		
		//Pesquisar reserva por nome da empresa de transporte
		reservas = reservaDao.buscarPorEmpresaTransporte("O");
		reservas.forEach(r -> System.out.println(r.getPacote().getTransporte().getEmpresa() + " " + 
														r.getPacote().getDescricao()));
		
		//Buscar pacotes por preço menor e qtd de dias maior
		pacotes = pacoteDao.buscarPorQtdDiasMaiorEPrecoMenor(5, 5000);
		pacotes.forEach(p -> System.out.println(p.getDescricao() + " " + p.getQtdDias() + " " + p.getPreco()));
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}
}