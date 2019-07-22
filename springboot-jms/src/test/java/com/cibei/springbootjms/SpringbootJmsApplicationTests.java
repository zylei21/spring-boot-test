package com.cibei.springbootjms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootJmsApplicationTests {
    @Autowired
    private JavaMailSenderImpl mailSender;

    @Test
    public void contextLoads() {
    }

    @Test
    public void sendSimpleMail(){
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setFrom("1601275750@qq.com");
        simpleMailMessage.setTo("zylei21@163.com");
        simpleMailMessage.setText("这是一封简单的邮件...");
        simpleMailMessage.setSubject("测试邮件");
        mailSender.send(simpleMailMessage);
        System.err.println("发送成功!");
    }

    @Test
    public void sendHtmlMail() throws Exception{
        MimeMessage mimeMessage=mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage);
        mimeMessageHelper.setFrom("1601275750@qq.com");
        mimeMessageHelper.setTo("zylei21@163.com");
        mimeMessageHelper.setSubject("html格式的测试邮件");
        StringBuilder sb = new StringBuilder();
        sb.append("<html><head></head>");
        sb.append("<body><h1>spring 邮件测试</h1><p>hello!this is spring mail test。</p></body>");
        sb.append("</html>");

        mimeMessageHelper.setText(sb.toString(),true);
        mailSender.send(mimeMessage);
        System.err.println("邮件已发送");
    }
    @Test
    public void sendHtmlWithImageMail() throws Exception{
        MimeMessage mimeMessage=mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom("1601275750@qq.com");
        mimeMessageHelper.setTo("zylei21@163.com");
        mimeMessageHelper.setSubject("html格式内嵌图片的测试邮件");
        StringBuilder sb = new StringBuilder();
        sb.append("<html><head></head>");
        sb.append("<body><h1>spring 邮件测试</h1><p>hello!this is spring mail test。</p>");
        sb.append("<img src=\"cid:imageId\"></body>");
        sb.append("</html>");

        mimeMessageHelper.setText(sb.toString(),true);
        mailSender.send(mimeMessage);
        System.err.println("邮件已发送");
    }
    @Test
    public void sendAttendedFileMail() throws Exception{
        MimeMessage mimeMessage=mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true,"UTF-8");
        mimeMessageHelper.setFrom("1601275750@qq.com");
        mimeMessageHelper.setTo("zylei21@163.com");
        mimeMessageHelper.setSubject("html格式带附件的测试邮件");
        StringBuilder sb = new StringBuilder();
        sb.append("<html><head></head>");
        sb.append("<body><h1>spring 邮件测试</h1><p>hello!this is spring mail test。</p>");
        sb.append("<img src=\"cid:imageId\"></body>");
        sb.append("</html>");

        mimeMessageHelper.setText(sb.toString(),true);
        FileSystemResource resource=new FileSystemResource("D:/sqlite.db");
        mimeMessageHelper.addAttachment("sqlite.db",resource);
        mailSender.send(mimeMessage);
        System.err.println("邮件已发送");
    }
}
