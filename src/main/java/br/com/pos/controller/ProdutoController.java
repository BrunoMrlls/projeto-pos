package br.com.pos.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.pos.model.Produto;
import br.com.pos.repository.ProdutoRepository;


@Path("/produto")
public class ProdutoController {

	private ProdutoRepository p = new ProdutoRepository();
	
	@GET
	@Path("/listar")
	@Produces("application/json; charset=UTF-8")
	public List<Produto> todosProdutos(){
		return p.listarProdutos();
	}
	
	@GET
	@Path("/find/{id}")
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	public Produto getProduto(@PathParam("id") Integer id){
		return p.getProdutoById(id);
	}
	
	@PUT
	@Path("/alterar")
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")	
	public String alterar(Produto produto) {

		try {
			p.salvar(produto);
			return "Registro alterado com sucesso!";
		} catch (Exception e) {
			return "Erro ao alterar o registro " + e.getMessage();
		}
		
	}
	
	@POST
	@Path("/inserir")
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	public String inserir(Produto produto) {
		System.out.println(produto.getDescricao());
		try {
			p.salvar(produto);
			return "Registro alterado com sucesso!";
		} catch (Exception e) {
			return "Erro ao alterar o registro " + e.getMessage();
		}
		
	}
	
	@DELETE
	@Path("/excluir/{id}")	
	@Produces("application/json; charset=UTF-8")
	public Response excluir(@PathParam("id") Integer id) {
	    if(id == null || id == 0) {
	        return Response.serverError().entity("id inválido.").build();
	    }
		
		try {			
			
			p.excluir(id);
			return Response.ok("Excluído com sucesso!", MediaType.APPLICATION_JSON).build();
			
		} catch (Exception e) {
			
			 return Response.status(Response.Status.EXPECTATION_FAILED).entity("Erro " + e.getMessage()).build();
			
		}
	}
	
}
