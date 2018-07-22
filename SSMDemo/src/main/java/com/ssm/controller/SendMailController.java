package com.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

/**
 * created by viking on 2018/07/17
 * 测试邮件发送controller
 */
@RestController
@RequestMapping("mail")
public class SendMailController {
    @Autowired
    private JavaMailSender javaMailSender;//在spring中配置的邮件发送的bean

    @RequestMapping("send")
    public Object sendMail03(){
        MimeMessage mMessage=javaMailSender.createMimeMessage();//创建邮件对象
        MimeMessageHelper mMessageHelper;
        Properties prop = new Properties();
        String from;
        try {
            //从配置文件中拿到发件人邮箱地址
            prop.load(this.getClass().getResourceAsStream("/config/mail.properties"));
            from = prop.get("mail.smtp.username")+"";
            mMessageHelper=new MimeMessageHelper(mMessage,true);
            mMessageHelper.setFrom(from);//发件人邮箱
            mMessageHelper.setTo("viking_yan@163.com");//收件人邮箱
            mMessageHelper.setSubject("Spring的邮件发送");//邮件的主题
            mMessageHelper.setText("<p>这是使用spring的邮件功能发送的一封邮件</p><br/>" +
                    "<a href='https://blog.csdn.net/Mr__Viking'>打开我的博客主页</a><br/>" +
                    "<img src='cid:fengye'>",true);//邮件的文本内容，true表示文本以html格式打开
            File file=new File("F:/img/枫叶.png");//在邮件中添加一张图片
            FileSystemResource resource=new FileSystemResource(file);
            mMessageHelper.addInline("fengye", resource);//这里指定一个id,在上面引用
            mMessageHelper.addAttachment("枫叶.png", resource);//在邮件中添加一个附件
            javaMailSender.send(mMessage);//发送邮件
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "发送成功";
    }



















    public void sendMail(){
        SimpleMailMessage smm=new SimpleMailMessage();
        smm.setFrom("发件人的邮件地址");//发送人的邮件
        smm.setTo("收件人的邮件地址");//接收的邮箱的地址
        smm.setSubject("使用了properties,哈哈");//邮件的标题
        smm.setText("骄傲骄傲骄傲骄傲家居,你收到了没有");//邮件的内容
        javaMailSender.send(smm);//发送邮件
        System.out.println("发送成功");
    }
    public void sendMail01(){
        /**
         * 使用另一种的方式发送邮件,然后在邮件 使html格式生效
         */
        MimeMessage mm=javaMailSender.createMimeMessage();
        MimeMessageHelper smm=new MimeMessageHelper(mm);
        try {
            smm.setFrom("发件人的邮件地址");//发送人的邮件
            smm.setTo("接收的邮箱的地址");//接收的邮箱的地址
            smm.setSubject("使用了properties,哈哈,猜猜我是谁?");//邮件的标题
            smm.setText("骄傲骄傲骄傲骄傲家居,你收到了没有<br><a href='http://www.baidu.com'>去百度吧!</a>",true);//邮件的内容  true 是代表的html格式生效
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        javaMailSender.send(mm);//发送邮件
        System.out.println("发送成功");
    }
    public void sendMail02(){
        /**
         * 使用另一种的方式发送邮件,然后在邮件,发送一个照片
         */
        MimeMessage mm=javaMailSender.createMimeMessage();
        MimeMessageHelper smm=null;
        try {
            smm=new MimeMessageHelper(mm,true);
            smm.setFrom("发送人的邮件");//发送人的邮件
            smm.setTo("接收的邮箱的地址");//接收的邮箱的地址
            smm.setSubject("你丫的吃了狗屎了,你还不发送成功");//邮件的标题  这里多此测试  有可能会导致报错,说你发送的邮件内容不合法,注意看报错码,然后在去找报错码的意思,我这里也是报错了的,我是在他们官网上面看到的
            smm.setText("山东凯撒第三款<a href='http://www.baidu.com'>去百度吧!</a><img src='cid:identifier1234'>",true);//邮件的内容  true 是代表的html格式生效
            File file=new File("D:/1.jpg");//发送邮件的图片
            FileSystemResource resource=new FileSystemResource(file);
            smm.addInline("identifier1234", resource);//这里指定一个id,在上面引用
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        javaMailSender.send(mm);//发送邮件
        System.out.println("发送成功");
    }
}
