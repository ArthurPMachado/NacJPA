package br.com.contabancaria.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_BANCO")
@SequenceGenerator(name="banco", sequenceName="SQ_TB_BANCO", allocationSize=1)
public class Banco {
	@Id
	@Column(name="cd_banco")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="banco")
	private int codigo;
	
	@Column(name="ds_razao_social", nullable=false, length=40)
	private String razaoSocial;
	
	@Column(name="nm_banco", nullable=false, length=20)
	private String nome;
	
	@Column(name="nr_telefone", nullable=false)
	private int telefone;
	
	@Column(name="nr_cnpj", nullable=false)
	private int cnpj;
	
	@OneToMany(mappedBy="banco")
	private List<Agencia> listaAgencias = new ArrayList<Agencia>();

	public Banco() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Banco(String razaoSocial, String nome, int telefone, int cnpj) {
		super();
		this.razaoSocial = razaoSocial;
		this.nome = nome;
		this.telefone = telefone;
		this.cnpj = cnpj;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}
	
}
