package br.usjt.arqsw.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author Daniel André dos Santos - RA: 816125541 - CCP3AN-MCA
 *
 */
@Entity
public class Usuario {
	private static final long serialVersionUID = 1L;
	
	@NotNull
	private String password;
	
	@NotNull
	@Size(max=50, message="O usuario deve ter no maximo 50 caracteres.")
	private String username;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [username=" + username + ", password=" + password + "]";
	}
	
	
}
