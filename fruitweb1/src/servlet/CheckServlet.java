package servlet;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

@WebServlet(name = "CheckServlet",urlPatterns = "/CheckServlet")
public class CheckServlet extends HttpServlet {
    private static int WIDTH = 60; //验证码图片宽度
    private static int HEIGHT = 20; //验证码图片高度
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.setContentType("image/jpg");
        //ServletOutputStream sos = response.getOutputStream();
        //设置浏览器不要缓存此图片
        response.setHeader("Pragma","No-cache");
        response.setHeader("Cache-Control","no-cache");
        response.setDateHeader("Expires", 0);
        //创建内存图象并获得其图形上下文
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        //产生随机的认证码
        char[] rands = generateCheckCode();
        //产生图像
        drawBackground(g);
        drawRands(g,rands);
        //结束图像的绘制过程，完成图像
        g.dispose();
        //将图像输出到客户端
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(response.getOutputStream());
        encoder.encode(image);
        //将当前验证码存入到Session中
        session.setAttribute("check_code",new String(rands));
    }

    //生成一个4字符的验证码
    private char [] generateCheckCode()
    {
        //定义验证码的字符表
        String chars = "0123456789abcdefghijklmnopqrstuvwxyz";
        char [] rands = new char[4];
        for(int i=0; i<4; i++)
        {
            int rand = (int)(Math.random() * 36);
            rands[i] = chars.charAt(rand);
        }
        return rands;
    }
    private void drawRands(Graphics g , char [] rands)
    {
        g.setColor(Color.BLACK);
        g.setFont(new Font(null,Font.ITALIC|Font.BOLD,18));
        //在不同的高度上输出验证码的每个字符
        g.drawString("" + rands[0],1,17);
        g.drawString("" + rands[1],16,15);
        g.drawString("" + rands[2],31,18);
        g.drawString("" + rands[3],46,16);
        //System.out.println(rands);
    }
    private void drawBackground(Graphics g)
    {
        //画背景
        g.setColor(new Color(0xDCDCDC));
        g.fillRect(0, 0, WIDTH, HEIGHT);
        //随机产生120个干扰点
        for(int i=0; i<120; i++)
        {
            int x = (int)(Math.random() * WIDTH);
            int y = (int)(Math.random() * HEIGHT);
            int red = (int)(Math.random() * 255);
            int green = (int)(Math.random() * 255);
            int blue = (int)(Math.random() * 255);
            g.setColor(new Color(red,green,blue));
            g.drawOval(x,y,1,0);
        }
    }
}
