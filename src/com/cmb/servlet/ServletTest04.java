package com.cmb.servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletTest04")

public class ServletTest04 extends HttpServlet {

    /**
	 * 3.ServletContext可以实现请求转发
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String data = "<h1><font color='red'>abcdefghijkl</font></h1>";
        
        response.getOutputStream().write(data.getBytes());
        ServletContext context = this.getServletContext();
        RequestDispatcher rDispatcher = context.getRequestDispatcher("/ServletTest03");
        rDispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}