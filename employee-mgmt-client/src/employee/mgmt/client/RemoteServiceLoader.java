/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package employee.mgmt.client;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 *
 * @author jvergara
 */
public class RemoteServiceLoader
{

    private static RemoteServiceLoader loader;

    public static Object load(Class service)
    {
        if (loader == null) {
            loader = new RemoteServiceLoader();
        }
        return loader.loadService(service);
    }
    
    
    private InitialContext ctx;

    private RemoteServiceLoader()
    {
        try {
            Properties props = new Properties();
            props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
            props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
            props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
            ctx = new InitialContext(props);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    Object loadService(Class service)
    {
        try {
            return ctx.lookup(service.getName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
