package utils;
import com.sun.mail.util.MailSSLSocketFactory;

import java.security.GeneralSecurityException;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
/**
 * 发送邮件的工具类
 */
public class Mail {
    public static void sendMail(String email, String emailMsg)
            throws Exception {
        // 1.创建一个程序与邮件服务器会话对象 Session
        Properties props = new Properties();
        // 设置邮件传输协议为SMTP
        props.setProperty("mail.transport.protocol", "smtp");
        // 设置SMTP服务器地址
        props.setProperty("mail.host", "smtp.qq.com");
        // 设置SMTP服务器是否需要用户验证，需要验证设置为true
        props.setProperty("mail.smtp.auth", "true");
        // 创建验证器
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                //发件人邮件用户名、授权码
                return new PasswordAuthentication("silverhammer@qq.com", "nqhfztksbymvbjih");
            }
        });

        Transport ts = session.getTransport();
        ts.connect("smtp.qq.com", "silverhammer@qq.com", "nqhfztksbymvbjih");

        // 2.创建一个Message，它相当于是邮件内容
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress("silverhammer@qq.com")); // 设置发送者
        message.setRecipient(RecipientType.TO, new InternetAddress(email)); // 设置发送方式与接收者
        message.setSubject("订单通知");
        message.setContent(emailMsg, "text/html;charset=utf-8");
        // 3.创建 Transport用于将邮件发送
        ts.sendMessage(message, message.getAllRecipients());
        ts.close();
    }
}
