package br.usjt.arqsw.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 
 * @author Daniel Andr� dos Santos - RA: 816125541 - CCP3AN-MCA
 *
 */
public class AutorizadorInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller) throws Exception {
		String uri = request.getRequestURI();
		if(uri.endsWith("LoginForm") || uri.endsWith("efetua_login") || uri.contains("css") || uri.contains("js") || uri.contains("img")) {
			return true;
		}
		
		if(request.getSession().getAttribute("usuarioLogado") != null) {
			return true;
		}
		response.sendRedirect("LoginForm");
		return false;
	}
}
