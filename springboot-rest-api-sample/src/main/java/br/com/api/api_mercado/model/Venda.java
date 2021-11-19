package br.com.api.api_mercado.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity
@SequenceGenerator(name = "seq_venda", sequenceName = "seq_venda", allocationSize = 1, initialValue = 1)
public class Venda  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_venda")
	private Long id;
	
	@NotNull
	@OneToOne
	private Funcionario fun;
	
	@NotNull
	private Date dataVenda;
	
	@NotNull
	private int quantidade;
	
	public Venda() {
		setDataVenda(Calendar.getInstance().getTime());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	private void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Funcionario getFun() {
		return fun;
	}

	public void setFun(Funcionario fun) {
		this.fun = fun;
	}
	
}
