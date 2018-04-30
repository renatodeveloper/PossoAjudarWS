package br.com.possoajudarws.dao;


import java.sql.ResultSet;

import org.json.JSONObject;

import br.com.possoajudarws.factory.ConnectionFactory;
import br.com.possoajudarws.model.Usuario;

import com.sun.jersey.json.impl.provider.entity.JSONObjectProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;


public class UsuarioDao extends ConnectionFactory {
	private static UsuarioDao instance;
	
	/*
	 * Metodo responsavel por criar uma instancia da classe usuarioDao
	 */
	public static UsuarioDao getInstance(){
		if(instance == null){
			instance = new UsuarioDao();
			return instance;
		}
		return instance;
	}
	
	
	
	/**
	 * Metodo responsavel por listar todos os usuarios
	 * @return usuarios
	 */
	public ArrayList<Usuario> listarTodos(){
		Connection conn = null;
		conn = criarConexao();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Usuario> usuarios = null;
		
		usuarios = new ArrayList<Usuario>();
		try{
			pstmt = conn.prepareStatement("SELECT * FROM USUARIO");
			rs = pstmt.executeQuery();
			while(rs.next()){
				Usuario usuarioX = new Usuario();
				usuarioX.setIdUsuario(rs.getInt("idUsuario"));
				usuarioX.setDsNome(rs.getString("dsNome"));
				usuarioX.setDsLogin(rs.getString("dsLogin"));
				usuarios.add(usuarioX);
				System.out.print("\n Nome:" + usuarioX.getDsNome().toString() + "\n");
			}
			
		}catch(Exception e){
			System.out.print("Erro ao listar os usuario" );
			e.printStackTrace();
		}finally{
			fecharConnexao(conn, pstmt, rs);
		}
		
		return usuarios;
	}
	
	
	
	
	
	/*
	 * Metodo responsavel por validar o usuario
	 */
	public String validaUsuario(String json){
		JSONObject status = new JSONObject();

		Connection conn = null;
		conn = criarConexao();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			status.put("result", "NOK");
			
			JSONObject jsonObject = new JSONObject(json);
		    String dsLogin = jsonObject.getString("username"); 
		    String dsSenha = jsonObject.getString("password"); 
		    
		    /*
		    JSONObject jsonObject = new JSONObject(json);
		    JSONObject jsonResult = jsonObject.getJSONObject("usuario");
		    String dsLogin = jsonResult.getString("dsLogin"); 
		    String dsSenha = jsonResult.getString("dsSenha"); 
		    */
			
			pstmt = conn.prepareStatement("SELECT * FROM USUARIO WHERE dsLogin = '" + dsLogin + "' AND dsSenha = '" + dsSenha + "'");
			rs = pstmt.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String dsNome = rs.getString("dsNome");
				
				return status.put("result", "OK").toString();
			}
		}catch(Exception e){
			System.out.print("Erro ao listar os usu�rio" );
			e.printStackTrace();
		}finally{
			fecharConnexao(conn, pstmt, rs);
		}
		return status.toString();
	}
}