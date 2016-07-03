package net.jmf.rmi.api;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {
	double sum(double a, double b) throws RemoteException;
}
