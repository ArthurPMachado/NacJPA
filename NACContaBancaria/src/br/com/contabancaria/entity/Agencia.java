package br.com.contabancaria.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_AGENCIA")
@SequenceGenerator(name="agencia", sequenceName="SQ_TB_AGENCIA", allocationSize=1)
public class Agencia {
	@Id
	@Column(name="cd_agencia")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="agencia")
	private int codigo;
	
	@Column(name="nm_agencia", nullable=false, length=20, unique=true)
	private String nome;
	
	@Column(name="ds_endereco", nullable=false, length=100)
	private String endereco;
	
	@Column(name="nr_telefone", nullable=false)	
	private int telefone;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="cd_banco")
	private Banco banco;
	
	@OneToMany(mappedBy="agencia", cascade=CascadeType.ALL)
	private List<ContaBancaria> contas = new ArrayList<ContaBancaria>();
	
	public void addContas(ContaBancaria conta) {
		contas.add(conta);
		conta.setAgencia(this);
	}
	
	public Agencia() {
		super();
	}

	public Agencia(String nome, String endereco, int telefone) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
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

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}
	
}
