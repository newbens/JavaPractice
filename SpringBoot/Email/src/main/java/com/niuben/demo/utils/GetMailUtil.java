package com.niuben.demo.utils;

import com.niuben.demo.domain.Content;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

import javax.mail.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class GetMailUtil {
    final static String USER = "newbens@163.com"; // 用户名
    final static String PASSWORD = "KGNGGATMGXLVXNGS"; // 密码
    public final static String MAIL_SERVER_HOST = "pop3.163.com"; // 邮箱服务器
    public final static String TYPE_HTML = "text/html;charset=UTF-8"; // 文本内容类型
    public final static String MAIL_FROM = "[email protected]"; // 发件人
    public final static String MAIL_TO = "[email protected]"; // 收件人
    public final static String MAIL_CC = "[email protected]"; // 抄送人
    public final static String MAIL_BCC = "[email protected]"; // 密送人

    private StringBuffer bodyText = new StringBuffer();


    public List<Content> getMail() throws Exception {
        // 创建一个有具体连接信息的Properties对象
        Properties prop = new Properties();
        prop.setProperty("mail.debug", "true");
        prop.setProperty("mail.store.protocol", "pop3");
        prop.setProperty("mail.pop3.host", MAIL_SERVER_HOST);
        // 1、创建session
        Session session = Session.getInstance(prop);
        // 2、通过session得到Store对象
        Store store = session.getStore();
        // 3、连上邮件服务器
        store.connect(MAIL_SERVER_HOST, USER, PASSWORD);
        // 4、获得邮箱内的邮件夹
        Folder folder = store.getFolder("inbox");
        folder.open(Folder.READ_ONLY);
        // 获得邮件夹Folder内的所有邮件Message对象
        Message[] messages = folder.getMessages();
        List<Content> list = new ArrayList<>();
        for (int i = 0; i < messages.length; i++) {
            Content content = new Content();
            content.setId(i+1);
            content.setTitle(messages[i].getSubject());
            content.setFrom(messages[i].getFrom()[0].toString());
            getMailContent((Part) messages[i]);
            content.setDetail(bodyText.toString());
            bodyText = new StringBuffer(); //重新初始化
            list.add(content);
        }
        // 5、关闭
        folder.close(false);
        store.close();
        return list;
    }

    public String getBodyText() {
        return bodyText.toString();
    }

    public void getMailContent(Part part) throws Exception {

        String contentType = part.getContentType();
        // 获得邮件的MimeType类型
        System.out.println("邮件的MimeType类型: " + contentType);

        int nameIndex = contentType.indexOf("name");

        boolean conName = false;

        if (nameIndex != -1) {
            conName = true;
        }

        System.out.println("邮件内容的类型:　" + contentType);

        if (part.isMimeType("text/plain") && conName == false) {
            // text/plain 类型
            bodyText.append((String) part.getContent());
        } else if (part.isMimeType("text/html") && conName == false) {
            // text/html 类型
            bodyText.append((String) part.getContent());
        } else if (part.isMimeType("multipart/*")) {
            // multipart/*
            Multipart multipart = (Multipart) part.getContent();
            int counts = multipart.getCount();
            for (int i = 0; i < counts; i++) {
                getMailContent(multipart.getBodyPart(i));
            }
        } else if (part.isMimeType("message/rfc822")) {
            // message/rfc822
            getMailContent((Part) part.getContent());
        } else {

        }
    }

}

