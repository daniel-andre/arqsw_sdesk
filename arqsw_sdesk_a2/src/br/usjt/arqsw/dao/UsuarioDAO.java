package br.usjt.arqsw.dao;

import java.io.IOException;
/**
 * 
 * @author Daniel André dos Santos - RA: 816125541 - CCP3AN-MCA
 *
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;
import br.usjt.arqsw.entity.Usuario;

@Repository
public class UsuarioDAO {
	private Connection conn;

	@Autowired
	public UsuarioDAO(DataSource dataSource) throws IOException{
		try{
			this.conn = dataSource.getConnection();
		} catch (SQLException e){
			throw new IOException(e);
		}
	}
	
	public boolean existeUsuario(Usuario u) throws IOException {
		Usuario usuario = u;
		boolean existeUsuario;
		String query = "select * from usuario where usuario=? and senha=?";

		try (PreparedStatement pst = conn.prepareStatement(query);) {
			pst.setString(1, usuario.getUsername());
			pst.setString(2, usuario.getPassword());
			System.out.println(usuario.toString());
			try (ResultSet rs = pst.executeQuery();) {

				if (rs.next()) {
					existeUsuario = true;
				} else {
					existeUsuario = false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return existeUsuario;
	}
}
