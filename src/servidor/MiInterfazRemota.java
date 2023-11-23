/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MiInterfazRemota extends Remote{
    public void miMetodo1() throws RemoteException;
    
    public int miMetodo2() throws RemoteException;

}