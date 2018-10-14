package br.com.cast.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.cast.models.Contact;

/**
 * Servlet Filter implementation class filterPages
 */
@WebFilter(filterName = "fPages", urlPatterns= {"/*"}, initParams = {
		@WebInitParam(name = "paginasPermitidas", value = ".gif,.css,.js,login.jsp,logIn,altadd.jsp,addAlt,del,.html,.js,Teste,list.jsp,TesteDois,add.jsp") })
public class filterPages implements Filter {

	List<String> paginasPermitidas;
	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, 
			ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		String url = req.getRequestURI();
		
		List<String> paginasPermitidasFiltradas = paginasPermitidas.stream()
				.filter(x -> url.endsWith(x))
				.collect(Collectors.toList());
		
		if (paginasPermitidasFiltradas.size() > 0) {
			chain.doFilter(request, response);
		} else {
			
			HttpSession session = req.getSession();
			Contact c = (Contact) session.getAttribute("logged user");
			
			if(c == null) {
				req.getRequestDispatcher("login.jsp").forward(req, response);
			} else {
				chain.doFilter(request, response);
			}
			
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		String paginas = fConfig.getInitParameter("paginasPermitidas");
		paginasPermitidas = new ArrayList<>(Arrays.asList(paginas.split(",")));
	}

}
