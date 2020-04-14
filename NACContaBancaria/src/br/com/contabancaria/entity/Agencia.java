package br.com.contabancaria.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_AGENCIA")
@SequenceGenerator(name="agencia", sequenceName="SQ_TB_AGENCIA", allocationSize=1)
public class Agencia {
	@Id
	@Column(name="cd_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="agencia")
	private int codigo;
	
	@Column(name="nm_agencia", nullable=false, length=20, unique=true)
	private String nome;
	
	@Column(name="ds_endereco", nullable=false, length=100)
	private String endereco;
	
	@Column(name="nr_telefone", nullable=false)
	private int telefone;
	
	@ManyToOne
	@JoinColumn(name="cd_banco")
	private Banco banco;

	public Agencia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Agencia(String nome, String endereco, int telefone, Banco banco) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.banco = banco;
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
