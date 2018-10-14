package br.com.cast.jsfintroBruno.filters;

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

import br.com.cast.models.Student;



/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(filterName = "fPages", urlPatterns= {"/tofilter/*"}, initParams = {
		@WebInitParam(name = "paginasPermitidas", value = ".gif,.css,.js,login,addStudent") })
public class LoginFilter implements Filter {

	List<String> paginasPermitidas;

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String url = req.getRequestURI();
		
		List<String> paginasPermitidasFiltradas = paginasPermitidas.stream()
				.filter(x -> url.endsWith(x))
				.collect(Collectors.toList());
		
		if (paginasPermitidasFiltradas.size() > 0) {
			chain.doFilter(request, response);
		} else {
			
			HttpSession session = req.getSession();
			Student c = (Student) session.getAttribute("logged");
			
			if(c == null) {
				req.getRequestDispatcher("/login.xhtml").forward(req, response);
			} else {
				chain.doFilter(request, response);
			}
			
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
		String paginas = fConfig.getInitParameter("paginasPermitidas");
		paginasPermitidas = new ArrayList<>(Arrays.asList(paginas.split(",")));
	}

}
