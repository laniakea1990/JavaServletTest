package com.cmb.servlet;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletTest05")

/**
 * ʹ��servletContext��ȡ��Դ�ļ�
 * 
 */
public class ServletTest05 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        /**
         * response.setContentType("text/html;charset=UTF-8");Ŀ���ǿ����������UTF-8���н��룻
         * �����Ͳ����������������
         */
        response.setHeader("content-type","text/html;charset=UTF-8");
        readSrcDirPropCfgFile(response);//��ȡsrcĿ¼�µ�properties�����ļ�
        response.getWriter().println("<hr/>");
        readWebRootDirPropCfgFile(response);//��ȡWebRootĿ¼�µ�properties�����ļ�
        response.getWriter().println("<hr/>");
        readPropCfgFile(response);//��ȡsrcĿ¼�µ�db.config���е�db3.properties�����ļ�
        response.getWriter().println("<hr/>");
        readPropCfgFile2(response);//��ȡsrcĿ¼�µ�gacl.servlet.study���е�db4.properties�����ļ�
        
    }

    /**
     * ��ȡsrcĿ¼�µ�gacl.servlet.study���е�db4.properties�����ļ�
     * @param response
     * @throws IOException
     */
    private void readPropCfgFile2(HttpServletResponse response)
            throws IOException {
        InputStream in = this.getServletContext().getResourceAsStream("/WEB-INF/classes/gacl/servlet/study/db4.properties");
        Properties prop = new Properties();
        prop.load(in);
        String driver = prop.getProperty("driver");
        String url = prop.getProperty("url");
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        response.getWriter().println("��ȡsrcĿ¼�µ�com.cmb.servlet���е�db4.properties�����ļ���");
        response.getWriter().println(
                MessageFormat.format(
                        "driver={0},url={1},username={2},password={3}", 
                        driver,url, username, password));
    }

    /**
     * ��ȡsrcĿ¼�µ�db.config���е�db3.properties�����ļ�
     * @param response
     * @throws FileNotFoundException
     * @throws IOException
     */
    private void readPropCfgFile(HttpServletResponse response)
            throws FileNotFoundException, IOException {
        //ͨ��ServletContext��ȡweb��Դ�ľ���·��
        String path = this.getServletContext().getRealPath("/WEB-INF/classes/db/config/db3.properties");
        InputStream in = new FileInputStream(path);
        Properties prop = new Properties();
        prop.load(in);
        String driver = prop.getProperty("driver");
        String url = prop.getProperty("url");
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        response.getWriter().println("��ȡsrcĿ¼�µ�db.config���е�db3.properties�����ļ���");
        response.getWriter().println(
                MessageFormat.format(
                        "driver={0},url={1},username={2},password={3}", 
                        driver,url, username, password));
    }

    /**
     * ͨ��ServletContext�����ȡWebRootĿ¼�µ�properties�����ļ�
     * @param response
     * @throws IOException
     */
    private void readWebRootDirPropCfgFile(HttpServletResponse response)
            throws IOException {
        /**
         * ͨ��ServletContext�����ȡWebRootĿ¼�µ�properties�����ļ�
         * ��/�����������Ŀ��Ŀ¼
         */
        InputStream in = this.getServletContext().getResourceAsStream("/db2.properties");
        Properties prop = new Properties();
        prop.load(in);
        String driver = prop.getProperty("driver");
        String url = prop.getProperty("url");
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        response.getWriter().println("��ȡWebRootĿ¼�µ�db2.properties�����ļ���");
        response.getWriter().print(
                MessageFormat.format(
                        "driver={0},url={1},username={2},password={3}", 
                        driver,url, username, password));
    }

    /**
     * ͨ��ServletContext�����ȡsrcĿ¼�µ�properties�����ļ�
     * @param response
     * @throws IOException
     */
    private void readSrcDirPropCfgFile(HttpServletResponse response) throws IOException {
        /**
         * ͨ��ServletContext�����ȡsrcĿ¼�µ�db1.properties�����ļ�
         */
        InputStream in = this.getServletContext().getResourceAsStream("/WEB-INF/classes/db1.properties");
        Properties prop = new Properties();
        prop.load(in);
        String driver = prop.getProperty("driver");
        String url = prop.getProperty("url");
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        response.getWriter().println("��ȡsrcĿ¼�µ�db1.properties�����ļ���");
        response.getWriter().println(
                MessageFormat.format(
                        "driver={0},url={1},username={2},password={3}", 
                        driver,url, username, password));
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

}