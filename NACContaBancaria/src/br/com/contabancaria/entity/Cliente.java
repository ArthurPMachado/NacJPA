package br.com.contabancaria.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CLIENTE")
@SequenceGenerator(name = "cliente", sequenceName = "SQ_TB_CLIENTE" ,allocationSize = 1)
public class Cliente {
	// Colunas nativa da tabela cliente
	@Id
	@Column(name = "CD_CLIENTE", precision = 5)
	@GeneratedValue(generator = "cliente", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name = "NM_CLIENTE", nullable = false, length = 50)
	private String nome;
	
	@Column(name = "DS_EMAIL", nullable = false, length = 40)
	private String email;
	
	@Column(name = "VL_RENDA_FATURAMENTO", nullable = true, precision = 9, scale = 2)
	private double rendaFaturamento;
	
	@Column(name = "DS_ENDERECO", nullable = false, length = 100)
	private String endereco;
	
	@Column(name = "NR_TELEFONE", nullable = true, precision = 9)
	private int telefone;
	
	@ManyToMany(mappedBy="clientes")
	private List<ContaBancaria> contas = new ArrayList<ContaBancaria>();
	
	// Atributos que fazem parte de ralacinomanetos

	public Cliente(String nome, String email, double rendaFaturamento, String endereco, int telefone) {
		super();
		this.nome = nome;
		this.email = email;
		this.rendaFaturamento = rendaFaturamento;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public Cliente() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getRendaFaturamento() {
		return rendaFaturamento;
	}

	public void setRendaFaturamento(double rendaFaturamento) {
		this.rendaFaturamento = rendaFaturamento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	
}
