package ru.learnup.bd.springbookmagazine;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import ru.learnup.bd.springbookmagazine.dao.activemq.MessageSender;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;


@Slf4j
@SpringBootApplication
@EnableJms
public class SpringBookMagazineApplication {

    public static void main(String[] args) {
//        System.setProperty("org.apache.activemq.SERIALIZABLE_PACKAGES", "*");
        ConfigurableApplicationContext context = SpringApplication.run(SpringBookMagazineApplication.class, args);

        MessageSender messageSender = context.getBean(MessageSender.class);
        messageSender.sendMessage("Hello MQ");
    }
}
