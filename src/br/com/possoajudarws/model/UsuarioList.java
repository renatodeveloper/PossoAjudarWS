package br.com.possoajudarws.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/*
 * Anotação obrigatoria, do contrario não funcionao web service
 */
@XmlRootElement
public final class UsuarioList {
	public List<Usuario> usuarios;
	
	public UsuarioList(){
        usuarios = new ArrayList<Usuario>();
    }
}
