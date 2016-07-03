package net.jmf.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.jmf.rmi.api.Calculator;

public class CalculatorSvc implements Calculator {
	private static final Logger log = Logger.getLogger(Client.class.toString());
	
    public CalculatorSvc() {
        super();
    }
    
	static {
		System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tc %4$s - %2$s %5$s%6$s%n");
		
	}
		
	public double sum(double a, double b) throws RemoteException {
		return a+b;
	}
	
    public static void main( String[] args )
    {
    	try {
            String name = "Calculator";
            Calculator engine = new CalculatorSvc(); 
            Calculator stub =
                (Calculator) UnicastRemoteObject.exportObject(engine, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(name, stub);
            log.info("CalculatorSvc bound");
        } 
    	catch (Exception e) {
    		log.log(Level.SEVERE, "CalculatorSvc exception:" + e.getMessage(), e);
        }
    }
}
