package br.com.casadocodigo.loja.controllers;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.models.RelatorioJson;

@Controller
@RequestMapping(value="/relatorio-produtos", method=RequestMethod.GET)
public class RelatorioProdutosController {  
	
	
	@Autowired
	private ProdutoDAO dao;
	
	
	@RequestMapping(params={"data"})
	@ResponseBody	
	public RelatorioJson listarPorDataJson(@RequestParam("data") @DateTimeFormat(pattern = "yyyy-MM-dd") Calendar data) { 
		RelatorioJson relatorio = new RelatorioJson();
		relatorio.setDataGeracao(Calendar.getInstance());
		relatorio.setQuantidade(dao.somaProdutosPorData(data));
		relatorio.setProdutos(dao.listaPorData(data));
		return relatorio;
	}
	
	@RequestMapping(value="")
	@ResponseBody	
	public RelatorioJson listarJson() { 
		RelatorioJson relatorio = new RelatorioJson();
		relatorio.setDataGeracao(Calendar.getInstance());
		relatorio.setQuantidade(dao.somaProdutos());
		relatorio.setProdutos(dao.listar());
		return relatorio;
	}
	
	
}