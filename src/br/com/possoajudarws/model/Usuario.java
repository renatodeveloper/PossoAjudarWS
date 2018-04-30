package br.com.possoajudarws.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.mysql.jdbc.Blob;

/**
 * Classe responsavel por conter os atributos do objeto Usuario
 * @author renato
 *
 */

/*
 * Anotação obrigatoria, do contrario não funcionao web service
 */
@XmlRootElement
public final class Usuario {
	
	private Integer  idUsuario;
	private String   dsNome;
    private String   dsLogin;
    private String   dsSenha;
    private String   namePhoto;
    private Blob     bytePhoto;
    private Integer  idRedeSocial;
    private Integer  idServico;
    
    /*
     * ctrl + 3 + ggas
     * Metodos Getters and Setters
     */
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getDsNome() {
		return dsNome;
	}
	public void setDsNome(String dsNome) {
		this.dsNome = dsNome;
	}
	public String getDsLogin() {
		return dsLogin;
	}
	public void setDsLogin(String dsLogin) {
		this.dsLogin = dsLogin;
	}
	public String getDsSenha() {
		return dsSenha;
	}
	public void setDsSenha(String dsSenha) {
		this.dsSenha = dsSenha;
	}
	public String getNamePhoto() {
		return namePhoto;
	}
	public void setNamePhoto(String namePhoto) {
		this.namePhoto = namePhoto;
	}
	public Blob getBytePhoto() {
		return bytePhoto;
	}
	public void setBytePhoto(Blob bytePhoto) {
		this.bytePhoto = bytePhoto;
	}
	public Integer getIdRedeSocial() {
		return idRedeSocial;
	}
	public void setIdRedeSocial(Integer idRedeSocial) {
		this.idRedeSocial = idRedeSocial;
	}
	public Integer getIdServico() {
		return idServico;
	}
	public void setIdServico(Integer idServico) {
		this.idServico = idServico;
	}
	
   
	/*
	 *  ctrl + 3 + gts
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", dsNome=" + dsNome
				+ ", dsLogin=" + dsLogin + ", dsSenha=" + dsSenha
				+ ", namePhoto=" + namePhoto + ", bytePhoto=" + bytePhoto
				+ ", idRedeSocial=" + idRedeSocial + ", idServico=" + idServico
				+ "]";
	}
	
	

	  /*
   * Gerar o 'hashCode'  and 'equals' =  ctrl + 3 + ghc
   * 
   */
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((bytePhoto == null) ? 0 : bytePhoto.hashCode());
		result = prime * result + ((dsLogin == null) ? 0 : dsLogin.hashCode());
		result = prime * result + ((dsNome == null) ? 0 : dsNome.hashCode());
		result = prime * result + ((dsSenha == null) ? 0 : dsSenha.hashCode());
		result = prime * result
				+ ((idRedeSocial == null) ? 0 : idRedeSocial.hashCode());
		result = prime * result
				+ ((idServico == null) ? 0 : idServico.hashCode());
		result = prime * result
				+ ((idUsuario == null) ? 0 : idUsuario.hashCode());
		result = prime * result
				+ ((namePhoto == null) ? 0 : namePhoto.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (bytePhoto == null) {
			if (other.bytePhoto != null)
				return false;
		} else if (!bytePhoto.equals(other.bytePhoto))
			return false;
		if (dsLogin == null) {
			if (other.dsLogin != null)
				return false;
		} else if (!dsLogin.equals(other.dsLogin))
			return false;
		if (dsNome == null) {
			if (other.dsNome != null)
				return false;
		} else if (!dsNome.equals(other.dsNome))
			return false;
		if (dsSenha == null) {
			if (other.dsSenha != null)
				return false;
		} else if (!dsSenha.equals(other.dsSenha))
			return false;
		if (idRedeSocial == null) {
			if (other.idRedeSocial != null)
				return false;
		} else if (!idRedeSocial.equals(other.idRedeSocial))
			return false;
		if (idServico == null) {
			if (other.idServico != null)
				return false;
		} else if (!idServico.equals(other.idServico))
			return false;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		if (namePhoto == null) {
			if (other.namePhoto != null)
				return false;
		} else if (!namePhoto.equals(other.namePhoto))
			return false;
		return true;
	}    
    
}