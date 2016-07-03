# simple-rmi
A simple java rmi project  

The server should be started with:  
> java -jar target\rmi-1.0-SNAPSHOT-jar-with-dependencies.jar  

The client should be started with:  
> mvn exec:java  
or  
> java -cp target\rmi-1.0-SNAPSHOT-jar-with-dependencies.jar net.jmf.rmi.Client  

The rmiregistry application should be started in the **target/classes** directory