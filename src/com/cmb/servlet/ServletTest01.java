package com.cmb.servlet;


import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletTest01")

public class ServletTest01 extends HttpServlet {

    /**
	 * 1.ServletContextʵ�ֲ�ͬservletֱ�ӵ����ݹ���
     * 2.ServletContext���Ի�ȡwebӦ�õĳ�ʼ������
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String data = "shared data!!!!!";
        /**
         * ServletConfig������ά����ServletContext��������ã�������Ա�ڱ�дservletʱ��
         * ����ͨ��ServletConfig.getServletContext�������ServletContext����
         */
        ServletContext context = this.getServletContext();//���ServletContext����
        context.setAttribute("data", data);  //��data�洢��ServletContext������
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}