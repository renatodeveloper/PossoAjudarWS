package br.com.possoajudarws.dao;


import java.awt.List;
import java.sql.ResultSet;

import org.json.JSONObject;

import br.com.possoajudarws.factory.ConnectionFactory;
import br.com.possoajudarws.model.Usuario;
import br.com.possoajudarws.model.UsuarioList;

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
	 * Metodo responsavel por listar todos os usuários
	 * @return usuarios
	 */
	public UsuarioList listarTodos(){
		Connection conn = null;
		conn = criarConexao();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		UsuarioList result = new UsuarioList();
		
		//UsuarioList list = new Usuario().new UsuarioList();
		//list.usuarios = new ArrayList<Usuario>();
	
		
		//List<MyType> myList = new ArrayList<MyType>();
		try{
			pstmt = conn.prepareStatement("SELECT * FROM USUARIO");
			rs = pstmt.executeQuery();
			while(rs.next()){
				Usuario user = new Usuario();
				user.setIdUsuario(rs.getInt("idUsuario"));
				user.setDsNome(rs.getString("dsNome"));
				user.setDsLogin(rs.getString("dsLogin"));
				
				result.usuarios.add(user);
				System.out.print("\n Nome:" + user.getDsNome().toString() + "\n");
			}
		}catch(Exception e){
			System.out.print("Erro ao listar os usuario" );
			e.printStackTrace();
		}finally{
			fecharConnexao(conn, pstmt, rs);
		}
		
		return result;
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
	
	public Usuario inserirUsuario(String str1, String str2){
		Connection conn = null;
		conn = criarConexao();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Usuario usuario = null;
		try{
			usuario = new Usuario();
			pstmt = conn.prepareStatement("INSERT INTO USUARIO(dsLogin, dsSenha)VALUES (?, ?)");
			pstmt.setString (1, str1);
			pstmt.setString (2, str2);
			boolean  ok = pstmt.execute();
			if(ok){
				pstmt = conn.prepareStatement("SELECT * FROM USUARIO WHERE dsLogin = '" + str1 + "' AND dsSenha = '" + str2 + "'");
				rs = pstmt.executeQuery();
				while(rs.next()){
					int id = rs.getInt("id");
			
					String dsLogin = rs.getString("dsLogin");
					String dsSenha = rs.getString("dsSenha");
					int idUsuario  = rs.getInt("idUsuario");
					
					usuario.setDsLogin(dsLogin);
					usuario.setDsSenha(dsSenha);
					usuario.setIdUsuario(idUsuario);
					
					return usuario;
				}
			}else{
				usuario = null;
			}
		    conn.close();
		}catch(Exception e){
			System.out.print("Erro ao listar os usu�rio" );
			e.printStackTrace();
		}finally{
			fecharConnexao(conn, pstmt, rs);
		}
		return usuario;
	}
	
}