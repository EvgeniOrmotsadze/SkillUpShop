package ge.evgo.shop.controller.jms.config;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by root_pc on 4/26/2016.
 */

@MessageDriven(name = "LoginQueue", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/LoginQueue"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")})
public class LoginQueue implements MessageListener {


    public void onMessage(Message message) {

        TextMessage msg = null;
        try {
            if (message instanceof TextMessage) {
                msg = (TextMessage) message;
                System.out.println(msg.getText().toString());
            } else {
                System.out.println("Message of wrong type: ");
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }


    }
}
