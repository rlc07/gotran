package filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Filter
 */
@WebFilter("/*")
public class Filter implements javax.servlet.Filter {

	private static final String[] URLS_TO_EXCLUDE = {".woff2",".woff",".css", ".js", ".png", ".jpg", ".gif", 
			"login.jsp","index.jsp", "/gotran/buscar", "/gotran/publico/buscador/buscar_transporte.jsp","verifica_email_cadastro.jsp", "verifica_email_recupera_senha.jsp",
			"alterar_senha.jsp", "admin.jsp", "jsonRelatorio.jsp", "http://localhost:8080/gotran/buscar?action=nova-senha"};
	
	private static final String[] URLS_EXCLUDE = {"meus_anuncios.jsp","/privado/anunciante/meus_anuncios.jsp", "anunciar_aluguel.jsp", "/privado/anunciante/anunciar_aluguel.jsp"
			+"/privado/anunciante/anunciar_escolar.jsp", "anunciar_escolar.jsp", "/privado/anunciante/meus_veiculos.jsp"
			+"meus_veiculos.jsp", "/privado/anunciante/anunciar_carreto.jsp", "anunciar_carreto.jsp"
			+"/privado/anunciante/anunciar_excursao.jsp", "anunciar_excursao.jsp"};
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = ((HttpServletRequest) request);
		String uri = httpRequest.getRequestURI();
		
		if (!isURIToExclusao(uri, httpRequest)) {
			HttpSession session = httpRequest.getSession();
			if (session.getAttribute("usuarioLogado") == null) {
				request.getRequestDispatcher("login.jsp").forward(request, response);
				
			}else if(isURIExclusao(uri, httpRequest)){
				if (session.getAttribute("usuarioLogado") != null) {
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
		} else {
				chain.doFilter(request, response);
			}
		}else {
			chain.doFilter(request, response);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

	private boolean isURIToExclusao(String uri, HttpServletRequest httpRequest) {
		boolean retorno = false;
		for (String url : URLS_TO_EXCLUDE) {
			
			
			if (uri != null && uri.endsWith(url)) {
				retorno = true;
			}
			
			if (uri != null && uri.endsWith("login")) {
				retorno = true;
			}
		}
		return retorno;
	}
	
	private boolean isURIExclusao(String uri, HttpServletRequest httpRequest) {
		boolean retorno = false;
		for (String url : URLS_EXCLUDE) {
			if (uri != null && uri.endsWith(url)){
				retorno = true;
			}
			
			if (uri != null && uri.endsWith("login")) {
				retorno = true;
			}
		}
		return retorno;
	}
}
