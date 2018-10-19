package br.com.pos.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;

import br.com.pos.model.Pessoa;
import br.com.pos.repository.PessoaRepository;

@Path("/pessoa")
public class PessoaController {
		
	PessoaRepository pr = new PessoaRepository();

	@GET
	@Path("/listar")
	@Produces("application/json; charset=UTF-8")
	public List<Pessoa> todasPessoas(){
		return pr.listarPessoas();
	}

	@GET
	@Path("/find/{id}")
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	public Pessoa getPessoa(@PathParam("id") Integer id){
		return pr.findPessoaById(id);
	}
	
	@PUT
	@Path("/alterar")
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")	
	public String alterar(Pessoa p) {

		try {
			pr.salvar(p);
			return "Registro alterado com sucesso!";
		} catch (Exception e) {
			return "Erro ao alterar o registro " + e.getMessage();
		}
		
	}
	
	@POST
	@Path("/inserir")
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	public String inserir(Pessoa p) {
		System.out.println(p.getNome());
		try {
			pr.salvar(p);
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
			
			pr.excluir(id);
			return Response.ok("Excluído com sucesso!", MediaType.APPLICATION_JSON).build();
			
		} catch (Exception e) {
			
			 return Response.status(Response.Status.EXPECTATION_FAILED).entity("Erro " + e.getMessage()).build();
			
		}
	}
	
	
}
