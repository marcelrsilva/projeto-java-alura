package br.com.casadocodigo.loja.models;

import java.util.Calendar;
import java.util.List;

public class RelatorioJson {	
	
	
	private Calendar dataGeracao;
	private Long quantidade;
	private List<Produto> produtos;
	
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public Calendar getDataGeracao() {
		return dataGeracao;
	}
	public void setDataGeracao(Calendar dataGeracao) {
		this.dataGeracao = dataGeracao;
	}
	public Long getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	

}
