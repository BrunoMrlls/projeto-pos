package br.com.pos.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.pos.model.Produto;
import br.com.pos.repository.ProdutoRepository;


@Path("/produto")
public class ProdutoController {

	private ProdutoRepository produtoRepository = new ProdutoRepository();
	
	@GET
	@Path("/listar")
	@Produces("application/json; charset=UTF-8")
	public List<Produto> todosProdutos(){
		return produtoRepository.listarProdutos();
	}
	
}
