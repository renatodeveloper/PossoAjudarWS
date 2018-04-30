package br.com.possoajudarws.controler;

import java.util.ArrayList;

import br.com.possoajudarws.dao.UsuarioDao;
import br.com.possoajudarws.model.Usuario;


public class UsuarioControler {
	
	
	/*
	 * Metodo responsavel por ser o controlador entre o resource e a camada dao
	 */
	public static ArrayList<Usuario> listarTodos(){
		return UsuarioDao.getInstance().listarTodos();
	}
	
	/*
	 * Metodo responsavel por ser o controlador entre o resource e a camada dao
	 */
	public static String validaUsuario(String json){
		return UsuarioDao.getInstance().validaUsuario(json);
	}
}
