package com.example.backingbeans;


import jakarta.annotation.Resource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.jms.JMSConnectionFactory;
import jakarta.jms.JMSContext;
import jakarta.jms.Queue;

@Named(value = "jmsMessageController")
@RequestScoped
public class JSMMessageController {

    @Inject
    private JSMMessageModel jsmMessageModel;

    @Resource(mappedName= "jms/myQueue")
    private Queue myQueue;

    @Inject
    @JMSConnectionFactory("jms/myConnectionFactory")
    private JMSContext context;

    public String sendMsg() {
        sendJMSMessageToMyQueue(jsmMessageModel.getMyMsg());
        return "conf";
    }
    private void sendJMSMessageToMyQueue(String messageData) {
        context.createProducer().send(myQueue, messageData);
    }



}
