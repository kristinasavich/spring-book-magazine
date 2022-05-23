package ru.learnup.bd.springbookmagazine.dao.activemq;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageSender {
    private final JmsTemplate jmsTemplate;
    private final String krisMq;

    public MessageSender(JmsTemplate jmsTemplate,
                     @Value("${kris.mq.text}") String krisMq){
        this.jmsTemplate = jmsTemplate;
        this.krisMq = krisMq;
    }

    public void sendMessage(String msg){
//        jmsTemplate.convertAndSend(krisMq, new Me(msg, "MQ message"));
        jmsTemplate.convertAndSend(krisMq, msg);

    }

    public void sendMessageList(List<Object> obj){
        jmsTemplate.convertAndSend(krisMq, obj);
    }
}

