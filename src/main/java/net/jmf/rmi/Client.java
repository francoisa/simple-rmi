package net.jmf.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.jmf.rmi.api.Calculator;

public class Client {
	private static final Logger log = Logger.getLogger(Client.class.toString());
	
	static {
		System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tc %4$s - %2$s %5$s%6$s%n");
		
	}
	
	public static void main(String[] args) {
		try {
            String name = "Calculator";
            Registry registry = LocateRegistry.getRegistry(args[0]);
            Calculator comp = (Calculator) registry.lookup(name);
            double sum = comp.sum(9, 10);
            log.info("sum=" + sum);
        } 
		catch (Exception e) {
            log.log(Level.SEVERE, "Calculator exception: " + e.getMessage(), e);
        }
	}

}
