package br.com.possoajudarws.resource;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.json.JSONObject;

import br.com.possoajudarws.controler.UsuarioControler;
import br.com.possoajudarws.model.Usuario;

/**
 * Classe responsavel por conter os metodos rest de acesso ao webservice
 */
@Path("/usuario")
public class UsuarioResource {
	
	/**
	 *  Metodo que verifica se o servidor está no ar
	 * @return String JSON
	 */
	@GET
	@Path("/conection")
	@Produces("application/json")
	//@Produces("aplication/xml")
	public String testResourceConnection(){
		JSONObject object = new JSONObject();
		try{
			object.put("status", 1000);
			object.put("mensage", "The connection was a success");
		}catch(Exception e){
			e.getMessage().toString();
		}	
		return object.toString();
	}
	
	/**
	 *  Metodo Responsável por fazer chamada ao controler
	 * @return ArrayList Usuario
	 */
	@GET
	@Path("/todos")
	@Produces("application/json")
	public ArrayList<Usuario> listarUsuarios(){
		return UsuarioControler.listarTodos();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 *  Metodo responsavel por fazer chamada ao controler
	 * @return 
	 * @return Boolean usuario
	 */
	
	
	@POST
	@Path("/login/stringImplicito")
	@Produces("application/json")
	//@Produces("aplication/xml")
	public String getStatusLoginStringImplicito(@Context UriInfo info, @QueryParam ("paramJsonUser") String paramJsonUser){
		String result = "NOK";
		String json = info.getQueryParameters().getFirst("paramJsonUser");
		try{
			if(json != null && json.length()>0){
				if(json.equals("Implicito")){
					return "OK_Implicito";
				}
				return "NOK_Implicito";
			}
		}catch(Exception e){
			e.getMessage().toString();
		}
	
		return result;
	}
	
	
	@GET
	@Path("/login/users/{username}")
	@Produces("application/json")
	//@Produces("aplication/xml")
	public String getStatusLoginStringExplicito(@Context UriInfo info, @PathParam ("username") String paramJsonUser){
		String result = "NOK";
		String json = info.getPathParameters().getFirst("username");
		try{
			if(json != null && json.length()>0){
				if(json.equals("Explicito")){
					return "Explicito";
				}
				return "NOK_Explicito";
			}
		}catch(Exception e){
			e.getMessage().toString();
		}
	
		return result;
	}
	
	
	@GET
	@Path("/login/users/json/{paramJsonUser}")
	@Produces("application/json")
	//@Produces("aplication/xml")
	public String getStatusLoginJson(@Context UriInfo info, @PathParam ("paramJsonUser") String paramJsonUser){
		String result = "NOK";
		String json = info.getPathParameters().getFirst("paramJsonUser");
		try{
			if(json != null && json.length()>0){
				return		UsuarioControler.validaUsuario(json);
			}
		}catch(Exception e){
			e.getMessage().toString();
		}
	
		return result;
	}
	
	
}