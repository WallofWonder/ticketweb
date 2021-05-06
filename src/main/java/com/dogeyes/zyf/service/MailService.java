package com.dogeyes.zyf.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ZYF
 * @create 2021-5-6 19:37
 */
@Service
public class MailService {
    @Resource
    private JavaMailSender mailSender;

    // 从配置文件中注入发件人的姓名
    @Value("${spring.mail.username}")
    private String fromEmail;

    /**
     * 发送文本邮件
     *
     * @param to      收件人
     * @param subject 标题
     * @param content 正文
     */
    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("TicketWeb<"+fromEmail+">"); // 发件人
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);
    }

    public String sendValidCode(String to) {
        String code = validCode();
        sendSimpleMail(to, "注册验证码","您好！本次的注册验证码为：" + code + "。");
        return code;

    }

    private String validCode() {
        return String.valueOf((int) ((Math.random() * 9 + 1) * 1000));
    }
}
