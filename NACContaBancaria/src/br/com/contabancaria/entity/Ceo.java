package br.com.contabancaria.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CEO")
@SequenceGenerator(name = "ceo", sequenceName = "SQ_TB_CEO", allocationSize = 1)
public class Ceo {
	@Id
	@Column(name = "CD_CEO")
	@GeneratedValue(generator = "ceo", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name = "NM_CEO", nullable = false, length = 20)
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "DS_GENERO", nullable = false)
	private Genero genero;
	
	@Column(name = "NR_IDADE", nullable = false, length = 2)
	private int idade;
	
	@Column(name = "VL_SALARIO", nullable = false, precision = 6, scale = 2)
	private double salario;
	
	@OneToOne(mappedBy="ceo")
	private Banco banco;
	
	public Ceo(String nome, Genero genero, int idade, double salario) {
		super();
		this.nome = nome;
		this.genero = genero;
		this.idade = idade;
		this.salario = salario;
	}

	public Ceo() {
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

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
}
