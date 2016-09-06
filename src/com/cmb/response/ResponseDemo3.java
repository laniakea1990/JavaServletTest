package com.cmb.response;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseDemo3
 * �������ͼƬ��Ϊ��֤��
 */
@WebServlet("/ResponseDemo3")
public class ResponseDemo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ResponseDemo3() {
        super();
    }

	
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setHeader("refresh", "5");//����refresh��Ӧͷ���������ÿ��5����ˢ��һ��
        //1.���ڴ��д���һ��ͼƬ
        BufferedImage image = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);
        //2.�õ�ͼƬ
        //Graphics g = image.getGraphics();
        Graphics2D g = (Graphics2D)image.getGraphics();
        g.setColor(Color.WHITE);//����ͼƬ�ı���ɫ
        g.fillRect(0, 0, 80, 20);//��䱳��ɫ
        //3.��ͼƬ��д����
        g.setColor(Color.pink);//����ͼƬ���������ɫ
        g.setFont(new Font(null, Font.BOLD, 20));
        g.drawString(makeNum(), 0, 20);
        //4.������Ӧͷ����������������ͼƬ�ķ�ʽ��
        response.setContentType("image/jpeg");//��ͬ��response.setHeader("Content-Type", "image/jpeg");
        //5.������Ӧͷ���������������ͼƬ����
        response.setDateHeader("expries", -1);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        //6.��ͼƬд�������
        ImageIO.write(image, "jpg", response.getOutputStream());
    }

    /**
     * �����������
     * @return
     */
    private String makeNum(){
        Random random = new Random();
        String num = random.nextInt(9999999)+"";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 7-num.length(); i++) {
            sb.append("0");
        }
        num = sb.toString()+num;
        return num;
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}