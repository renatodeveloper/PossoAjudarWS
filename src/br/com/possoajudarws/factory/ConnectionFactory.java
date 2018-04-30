package br.com.possoajudarws.factory;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Classe responsavel por criar e fechar o banco
 * @author renato
 *
 */
public class ConnectionFactory {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/";
	private static final String DBNAME = "possoajudardb";
	private static final String USUARIO = "root";
	private static final String SENHA = "developer";
	
	/**
	 * Criar connexao 
	 * @return
	 */
	public Connection criarConexao(){
		Connection conn = null;
		try{
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL + DBNAME,USUARIO, SENHA);
		}catch(Exception e){
			System.out.print("Não foi possivel criar conexão com o banco! " + DBNAME );
			e.printStackTrace();
		}
		return conn;
	}
	
	
	public boolean testConnection(){
		Connection conn = null;
		conn = criarConexao();
		if(conn  != null){
			return true;
		}
		return false;
	}
	
	public void fecharConnexao(Connection conn, PreparedStatement pstmt, ResultSet rs){
		try{
			if(conn != null){
				conn.close();
			}
			if(pstmt != null){
				pstmt.close();
			}
			if(rs != null){
				rs.close();
			}
		}catch(Exception e){
			System.out.print("Erro ao fechar conexao com o banco! " + DBNAME );
			e.printStackTrace();
		}
	}
	
}