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
 * 1.ServletContextʵ�ֲ�ͬservletֱ�ӵ����ݹ���
 * 2.ServletContext���Ի�ȡwebӦ�õĳ�ʼ������
 * 3.ServletContext����ʵ������ת��
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
        String data = (String) context.getAttribute("data");//��ServletContext������ȡ������
        response.getWriter().println("data="+data);
        
        String initParam = context.getInitParameter("url");
        response.getWriter().println(initParam);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}