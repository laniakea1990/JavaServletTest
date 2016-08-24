package com.cmb.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//3.ServletContext可以实现请求转发
@WebServlet("/ServletTest03")

public class ServletTest03 extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getOutputStream().write("asdfja;ldsjkfalsdfalds;kfja;lskdjf".getBytes());
        response.getOutputStream().println("In fact calls the ServletTest03!");
	}

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}