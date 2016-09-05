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
 * 使用response实现文件下载功能
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
	 * 下载文件，通过OutputStream流（非 Javadoc）
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@SuppressWarnings("unused")
	private void downloadFileByOutputStream(HttpServletResponse response) throws IOException{
		//1.获取要下载文件的绝对路径
		String realPath = this.getServletContext().getRealPath("/download/jiuzhaigou.JPG");
		//2.获取要下载的文件名
		String fileName = realPath.substring(realPath.lastIndexOf("/")+1);
		//3.设置content-disposition响应头控制浏览器以下载的形式打开文件
		response.setHeader("content-disposition", "attachment;filename="+fileName);
		//4.获取要下载文件的输入流
		InputStream inputStream = new FileInputStream(realPath);
		int len = 0;
		//5.创建数据缓冲区
		byte[] buffer = new byte[1024];
		//6.通过response对象获取OutputStream流
		OutputStream outputStream = response.getOutputStream();
		//7.将FileInputStream流写入到buffer缓冲区
		while((len = inputStream.read(buffer))>0){
			//8.使用OutputStream将缓冲区的数据输出到客户端浏览器
			outputStream.write(buffer, 0, len);
		}
		inputStream.close();
		
	}
	
	/**
     * 下载中文文件,中文文件下载时，文件名要经过URL编码，否则会出现文件名乱码
     * @param response
     * @throws FileNotFoundException
     * @throws IOException
     */
    @SuppressWarnings("unused")
	private void downloadChineseFileByOutputStream(HttpServletResponse response)
            throws FileNotFoundException, IOException {
        String realPath = this.getServletContext().getRealPath("/download/五彩池.JPG");//获取要下载的文件的绝对路径
//        String realPath = this.getServletContext().getRealPath("/download/九寨沟.JPG");//获取要下载的文件的绝对路径
        String fileName = realPath.substring(realPath.lastIndexOf("/")+1);//获取要下载的文件名
        //设置content-disposition响应头控制浏览器以下载的形式打开文件，中文文件名要使用URLEncoder.encode方法进行编码，否则会出现文件名乱码
        response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode(fileName, "UTF-8"));
        InputStream in = new FileInputStream(realPath);//获取文件输入流
        int len = 0;
        byte[] buffer = new byte[1024];
        OutputStream out = response.getOutputStream();
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer,0,len);//将缓冲区的数据输出到客户端浏览器
        }
        in.close();
    }
    
    /**
     * 下载文件，通过PrintWriter流，虽然也能够实现下载，但是会导致数据丢失，因此不推荐使用PrintWriter流下载文件
     * @param response
     * @throws FileNotFoundException
     * @throws IOException
     */
    @SuppressWarnings("unused")
	private void downloadFileByPrintWriter(HttpServletResponse response)
            throws FileNotFoundException, IOException {
        String realPath = this.getServletContext().getRealPath("/download/九寨沟.JPG");//获取要下载的文件的绝对路径
        String fileName = realPath.substring(realPath.lastIndexOf("/")+1);//获取要下载的文件名
        //设置content-disposition响应头控制浏览器以下载的形式打开文件，中文文件名要使用URLEncoder.encode方法进行编码
        response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode(fileName, "UTF-8"));
        FileReader in = new FileReader(realPath);
        int len = 0;
        char[] buffer = new char[1024];
        PrintWriter out = response.getWriter();
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer,0,len);//将缓冲区的数据输出到客户端浏览器
        }
        in.close();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
