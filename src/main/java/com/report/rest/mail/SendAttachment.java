package com.report.rest.mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.*;

public class SendAttachment extends TimerTask {
    public void dateOfSend() throws ParseException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String taskYear = String.valueOf(YearMonth.now().getYear());
        String taskMonth = String.valueOf(YearMonth.now().getMonthValue());
        int taskDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
//        int taskHour = 17;
//        int currentHour = LocalDateTime.now().getHour();

//        if (currentHour > taskHour) {
//            taskDay++;
//        }

        String taskDayString = String.valueOf(taskDay);
        Date date = dateFormatter.parse(taskYear + "-" + taskMonth + "-" + taskDayString + " 18:27:00");
        Timer timer = new Timer();
        timer.schedule(new SendAttachment(), date);
    }

    @Override
    public void run() {
        final String user = "orangegroup2222@gmail.com";
        final String password = "awdAWD12";

        String to = "gizelbard@ukr.net";

        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.debug", "true");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user, password);
                    }
                });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Orange team. Time management");
            message.setText("Here will be report");

            Transport.send(message);

            System.out.println("Message sent successfully");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}