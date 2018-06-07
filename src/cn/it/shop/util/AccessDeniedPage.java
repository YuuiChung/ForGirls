package cn.it.shop.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

@Component("auccessDeniedPage")
public class AccessDeniedPage implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request,
			HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException,
			ServletException {
		if("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))){
			System.out.println("-----ajax------");
			PrintWriter out = response.getWriter();
			out.write("fail");
			out.flush();
			out.close();
		}else{
			System.out.println("-----http------");
			request.setAttribute("error","权限不足!");
			request.getRequestDispatcher("/alogin.jsp").forward(request, response);
		}
	}
}
