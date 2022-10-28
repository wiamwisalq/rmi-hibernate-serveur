/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.IDao;
import entity.Machine;
import java.net.MalformedURLException;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Date;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import service.MachineService;
import util.HibernateUtil;

/**
 *
 * @author Lachgar
 */
public class Server {

    public static void main(String[] args) throws RemoteException {

   
        try {
            IDao<Machine> dao = new MachineService();
            LocateRegistry.createRegistry(1099);
            
            final Hashtable<Object, Object> config = new Hashtable<Object, Object>();
            config.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
            config.put(Context.PROVIDER_URL, "rmi://localhost:1099");
            InitialContext context = new InitialContext(config);
            
            context.bind("dao", dao);
            System.out.println("En attete des clients");
        } catch (NamingException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
