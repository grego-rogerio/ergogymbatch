package com.consultoria.ergogymbatch.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 121312311L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String login;
	private String senha;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsuario() {
		return login;
	}
	public void setUsuario(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	public String toString() {
		return this.getUsuario();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		
		if(obj instanceof Usuario) {
			if(((Usuario)obj).getUsuario().equals(this.getUsuario())) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.getId()*58;
	}

}
