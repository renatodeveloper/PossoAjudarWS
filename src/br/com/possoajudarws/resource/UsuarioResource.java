package br.com.possoajudarws.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import br.com.possoajudarws.controler.UsuarioControler;
import br.com.possoajudarws.model.ServiceResponse;
import br.com.possoajudarws.model.Usuario;
import br.com.possoajudarws.model.UsuarioList;

/**
 * Classe responsavel por conter os metodos rest de acesso ao webservice
 */
@Path("/usuarios")
public class UsuarioResource {
	private static List<Usuario> usuarios = new ArrayList<Usuario>();
	
	
	@GET
	@Path("/conection")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)//@Produces("application/json")//@Produces("aplication/xml")
	public ServiceResponse recuperarStatusConexao(){
		ServiceResponse object = new ServiceResponse();
		try{
			object.code = "1000";
			object.message = "The connection was a success";
		}catch(Exception e){
			e.getMessage().toString();
		}	
		String retorno = object.toString();
		return object;
	}
	

	@GET
	@Path("/todos")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public UsuarioList listarUsuarios(){
		UsuarioList listRetorno = UsuarioControler.listarTodos();
		return listRetorno;
	}
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{idUsuario}")
	public Usuario getUsuario(@PathParam("idUsuario") int id) {
		Usuario result = null;
		  try{
			  int searchUser  = id;
			  if(searchUser>0){
				  result = new Usuario();
				  result.setDsNome("Nome sucesso");
				  result.setDsLogin("Login sucesso");
			  }
			  if (result == null) {
				   throw new WebApplicationException(404);
				  }
		  }catch(Exception e){
			  e.getMessage().toString();
		  }
		  return result;
	}
	
	
	@GET
	@Path("/find/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	 public List<Usuario> findByName(@PathParam("name") String name) {
	  
	  List<Usuario> result = new ArrayList<Usuario>();
	  
	  for (Usuario contact : usuarios) {
	   if (contact.getDsNome() != null
	     && contact.getDsNome().toLowerCase()
	        .contains(name.toLowerCase())) {
	    result.add(contact);
	   }
	  }
	  
	  return result;
	 }
	
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario add(Usuario user) {
	  
	  if (user.getDsNome() == null || user.getDsNome().trim().equals("")) {
	   throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST)
	     .entity("O nome do usuário é obrigatório").build());
	  }
	  Usuario usuario = new Usuario();
	  usuario.setDsNome(user.getDsNome() + ".adicionado");
	  usuario.setDsLogin(user.getDsLogin());
	  usuario.setDsSenha(user.getDsSenha());
	  
	  return usuario;
	}
	
	 
	@PUT
	@Path("/{idUsuario}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void update(@PathParam("idUsuario") int id, Usuario user) {
	  usuarios.set(id - 1, user);
	  user.setIdUsuario(usuarios.indexOf(user) + 1);
	}
	  
	@DELETE
	@Path("/{idUsuario}")
	public void delete(@PathParam("idUsuario") int id) {
		 Usuario contact = usuarios.get(id - 1);
		 usuarios.remove(contact);
	}
	
}