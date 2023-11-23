/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class MiClaseRemota extends UnicastRemoteObject implements
    MiInterfazRemota {

  public MiClaseRemota() throws RemoteException {
    // Código del constructor
  }

  public void miMetodo1() throws RemoteException {
    // Aquí ponemos el código que queramos
    System.out.println("Estoy en miMetodo1()");
  }

  public int miMetodo2() throws RemoteException {
    // Aquí ponemos el código que queramos
    return 5;
  }

  public void anotherMethod() {
    //
  }

  public static void main(String[] args) {
    try {
      LocateRegistry.createRegistry(Integer.parseInt("1234"));

      MiInterfazRemota mri = new MiClaseRemota();

      java.rmi.Naming.rebind("//" +
          java.net.InetAddress.getLocalHost().getHostAddress() +
          ":1234/PruebaRMI", mri);
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}