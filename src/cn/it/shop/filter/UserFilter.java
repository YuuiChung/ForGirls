package cn.it.shop.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// 判断session中是否有 user对象
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		if(req.getSession().getAttribute("user")==null){
			// 保存当前客户要去的地址
			String goURL=req.getServletPath();
			System.out.println("客户要去的地址:" + goURL);
//			System.out.println("客户要去的地址(有工程名):" + req.getRequestURI());
//			System.out.println("客户要去的地址(绝对URL地址):" + req.getRequestURL());
			String param=req.getQueryString();
			if(param!=null){
				goURL += "?" + param;
			}
			req.getSession().setAttribute("goURL", goURL);
			// 非法访问,跳转到登陆页面
			req.getSession().setAttribute("error", "非法访问请登陆!");
			res.sendRedirect(req.getContextPath() + "/ulogin.jsp");
		}else{
			// 合法访问
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
