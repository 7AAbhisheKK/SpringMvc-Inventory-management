package dbms.Security_config;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
@Configuration
public class CustomLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	
	@Override
	protected void handle(HttpServletRequest request,HttpServletResponse response,Authentication authentication) throws IOException
	{
		String targeturl=determinetargeturl(authentication);
		if(response.isCommitted())
		{
			return;
		}
		RedirectStrategy redirectstrategy=new DefaultRedirectStrategy();
		redirectstrategy.sendRedirect(request, response, targeturl);
		HttpSession session=request.getSession();
		session.setAttribute("name", authentication.getName());
	}
	protected String determinetargeturl(Authentication authentication)
	{
		String url="/login?error=true";
		Collection<? extends GrantedAuthority> authorities=authentication.getAuthorities();
		List<String> roles=new ArrayList<String>();
		for(GrantedAuthority a:authorities)
		{
			roles.add(a.getAuthority());
		}
		if(roles.contains("ROLE_ADMIN"))
		{
			url="/admin";
		}
		else if(roles.contains("ROLE_CASHIER"))
		{
			url="/cashier/cart";
		}
		else if(roles.contains("ROLE_STAFF"))
		{
			url="/staff";
		}
		return url;
	}

}
