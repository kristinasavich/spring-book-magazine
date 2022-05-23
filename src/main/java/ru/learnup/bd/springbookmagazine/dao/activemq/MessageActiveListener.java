package ru.learnup.bd.springbookmagazine.dao.activemq;

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;

@Slf4j
@Component
public class MessageActiveListener implements MessageListener {


    @JmsListener(destination = "kris-mq-text")
    @Override
    public void onMessage(Message message) {
        try {
            ActiveMQTextMessage textMessage = (ActiveMQTextMessage) message;
            String msg = textMessage.getText();
            log.info("Received Message: " + msg);
        } catch (Exception e) {
            log.error("Received Exception : " + e);
        }
    }


}
