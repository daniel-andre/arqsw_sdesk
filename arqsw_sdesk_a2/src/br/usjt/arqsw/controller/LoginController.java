package br.usjt.arqsw.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.arqsw.entity.Usuario;
import br.usjt.arqsw.service.UsuarioService;
/**
 * 
 * @author Daniel André dos Santos - RA: 816125541 - CCP3AN-MCA
 *
 */
@Controller
public class LoginController {
	private UsuarioService usuarioService;
	
	@Autowired
	public LoginController(UsuarioService us) {
		usuarioService = us;
	}
	
	@RequestMapping("/LoginForm")
	public String loginForm(Model model) throws IOException {
		return "LoginForm";
	}
	
	@RequestMapping("/efetua_login")
	public String efetuaLogin(@Valid Usuario u, HttpSession session) throws Throwable {
		if (usuarioService.existeUsuario(u)) {
			session.setAttribute("usuarioLogado", u); 
			return "ChamadoListar";
		}
		return "LoginForm";
	}

}
