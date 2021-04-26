package com.example.EJBs.impl;


import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.TextMessage;

import java.util.logging.Logger;


@MessageDriven(activationConfig= {
        @ActivationConfigProperty(propertyName= "destinationLookup", propertyValue= "jms/myQueue"),
        @ActivationConfigProperty(propertyName= "destinationType", propertyValue= "javax.jms.Queue")
})
public class MessageReceiver implements MessageListener {

    private static Logger logger = Logger.getLogger(
            MessageReceiver.class.getName());

    @Override
    public void onMessage(Message message) {
        TextMessage receivedMessage = (TextMessage) message;
        try {
            System.out.println("GOT A MSG " + ((TextMessage) message).getText());
            logger.info("HELLO ==================================  ");
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
