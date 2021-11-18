package br.com.api.api_mercado.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto", allocationSize = 1, initialValue = 1)
public class Produto  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_produto")
	private Long id;
	
	@NotNull @NotEmpty @Length(min = 3)
	private String nome;
	
	@NotNull
	private int quantidade;
	
	@NotNull
	private Date dataVenda;
	
	public Produto() {
		setDataVenda(Calendar.getInstance().getTime());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
}
