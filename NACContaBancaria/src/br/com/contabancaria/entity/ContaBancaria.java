package br.com.contabancaria.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_CONTA_BANCARIA")
@SequenceGenerator(name="conta", sequenceName="SQ_TB_CONTA_BANCARIA", allocationSize=1)
public class ContaBancaria {
	@Id
	@Column(name="cd_conta")
	@GeneratedValue(generator="conta", strategy=GenerationType.SEQUENCE)
	private int codigo;

	@Column(name="vl_saldo", nullable=false)
	private double saldo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_abertura", nullable=false)
	private Calendar abertura;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_fechamento")
	private Calendar fechamento;
	
	@ManyToOne
	@JoinColumn(name="cd_agencia")
	private Agencia agencia;
	
	@ManyToMany
	@JoinTable(name="TB_CONTA_BANCARIA_CLIENTE",
				joinColumns=@JoinColumn(name="cd_conta"),
				inverseJoinColumns=@JoinColumn(name="cd_cliente"))
	private List<Cliente> clientes = new ArrayList<Cliente>();

	public ContaBancaria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContaBancaria(double saldo, Calendar abertura, Agencia agencia) {
		super();
		this.saldo = saldo;
		this.abertura = abertura;
		this.agencia = agencia;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Calendar getAbertura() {
		return abertura;
	}

	public void setAbertura(Calendar abertura) {
		this.abertura = abertura;
	}

	public Calendar getFechamento() {
		return fechamento;
	}

	public void setFechamento(Calendar fechamento) {
		this.fechamento = fechamento;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}
	
}
