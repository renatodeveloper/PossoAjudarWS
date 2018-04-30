package br.com.possoajudarws.dao;


import java.sql.ResultSet;

import org.json.JSONObject;

import br.com.possoajudarws.factory.ConnectionFactory;

import com.sun.jersey.json.impl.provider.entity.JSONObjectProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;


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
			System.out.print("Erro ao listar os usuário" );
			e.printStackTrace();
		}finally{
			fecharConnexao(conn, pstmt, rs);
		}
		return status.toString();
	}
}