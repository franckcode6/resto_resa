package fr.open.restau_resa.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

//@Component
public class CheckSessionFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if (((HttpServletRequest) request).getRequestURI().startsWith("/admin")
				&& ((HttpServletRequest) request).getSession().getAttribute("admin") == null) {
			System.out.println("Pas de session");
			((HttpServletResponse) response).sendRedirect("/");
		} else if (((HttpServletRequest) request).getRequestURI().startsWith("/profil")
				&& ((HttpServletRequest) request).getSession().getAttribute("customer") == null) {
			System.out.println("Pas de session");
			((HttpServletResponse) response).sendRedirect("/");
		} else if (((HttpServletRequest) request).getRequestURI().startsWith("/professionnal")
				&& ((HttpServletRequest) request).getSession().getAttribute("professionnal") == null) {
			System.out.println("Pas de session");
			((HttpServletResponse) response).sendRedirect("/");
		} else {
			chain.doFilter(request, response);
		}
	}
}
