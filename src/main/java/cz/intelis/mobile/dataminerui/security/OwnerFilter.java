package cz.intelis.mobile.dataminerui.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

import cz.intelis.mobile.dataminerui.model.User;
import cz.intelis.mobile.dataminerui.service.impl.UserServiceImpl;
import cz.intelis.mobile.dataminerui.utils.PwdUtils;

/**
 * @author Ludek Cermak
 * 
 */
public class OwnerFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		final HttpServletRequest request = (HttpServletRequest) req;
		final HttpServletResponse response = (HttpServletResponse) res;

		final String auth = request.getHeader("Authorization");
		if (auth != null) {
			try {
				final String[] credentials = PwdUtils.decode(auth);
				User user = new User();
				user.setUserEmail(credentials[0]);
				user.setUserPwd(credentials[1]);
				user = UserServiceImpl.getInstance().loginUser(user);
				if ((user != null) && (user.getUserId() != null)) {
					chain.doFilter(request, response);
				} else {
					response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized.");
				}
			} catch (Exception e) {
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized.");
			}
		} else {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized.");
		}
	}

}
