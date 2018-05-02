package br.com.possoajudarws.controler;

import java.util.ArrayList;

import br.com.possoajudarws.dao.UsuarioDao;
import br.com.possoajudarws.model.Usuario;
import br.com.possoajudarws.model.UsuarioList;


public class UsuarioControler {
	
	
	/*
	 * Metodo responsavel por ser o controlador entre o resource e a camada dao
	 */
	public static UsuarioList listarTodos(){
		return UsuarioDao.getInstance().listarTodos();
	}
	
	/*
	 * Metodo responsavel por ser o controlador entre o resource e a camada dao
	 */
	public static String validaUsuario(String json){
		return UsuarioDao.getInstance().validaUsuario(json);
	}
	
	public static Usuario inserirUsuario(String str1, String str2){
		return UsuarioDao.getInstance().inserirUsuario(str1, str2);
	}
}
