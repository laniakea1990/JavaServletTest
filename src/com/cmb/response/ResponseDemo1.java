package com.cmb.response;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ResponseDemo1
 * ʹ��OutputStream���������
 * ʹ��PrintWriter���������
 * @param request
 * @param response
 * @throws IOException 
*/

@WebServlet("/ResponseDemo1")
public class ResponseDemo1 extends HttpServlet {

    private static final long serialVersionUID = 4312868947607181532L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //outputChineseByOutputStream(response);//ʹ��OutputStream���������
        outPutChineseByPrintWriter(response);//ʹ��PrintWriter���������
    }
    
   
    public void outPutChineseByOutputStream(HttpServletResponse response) throws IOException{
        /**ʹ��OutputStream�������ע�����⣺
         * �ڷ������ˣ����������ĸ��������ģ���ô��Ҫ���ƿͻ������������Ӧ�����򿪣�
         * ���磺outputStream.write("�й�".getBytes("UTF-8"));//ʹ��OutputStream����ͻ��������������ģ���UTF-8�ı���������
         * ��ʱ��Ҫ���ƿͻ����������UTF-8�ı���򿪣�������ʾ��ʱ��ͻ�����������룬��ô�ڷ���������ο��ƿͻ������������UTF-8�ı�����ʾ�����أ�
         * ����ͨ��������Ӧͷ�������������Ϊ�����磺
         * response.setHeader("content-type", "text/html;charset=UTF-8");//ͨ��������Ӧͷ�����������UTF-8�ı�����ʾ����
         */
        String data = "�й�";
        OutputStream outputStream = response.getOutputStream();//��ȡOutputStream�����
        response.setHeader("content-type", "text/html;charset=UTF-8");//ͨ��������Ӧͷ�����������UTF-8�ı�����ʾ���ݣ����������仰����ô�������ʾ�Ľ�������
        /**
         * data.getBytes()��һ�����ַ�ת�����ֽ�����Ĺ��̣����������һ����ȥ�����
         * ��������ĵĲ���ϵͳ������Ĭ�Ͼ��ǲ��Ҳ�GB2312�����
         * ���ַ�ת�����ֽ�����Ĺ��̾��ǽ������ַ�ת����GB2312������϶�Ӧ������
         * ���磺 "��"��GB2312������϶�Ӧ��������98
         *         "��"��GB2312������϶�Ӧ��������99
         */
        /**
         * getBytes()�������������������ô�ͻ���ݲ���ϵͳ�����Ի�����ѡ��ת�������������Ĳ���ϵͳ����ô��ʹ��GB2312�����
         */
        byte[] dataByteArr = data.getBytes("UTF-8");//���ַ�ת�����ֽ����飬ָ����UTF-8�������ת��
        outputStream.write(dataByteArr);//ʹ��OutputStream����ͻ�������ֽ�����
    }

    
    /*
     * ʹ��PrintWriter��������ģ��� Javadoc��
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    
    public void outPutChineseByPrintWriter(HttpServletResponse response) throws IOException{
    	String data = "�콫��������˹��Ҳ�����ȿ�����־�������ǣ�����������շ������з�������Ϊ�����Զ������ԣ�������������";
    	
    	response.setCharacterEncoding("UTF-8");
    	PrintWriter oWriter = response.getWriter();
    	
    	response.setHeader("content-type","text/html;charset=UTF-8");
    	
    	oWriter.write(data);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}