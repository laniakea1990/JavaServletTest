package com.cmb.response;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ʹ��responseʵ���ļ����ع���
 * @author RaiseKing
 */
@WebServlet("/ResponseDemo2")
public class ResponseDemo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//downloadFileByOutputStream(response);
		//downloadChineseFileByOutputStream(response);
		downloadFileByPrintWriter(response);
	}

	/*
	 * �����ļ���ͨ��OutputStream������ Javadoc��
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@SuppressWarnings("unused")
	private void downloadFileByOutputStream(HttpServletResponse response) throws IOException{
		//1.��ȡҪ�����ļ��ľ���·��
		String realPath = this.getServletContext().getRealPath("/download/jiuzhaigou.JPG");
		//2.��ȡҪ���ص��ļ���
		String fileName = realPath.substring(realPath.lastIndexOf("/")+1);
		//3.����content-disposition��Ӧͷ��������������ص���ʽ���ļ�
		response.setHeader("content-disposition", "attachment;filename="+fileName);
		//4.��ȡҪ�����ļ���������
		InputStream inputStream = new FileInputStream(realPath);
		int len = 0;
		//5.�������ݻ�����
		byte[] buffer = new byte[1024];
		//6.ͨ��response�����ȡOutputStream��
		OutputStream outputStream = response.getOutputStream();
		//7.��FileInputStream��д�뵽buffer������
		while((len = inputStream.read(buffer))>0){
			//8.ʹ��OutputStream��������������������ͻ��������
			outputStream.write(buffer, 0, len);
		}
		inputStream.close();
		
	}
	
	/**
     * ���������ļ�,�����ļ�����ʱ���ļ���Ҫ����URL���룬���������ļ�������
     * @param response
     * @throws FileNotFoundException
     * @throws IOException
     */
    @SuppressWarnings("unused")
	private void downloadChineseFileByOutputStream(HttpServletResponse response)
            throws FileNotFoundException, IOException {
        String realPath = this.getServletContext().getRealPath("/download/��ʳ�.JPG");//��ȡҪ���ص��ļ��ľ���·��
//        String realPath = this.getServletContext().getRealPath("/download/��կ��.JPG");//��ȡҪ���ص��ļ��ľ���·��
        String fileName = realPath.substring(realPath.lastIndexOf("/")+1);//��ȡҪ���ص��ļ���
        //����content-disposition��Ӧͷ��������������ص���ʽ���ļ��������ļ���Ҫʹ��URLEncoder.encode�������б��룬���������ļ�������
        response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode(fileName, "UTF-8"));
        InputStream in = new FileInputStream(realPath);//��ȡ�ļ�������
        int len = 0;
        byte[] buffer = new byte[1024];
        OutputStream out = response.getOutputStream();
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer,0,len);//��������������������ͻ��������
        }
        in.close();
    }
    
    /**
     * �����ļ���ͨ��PrintWriter������ȻҲ�ܹ�ʵ�����أ����ǻᵼ�����ݶ�ʧ����˲��Ƽ�ʹ��PrintWriter�������ļ�
     * @param response
     * @throws FileNotFoundException
     * @throws IOException
     */
    @SuppressWarnings("unused")
	private void downloadFileByPrintWriter(HttpServletResponse response)
            throws FileNotFoundException, IOException {
        String realPath = this.getServletContext().getRealPath("/download/��կ��.JPG");//��ȡҪ���ص��ļ��ľ���·��
        String fileName = realPath.substring(realPath.lastIndexOf("/")+1);//��ȡҪ���ص��ļ���
        //����content-disposition��Ӧͷ��������������ص���ʽ���ļ��������ļ���Ҫʹ��URLEncoder.encode�������б���
        response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode(fileName, "UTF-8"));
        FileReader in = new FileReader(realPath);
        int len = 0;
        char[] buffer = new char[1024];
        PrintWriter out = response.getWriter();
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer,0,len);//��������������������ͻ��������
        }
        in.close();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
