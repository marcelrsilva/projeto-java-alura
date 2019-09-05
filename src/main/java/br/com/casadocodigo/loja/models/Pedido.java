package br.com.casadocodigo.loja.models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Pedido {
	
	private Integer id;
	private BigDecimal valor;		
	private Date data;	
	private List<Object> produtos;	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public List<Object> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Object> produtos) {
		this.produtos = produtos;
	}
	

}
