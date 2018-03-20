package br.usjt.arqsw.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.arqsw.dao.ChamadoDAO;
import br.usjt.arqsw.dao.UsuarioDAO;
import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;
import br.usjt.arqsw.entity.Usuario;

/**
 * 
 * @author Daniel André dos Santos - RA: 816125541 - CCP3AN-MCA
 *
 */
@Service
public class UsuarioService {
	UsuarioDAO dao;
	
	@Autowired
	public UsuarioService(UsuarioDAO dao){
		this.dao = dao;
	}
	
	public boolean existeUsuario(Usuario u) throws Throwable {
		return dao.existeUsuario(u);
	}

}
