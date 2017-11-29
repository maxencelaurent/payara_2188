package ch.maxence.payara_2188;

import javax.ejb.Singleton;

/**
 *
 * @author maxence
 */
@Singleton
public class MySingleton {

    public String sayHello() {
        System.out.println("Hello, World!");
        return "Hello, world\n";
    }
}
