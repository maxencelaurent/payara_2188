/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.maxence.payara_2188;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author maxence
 */
public class ATest {

    @Test
    public void startContainer() {

        Map<String, Object> properties = new HashMap<>();

        properties.put(EJBContainer.MODULES, new File("src/main/resource/embed-classes"));

        EJBContainer container = EJBContainer.createEJBContainer(properties);

        try {
            MySingleton lookup = (MySingleton) container.getContext().lookup("java:global/classes/MySingleton!" + MySingleton.class.getName());
            String sayHello = lookup.sayHello();
            Assert.assertNotNull("Not saying hello :-(", sayHello);
        } catch (NamingException ex) {
            Assert.fail("MySingleton has not been loaded...");
        }

    }
}
