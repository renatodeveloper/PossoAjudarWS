package br.com.possoajudarws.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import br.com.possoajudarws.controler.UsuarioControler;

/**
 * Classe responsavel por conter os metodos rest de acesso ao webservice
 */
@Path("/usuario")
public class UsuarioResource {
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