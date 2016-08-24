package com.cmb.servlet;


import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TTT
 * 1.ServletContext实现不同servlet直接的数据共享
 * 2.ServletContext可以获取web应用的初始化参数
 * 3.ServletContext可以实现请求转发
 */
@WebServlet("/ServletTest02")

public class ServletTest02 extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = this.getServletConfig().getServletContext();
        String data = (String) context.getAttribute("data");//从ServletContext对象中取出数据
        response.getWriter().println("data="+data);
        
        String initParam = context.getInitParameter("url");
        response.getWriter().println(initParam);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}