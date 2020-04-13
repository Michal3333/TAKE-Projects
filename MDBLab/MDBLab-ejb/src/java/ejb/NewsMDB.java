/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author michal
 */
@JMSDestinationDefinition(name = "java:app/jms/NewsQueue", interfaceName = "javax.jms.Queue", resourceAdapter = "jmsra", destinationName = "NewsQueue")
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:app/jms/NewsQueue"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class NewsMDB implements MessageListener {
    
    public NewsMDB() {
    }
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void onMessage(Message message) {
        TextMessage msg = null; try {
            if (message instanceof TextMessage) {
                msg = (TextMessage) message;
                String[] arrOfStr = msg.getText().split("\\|"); 
                String heading = arrOfStr[0];
                String body = arrOfStr[1];
                NewsItem i = new NewsItem();
                i.setHeading(heading);
                i.setBody(body);
                
                NewsItem e = (NewsItem) i; em.persist(e);
            }
        } catch (JMSException e) {
                e.printStackTrace(); 
             }
    }
    
    
    
}
